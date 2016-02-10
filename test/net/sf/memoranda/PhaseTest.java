package net.sf.memoranda;

import static org.junit.Assert.*;
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
	
	@Before
	public void setUp() throws Exception {
		Element e = new Element("elem");
		ProjectManager.getProject("__default");
		Project prj = ProjectManager.getProject("__default");
		list = new TaskListImpl(e, prj);
		phase = new Phase(e, list);
	}

	@After
	public void tearDown() throws Exception {
		phase = null;
		list = null;
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
	
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#getTaskElementByID()}.
	 * 
	 * This method checks if the correct element object is returned
	 */
	@Test
	public void getTaskElementByIDTest(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("id", "test1234"));
		list.addElement(e);
		String id = e.getAttribute("id").getValue();
		
		Element testElem = phase.getTaskElementByID(id);
		testElem.addAttribute(new Attribute("id", "test1234"));
		String testID = testElem.getAttribute("id").getValue();
		
		
		assertEquals(id, testID);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#getStartDate()}.
	 * 
	 * This method checks if the correct date from subtasks is returned
	 */
	@Test
	public void getStartDateTest(){
		Element e = new Element("task");
		Element e1 = new Element("task");
		e.addAttribute(new Attribute("startDate", "9/1/2016"));
		e1.addAttribute(new Attribute("startDate", "9/1/2016"));
		list.addElement(e);
		String id = e.getAttribute("startDate").getValue();
		
		Element testElem = new Element("teste");
		testElem.addAttribute(new Attribute("startDate", "9/1/2016"));
		
		Phase ph = new Phase(testElem, list);
		String testID = ph.getStartDate().toString();
		
		
		assertEquals(id, testID);
	}
	

	/**
	 * Test method for {@link net.sf.memoranda.Phase#getPriority()}.
	 * 
	 * This method checks if the correct date is returned
	 */
	@Test
	public void getPriorityTest(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("priority", "2"));
		list.addElement(e);
		int num = new Integer(e.getAttribute("priority").getValue());
		
		Element testElem = new Element("teste");
		testElem.addAttribute(new Attribute("priority", "2"));
		
		Phase ph = new Phase(testElem, list);
		int testNum = ph.getPriority();
		
		
		assertEquals(num, testNum);
	}
	
	/**
	 * Test method for {@link net.sf.memoranda.Phase#getPriority()}.
	 * 
	 * This method checks if the correct date is returned when set as priority phase (5)
	 */
	@Test
	public void getPriorityTest2(){
		Element e = new Element("task");
		e.addAttribute(new Attribute("priority", "5"));
		list.addElement(e);
		int num = new Integer(e.getAttribute("priority").getValue());
		
		Element testElem = new Element("teste");
		testElem.addAttribute(new Attribute("priority", "5"));
		
		Phase ph = new Phase(testElem, list);
		int testNum = ph.getPriority();
		
		
		assertEquals(num, testNum);
	}

}
