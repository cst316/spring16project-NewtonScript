package net.sf.memoranda.ui;
import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.TestCase;
import net.sf.memoranda.util.Local;

/**
 * Table for the test cases
 * 
 * @author Doug Carroll
 */
public class TestCaseTable extends JTable {
	
	
	private DefaultTableModel model;
	private TableCellRenderer renderer;
	public static final int COLUMNS = 7;
	
	// Constants for column nums
	public static final int ID = 0;
	public static final int METHOD = 1;
	public static final int DESCRIPTION = 2;
	public static final int TESTCASE = 3;
	public static final int EXPRES = 4;
	public static final int ACTRES = 5;
	public static final int STATUS = 6;
	
	private String[] columnNames = {"ID", "Method Name",
			"Description", "Test Case",
			"Expected Results", "Actual Results",
			"Status" };
	
	private String[][] data;
	
	public TestCaseTable() {
		initComponents();
	}
	
	/**
	 * Get the model for this table
	 * 
	 * @return DefaultTableModel
	 */
	public DefaultTableModel getModel(){
		return model;
	}

	private void initComponents() {
		
		renderer = new TableCellRenderer();
		model = new DefaultTableModel(data, columnNames);
		setLayout(new FlowLayout());
		setModel(model);
		getTableHeader().setReorderingAllowed(false);
		setShowGrid(false);
		setRowHeight(50);
		this.setVisible(true);
		
		// Set the renderer for the status column
		getColumnModel().getColumn(STATUS).setCellRenderer(renderer);
		
		initColumns();
	}
	
	private void initColumns(){
		TableColumn column;
		
		for(int i = 0; i < COLUMNS; i++){
			column = getColumnModel().getColumn(i);
			// Make last and first column smaller
			if(i == STATUS || i == ID){
				column.setPreferredWidth(10);
			}
			// Make method and description column biggest
			else if(i == METHOD || i == DESCRIPTION){
				 column.setPreferredWidth(250);
			}
			else{
				column.setPreferredWidth(100);
			}
		}
	}
	
	/**
	 * Add a test case to the table
	 * 
	 * @param tc
	 */
	public void addTestCase(TestCase tc){
		model.addRow(new String[]{
				tc.getID(),          // Row 0
				tc.getMethod(),      // Row 1
				tc.getDescription(), // Row 2
				tc.getTestCase(),    // Row 3
				tc.getExpectedRes(), // Row 4
				tc.getActualRes(),   // Row 5
				tc.getStatusString() // Row 6
				});
	}
	
	/**
	 * Remove the selected test case from the table
	 * 
	 */
	public void remTestCase(){
		model.removeRow(getSelectedRow());
	}
	
	// Get all the values in the row
	public String[] getRowValues(){
		int row = getSelectedRow();
		String rowValues[] = new String[COLUMNS];
		
		for(int i = 0; i < COLUMNS; i++){
			rowValues[i] = (String) model.getValueAt(row, i);
		}
		
		return rowValues;
	}
	
	// Override the cell render for the status column
	class TableCellRenderer extends DefaultTableCellRenderer{
	
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
			
			JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			setHorizontalAlignment(SwingConstants.CENTER);
			
			if(label.getText().equals(TestCase.PASSED)){
				label.setBackground(Color.green);
			}
			else if(label.getText().equals(TestCase.FAILED)){
				label.setBackground(Color.red);
			}
			else{
				label.setBackground(Color.white);
			}
			
			return label;
			
		}
	}
}
