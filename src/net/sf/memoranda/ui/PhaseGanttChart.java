package net.sf.memoranda.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.jfree.chart.axis.DateAxis;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Phase;
import net.sf.memoranda.util.ChartData;

/**
 * Gantt chart for the phases/tasks
 * 
 * @author Douglas Carroll
 */
public class PhaseGanttChart extends GanttChart{

	public static final String DOMAINTITLE = "Percent done";
	private static final long serialVersionUID = 1332L;
	
	public PhaseGanttChart() {
		super("Project Phase Progress", "Phases", "Progress");
		init();
	}
	
	
	private void init(){
		loadData();
		setSeriesColor(0, Color.blue);
		ChartData.addChangeListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
			
		});
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
		super.update();
	}
	
	@Override
	public void update(){
		clearData();
		loadData();
		super.update();
	}

	private void clearData(){
		getData().removeAll();
	}

}
