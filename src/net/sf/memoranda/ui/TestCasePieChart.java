package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.TestCase;

/**
 * This panel holds the test case pie with all chart options.
 * 
 * @author Douglas Carroll
 */
public class TestCasePieChart extends PieChartPopulatedPanel{
	
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "Test Case Status";
	public static final int STARTVAL = 0; // Starting value for each section
 
	private int inProgValue = 0;
	private int passedValue = 0;
	private int failedValue = 0;
	
	public TestCasePieChart() {
		super(TITLE);
		this.init();
	}
	
	private void init(){
		
		// Insert test case data categories
		insertNewData(TestCase.INPROG, inProgValue);
		insertNewData(TestCase.PASSED, passedValue);
		insertNewData(TestCase.FAILED, failedValue);
		
		// Toggle rotation on
		toggleRotation(false);
		
		setTransparency(60);
		setBackgroundGap(5);
		getPlot().setNoDataMessage("No Test Cases");
		
		// Label settings
		toggleLabelValues(true);
		getPlot().setLabelBackgroundPaint(Color.white);
		getPlot().setLabelShadowPaint(new Color(105, 105, 105)); // Grey
		setLegendLabels("{0} = {1} ({2})");
		setMouseWheelEnabled(true);
		
		// Set colors
		setColor(TestCase.INPROG, Color.white);
		setColor(TestCase.PASSED, Color.green);
		setColor(TestCase.FAILED, Color.red);
		
		
		updatePie();
	}
	
	/**
	 * Loads the pie chart from the saved list.
	 * Made to be called whenever the entire chart needs to
	 * be updated.
	 */
	public void updatePie(){
		ArrayList<TestCase> tcList = CurrentProject.getTestCaseList().getAllTestCases();
		inProgValue = STARTVAL;
		passedValue = STARTVAL;
		failedValue = STARTVAL;
		
		for(TestCase tc : tcList){
			applyValue(tc);
		}
		
		// Update the values
		editValue(TestCase.INPROG, inProgValue);
		editValue(TestCase.PASSED, passedValue);
		editValue(TestCase.FAILED, failedValue);
		
		update();
	}
	
	
	// Increments the values based on the given test case
	private void applyValue(TestCase tc){
		switch(tc.getStatus()){
		case INPROGRESS:
			inProgValue++;
			break;
		case FAILED:
			failedValue++;
			break;
		case PASSED:
			passedValue++;
			break;
		default:
			break;
		
		}
	}

}
