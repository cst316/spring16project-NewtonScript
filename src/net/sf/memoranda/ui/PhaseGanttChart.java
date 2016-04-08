package net.sf.memoranda.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.Dataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Phase;
import net.sf.memoranda.date.CalendarDate;

/**
 * Gantt chart for the phases/tasks
 * 
 * @author Douglas Carroll
 */
public class PhaseGanttChart extends GanttChart{

	private static final long serialVersionUID = 1332L;
	public static final String DOMAINTITLE = "Percent done";
	
	public PhaseGanttChart() {
		super("Project Phase Progress", "Phases", "Progress");
		init();
	}
	
	private void init(){
		loadData();
		setSeriesColor(0, Color.blue);
	}
	
	// Load data from XML
	private void loadData(){
		TaskSeriesCollection data = getData();
		ArrayList<Phase> pl = CurrentProject.getPhaseList().getPhases();
		TaskSeries phases = new TaskSeries("Scheduled");
		DateAxis axis = (DateAxis) getPlot().getRangeAxis();
		axis.setMinimumDate(CurrentProject.get().getStartDate().getDate());
		axis.setMaximumDate(CurrentProject.get().getEndDate().getDate());
		//axis.setDateFormatOverride(new SimpleDateFormat());

		
		// Grab the phases
		for(Phase p : pl){
			Task phase = new Task(p.getTitle(), 
					p.getStartDate().getDate(), 
					p.getEndDate().getDate()
			);
			phase.setPercentComplete(((double) p.getProgress()) / 100);
			
			phases.add(phase);
		}
		
		data.add(phases);
		update();
	}
	
	public void updatePie(){
		clearData();
		loadData();
	}

	private void clearData(){
		getData().remove(0);
	}

}
