package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.DefectList;
import net.sf.memoranda.PhaseList;
import net.sf.memoranda.TestCaseList;

/**
 * This is the panel to provide an overview of the statistics from all charts
 * 
 * @author Douglas Carroll
 */
public class StatsOverviewPanel extends JPanel {

	private final JLabel TOTALPHASE = new JLabel("Total Phases: ");
	private final JLabel ACTIVEPHASE = new JLabel("Active Phases: ");
	private final JLabel CLOSEDPHASE = new JLabel("Closed Phases: ");
	private final JLabel TOTTASKS = new JLabel("Total Tasks: ");
	private final JLabel OPENTASKS = new JLabel("Open Tasks: ");
	private final JLabel CLOTASKS = new JLabel("Closed Tasks: ");
	private final JLabel STARTTASKS = new JLabel("Tasks Started: ");
	private final JLabel NONSTARTTASKS = new JLabel("Tasks Not Started: ");
	private final JLabel TOTDEFECTS = new JLabel("Total Defects: ");
	private final JLabel OPENDEFECTS = new JLabel("Open Defects: ");
	private final JLabel CLOSEDDEFECTS = new JLabel("Closed Defects: ");
	private final JLabel TOTALTC = new JLabel("Total Test Cases: ");
	private final JLabel INPROGTC = new JLabel("In progress Test Cases: ");
	private final JLabel FAILEDTC = new JLabel("Failed Test Cases: ");
	private final JLabel PASSEDTC = new JLabel("Passed Test Cases: ");

	private static final long serialVersionUID = 134L;
	
	private JPanel outerGrid;
	private JPanel upperLeft;
	private JPanel upperLeftGrid;
	private JPanel lowerLeft;
	private JPanel upperRight;
	private JPanel lowerRight;
	private JPanel infoPanel;
	// Phases
	private JLabel totalPhVal = new JLabel();
	private JLabel activePhVal = new JLabel();
	private JLabel closedPhVal = new JLabel();
	// Tasks
	private JLabel totalTVal = new JLabel();
	private JLabel openTVal = new JLabel();
	private JLabel closedTVal = new JLabel();
	private JLabel startedTVal = new JLabel();
	private JLabel notStartedTVal = new JLabel();
	// Defects
	private JLabel totalDefVal = new JLabel();
	private JLabel openDefVal = new JLabel();
	private JLabel closedDefVal = new JLabel();
	// Test cases
	private JLabel totalVal = new JLabel();
	private JLabel inProgVal = new JLabel();
	private JLabel passedVal = new JLabel();
	private JLabel failedVal = new JLabel();
	
	private Font titleFont;
	private TestCasePieChart tp;
	private DefectPieChart dp;
	private PhaseGanttChart pg;
	
	
	public StatsOverviewPanel(){
		init();
	}
	
	/**
	 * Constructor to set the title font
	 * 
	 * @param font
	 */
	public StatsOverviewPanel(Font font){
		titleFont = font;
		init();
	}
	
	/**
	 * Update the overview panel
	 */
	public void update(){
		DefectList dl = CurrentProject.getDefectList();
		PhaseList ph = CurrentProject.getPhaseList();
		TestCaseList tc = CurrentProject.getTestCaseList();
		int phaseNum = ph.getPhases().size();
		int activePhaseNum = ph.getActivePhaseNum();
		int totalTasks = ph.getTaskNum();
		int actTasks = ph.getActiveTaskNum();
		int startedTasks = ph.getStartedTaskNum();
		int totalDefs = dl.getDefectNum();
		int openDefs = dl.getOpenDefectNum();
		
		// Update internal pie charts
		tp.updatePie();
		dp.updatePie();
		pg.updateChart();
		
		// Update phase numbers
		totalPhVal.setText(Integer.toString(phaseNum));
		activePhVal.setText(Integer.toString(activePhaseNum));
		closedPhVal.setText(Integer.toString(phaseNum - activePhaseNum));
		
		// Update task numbers
		totalTVal.setText(Integer.toString(totalTasks));
		openTVal.setText(Integer.toString(actTasks));
		closedTVal.setText(Integer.toString((totalTasks - actTasks)));
		startedTVal.setText(Integer.toString(startedTasks));
		notStartedTVal.setText(Integer.toString((totalTasks - startedTasks)));
		
		// Update defect numbers
		totalDefVal.setText(Integer.toString(totalDefs));
		openDefVal.setText(Integer.toString(openDefs));
		closedDefVal.setText(Integer.toString((totalDefs - openDefs)));
		
		// Update test case numbers
		totalVal.setText(Integer.toString(tc.getTestCaseNum()));
		inProgVal.setText(Integer.toString(tc.getInProgNum()));
		passedVal.setText(Integer.toString(tc.getPassedNum()));
		failedVal.setText(Integer.toString(tc.getFailedNum()));
		
	}
	

	private void init() {
		outerGrid = new JPanel(new GridLayout(0, 2));
		upperLeft = new JPanel(new BorderLayout());
		upperLeftGrid = new JPanel(new GridLayout(0, 2));
		infoPanel = new JPanel();
		lowerLeft = new JPanel(new BorderLayout());
		upperRight = new JPanel(new BorderLayout());
		lowerRight = new JPanel(new BorderLayout());
		JLabel title = new JLabel("Number Overview");
		titleFont = titleFont.deriveFont(16f);
		titleFont = titleFont.deriveFont(Font.BOLD);
		
		
		title.setFont(titleFont);
		this.setLayout(new BorderLayout());
		
		// Upper left
		initStats();
		upperLeft.add(title, BorderLayout.NORTH);
		
		// Upper Right
		tp = new TestCasePieChart();
		tp.enableOptions(false);
		upperRight.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.WEST);
		upperRight.add(tp, BorderLayout.CENTER);
		
		// Lower left
		dp = new DefectPieChart(DefectPieChart.Category.OC);
		dp.enableOptions(false);
		lowerLeft.add(new JSeparator(), BorderLayout.NORTH);
		lowerLeft.add(dp, BorderLayout.CENTER);
		
		// Lower Right
		pg = new PhaseGanttChart();
		lowerRight.add(new JSeparator(), BorderLayout.NORTH);
		lowerRight.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.WEST);
		lowerRight.add(pg, BorderLayout.CENTER);
		
		
		// Add panels to the grid - ORDER MATTERS
		outerGrid.add(upperLeft);
		outerGrid.add(upperRight);
		outerGrid.add(lowerLeft);
		outerGrid.add(lowerRight);
		this.add(outerGrid, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	// Set up the listed stats
	private void initStats(){
		// Upper left
		
		// Tasks/phases
		infoPanel.setLayout(new GridLayout(0, 2));
		infoPanel.add(TOTALPHASE);
		infoPanel.add(totalPhVal);
		infoPanel.add(ACTIVEPHASE);
		infoPanel.add(activePhVal);
		infoPanel.add(CLOSEDPHASE);
		infoPanel.add(closedPhVal);
		infoPanel.add(new JSeparator());
		infoPanel.add(new JSeparator());
		infoPanel.add(TOTTASKS);
		infoPanel.add(totalTVal);
		infoPanel.add(OPENTASKS);
		infoPanel.add(openTVal);
		infoPanel.add(CLOTASKS);
		infoPanel.add(closedTVal);
		infoPanel.add(STARTTASKS);
		infoPanel.add(startedTVal);
		infoPanel.add(NONSTARTTASKS);
		infoPanel.add(notStartedTVal);
		infoPanel.add(new JSeparator());
		infoPanel.add(new JSeparator());
		
		// Defect info
		infoPanel.add(TOTDEFECTS);
		infoPanel.add(totalDefVal);
		infoPanel.add(OPENDEFECTS);
		infoPanel.add(openDefVal);
		infoPanel.add(CLOSEDDEFECTS);
		infoPanel.add(closedDefVal);
		infoPanel.add(new JSeparator());
		infoPanel.add(new JSeparator());
		
		// Test cases
		infoPanel.add(TOTALTC);
		infoPanel.add(totalVal);
		infoPanel.add(INPROGTC);
		infoPanel.add(inProgVal);
		infoPanel.add(FAILEDTC);
		infoPanel.add(failedVal);
		infoPanel.add(PASSEDTC);		
		infoPanel.add(passedVal);
		infoPanel.add(new JSeparator());
		infoPanel.add(new JSeparator());
		
		upperLeftGrid.add(infoPanel);
		upperLeft.add(upperLeftGrid, BorderLayout.CENTER);
	}
	
}
