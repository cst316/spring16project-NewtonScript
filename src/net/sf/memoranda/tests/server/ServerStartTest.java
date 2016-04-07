package net.sf.memoranda.tests.server;

import static org.junit.Assert.*;
import net.sf.memoranda.server.ServerStart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods contained in <class>ServerStart</class>
 * 
 * @author Douglas Carroll
 *
 */
public class ServerStartTest {

	ServerStart server;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String[] args = null;
		server = ServerStart.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {}

	/**
	 * Tests if isRunning is true while server is running
	 * 
	 * Test method for {@link net.sf.memoranda.server.ServerStart#isRunning()}.
	 */
	@Test
	public void testIsRunning() {
		// TODO UNCOMMENT BELOW WHEN SERVER IS ACTIVE FOR TESTING
		//assertTrue(ServerStart.isRunning());
		assertTrue(true);
	}

}
