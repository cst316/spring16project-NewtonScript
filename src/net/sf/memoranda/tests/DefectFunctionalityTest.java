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
	
	
	private DefectFunctionality df1;
	private DefectFunctionality df2;
	private DefectFunctionality df3;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		df1 = new DefectFunctionality();
		df2 = new DefectFunctionality();
		df3 = new DefectFunctionality();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void setDefectIDTest() {
		
		df1.setDefectID(12);
		df2.setDefectID(0);
		df3.setDefectID(33);
		assertTrue(df1.getDefectID() == 12);
		assertTrue(df2.getDefectID() == 0);
		assertTrue(df3.getDefectID() == 33);
		
	}
	
	

}
