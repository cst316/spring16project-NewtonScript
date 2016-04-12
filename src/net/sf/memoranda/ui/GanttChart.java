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
public class GanttChart extends Chart {

	public static final double MAXBARSIZE = 0.05;
	public static final int PNGWIDTH = 1200;
	public static final int PNGHEIGHT = 800;
	private static final long serialVersionUID = 189L;
	private TaskSeriesCollection data;
	private String title;
	private String domainLabel;
	private String rangeLabel;
	
	public GanttChart(String title, String domain, String range){
		super(title);
		domainLabel = domain;
		rangeLabel = range;
		init();
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
	
}
