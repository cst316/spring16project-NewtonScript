package net.sf.memoranda.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.NoteList;
import net.sf.memoranda.PhaseList;
import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectListener;
import net.sf.memoranda.ResourcesList;
import net.sf.memoranda.TaskList;
import net.sf.memoranda.TestCase;
import net.sf.memoranda.TestCaseImpl;
import net.sf.memoranda.TestCaseList;
import net.sf.memoranda.TestCase.STATUS;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.date.DateListener;
import net.sf.memoranda.util.CurrentStorage;
import nu.xom.Attribute;
import nu.xom.Element;
/*
 * Created by JFormDesigner on Sat Feb 27 19:42:23 MST 2016
 */

/**
 * Outer panel for the Test Case Page
 * 
 * @author Doug Carroll
 */
public class TestCasePanel extends JPanel {
	
	private TestCaseTable table;
	private JSplitPane splitPane1;
	private JPanel panel1;
	private JButton newButton;
	private JButton editButton;
	private JButton removeButton;
	private JPanel panel2;
	private JButton passButton;
	private JButton failButton;
	private JButton inProgButton;
	private JScrollPane scrollPane;

	
	public TestCasePanel() {
		initComponents();
	}

	private void initComponents() {
		
		splitPane1 = new JSplitPane();
		panel1 = new JPanel();
		newButton = new JButton();
		editButton = new JButton();
		inProgButton = new JButton();
		removeButton = new JButton();
		panel2 = new JPanel();
		passButton = new JButton();
		failButton = new JButton();
		table = new TestCaseTable();
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(table);
		
		CurrentDate.addDateListener(new DateListener() {
            public void dateChange(CalendarDate d) {
                updateTable();
            }
        });
        CurrentProject.addProjectListener(new ProjectListener() {
            public void projectChange(Project p, NoteList nl, TaskList tl,
                    ResourcesList rl, PhaseList ph, TestCaseList tc) {
            }

            public void projectWasChanged() {
            	updateTable();
            }
        });

		setLayout(new BorderLayout());
		
		loadTestCases();

	
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

		//---- newButton ----
		newButton.setText("New");
		panel1.add(newButton);
		newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAction();
            }
        });
		//---- editButton ----
		editButton.setText("Edit");
		panel1.add(editButton);
		editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editAction();
            }
        });

		//---- removeButton ----
		removeButton.setText("Remove");
		panel1.add(removeButton);
		removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeAction();
            }
        });
		
		splitPane1.setLeftComponent(panel1);

	
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

		//---- in progress ----
		inProgButton.setText("Reset");
		panel2.add(inProgButton);
		inProgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inProgAction();
            }
        });
		
		//---- pass ----
		passButton.setText("Pass");
		passButton.setIcon(
		           new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource(
		        		   "resources/icons/PassButton.png")));
		panel2.add(passButton);
		passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passAction();
            }
        });

		//---- fail ----
		failButton.setText("Fail");
		failButton.setIcon(
		           new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource(
		        		   "resources/icons/FailButton.png")));
		panel2.add(failButton);
		failButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                failAction();
            }
        });
	
		splitPane1.setRightComponent(panel2);
		add(splitPane1, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setVisible(true);
	}
	
	// Load test cases into the table
	private void loadTestCases() {
		ArrayList<TestCase> tcs = 
				CurrentProject.getTestCaseList().getAllTestCases();
		
		for(TestCase tc : tcs){
			table.addTestCase(tc);
		}
	}

	private void addAction(){
		TestCaseList tcl = CurrentProject.getTestCaseList();
		TestCase tc = null;
		String id;
		
		//Test case dialog opens here
		TestCaseDialog dlg = new TestCaseDialog(App.getFrame());
		id = dlg.getSelectedID();
		Element elem = new Element("testcase");
		elem.addAttribute(new Attribute(TestCase.ID, id));
		elem.addAttribute(new Attribute(TestCase.METHOD, dlg.getSelectedMethod()));
		elem.addAttribute(new Attribute(TestCase.DES, dlg.getSelectedDescription()));
		elem.addAttribute(new Attribute(TestCase.TC, dlg.getSelectedTestCase()));
		elem.addAttribute(new Attribute(TestCase.ER, dlg.getSelectedExpected()));
		elem.addAttribute(new Attribute(TestCase.AR, dlg.getSelectedActual()));
		if(dlg.getSelectedStatus().equals("In Progress")) {
			elem.addAttribute(new Attribute(TestCase.PASS, 
					STATUS.INPROGRESS.toString()));
		} else if(dlg.getSelectedStatus().equals("Passed")) {
			elem.addAttribute(new Attribute(TestCase.PASS, 
					STATUS.PASSED.toString()));
		} else if(dlg.getSelectedStatus().equals("Failed")) {
			elem.addAttribute(new Attribute(TestCase.PASS, 
					STATUS.FAILED.toString()));
		}
		//---------------------------------------------
		
		
		// If a test case with this id exists, warn the user and don't add the test case
		if(tcl.hasTestCase(id)){
			JOptionPane.showMessageDialog(this, "Test case with the same ID already exists!");
		}
		// Else, do everything to add the test case
		else{
			// Create a new test case based on the above elements and add it to the table
			tc = tcl.createTestCase(elem);
			table.addTestCase(tc);
			
			save();
			updateTable();
		}
		
	}
	
	private void editAction() {
		String id;
		
		// If nothing is highlighted, warn the user.
		if(table.getSelectedRow() < 0){
			JOptionPane.showMessageDialog(this, "Please select a test case");
		} else{
			id = (String) table.getModel().getValueAt(table.getSelectedRow(), TestCaseTable.ID);
			TestCase tc = CurrentProject.getTestCaseList().getTestCase(id);
			//Creates dialog with test case info
			TestCaseDialog dlg = new TestCaseDialog(App.getFrame(), tc.getID(), tc.getMethod(), 
					tc.getDescription(), tc.getExpectedRes(), tc.getActualRes(), tc.getTestCase(),
					tc.getStatusString());
			
			//Sets new dialog info to test case
			tc.setMethod(dlg.getSelectedMethod());
			tc.setDescription(dlg.getSelectedDescription());
			tc.setExpectedRes(dlg.getSelectedExpected());
			tc.setActualRes(dlg.getSelectedActual());
			tc.setTestCase(dlg.getSelectedTestCase());
			if(dlg.getSelectedStatus().equals("In Progress")) {
				tc.setStatus(STATUS.INPROGRESS);
			} else if(dlg.getSelectedStatus().equals("Passed")) {
				tc.setStatus(STATUS.PASSED);
			} else if(dlg.getSelectedStatus().equals("Failed")) {
				tc.setStatus(STATUS.FAILED);
			}
			
			save();
			updateTable();
		}
	}
	
	private void removeAction(){
		
		// If nothing is highlighted, warn user.
		if(table.getSelectedRow() < 0){
			JOptionPane.showMessageDialog(this, "Please select a test case to delete");
		}
		// Else, lets get that test case removed
		else{
			
			String id = (String) table.getModel().getValueAt(
					table.getSelectedRow(), table.ID
					);
			
			table.remTestCase(); // Remove the selected test case from table
			
			CurrentProject.getTestCaseList().removeTestCase(id);
			
			save();
			updateTable();
		}
	}
	
	private void passAction(){
int row = table.getSelectedRow();
		
		// If nothing is highlighted, warn user
		if(row < 0){
			JOptionPane.showMessageDialog(this, "Please select a test case");
		}
		// Else, lets pass the test case
		else{
			
			String id = (String) table.getModel().getValueAt(row, TestCaseTable.ID);
			TestCase tc = CurrentProject.getTestCaseList().getTestCase(id);
			tc.pass();
			
			table.setValueAt(tc.getStatusString(), row, TestCaseTable.STATUS);
			
			save();
			updateTable();
		}
	}
	
	private void failAction() {
		int row = table.getSelectedRow();
		
		// If nothing is highlighted, warn user
		if(row < 0){
			JOptionPane.showMessageDialog(this, "Please select a test case");
		}
		// Else, lets fail the test case
		else{
			
			String id = (String) table.getModel().getValueAt(row, TestCaseTable.ID);
			TestCase tc = CurrentProject.getTestCaseList().getTestCase(id);
			tc.fail();
			
			table.setValueAt(tc.getStatusString(), row, TestCaseTable.STATUS);
			
			save();
			updateTable();
		}
	}
	
	private void inProgAction() {
		
		int row = table.getSelectedRow();
		
		// If nothing is highlighted, warn user
		if(row < 0){
			JOptionPane.showMessageDialog(this, "Please select a test case");
		}
		// Else, lets reset the test case status
		else{
			
			String id = (String) table.getModel().getValueAt(row, TestCaseTable.ID);
			TestCase tc = CurrentProject.getTestCaseList().getTestCase(id);
			tc.setStatus(STATUS.INPROGRESS);
			
			table.setValueAt(tc.getStatusString(), row, TestCaseTable.STATUS);
			
			save();
			updateTable();
		}
	}
	
	// Save the test cases
	private void save(){
		 CurrentStorage.get().storeTestCaseList(
				 CurrentProject.getTestCaseList(), 
				 CurrentProject.get()
				 ); 
	}
	
	// Update the table
	private void updateTable(){
		table.getModel().fireTableDataChanged();
		table.updateUI();
	}

}
