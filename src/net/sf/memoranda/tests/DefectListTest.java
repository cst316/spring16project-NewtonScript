package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import net.sf.memoranda.Defect;
import net.sf.memoranda.DefectImpl;
import net.sf.memoranda.DefectList;
import net.sf.memoranda.DefectListImpl;
import net.sf.memoranda.ProjectManager;
import net.sf.memoranda.Defect.DISCOVERY;
import net.sf.memoranda.Defect.INJECTION;
import net.sf.memoranda.Defect.REMOVAL;
import net.sf.memoranda.Defect.SEVERITY;
import net.sf.memoranda.Defect.TYPE;
import net.sf.memoranda.date.CalendarDate;
import nu.xom.Element;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefectListTest {
	
	DefectList dl;

	@Before
	public void setUp() throws Exception {
		// Use the default project for testing
		dl = new DefectListImpl(ProjectManager.getProject("_default"));
	}

	@After
	public void tearDown() throws Exception {
		dl = null;
	}

	/**
	 * Tests if getDefect() returns the same defect that was created
	 */
	@Test
	public void testGetDefect() {
		String id = "1234";
		String desc = "Test description";
		Element e = new Element("Defect");
		Defect def = new DefectImpl(e);
		def.setID(id);
		def.setDesc(desc);
		
		dl.createDefect(def.getContent());
		
		assertEquals(dl.getDefect(id).getDesc(), desc);
	}

	/**
	 * Tests if the correct element is returned from getDefectElem()
	 */
	@Test
	public void testGetDefectElem() {
		String id = "1234";
		Element e = new Element("Defect");
		Defect def = new DefectImpl(e);
		def.setID(id);
		
		dl.createDefect(def.getContent());
		
		assertEquals(dl.getDefectElem(id), e);
	}

	/**
	 * Tests creating a defect from an element
	 */
	@Test
	public void testCreateDefectElem() {
		String id = "1234";
		Element e = new Element("Defect");
		Defect def = new DefectImpl(e);
		Defect testDef;
		def.setID(id);
		
		testDef = dl.createDefect(def.getContent());
		
		assertEquals(def.getID(), testDef.getID());
	}

	/**
	 * Tests creating defect from raw data
	 */
	@Test
	public void testCreateDefectParms() {
		String id = "1234";
		String desc = "TestDesc"; 
		INJECTION inj = Defect.INJECTION.REQUIREMENTS; 
		DISCOVERY dis = Defect.DISCOVERY.IMPLEMENTATION; 
		SEVERITY sev = Defect.SEVERITY.MEDIUM; 
		TYPE type = Defect.TYPE.INTERFACE; 
		CalendarDate date = new CalendarDate(3, 20, 2016);
		
		Defect def = dl.createDefect(id, desc, inj, dis, sev, type, date);
		
		assertEquals(def.getID(), id);
		assertEquals(def.getDesc(), desc);
		assertEquals(def.getInj(), inj);
		assertEquals(def.getDiscovery(), dis);
		assertEquals(def.getSeverity(), sev);
		assertEquals(def.getType(), type);
		assertEquals(def.getDate().toString(), date.toString());

	}

	/**
	 * Test to make sure defect is closed properly
	 */
	@Test
	public void testCloseDefect() {
		String id = "1234";
		Element e = new Element("Defect");
		Defect def = new DefectImpl(e);
		CalendarDate remDate = new CalendarDate(3, 20, 2016);
		String notes = "Test Notes.";  
		int hours = 56; 
		REMOVAL rem = Defect.REMOVAL.REQUIREMENTS;
		def.setID(id);
		dl.createDefect(e);
		
		dl.closeDefect(id, remDate, notes, hours, rem);
		
		assertEquals(def.getRemDate().toString(), remDate.toString());
		assertEquals(def.getNote(), notes);
		assertEquals(def.getHours(), hours);
		assertEquals(def.getRemoval(), rem);
	}

	/**
	 * Tests that a defect is removed properly by id.
	 */
	@Test
	public void testRemoveDefect() {
		String id = "1234";
		Element e = new Element("Defect");
		Defect def = new DefectImpl(e);
		def.setID(id);
		dl.createDefect(e);
		// Make sure array is populated, so we don't get false positives below
		assertNotNull(dl.getDefect(id).getContent());
		
		dl.removeDefect(id);
		
		// Test if the defect was removed (should get a null back)
		assertNull(dl.getDefect(id).getContent());
		
	}

	/**
	 * Ensures the correct defects are received.
	 */
	@Test
	public void testGetAllDefects() {
		int defectNum = 100;
		// Builds 100 defects for testing
		for(int i = 0; i < defectNum; i++){
			Element e = new Element("Defect");
			String id = Integer.toString(i);
			Defect def = new DefectImpl(e);
			def.setID(id);
			dl.createDefect(e);
		}
		
		ArrayList<Defect> defList = dl.getAllDefects();

		// Check the array size first
		assertEquals(defList.size(), defectNum);
		
		// Go through the list and ensure everything is there.
		for(int j = 0; j < defectNum; j++){
			System.out.println(defList.get(j).getID());
			assertEquals((Integer.toString(j)), defList.get(j).getID());
		}
	}

	/**
	 * Tests to make sure the next ID available is correctly returned.
	 */
	@Test
	public void testGetNextID() {
		int defectNum = 27;
		
		// Create defects with id's from 1 to defectNum
		for(int i = 1; i <= defectNum; i++){
			String id = Integer.toString(i);
			Element e = new Element("Defect");
			Defect def = new DefectImpl(e);
			def.setID(id);
			dl.createDefect(e);
		}
		
		assertEquals(dl.getNextID(), (defectNum + 1));
		
	}

}
