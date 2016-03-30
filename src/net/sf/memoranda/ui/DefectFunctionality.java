package net.sf.memoranda.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Defect;
import net.sf.memoranda.DefectList;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ui.DefectCompleteDialog.CustomCompComboBox;
import net.sf.memoranda.ui.NewDefectDialog.CustomComboBox;
import net.sf.memoranda.util.CurrentStorage;
	
public class DefectFunctionality {
	
	static private int defectID = 1;
	private DefectComparator dc;

    public DefectFunctionality(){
    	dc = new DefectComparator();
    	loadDefects();
    	restoreDefectID();
    }
    
    /**
     * Compares defects based on ID
     * 
     * @return DefectComparator
     */
    public DefectComparator getDefectComp(){
    	return dc;
    }
	/**
     *  Deletes a row in the table
     *  
     * @param defectID
     * @param table
     */
    public void deleteRow(int defectID, JTable table){
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefectList dl = CurrentProject.getDefectList();
        String id = (String) table.getValueAt(table.getSelectedRow(), 0);
        
        model.removeRow(table.getSelectedRow());
        dl.removeDefect(id);
        
        CurrentStorage.get().storeDefectList(CurrentProject.getDefectList(), CurrentProject.get());
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

	public void addRow(CustomComboBox<Defect.DISCOVERY> newDefectDiscovery, 
			CustomComboBox<Defect.INJECTION> newDefectInjection, JSpinner newDefectDate, 
			CustomComboBox<Defect.SEVERITY> newDefectSeverity, CustomComboBox<Defect.TYPE> newDefectType, 
			JTextPane newDefectDescription) {
        
		DefectList dl = CurrentProject.getDefectList();
		String id =  Integer.toString(dl.getNextID());
		Defect.TYPE type = (Defect.TYPE) newDefectType.getItem();
		Defect.DISCOVERY dis = (Defect.DISCOVERY) newDefectDiscovery.getItem();
		Defect.INJECTION inj = (Defect.INJECTION) newDefectInjection.getItem();
		Defect.SEVERITY sev = (Defect.SEVERITY) newDefectSeverity.getItem();
		CalendarDate date = new CalendarDate((Date) newDefectDate.getModel().getValue());
		String desc = String.valueOf(newDefectDescription.getText());
		
		
		DefaultTableModel model = (DefaultTableModel) DefectTable.getOpenTable().getModel();
		
	
        model.addRow(new String[]{id, type.toString(), dis.toString(), inj.toString(), sev.toString(), date.getShortDateString(), desc});
        
        // Save defect in the file
        dl.createDefect(id, desc, inj, dis, sev, type, date);
        CurrentStorage.get().storeDefectList(CurrentProject.getDefectList(), CurrentProject.get());
        
	}
	/**
	 * Setter method for the variable defectID.
	 * @param id
	 */
	public void setDefectID(int id){
	    DefectFunctionality.defectID = id;
	}
	/**
	 * return the value of the defect ID
	 * 
	 * @return
	 */
	public int getDefectID(){
		
		return DefectFunctionality.defectID;
	}
	/**
	 * Increments the defect id
	 */
	private void defectInc(){
		++defectID;
	}
	/**
	 * Restores the defect id by counting the number of rows that are in the table after the program has loaded. This 
	 * is so the program can keep the current count after user has closed the program. 
	 * 
	 */
	private void restoreDefectID(){
		DefectFunctionality.defectID = DefectTable.getOpenTable().getModel().getRowCount() + 1;
	}
	
	/**
	 * Load defects from the file and place them on the table
	 */
	private void loadDefects() {
		DefectList dl = CurrentProject.getDefectList();
		DefaultTableModel modelOpen = (DefaultTableModel) DefectTable.getOpenTable().getModel();
		DefaultTableModel modelClosed = (DefaultTableModel) DefectTable.getClosedDefectTable().getModel();
		
		// Sort list so that it is applied properly to table
		ArrayList<Defect> list = dl.getAllDefects();
		Collections.sort(list, dc);
		
		for(Defect d : list){
			if(d.isOpen()){
				 modelOpen.addRow(new String[]{
						 d.getID(), 
						 d.getType().toString(), 
						 d.getDiscovery().toString(), 
						 d.getInj().toString(), 
		 				 d.getSeverity().toString(), 
		 				 d.getDate().getShortDateString(), 
		 				 d.getDesc() 
		 		  });
			}
			else{
				 modelClosed.addRow(new String[]{
						 d.getID(), 
						 d.getType().toString(), 
						 d.getInj().toString(), 
		 				 d.getDate().getShortDateString(), 
		 				 d.getDesc(), 
						 d.getDiscovery().toString(), 
		 				 d.getRemoval().toString(),
		 				 String.valueOf(d.getHours()),
		 				 d.getRemDate().getShortDateString(),
		 				 d.getNote()
		 		  });
			}
			 
			 System.out.println("Added defect " + d.getID() + " to table.");
		}
	}
	
	
	public void addCompletedRow(String id,Defect.DISCOVERY newDefectDiscovery, 
			Defect.INJECTION newDefectInjection, CalendarDate date, 
			Defect.SEVERITY newDefectSeverity, Defect.TYPE newDefectType, 
			String newDefectDescription, CustomCompComboBox<Defect.REMOVAL> newDefectRemoval, JSpinner newRemovalDate, 
			JTextPane notes, JSpinner manHours) {
        
		DefectList dl = CurrentProject.getDefectList();
		Defect.REMOVAL rmv = (Defect.REMOVAL) newDefectRemoval.getItem();
		CalendarDate rmvDate = new CalendarDate((Date) newRemovalDate.getModel().getValue());
		String rmvNotes = String.valueOf(notes.getText());

		String hours = Integer.toString((int) manHours.getModel().getValue());
        

 
		DefaultTableModel closedTable = (DefaultTableModel) DefectTable.getClosedDefectTable().getModel();
		JTable openTable = DefectTable.getOpenTable();
		DefaultTableModel openModel = (DefaultTableModel) openTable.getModel();


		
	
        closedTable.addRow(new String[]{id, newDefectType.toString(), newDefectInjection.toString(), date.getShortDateString(), newDefectDiscovery.toString(), 
        		newDefectDescription, rmv.toString(), hours, rmvDate.getShortDateString(), rmvNotes});
        
        // Remove the selected row
        openModel.removeRow(openTable.getSelectedRow());
        
        // Close and save
        dl.closeDefect(id, rmvDate, rmvNotes, Integer.parseInt(hours), rmv);
        CurrentStorage.get().storeDefectList(CurrentProject.getDefectList(), CurrentProject.get());

	}
	
	
	
	/**
	 * Will compare defects based on the ID.
	 * Used for sorting.
	 * 
	 * @author Douglas Carroll
	 */
	class DefectComparator implements Comparator<Defect>{

		// Sort by the string values of the ID, safer then converting to int I think.
		@Override
		public int compare(Defect o1, Defect o2) {
			return o1.getID().compareTo(o2.getID());
		}
		
	}
}
