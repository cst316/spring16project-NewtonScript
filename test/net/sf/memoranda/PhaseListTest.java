/**
 * 
 */
package net.sf.memoranda;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This tests the class <class>PhaseList</class>
 * 
 * @author Douglas Carroll
 *
 */
public class PhaseListTest {
	
	PhaseList list;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new PhaseList();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list = null;
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.PhaseList#getPhase(java.lang.String)}.
	 */
	@Test
	public void getPhaseTest() {
		String str = "test";
		
		// Add test phases to list
		list.getPhases().add(new Phase(str));
		list.getPhases().add(new Phase("tEst2"));
		list.getPhases().add(new Phase("123"));
		
		// Retrieve the phase
		Phase ph = list.getPhase(str);
		
		// Compare the retrieved phase
		assertEquals(ph.getTitle(), str);
	}
	
	/**
	 * Test if phase is not in the list
	 * 
	 * Test method for {@link net.sf.memoranda.PhaseList#getPhase(java.lang.String)}.
	 */
	@Test
	public void getPhaseTest2() {
		String str = "test";
		
		// Add test phases to list
		list.getPhases().add(new Phase("tEst2"));
		list.getPhases().add(new Phase("123"));
		
		// Retrieve the phase
		Phase ph = list.getPhase(str);
		
		// Compare the retrieved phase
		assertEquals(ph, null);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.PhaseList#getDefault()}.
	 * 
	 * Tests to see if the default (first in list) is properly retreived
	 */
	@Test
	public void getDefaultTest() {
		String str = "default";
		
		// Add test phases to list
		list.getPhases().add(new Phase(str));
		list.getPhases().add(new Phase("tEst2"));
		list.getPhases().add(new Phase("123"));
		list.getPhases().add(new Phase("test"));
		
		// Retrieve the phase
		Phase ph = list.getDefault();
		
		// Compare the retrieved phase
		assertEquals(ph.getTitle(), str);
	}

}
