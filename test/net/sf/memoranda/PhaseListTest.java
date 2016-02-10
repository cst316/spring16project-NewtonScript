/**
 * 
 */
package net.sf.memoranda;

import static org.junit.Assert.*;
import nu.xom.Attribute;
import nu.xom.Element;

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
	Phase phase;
	TaskList taskList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Element e = new Element("elem");
		ProjectManager.getProject("__default");
		Project prj = ProjectManager.getProject("__default");
		taskList = new TaskListImpl(e, prj);
		phase = new Phase(e, taskList);
		list = new PhaseList(prj);
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
		String testName = "testname";
		Element e = new Element("task");
		Element txt = new Element("text");
		txt.appendChild(testName);
		e.appendChild(txt);
	
		// Add test phases to list
		list.getPhases().add(new Phase(e, taskList));
		
		// Retrieve the phase
		Phase ph = list.getPhase(testName);
		
		// Compare the retrieved phase
		assertEquals(ph.getTitle(), testName);
	}
	
	
	/**
	 * Test method for {@link net.sf.memoranda.PhaseList#createPhase(java.lang.String)}.
	 */
	@Test
	public void createPhaseTest() {
		String testName = "testname";
		
		Phase phase = list.createPhase(testName);
		
		// Compare the retrieved phase with various default values
		assertEquals(phase.getTitle(), testName);
		assertEquals(phase.getPriority(), 5);
		assertEquals(phase.getProgress(), 0);
	}

}
