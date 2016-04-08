package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.TaskSeriesCollection;

/**
 * Adaptor class for the Gantt Chart API.
 * This is create a basic, empty Gantt chart.
 * 
 * @author Douglas Carroll
 */
public class GanttChart extends JPanel {

	public static final double MAXBARSIZE = 0.05;
	public static final int PNGWIDTH = 1200;
	public static final int PNGHEIGHT = 800;
	private static final long serialVersionUID = 189L;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private TaskSeriesCollection data;
	private String title;
	private String domainLabel;
	private String rangeLabel;
	
	public GanttChart(String title, String domain, String range){
		this.title = title;
		domainLabel = domain;
		rangeLabel = range;
		init();
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public TaskSeriesCollection getData() {
		return data;
	}

	public void setData(TaskSeriesCollection data) {
		this.data = data;
	}
	
	public CategoryPlot getPlot(){
		return chart.getCategoryPlot();
	}
	
	public CategoryItemRenderer getRenderer(){
		return chart.getCategoryPlot().getRenderer();
	}
	
	public void setSeriesColor(int seriesNum, Color c){
		chart.getCategoryPlot().getRenderer().setSeriesPaint(seriesNum, c);
	}
	
	/**
	 * Allows user to save the file as a png.
	 */
	public void exportPNG(){
		String path = "(Path undefined)"; // Start with invalid path label.
		
		try{
			JFileChooser fc = new JFileChooser();
			fc.setDialogType(JFileChooser.SAVE_DIALOG);
			fc.addChoosableFileFilter(new FileNameExtensionFilter("png", "png"));
			fc.setFileHidingEnabled(true); // Hide the users hidden files
			int res = fc.showOpenDialog(App.getFrame());
			
			if(res == JFileChooser.APPROVE_OPTION){
				path = fc.getSelectedFile() + ".png";
				File selection = new File(path);
				// API utility to save to PNG
				ChartUtilities.saveChartAsPNG(selection, chart, PNGWIDTH, PNGHEIGHT);
				// Confirm box
				JOptionPane.showMessageDialog(App.getFrame(), 
						"File Saved to " + fc.getSelectedFile());
			}
		} catch (NullPointerException e) {
			// Use the memoranda exception dialog to inform the user
            new ExceptionDialog(
	                    e,
	                    "Failed to create file at" + path + ".",
	                    "Please try again."
                    );
		} catch (HeadlessException e) {
			// Use the memoranda exception dialog to inform the user
            new ExceptionDialog(
	                    e,
	                    "Failed to open dialog.",
	                    ""
                    );
		} catch (IOException e) {
			// Use the memoranda exception dialog to inform the user
            new ExceptionDialog(
	                    e,
	                    "Exporting PNG to " + path + " failed.",
	                    "Please try again."
                    );
		}
		
	}

	private void init(){
		data = new TaskSeriesCollection();
		
		// Build the Gantt graph
		chart = ChartFactory.createGanttChart(title, 
				domainLabel, 
				rangeLabel, 
				data
		);
		((BarRenderer)getRenderer()).setMaximumBarWidth(MAXBARSIZE);
		chartPanel = new ChartPanel(chart);
		fixAspectRatio();
		this.setLayout(new BorderLayout());
		this.add(chartPanel, BorderLayout.CENTER);
		this.setVisible(true);
		chartPanel.setVisible(true);
	}
	
	/**
	 * Updates the gantt chart
	 */
	public void update(){
		chart.fireChartChanged();
		chartPanel.updateUI();
		updateUI();
	}
	
	// Setting these will force the chart to maintain it's aspect ratio
	private void fixAspectRatio(){
		chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
	}
}
