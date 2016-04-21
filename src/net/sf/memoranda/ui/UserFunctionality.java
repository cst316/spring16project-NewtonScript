package net.sf.memoranda.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Users;
import net.sf.memoranda.UsersList;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.CurrentStorage;

public class UserFunctionality {
	
	
	
		

		
		static private int userID = 1;
		private UsersComparator userComparator;

	    public UserFunctionality(){
	    	userComparator = new UsersComparator();
	    	loadDefects();
	    	restoreUserID();
	    }
	    
	    /**
	     * Compares defects based on ID
	     * 
	     * @return DefectComparator
	     */
	    public UsersComparator getUserComp(){
	    	return userComparator;
	    }
		/**
	     *  Deletes a row in the table
	     *  
	     * @param defectID
	     * @param table
	     */
	    public void deleteRow(int defectID, JTable table){ 
	    	
	    	DefaultTableModel model = (DefaultTableModel) table.getModel();
	        UsersList dl = CurrentProject.getUsersList();
	        String id = (String) table.getValueAt(table.getSelectedRow(), 0);
	        
	        model.removeRow(table.getSelectedRow());
	        dl.removeUser(id);
	        
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

		public void addRow(JTextField first, JTextField last, JTextField depart, JTextField title, JTextField email, JTextField phone) {
			
			
	        
			UsersList userList = CurrentProject.getUsersList();
			
		
			String id         = Integer.toString(userList.getNextid());
			String firstName   = first.getText();
			String lastName   = last.getText();
			String userDepart = phone.getText();
			String userTitle  = depart.getText();
		    String userEmail  = email.getText();
			String userPhone  = phone.getText();
			

			
			
			DefaultTableModel model = (DefaultTableModel) UserPanel.getUserTable().getModel();
			
		
	        model.addRow(new String[]{id, firstName, lastName, userDepart, userTitle, userEmail, userPhone});
	        
	        // Save user in the file
	        userList.createUser(id, firstName, lastName, userDepart, userTitle, userEmail, userPhone);
	        CurrentStorage.get().storeUsersList(CurrentProject.getUsersList(), CurrentProject.get());
	        
		}
		/**
		 * Setter method for the variable defectID.
		 * @param id
		 */
		public static void setUserID(int id){
		    UserFunctionality.userID = id;
		}
		/**
		 * return the value of the user ID
		 * 
		 * @return
		 */
		public static int getUserID(){
			
			return UserFunctionality.userID;
			
		}
		/**
		 * Increments the defect id
		 */
		private void defectInc(){
			++userID;
		}
		/**
		 * Restores the users id by counting the number of rows that are in the table after the program has loaded. This 
		 * is so the program can keep the current count after user has closed the program. 
		 * 
		 */
		private void restoreUserID(){
			
			UserFunctionality.userID = UserPanel.getUserTable().getModel().getRowCount() + 1;
		}
		
		/**
		 * Load users from the file and place them on the table
		 */
		private void loadDefects() {
			UsersList userList = CurrentProject.getUsersList();
			DefaultTableModel modelOpen = (DefaultTableModel) UserPanel.getUserTable().getModel();
			
			// Sort list so that it is applied properly to table
			ArrayList<Users> list = userList.getAllUsers();
			Collections.sort(list, userComparator);
			
			for(Users user : list){
			
			    modelOpen.addRow(new String[]{
				    user.getID(), 
			        user.getTitle().toString(), 
				    user.getFirstName().toString(), 
				    user.getLastName().toString(), 
			 	    user.getDepartment().toString(),
			 	    user.getEmailAddress().toString(),
			 	    user.getPhoneNumber().toString()
			    });
				 System.out.println("Added defect " + user.getID() + " to table.");
			}
		}
		
		/**
		 * Will compare Users based on the ID.
		 * Used for sorting.
		 * 
		 * @author Jeb Johnson
		 */
		class UsersComparator implements Comparator<Users>{

			@Override
			public int compare(Users o1, Users o2) {
				return o1.getID().compareTo(o2.getID());
			}
			
		}
}
	
	


