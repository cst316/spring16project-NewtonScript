package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

/**
 * Panel for the Statistics page.
 * 
 * @author Douglas Carroll
 */

public class StatsPanel extends JPanel {
	
	// Save the indices of each tab
	public static final int OVERVIEWINDEX = 0;
	public static final int TESTCASEINDEX = 1;
	public static final int DEFECTINDEX = 2;
	public static final int PHASESINDEX = 3;
	
	DailyItemsPanel parentPanel;
	private static final long serialVersionUID = 1556L;
	private JLabel title;
	private Font titleFont;
	private JTabbedPane tabbedPane;
	private JPanel northPanel;  // Menu and title
	private JPanel titlePanel;  // Title label panel
	private JPanel menuPanel;   
	private JPanel overviewPanel;
	private JPanel testCasePanel;
	private JPanel defectsPanel;
	private JPanel tasksPanel;
	private JMenuBar menu;
	private JMenu export;
	private JMenuItem png;
	private PieChartPopulatedPanel testPanel;
	private PieChartPopulatedPanel defectPanel;
	private Chart phaseChart;
	private StatsOverviewPanel innerOverviewPanel;
	
	public StatsPanel(){
		initComponents();
	}

	// Handles building of all charts
	private void buildCharts() {
		ChartFactory factory = new ChartFactory();
		testPanel = factory.getPopulatedChart(ChartFactory.PopulatedType.TESTCASE);
		defectPanel = factory.getPopulatedChart(ChartFactory.PopulatedType.DEFECT);
		phaseChart = factory.getChart(ChartFactory.ChartType.PHASE);
	}
	
	// Builds the panel
	private void initComponents() {
		tabbedPane = new JTabbedPane();
		overviewPanel = new JPanel();
		testCasePanel = new JPanel();
		defectsPanel = new JPanel();
		tasksPanel = new JPanel();
		title = new JLabel("Statistics");
		northPanel = new JPanel();
		titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		menu = new JMenuBar();
		export = new JMenu("Export As...");
		png = new JMenuItem("PNG...");
		
		// Build the charts
		buildCharts();
		
		setLayout(new BorderLayout());
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		
		// Title label
		loadFont();
		titleFont = titleFont.deriveFont(24f); // Set font size
		title.setFont(titleFont);
		
		// Menu
		menu.add(export);
		export.add(png);
		png.getAccessibleContext().setAccessibleDescription("Export chart as a PNG");
		png.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportPNG();
            }
        });
		
		// Overview tab
		innerOverviewPanel = new StatsOverviewPanel(titleFont);
		overviewPanel.setLayout(new BorderLayout());
		overviewPanel.add(innerOverviewPanel, BorderLayout.CENTER);
		tabbedPane.addTab("Overview", overviewPanel);
		tabbedPane.setComponentAt(OVERVIEWINDEX, overviewPanel);
		
		// Test case tab
		testCasePanel.setLayout(new BorderLayout());
		testCasePanel.add(testPanel, BorderLayout.CENTER); // Add test case pie
		tabbedPane.addTab("Test Cases", testCasePanel);
		tabbedPane.setComponentAt(TESTCASEINDEX, testCasePanel);

		// Defects tab
		defectsPanel.setLayout(new BorderLayout());
		defectsPanel.add(defectPanel, BorderLayout.CENTER);
		tabbedPane.addTab("Defects", defectsPanel);
		tabbedPane.setComponentAt(DEFECTINDEX, defectsPanel);

		// Tasks tab
		tasksPanel.setLayout(new BorderLayout());
		tasksPanel.add(phaseChart, BorderLayout.CENTER);
		tabbedPane.addTab("Phases", tasksPanel);
		tabbedPane.setComponentAt(PHASESINDEX, tasksPanel);

		
		// Mend all panels/comps
		titlePanel.add(title);
		menuPanel.add(menu);
		northPanel.add(titlePanel);
		northPanel.add(new JSeparator());
		northPanel.add(menuPanel);
		northPanel.add(new JSeparator());
		add(northPanel, BorderLayout.NORTH);
		add(tabbedPane, BorderLayout.CENTER);
		testPanel.getPie().setPreferredSize(new Dimension());
	}
	
	// Loads the title font
	private void loadFont(){
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT, 
					AppFrame.class.getResourceAsStream("resources/Ubuntu-R.ttf"));
		} catch (FontFormatException e) {
			System.out.println("Font not loaded correctly on Stats page.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Font not loaded correctly on Stats page.");
			e.printStackTrace();
		}
	}
	
	// Export png based on what tab is selected
	private void exportPNG(){
		int index = tabbedPane.getSelectedIndex();
	
		switch(index){
		case OVERVIEWINDEX:
			JOptionPane.showMessageDialog(this, "Cannot export a PNG of the overview panel.\n"
					+ "Please select a tab first.");
			break;
		case TESTCASEINDEX:
			testPanel.getPie().exportPNG();
			break;
		case DEFECTINDEX:
			defectPanel.getPie().exportPNG();
			break;
		case PHASESINDEX:
			phaseChart.exportPNG();
			break;
		}
	}
	
}
