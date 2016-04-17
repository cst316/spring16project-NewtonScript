package net.sf.memoranda;

import java.util.*;
import java.util.Vector;

import nu.xom.Document;
import nu.xom.Element;

public interface UsersList {
	
	/**
	 * Get the current project
	 * 
	 * @return Project Current project
	 */
	public Project getProject();
	
	/**
	 * Get a user by ID
	 * 
	 * @param id User ID
	 * @return User user with the same ID
	 */
	public Users getUser(String id);
	
	/**
	 * Return the element for the User by ID
	 * 
	 * @param id ID of element
	 * @return Element
	 */
	public Element getUserElem(String id);
	
	/**
	 * Create a user with an element
	 * 
	 * @param e Pre-made element
	 * @return User
	 */
	public Users createUser(Element e);
	
	
	/**
	 * Create a new test case
	 * 
	 * @param id
	 * @param first
	 * @param last
	 * @param depart
	 * @param title
	 * @param email
	 * @param phone
	 * @return
	 */
	public Users createUser(String id, String first, 
			String last, String depart, String title, 
			String email, String phone);
	
	/**
	 * Remove user by ID
	 * 
	 * @param id
	 */
	public void removeUser(String id);
	
	/**
	 * Get an ArrayList of all the Users
	 * 
	 * @return ArrayList List of Users
	 */
	public ArrayList<Users> getAllUsers();
	
	/**
	 * Get an ArrayList of names of all the Users
	 * 
	 * @return ArrayList List of Users
	 */
	public Vector<String> getUserNames();
	
	/**
	 * See if a user with the same ID is in the list
	 * 
	 * @param id
	 * @return
	 */
	public boolean hasUser(String id);
	
	/**
	 * Get the XML content for this list
	 * 
	 * @return Document XML document
	 */
	public Document getXMLContent();
	
}