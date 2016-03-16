package net.sf.memoranda.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;

/**
 * JPanel which will contain functionality
 * for producing a basic pie chart.
 * 
 * Mostly used as an adaptor for the pie chart API
 * to make our lives a little easier.
 * 
 * @author Douglas Carroll
 */

public class PieChartPanel extends JPanel{
	
	public static final int ANGLE = 270;
	
	private static final long serialVersionUID = 1L;
	private String title;		// Title for the pie chart
	private JFreeChart pie;		// Chart itself
	private DefaultPieDataset data;	// Data for the chart
	private ChartPanel chartPane;
	private PiePlot3D plot;
	private PieRotator rotator = null;
	
	public PieChartPanel(String title){
		this.title = title;
		init();
	}
	
	public JFreeChart getChart(){
		return pie;
	}
	
	public PieDataset getData(){
		return data;
	}
	
	public PiePlot getPlot(){
		return plot;
	}
	
	public ChartPanel getPanel(){
		return chartPane;
	}
	
	/**
	 * Toggles rotation of the chart on and off
	 * 
	 * @param res
	 */
	public void toggleRotation(boolean res){
		if(rotator == null)
			rotator = new PieRotator(plot);
		
		if(res){
			rotator.start();
		}
		else{
			rotator.stop();
		}
	
	}
	
	/**
	 * Sets the pie sections color
	 * 
	 * @param title Title of category
	 * @param c color
	 */
	public void setColor(String title, Color c){
		plot.setSectionPaint(title, c);
	}
	
	/**
	 * Set the transparency percent of the chart,
	 * 
	 * @param percent 0 - 100
	 */
	public void setTransparency(int percent){
		plot.setForegroundAlpha(convertToPercent(percent));
	}
	
	/**
	 * Set the gap between the chart and the edges of the plot area
	 * 
	 * @param percent 0 - 100
	 */
	public void setBackgroundGap(int percent){
		plot.setInteriorGap(convertToPercent(percent));
	}
	
	/**
	 * To set the extended labels or not
	 * 
	 * True - Set the labels directly on the chart.
	 * False - Set the labels connected by a line.
	 * 
	 * @param res
	 */
	public void setNoExtendedLabels(boolean res){
		plot.setSimpleLabels(res);
	}
	
	/**
	 * This will control whether or not values are displayed within the charts labels
	 * 
	 * @param res
	 */
	public void toggleLabelValues(boolean res){
		if(res){
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({1})"));
		}
		else{
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
		}
	}
	
	/**
	 * This will determine how the legend titles are displayed.
	 * 
	 * According to the API:
	 * {0} -> title
	 * {1} -> value
	 * {2} -> percentage
	 * 
	 * @param str
	 */
	public void setLegendLabels(String str){
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(str));
	}
	
	/**
	 * Set the transparency of the charts background
	 * 0 means completely transparent.
	 * 
	 * @param percent 0 - 100
	 */
	public void setBackgroundTransparency(int percent){
		plot.setBackgroundAlpha(convertToPercent(percent));
	}
	
	/**
	 * Set the background color for the chart
	 * 
	 * @param c
	 */
	public void setBackgroundColor(Color c){
		plot.setBackgroundPaint(c);
	}
	
	/**
	 * Enables or disabled mouse wheel scrolling of the pie chart
	 * 
	 * @param res
	 */
	public void setMouseWheelEnabled(boolean res){
		chartPane.setMouseWheelEnabled(res);
	}
	
	// Converts int percentage to a float
	private float convertToPercent(int percent){
		float trans = 0.0f;
		try{
			if(percent > 100 || percent < 0)
				throw new IllegalArgumentException();
			trans = ((float)percent) / 100;
			
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid percentage!");
			e.printStackTrace();
		}
		
		return trans;
	}
	
	private void init(){
		data = new DefaultPieDataset();
		
		// Create a generic pie chart
		pie = ChartFactory.createPieChart3D(
				title,			// Title
				data,			// Pie chart data
				true,			// Legend
				true,			// Tooltips
				false			// URLs
		);
		chartPane = new ChartPanel(pie);
		
		pie.setPadding(new RectangleInsets(4, 8, 2, 2));
		plot = (PiePlot3D) pie.getPlot();
		plot.setStartAngle(ANGLE);
		this.setLayout(new FlowLayout());
		this.add(chartPane);
		this.setVisible(true);
		chartPane.setVisible(true);
	}
	
	/**
	 * Inserts a new data category into the chart
	 * 
	 * @param title
	 * @param value
	 */
	public void insertNewData(String title, int value){
		data.insertValue(data.getItemCount(), title, value);
	}
	
	/**
	 * Removes a section of the pie chart
	 * 
	 * @param key
	 */
	public void remove(String title){
		data.remove(title);
	}
	
	/**
	 * Sets the value of the data
	 * 
	 * @param title
	 * @param val
	 */
	public void editValue(String title, int val){
		data.setValue(title, val);
	}
	
	/**
	 * Updates the pie chart
	 */
	public void update(){
		pie.fireChartChanged();
		chartPane.updateUI();
		updateUI();
	}
	
}

/**
 * Handles graph rotation
 */
class PieRotator extends Timer implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private PiePlot3D roPlot;
	private int angle = PieChartPanel.ANGLE;
	
	PieRotator(PiePlot3D plot){
		super(100, null);
		roPlot = plot;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		roPlot.setStartAngle(angle);
		angle++;
		if(angle >= 360){
			angle = 0;
		}
	}
	
}
