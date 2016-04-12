package net.sf.memoranda.ui;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 * Chart class which will parent all chart types
 * 
 * @author Douglas Carroll
 */
public abstract class Chart extends JPanel{

	public static final int PNGWIDTH = 1200;
	public static final int PNGHEIGHT = 800;
	protected JFreeChart chart;
	protected ChartPanel chartPanel;
	protected String title;
	private static final long serialVersionUID = 199L;
	
	public Chart(String title){
		this.title = title;
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		chart.setTitle(title);
	}
	
	/**
	 * Enables or disabled mouse wheel scrolling of the pie chart
	 * 
	 * @param res
	 */
	public void setMouseWheelEnabled(boolean res){
		chartPanel.setMouseWheelEnabled(res);
	}
	
	/**
	 * Exports the chart as a PNG
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
	
	// Setting these will force the chart to maintain it's aspect ratio
	protected void fixAspectRatio(){
		chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
	}
	
	/**
	 * Updates the pie chart
	 */
	public void update(){
		chart.fireChartChanged();
		chartPanel.updateUI();
		updateUI();
	}
}
