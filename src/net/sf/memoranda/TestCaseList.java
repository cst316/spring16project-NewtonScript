package net.sf.memoranda;

import java.util.ArrayList;

import net.sf.memoranda.date.CalendarDate;
import nu.xom.Document;
import nu.xom.Element;

public interface TestCaseList {
	
	/**
	 * Get the current project
	 * 
	 * @return Project Current project
	 */
	public Project getProject();
	
	/**
	 * Get a testCase by ID
	 * 
	 * @param id test case ID
	 * @return TestCase test case with the same ID
	 */
	public TestCase getTestCase(String id);
	
	/**
	 * Return the element for the TestCase by ID
	 * 
	 * @param id ID of element
	 * @return Element
	 */
	public Element getTestCaseElem(String id);
	
	/**
	 * Create a test case with an element
	 * 
	 * @param e Pre-made element
	 * @return TestCase
	 */
	public TestCase createTestCase(Element e);
	
	
	/**
	 * Create a new test case
	 * 
	 * @param id
	 * @param method
	 * @param des
	 * @param testCase
	 * @param ex
	 * @param ac
	 * @return
	 */
	public TestCase createTestCase(String id, String method, 
			String des, String testCase, String ex, 
			String ac);
	
	/**
	 * Remove TestCase by ID
	 * 
	 * @param id
	 */
	public void removeTestCase(String id);
	
	/**
	 * Get an ArrayList of all the TestCases
	 * 
	 * @return ArrayList List of TestCases
	 */
	public ArrayList<TestCase> getAllTestCases();
	
	/**
	 * See if a test case with the same ID is in the list
	 * 
	 * @param id
	 * @return
	 */
	public boolean hasTestCase(String id);
	
	/**
	 * Get total test case number.
	 * 
	 * @return
	 */
	public int getTestCaseNum();
	
	/**
	 * Get total number of in progress test cases.
	 * 
	 * @return
	 */
	public int getInProgNum();
	
	/**
	 * Get number of failed test cases.
	 * 
	 * @return
	 */
	public int getFailedNum();
	
	/**
	 * Get total number of passed test cases.
	 * 
	 * @return
	 */
	public int getPassedNum();
	
	/**
	 * Get the XML content for this list
	 * 
	 * @return Document XML document
	 */
	public Document getXMLContent();
	
}
