package net.sf.memoranda.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Defect;
import net.sf.memoranda.Defect.Discovery;
import net.sf.memoranda.Defect.Injection;
import net.sf.memoranda.Defect.Type;
import net.sf.memoranda.util.ChartData;


/**
 * Pie chart for defect data
 * 
 * 
 * @author Douglas Carroll
 *
 */
public class DefectPieChart extends PieChart{
	
	// High level Categories
	public static enum Category { 
		TYPE("Type"),
		DIS("Discovery"),
		INJ("Injection"),
		SEV("Severity"),
		OC("Open/Closed");
		
		private String name;
		
		Category(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	public static final String TITLE = "Defects";
	public static final int STARTVAL = 0; // Starting value
	private static final long serialVersionUID = 120L;
	
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
	private Category cat;
	
	public DefectPieChart() {
		super(TITLE);
		this.init();
	}
	
	/**
	 * Get the category currenyl being displayed
	 * 
	 * @return
	 */
	public Category getCat() {
		return cat;
	}

	/**
	 * Set the category to be displayed
	 * 
	 * @param cat
	 */
	public void setCat(Category cat) {
		this.cat = cat;
		update();
	}
	
	private void init(){
		
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
		
		ChartData.addChangeListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
			
		});
		
		cat = Category.TYPE;
		
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
	
	/**
	 * Show the type pie chart.
	 * 
	 * @param dl
	 */
	public void showTypeView(ArrayList<Defect> dl){

		setTitle("Defects by Type");
		
		int i = 0;
		// Load pie data sets and set to empty
		
		for(Defect.Type ty : Defect.Type.values()){
			insertNewData(ty.toString(), STARTVAL);
			setColor(ty.toString(), colors[i]);
			i++;
		}
		
		// Load values
		for(Defect d : dl){
			Type type = d.getType();
			addValue(type.toString(), 1);
		}
		
	}
	
	/**
	 * Show the discovery pie chart.
	 * 
	 * @param dl
	 */
	public void showDisView(ArrayList<Defect> dl){
	
		setTitle("Defects by Discovery");
	
		int i = 0;
		// Load pie data sets and set to empty
		for(Discovery dis : Defect.Discovery.values()){
			insertNewData(dis.toString(), STARTVAL);
			setColor(dis.toString(), colors[i]);
			i++;
		}
		
		// Load values
		for(Defect d : dl){
			Defect.Discovery dis = d.getDiscovery();
			addValue(dis.toString(), 1);
		}
		
	}
	
	/**
	 * Show the Injection pie chart.
	 * 
	 * @param dl
	 */
	public void showInjectionView(ArrayList<Defect> dl){

		setTitle("Defects by Injection");
		
		int i = 0;
		// Load pie data sets and set to empty
		for(Injection inj : Defect.Injection.values()){
			insertNewData(inj.toString(), STARTVAL);
			setColor(inj.toString(), colors[i]);
			i++;
		}
		
		// Load values
		for(Defect d : dl){
			Defect.Injection inj = d.getInj();
			addValue(inj.toString(), 1);
		}
		
	}
	
	/**
	 * Show the severity pie chart.
	 * 
	 * @param dl
	 */
	public void showSeverityView(ArrayList<Defect> dl){
		
		setTitle("Defects by Severity");
		
		// Load pie data sets and set to empty
		for(Defect.Severity sev : Defect.Severity.values()){
			insertNewData(sev.toString(), STARTVAL);
		}
		
		// Set colors for severity
		setColor(Defect.Severity.LOW.toString(), Color.yellow);
		setColor(Defect.Severity.MEDIUM.toString(), Color.orange);
		setColor(Defect.Severity.HIGH.toString(), Color.red);
		
		// Load values
		for(Defect d : dl){
			Defect.Severity sev = d.getSeverity();
			addValue(sev.toString(), 1);
		}
		
	}
	
	/**
	 * Show the open/close pie chart.
	 * 
	 * @param dl
	 */
	public void showOpenCloseyView(ArrayList<Defect> dl){
		
		setTitle("Open/Closed Defects");
		
		String open = "Open";
		String closed = "Closed";
		
		insertNewData(open, DefectPieChart.STARTVAL);
		setColor(open, Color.WHITE);
		insertNewData(closed, DefectPieChart.STARTVAL);
		setColor(closed, Color.GREEN);
		
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
	
	public void update(){
		setChartView();
		super.update();
	}
}
