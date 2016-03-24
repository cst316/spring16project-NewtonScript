package net.sf.memoranda.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Defect;

/**
 * Pie chart for defect data
 * 
 * 
 * @author Douglas Carroll
 *
 */
public class DefectPieChart extends PieChartPopulatedPanel{
	private static final long serialVersionUID = 120L;
	
	public static final String TITLE = "Defects";
	public static final int STARTVAL = 0; // Starting value for each section
	
	// High level Categories
	public static enum CATEGORY { 
		TYPE("Type"),
		DIS("Discovery"),
		INJ("Injection"),
		SEV("Severity"),
		OC("Open/Closed");
		
		private String name;
		
		CATEGORY(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	// Colors to be used for the pie charts.
	// Should be as many colors as there are MAX sections for each category (or more).
	private Color colors[] = {
			Color.orange, 
			Color.yellow, 
			Color.blue, 
			Color.pink, 
			Color.WHITE, 
			Color.cyan, 
			Color.green, 
			Color.red,
			Color.MAGENTA,
			Color.BLACK,
			Color.ORANGE
			};
	private CATEGORY cat;
	private JToggleButton typeButton;
	private JToggleButton disButton;
	private JToggleButton injButton;
	private JToggleButton sevButton;
	private JToggleButton ocButton;
	
	public DefectPieChart() {
		super(TITLE);
		this.init();
	}
	
	public CATEGORY getCat() {
		return cat;
	}

	public void setCat(CATEGORY cat) {
		this.cat = cat;
	}

	private void init(){
		JPanel options = getOptionsPanel();
		JPanel buttons = new JPanel();
		typeButton = new JToggleButton();
		disButton = new JToggleButton();
		injButton = new JToggleButton();
		sevButton = new JToggleButton();
		ocButton = new JToggleButton();
		

		cat = CATEGORY.TYPE;
		
		// Toggle rotation off
		toggleRotation(false);
		
		setTransparency(60);
		setBackgroundGap(5);
		//setBorderPaint(UIManager.getColor("Panel.background"));
		getPlot().setNoDataMessage("No Defects");
		
		// Label settings
		toggleLabelValues(true);
		getPlot().setLabelBackgroundPaint(Color.white);
		getPlot().setLabelShadowPaint(new Color(105, 105, 105)); // Grey
		setLegendLabels("{0} = {1} ({2})");
		setMouseWheelEnabled(true);
		
		// Setup buttons
		typeButton.setSelected(true);
		typeButton.setToolTipText(CATEGORY.TYPE.toString());
		typeButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieType.png"))
	            );
		typeButton.setBorder(null);
		typeButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(typeButton);
				   cat = CATEGORY.TYPE;
				   updatePie();
			   }
		});
		
		disButton.setToolTipText(CATEGORY.DIS.toString());
		disButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieDis.png"))
	            );
		disButton.setBorder(null);
		disButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(disButton);
				   cat = CATEGORY.DIS;
				   updatePie();
			   }
		});
		
		injButton.setToolTipText(CATEGORY.INJ.toString());
		injButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieInj.png"))
	            );
		injButton.setBorder(null);
		injButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(injButton);
				   cat = CATEGORY.INJ;
				   updatePie();
			   }
		});
		
		sevButton.setToolTipText(CATEGORY.SEV.toString());
		sevButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieSev.png"))
	            );
		sevButton.setBorder(null);
		sevButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(sevButton);
				   cat = CATEGORY.SEV;
				   updatePie();
			   }
		});
		
		ocButton.setToolTipText(CATEGORY.OC.toString());
		ocButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieOC.png"))
	            );
		ocButton.setBorder(null);
		ocButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(ocButton);
				   cat = CATEGORY.OC;
				   updatePie();
			   }
		});
		
		// Put the defect unique options on the panel
		// Uncomment below to put button on the bottom of the panel
		//options.add(Box.createVerticalGlue());
		options.add(typeButton);
		options.add(disButton);
		options.add(injButton);
		options.add(sevButton);
		options.add(ocButton);
		
		updatePie();
	}
	
	/**
	 * Loads the pie chart from the saved list.
	 * Made to be called whenever the entire chart needs to
	 * be updated.
	 * 
	 * Should be called when defect chart is selected or 
	 * when a new type of defect chart is chosen.
	 */
	public void updatePie(){
		setChartView();
		update();
	}
	
	// Set the chart type based on user selection
	private void setChartView(){
		ArrayList<Defect> defList = CurrentProject.getDefectList().getAllDefects();
		
		clearData(); // Wipe data in the pie chart
		
		switch(cat){
		case TYPE:
			showTypeView(defList);
			break;
		case DIS:
			showDisView(defList);
			break;
		case INJ:
			showInjectionView(defList);
			break;
		case SEV:
			showSeverityView(defList);
			break;
		case OC:
			showOpenCloseyView(defList);
			break;
		default:
			showTypeView(defList);
			break;
		}
	}
	
	// Show the type view of the pie
	private void showTypeView(ArrayList<Defect> dl){

		setTitle("Defects by Type");
		
		int i = 0;
		// Load pie data sets and set to empty
		for(Defect.TYPE ty : Defect.TYPE.values()){
			insertNewData(ty.toString(), STARTVAL);
			setColor(ty.toString(), colors[i]);
			i++;
		}
		
		// Load values
		for(Defect d : dl){
			Defect.TYPE type = d.getType();
			addValue(type.toString(), 1);
		}
		
	}
	
	// Show the discovery view of the pie
	private void showDisView(ArrayList<Defect> dl){
	
		setTitle("Defects by Discovery");
		
		int i = 0;
		// Load pie data sets and set to empty
		for(Defect.DISCOVERY dis : Defect.DISCOVERY.values()){
			insertNewData(dis.toString(), STARTVAL);
			setColor(dis.toString(), colors[i]);
			i++;
		}
		
		// Load values
		for(Defect d : dl){
			Defect.DISCOVERY dis = d.getDiscovery();
			addValue(dis.toString(), 1);
		}
		
	}
	// Show the injection view of the pie
	private void showInjectionView(ArrayList<Defect> dl){

		setTitle("Defects by Injection");
		
		int i = 0;
		// Load pie data sets and set to empty
		for(Defect.INJECTION inj : Defect.INJECTION.values()){
			insertNewData(inj.toString(), STARTVAL);
			setColor(inj.toString(), colors[i]);
			i++;
		}
		
		// Load values
		for(Defect d : dl){
			Defect.INJECTION inj = d.getInj();
			addValue(inj.toString(), 1);
		}
		
	}
	
	// Show the severity view of the pie
	private void showSeverityView(ArrayList<Defect> dl){
		
		setTitle("Defects by Severity");
		
		// Load pie data sets and set to empty
		for(Defect.SEVERITY sev : Defect.SEVERITY.values()){
			insertNewData(sev.toString(), STARTVAL);
		}
		
		// Set colors for severity
		setColor(Defect.SEVERITY.LOW.toString(), Color.yellow);
		setColor(Defect.SEVERITY.MEDIUM.toString(), Color.orange);
		setColor(Defect.SEVERITY.HIGH.toString(), Color.red);
		
		// Load values
		for(Defect d : dl){
			Defect.SEVERITY sev = d.getSeverity();
			addValue(sev.toString(), 1);
		}
		
	}
	
	// Show the open close view of the pie
	private void showOpenCloseyView(ArrayList<Defect> dl){
		
		setTitle("Open/Closed Defects");
		
		String open = "Open";
		String closed = "Closed";
		
		insertNewData(open, STARTVAL);
		setColor(open, Color.GREEN);
		insertNewData(closed, STARTVAL);
		setColor(closed, Color.RED);
		
		// Load values
		for(Defect d : dl){
			if(d.isOpen()){
				addValue(open, 1);
			}
			else{
				addValue(closed, 1);
			}
		}
		
	}

	// Clear all button states except the one that is selected
	private void clearButtons(JToggleButton btn){
		typeButton.setSelected(false);
		disButton.setSelected(false);
		injButton.setSelected(false);
		sevButton.setSelected(false);
		ocButton.setSelected(false);
		
		btn.setSelected(true);
	}


}
