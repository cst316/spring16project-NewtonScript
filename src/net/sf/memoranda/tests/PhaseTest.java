package net.sf.memoranda.tests;

import static org.junit.Assert.*;
import net.sf.memoranda.Phase;
import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectManager;
import net.sf.memoranda.TaskList;
import net.sf.memoranda.TaskListImpl;
import net.sf.memoranda.date.CalendarDate;
import nu.xom.Attribute;
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
	TaskList list;
	Project prj;
	
	@Before
	public void setUp() throws Exception {
		Element e = new Element("elem");
		ProjectManager.getProject("__default");
		prj = ProjectManager.getProject("__default");
		list = new TaskListImpl(e, prj);
		phase = new Phase(e, list);
	}

	@After
	public void tearDown() throws Exception {
		phase = null;
		list = null;
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#getStartDate()}.
	 * 
	 * This method checks if the correct date from subtasks is returned
	 * -- SAVED FOR LATER USE WITH FUTURE STORY
	 */
	@Test
	public void getStartDateTest(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("id", "test-e"));
		e.addAttribute(new Attribute("startDate", "9/1/2016"));
		list.addElement(e);
		String id = "9/1/2016";
		
		Element testElem = new Element("teste");
		testElem.addAttribute(new Attribute("startDate", "9/1/2016"));
		
		Phase ph = new Phase(testElem, list);
		String testID = ph.getStartDate().toString();
		
		
		assertEquals(id, testID);
	}
	

	/**
	 * Test method for {@link net.sf.memoranda.Phase#getPriority()}.
	 * 
	 * This method checks if the correct priority is returned
	 */
	@Test
	public void getPriorityTest(){
		int num = 2;
		
		Element testElem = new Element("teste");
		testElem.addAttribute(new Attribute("priority", "2"));
		
		Phase ph = new Phase(testElem, list);
		int testNum = ph.getPriority();
		
		
		assertEquals(num, testNum);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#getPriority()}.
	 * 
	 * This method checks if the correct priority is returned when set as priority phase (5)
	 */
	@Test
	public void getPriorityTest2(){
		int num = 5;
		
		Element testElem = new Element("teste");
		testElem.addAttribute(new Attribute("priority", "5"));
		
		Phase ph = new Phase(testElem, list);
		int testNum = ph.getPriority();
		
		
		assertEquals(num, testNum);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#getPriority()}.
	 * 
	 * This method checks if the correct date is returned
	 */
	@Test
	public void getTextTest(){
		Element e = new Element("task");
		Element txt = new Element("text");
        txt.appendChild("test");
        e.appendChild(txt);
		
		Phase ph = new Phase(e, list);
		String test = ph.getText();
		
		assertEquals("test", test);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#setProgress(int)}.
	 * 
	 * This method checks if the correct progress value is accepted or denied
	 * 
	 * (p >= 0) && (p <= 100)
	 */
	@Test
	public void setProgressTest(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("progress", "0"));
		Phase ph = new Phase(e, list);
		ph.setProgress(-1);
		
		int pro = ph.getProgress();
		
		// Value should be zero
		assertEquals(pro, 0);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#setProgress(int)}.
	 * 
	 * This method checks if the correct progress value is accepted or denied
	 * 
	 * (p >= 0) && (p <= 100)
	 */
	@Test
	public void setProgressTest1(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("progress", "0"));
		
		Phase ph = new Phase(e, list);
		ph.setProgress(0);
		
		int pro = ph.getProgress();
		
		// Value should be zero
		assertEquals(pro, 0);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#setProgress(int)}.
	 * 
	 * This method checks if the correct progress value is accepted or denied
	 * 
	 * (p >= 0) && (p <= 100)
	 */
	@Test
	public void setProgressTest2(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("progress", "0"));
		
		Phase ph = new Phase(e, list);
		ph.setProgress(100);
		
		int pro = ph.getProgress();
		
		// Value should be 100
		assertEquals(pro, 100);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#setProgress(int)}.
	 * 
	 * This method checks if the correct progress value is accepted or denied
	 * 
	 * (p >= 0) && (p <= 100)
	 */
	@Test
	public void setProgressTest3(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("progress", "0"));
		
		Phase ph = new Phase(e, list);
		ph.setProgress(101);
		
		int pro = ph.getProgress();
		
		// Value should be 0
		assertEquals(pro, 0);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#setDescription(String)}.
	 * 
	 * This method checks if the correct description is applied
	 *
	 */
	@Test
	public void setDescriptionTest(){
		Element e = new Element("task");
		
		Phase ph = new Phase(e, list);
		ph.setDescription("test123");
		
		String res = ph.getDescription();
		
		assertEquals(res, "test123");
	}
	
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#freeze()}.
	 * 
	 * This method checks if the method was properly frozen
	 *
	 */
	@Test
	public void freezeTest(){
		Element e = new Element("task");
		
		Phase ph = new Phase(e, list);
		ph.freeze();
		
		assertTrue(ph.isFrozen());
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#unfreeze()}.
	 * 
	 * This method checks if the method was properly unfrozen
	 *
	 */
	@Test
	public void unfreezeTest(){
		Element e = new Element("task");
		
		Phase ph = new Phase(e, list);
		ph.freeze();
		
		ph.unfreeze();
		
		assertFalse(ph.isFrozen());
	}
}
