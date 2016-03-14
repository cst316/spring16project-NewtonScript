/**
 * 
 */
package net.sf.memoranda.tests;

import static org.junit.Assert.*;
import net.sf.memoranda.Phase;
import net.sf.memoranda.PhaseList;
import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectManager;
import net.sf.memoranda.Task;
import net.sf.memoranda.TaskList;
import net.sf.memoranda.TaskListImpl;
import net.sf.memoranda.date.CalendarDate;
import nu.xom.Attribute;
import nu.xom.Element;
import net.sf.memoranda.util.Util;

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
	
	/**
	 * Test method for {@link net.sf.memoranda.PhaseList#getElementByID(java.lang.String)}.
	 * 
	 * Get a phase element by ID
	 */
	@Test
	public void getElementByIDTest() {
		String testName = "testname";
		Phase phase = list.createPhase(testName);
		
		// Retrieve the phase
		Element e = list.getElementByID(phase.getID());
		
		// Compare the retrieved element
		assertEquals(e.getFirstChildElement("text").getValue(), testName);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.PhaseList#getAllByID(java.lang.String)}.
	 * 
	 * Get a phase by ID
	 */
	@Test
	public void getAllByIDTest() {
		String testName = "testname";
		Phase phase = list.addNewPhase(testName);
		
		// Retrieve the phase
		Task t = list.getAllByID(phase.getID());
		
		// Compare the retrieved task
		assertEquals(t.getID(), phase.getID());
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.PhaseList#removeTask(net.sf.memoranda.Task)}.
	 * 
	 * Remove a task
	 */
	@Test
	public void removeTaskTest() {
		String testName = "testname";
		Task phase = list.createPhase(testName);
		
		// Retrieve the phase
		list.removeTask(phase);
		
		// If phase not found, then test passes
		assertNull(list.getPhase(testName));
	}
	
	
}
