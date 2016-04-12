package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class TestCaseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel outerGrid;
	private JTextField idTextField;
	private JTextField methodTextField;
	private JTextField expectedTF;
	private JTextField actualTextField;
	private JTextField testCaseTextField;
	private JComboBox statusCB;
	private JTextArea textArea;
	private String selectedID, selectedMethod, selectedDescription, 
		selectedExpected, selectedActual, selectedTestCase, selectedStatus;
	private boolean canceled = false;

	/**
	 * Create the dialog.
	 */
	public TestCaseDialog(Frame appFrame) { 
		super(appFrame, Dialog.ModalityType.APPLICATION_MODAL);
		display();
		run();
	}
	public TestCaseDialog(Frame appFrame, String testID, String testMethod,
			String testDescription, String testExpected, String testActual,
			String testTestCase, String testStatus) { 
		super(appFrame, Dialog.ModalityType.APPLICATION_MODAL);
		display();
		//Sets the text fields as the test case info
		//so the user can see
		setSelectedID(testID);
		setSelectedMethod(testMethod);
		setSelectedDescription(testDescription);
		setSelectedTestCase(testTestCase);
		setSelectedExpected(testExpected);
		setSelectedActual(testActual);
		setSelectedStatus(testStatus);
		idTextField.setEditable(false);
		run();
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public void run() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(500, 300));
		setVisible(true);
		pack();
	}
	private void display() {
		outerGrid = new JPanel(new GridLayout(2, 1));
		JPanel lowerPanel = new JPanel();
		JPanel upperPanel = new JPanel(new GridLayout(4, 2));
		/*
		 * Start grid panels:
		 * 
		 *  0 1
		 * 0{}{}
		 * 1{}{}
		 * 2{}{}
		 * 3{}{}
		 */
		JPanel grid00 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid01 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid10 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid20 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid21 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid30 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel grid31 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
		
		setTitle("Input Test Case Info");
		setAlwaysOnTop(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout());
		
		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(29, 30, 30, 16);
		grid00.add(idLabel);
		
		idTextField = new JTextField();
		grid00.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel methodLabel = new JLabel("Method:");
		grid01.add(methodLabel);
		
		methodTextField = new JTextField();
		grid01.add(methodTextField);
		methodTextField.setColumns(10);

		JPanel desLabel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		desLabel.setAlignmentY(Component.LEFT_ALIGNMENT);
		JLabel descriptionLabel = new JLabel("Description");
		desLabel.add(descriptionLabel);
		lowerPanel.add(desLabel);
		
		JLabel statusLabel = new JLabel("Status:");
		grid11.add(statusLabel);
		
	    statusCB = new JComboBox();
		statusCB.setModel(new DefaultComboBoxModel(new String[] {"In Progress", "Passed", "Failed"}));
		statusCB.setMaximumRowCount(3);
		grid11.add(statusCB);
		
		JLabel expectedLabel = new JLabel("Expected Result:");
		grid10.add(expectedLabel);
		
		expectedTF = new JTextField();
		grid10.add(expectedTF);
		expectedTF.setColumns(10);
		
		JLabel actualLabel = new JLabel("Actual Result:");
		grid20.add(actualLabel);
		
		actualTextField = new JTextField();
		grid20.add(actualTextField);
		actualTextField.setColumns(10);
		
		JLabel testCaseLabel = new JLabel("Test Case:");
		grid21.add(testCaseLabel);
		
		testCaseTextField = new JTextField();
		grid21.add(testCaseTextField);
		testCaseTextField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setColumns(10);
		lowerPanel.add(textArea);
		
		upperPanel.add(grid00);
		upperPanel.add(grid01);
		upperPanel.add(grid10);
		upperPanel.add(grid11);
		upperPanel.add(grid20);
		upperPanel.add(grid21);
		upperPanel.add(grid30);
		upperPanel.add(grid31);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save the information in variables
				okButtonPressed();
				//If one of the boxes is empty, warn the user.
				if(checkForNull()) {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(App.getFrame(), "Please enter information in all the boxes.");
					setAlwaysOnTop(true);
				} else {
					dispose();
				}
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canceled = true;
				dispose();
			}
		});
		buttonPane.add(cancelButton);
		outerGrid.add(upperPanel);
		outerGrid.add(lowerPanel);
		contentPanel.add(outerGrid);
	}
	private void okButtonPressed() {
		//Saves the selected items into variables
    	if(!idTextField.getText().isEmpty()) {
    		selectedID = idTextField.getText();
    	}
    	if(!methodTextField.getText().isEmpty()) {
    		selectedMethod = methodTextField.getText();
    	}
    	if(!expectedTF.getText().isEmpty()) {
    		selectedExpected = expectedTF.getText();
    	}
    	if(!actualTextField.getText().isEmpty()) {
    		selectedActual = actualTextField.getText();
    	}
    	if(!testCaseTextField.getText().isEmpty()) {
    		selectedTestCase = testCaseTextField.getText();
    	}
    	if(!textArea.getText().isEmpty()) {
    		selectedDescription = textArea.getText();
    	}
    	selectedStatus = String.valueOf(statusCB.getSelectedItem());
	}
	public String getSelectedID() {
		return selectedID;
	}
	public String getSelectedMethod() {
		return selectedMethod;
	}
	public String getSelectedExpected() {
		return selectedExpected;
	}
	public String getSelectedActual() {
		return selectedActual;
	}
	public String getSelectedDescription() {
		return textArea.getText();
	}
	public String getSelectedTestCase() {
		return selectedTestCase;
	}
	public String getSelectedStatus() {
		return selectedStatus;
	}
	public void setSelectedID(String testID) {
		idTextField.setText(testID);
	}
	public void setSelectedMethod(String testMethod) {
		methodTextField.setText(testMethod);
	}
	public void setSelectedExpected(String testExpected) {
		expectedTF.setText(testExpected);
	}
	public void setSelectedActual(String testActual) {
		actualTextField.setText(testActual);
	}
	public void setSelectedDescription(String testDescription) {
		textArea.setText(testDescription);
	}
	public void setSelectedTestCase(String testTestCase) {
		testCaseTextField.setText(testTestCase);
	}
	public void setSelectedStatus(String testStatus) {
		statusCB.setSelectedItem(testStatus);
	}
	public boolean checkForNull() {
		boolean nullCheck;
		if(idTextField.getText().isEmpty()) {
			nullCheck = true;
		} else if (methodTextField.getText().isEmpty()) {
			nullCheck = true;
		} else if (textArea.getText().isEmpty()) {
			nullCheck = true;
		} else if (actualTextField.getText().isEmpty()) {
			nullCheck = true;
		} else if (expectedTF.getText().isEmpty()) {
			nullCheck = true;
		} else if (testCaseTextField.getText().isEmpty()) {
			nullCheck = true;
		} else {
			nullCheck = false;
		}
		return nullCheck;
	}
}