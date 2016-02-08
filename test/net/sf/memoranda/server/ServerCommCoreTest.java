/**
 * 
 */
package net.sf.memoranda.server;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This tests the class <class>ServerCommCore</class>
 * 
 * 
 * @author Douglas Carroll
 *
 */
public class ServerCommCoreTest {

	private ServerCommCore testObj;
	private String testStr = "Testing String for JSON";
	private String originalMOTD; // Save the original to replace it at the end of testing
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testObj = new ServerCommCore();
		originalMOTD = testObj.getMOTD(); // Get original MOTD
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testObj.setMOTD(originalMOTD); // Set original MOTD back in file
		testObj = null;
	}

	/**
	 * Test method for {@link net.sf.memoranda.server.ServerCommCore#getMOTD()}.
	 * 
	 * This method checks if the proper values are being retrieved from the JSON file 
	 */
	@Test
	public void testGetMOTD() {
		testObj.setMOTD(testStr);
		
		assertEquals(testStr, testObj.getMOTD());
	}

	/**
	 * Test method for {@link net.sf.memoranda.server.ServerCommCore#setMOTD(java.lang.String, java.lang.String)}.
	 * 
	 * This method checks if the proper values are being written to the JSON file  
	 */
	@Test
	public void testSetMOTD() {
		testObj.setMOTD(testStr);
		
		assertEquals(testStr, testObj.getMOTD());
		
	}

}
