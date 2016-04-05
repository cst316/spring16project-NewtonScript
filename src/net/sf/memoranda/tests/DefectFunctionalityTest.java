package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ui.DefectFunctionality;

public class DefectFunctionalityTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void setDefectIDTest() {
		
		DefectFunctionality.setDefectID(12);
		assertTrue(DefectFunctionality.getDefectID() == 12);
		DefectFunctionality.setDefectID(0);
		assertTrue(DefectFunctionality.getDefectID() == 0);
		DefectFunctionality.setDefectID(33);
		assertTrue(DefectFunctionality.getDefectID() == 33);
		
	}
	
	

}
