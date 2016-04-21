package net.sf.memoranda;

import nu.xom.Element;

/**
 * Interface for users
 */
public interface Users {
	
	// Constants for key storage
	public static final String ID = "id";
	public static final String FIRST = "firstName";
	public static final String LAST = "lastName";
	public static final String DEPART = "department";
	public static final String TITLE = "title";
	public static final String EMAIL = "emailAddress";
	public static final String PHONE = "phoneNumber";
	
	
	/**
	 * Get the user ID.
	 *
	 * @return String ID
	 */
	public String getID();
	
	/**
	 * Get the first name.
	 *
	 * @return String first name
	 */
	public String getFirstName();
	
	/**
	 * Get the last name.
	 *
	 * @return String last name
	 */
	public String getLastName();
	
	/**
	 * Get the department.
	 *
	 * @return String department
	 */
	public String getDepartment();
	
	/**
	 * Get the title.
	 *
	 * @return String title
	 */
	public String getTitle();
	
	/**
	 * Get the email address.
	 *
	 * @return String email address
	 */
	public String getEmailAddress();
	
	/**
	 * Get the phone number
	 * 
	 * @return String phone Number
	 */
	public String getPhoneNumber();
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 */
	public void setID(String id);
	
	/**
	 * Sets the first name
	 * 
	 * @param first
	 */
	public void setFirstName(String first);
	
	/**
	 * Sets the last name
	 * 
	 * @param last
	 */
	public void setLastName(String last);
	
	/**
	 * Sets the department
	 * 
	 * @param depart
	 */
	public void setDepartment(String depart);
	
	/**
	 * Sets the title
	 * 
	 * @param title
	 */
	public void setTitle(String title);
	
	/**
	 * Sets the email address.
	 * 
	 * @param email
	 */
	public void setEmailAddress(String email);
	
	/**
	 *  Set the phone number
	 * 
	 * @param phone
	 */
	public void setPhoneNumber(String phone);

	/**
	 * Get the element for this user
	 * 
	 * @return Element
	 */
	public Element getElement();
	
}