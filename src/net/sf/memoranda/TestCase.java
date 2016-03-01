package net.sf.memoranda;

import nu.xom.Element;

/**
 * Interface for test cases
 * 
 * @author Doug Carroll
 */
public interface TestCase {
	
	// Constants for key storage
	public static final String ID = "id";
	public static final String METHOD = "method";
	public static final String DES = "description";
	public static final String TC = "testcase";
	public static final String ER = "expectedResults";
	public static final String AR = "actualResults";
	public static final String PASS = "pass";
	
	// Constants for display names
	public static final String INPROG = "In Progress";
	public static final String PASSED = "Passed";
	public static final String FAILED = "Failed";
	
	// Options for test case result
	public static enum STATUS { 
		INPROGRESS,
		FAILED,
		PASSED
	}
	
	/**
	 * Get the test case ID.
	 *
	 * @return String ID
	 */
	public String getID();
	
	/**
	 * Get the method to be tested.
	 *
	 * @return String method
	 */
	public String getMethod();
	
	/**
	 * Get the test case description.
	 *
	 * @return String description
	 */
	public String getDescription();
	
	/**
	 * Get the test case.
	 *
	 * @return String test case
	 */
	public String getTestCase();
	
	/**
	 * Get the expected results.
	 *
	 * @return String expected results
	 */
	public String getExpectedRes();
	
	/**
	 * Get the actual results.
	 *
	 * @return String actual results
	 */
	public String getActualRes();
	
	/**
	 * Get the status of the test case.
	 * 
	 * @return STATUS
	 */
	public STATUS getStatus();
	
	/**
	 * Get the status as a readable string
	 * 
	 * @return String
	 */
	public String getStatusString();
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 */
	public void setID(String id);
	
	/**
	 * Sets the method.
	 * 
	 * @param m
	 */
	public void setMethod(String m);
	
	/**
	 * Sets the description.
	 * 
	 * @param des
	 */
	public void setDescription(String des);
	
	/**
	 * Sets the test case.
	 * 
	 * @param tc
	 */
	public void setTestCase(String tc);
	
	/**
	 * Sets the expected res
	 * 
	 * @param e
	 */
	public void setExpectedRes(String e);
	
	/**
	 * Sets the actual res.
	 * 
	 * @param ar
	 */
	public void setActualRes(String ar);
	
	/**
	 *  Set the status for the test case
	 * 
	 * @param s
	 */
	public void setStatus(STATUS s);
	
	/**
	 * Change test case status to failed
	 */
	public void fail();
	
	/**
	 * Change test case status to passed
	 */
	public void pass();
	
	/**
	 * Get the element for this test case
	 * 
	 * @return Element
	 */
	public Element getElement();
	
}
