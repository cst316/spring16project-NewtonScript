package net.sf.memoranda;

import static org.junit.Assert.*;
import nu.xom.Element;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This tests the class <class>Phase</class>
 * 
 * 
 * @author Douglas Carroll
 *
 */

public class PhaseTest {
	
	Phase phase;
	
	@Before
	public void setUp() throws Exception {
		phase = new Phase("test");
	}

	@After
	public void tearDown() throws Exception {
		phase = null;
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#toElement()}.
	 * 
	 * This method checks if the proper title value is being written to the element 
	 */
	@Test
	public void toElementTest() {
		phase.setTitle("test");
		Element e = phase.toElement();
		String str = e.getAttributeValue("title");
		
		assertEquals("test", str);
	}

}
