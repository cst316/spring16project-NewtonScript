package net.sf.memoranda.ui;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
	
public class DefectFunctionality {
	
	static private int defectID;

    public DefectFunctionality(){
    	
    	setDefectID(1);
    	restoreDefectID();
    }
    /**
     *  Deletes a row in the table
     *  
     * @param defectID
     * @param table
     */
    public void deleteRow(int defectID, JTable table){
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(table.getSelectedRow());
    }
    /**
     * Adds a row to the table
     * 
     * @param newDefectDiscovery
     * @param newDefectInjection
     * @param newDefectDate
     * @param newDefectSeverity
     * @param newDefectType
     * @param newDefectDescription
     * @param table
     */

	public void addRow(JComboBox<?> newDefectDiscovery, JComboBox<?> newDefectInjection, JSpinner newDefectDate, JComboBox<?> newDefectSeverity, JComboBox<?> newDefectType, JTextPane newDefectDescription, JTable table) {
	
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{getDefectID(), newDefectType.getSelectedItem(), newDefectDiscovery.getSelectedItem(), newDefectInjection.getSelectedItem(), newDefectSeverity.getSelectedItem(), newDefectDate.getValue(), newDefectDescription.getText()});
        defectInc();
	}
	/**
	 * Setter method for the variable defectID.
	 * @param id
	 */
	public void setDefectID(int id){
	    DefectFunctionality.defectID = id;
	}
	/**
	 * retrun the value of the defect ID
	 * 
	 * @return
	 */
	public int getDefectID(){
		
		return DefectFunctionality.defectID;
	}
	/**
	 * Increments the defect id
	 */
	public void defectInc(){
		++defectID;
	}
	/**
	 * Restores the defect id by counting the number of rows that are in the table after the program has loaded. This 
	 * is so the program can keep the current count after user has closed the program. 
	 * 
	 */
	public void restoreDefectID(){
		DefectFunctionality.defectID = DefectTable.openDefectTable.getModel().getRowCount() + 1;
	}
}
