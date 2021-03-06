package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * JPanel which will contain functionality
 * for producing a basic pie chart.
 * 
 * Mostly used as an adaptor for the pie chart API
 * to make our lives a little easier.
 * 
 * See PieChartPopulatedPanel for a panel that includes
 * extra options.
 * 
 * @author Douglas Carroll
 */

public abstract class PieChart extends Chart{
	
	public static final int ANGLE = 270;
	public static final int PNGWIDTH = 1200;
	public static final int PNGHEIGHT = 800;
	
	private static final long serialVersionUID = 1L;
	private DefaultPieDataset data;	// Data for the chart
	private PiePlot3D plot;
	private PieRotator rotator = null;
	protected double pieAngle = ANGLE;
	
	public PieChart(String title){
		super(title);
		init();
	}

	private void init(){
		data = new DefaultPieDataset();
		
		// Create a generic pie chart
		chart = ChartFactory.createPieChart3D(
				title,			// Title
				data,			// Pie chart data
				true,			// Legend
				true,			// Tooltips
				false			// URLs
		);
		chartPanel = new ChartPanel(chart);
		fixAspectRatio();
		plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(ANGLE);
		plot.setCircular(true);
		rotator = new PieRotator(plot);
		this.setLayout(new BorderLayout());
		this.add(chartPanel, BorderLayout.CENTER);
		this.setVisible(true);
		chartPanel.setVisible(true);
	}
	
	public PieDataset getData(){
		return data;
	}
	
	public PiePlot getPlot(){
		return plot;
	}
	
	/**
	 * Toggles rotation of the chart on and off
	 * 
	 * @param res
	 */
	public void toggleRotation(boolean res){
		if(res){
			pieAngle = plot.getStartAngle();
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
	 * Toggles label location on the pie chart.
	 * 
	 * True - labels stick to pie.
	 * False - labels float.
	 * 
	 * @param res
	 */
	public void setStaticLabels(boolean res){
			plot.setSimpleLabels(res);
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
	 * Set the background color for the plot
	 * 
	 * @param c
	 */
	public void setBackgroundColor(Color c){
		plot.setBackgroundPaint(c);
	}
	
	/**
	 * Set the background color for the panel.
	 * This is the area around the edges and title.
	 * 
	 * @param c
	 */
	public void setBorderPaint(Color c){
		chart.setBackgroundPaint(c);
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
	 * Clears all data in the pie chart
	 * 
	 */
	public void clearData(){
		data.clear();
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
	 * Add value to the existing data
	 * 
	 * @param title
	 * @param val
	 */
	public void addValue(String title, int val){
		data.setValue(title, data.getValue(title).intValue() + val);
	}
	
	// Converts int percentage to a float
	private float convertToPercent(int percent){
		float trans = 0.0f;
		try{
			if(percent > 100 || percent < 0)
				throw new IllegalArgumentException();
			trans = ((float)percent) / 100;
			
		} catch(IllegalArgumentException e) {
			// Use the memoranda exception dialog to inform the user
            new ExceptionDialog(
	                    e,
	                    "Invalid value recorded for the pie chart.",
	                    ""
                    );
		} catch(Exception e) {
			// Use the memoranda exception dialog to inform the user
            new ExceptionDialog(
	                    e,
	                    "Error! Invalid pie chart data.",
	                    ""
                    );
            // Make sure trans is set to zero in case there was some arithmetic error
            trans = 0.0f; 
		}
		
		return trans;
	}

	/**
	 * Handles graph rotation
	 */
	class PieRotator extends Timer implements ActionListener{
		
		private static final long serialVersionUID = 1L;
		private PiePlot3D roPlot;
		
		PieRotator(PiePlot3D plot){
			super(100, null);
			roPlot = plot;
			addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Convert the angle to it's positive counterpart
	        pieAngle = ((pieAngle) % -360) + 360;
			roPlot.setStartAngle(pieAngle);
			pieAngle--;
			
		}
	}
}
	
