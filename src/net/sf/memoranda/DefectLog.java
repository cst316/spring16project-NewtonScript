package net.sf.memoranda;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class DefectLog {
	
	private int defectID;
	
	public DefectLog(){
		setDefectID(0);
	}
	/**
	 * public void addRow(JTextPane injection, JTextPane removal, JTextPane hours, JTextPane description, JTable table)
	 * 
	 * Method that adds rows to the defect table desired table
	 *               
	 * 
	 * @param defectID          An integer that will increment to give each defect a unique ID number. 
	 * @param injection         A string that indicates where the defect happened.
	 * @param removal           A string indicating where the defect was removed
	 * @param hours             A string estimating how many hours will be needed to fix the defect
	 * @param description       A string indicating some additional information about the defect
	 * @param table             A variable respective table where the data will be input to.
	 */
	public void addRow(JTextPane injection, JTextPane removal, JTextPane hours, JTextPane description, JTable table){
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{getDefectID(), injection.getText(), removal.getText(), hours.getText(), description.getText()});
	}
	/**
	 * public void deleteRow(JTable table)
	 * 
	 * Method deletes row from the  defect table
	 * 
	 * @param table          The table where the row will be deleted
	 */
	public void deleteRow(JTable table){
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(table.getSelectedRow());
	}
	
	public int getDefectID() {
		defectID++;
		return defectID;
	}
	public void setDefectID(int defectID) {
		this.defectID = defectID;
	}

}

















