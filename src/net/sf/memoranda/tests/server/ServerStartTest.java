/**
 * 
 */
package net.sf.memoranda.server;

import static org.junit.Assert.*;

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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String[] args = null;
		ServerStart.main(args);
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
		assertEquals(true, ServerStart.isRunning());
	}

}
