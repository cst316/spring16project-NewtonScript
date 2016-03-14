package net.sf.memoranda.ui;

import java.util.Arrays;
import java.util.Vector;

public class UsersList {
	   private static UsersList instance = null;
	   public Vector<String> myList = new Vector<String>();
	   protected UsersList() {
	      // Exists only to defeat instantiation.
	   }
	   public static UsersList getInstance() {
	      if(instance == null) {
	         instance = new UsersList();
	      }
	      return instance;
	   }
	   public void add(String name) {
		   myList.add(name);
	   }
	   public void remove(String name) {
		   myList.remove(name);
	   }
	   public void addArray(String[] stringArray) {
		   myList.addAll(Arrays.asList(stringArray));
	   }
	   public Vector<String> getUserList() {
		   return myList;
	   }
	   public boolean isEmpty() {
		   return myList.isEmpty();
	   }
	   public String[] getNames() {
			String[] nameList = new String[myList.size()];
			for(int i = 0; i < myList.size(); i++)
				nameList[i] = myList.get(i);
			return nameList;
		}
}