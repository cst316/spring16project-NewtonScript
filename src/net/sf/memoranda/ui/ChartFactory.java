package net.sf.memoranda.ui;

/**
 * Factory class to get the various different charts and panels
 * 
 * @author Douglas Carroll
 */
public class ChartFactory {

	public static enum ChartType{
		DEFECT,
		TESTCASE,
		PHASE
	}
	
	public static enum PopulatedType{
		DEFECT,
		TESTCASE
	}
	
	/**
	 * Get the selected chart instance. 
	 * 
	 * @param t Type of chart (DEFECT, TESTCASE, PHASE)
	 * @return
	 */
	public Chart getChart(ChartType t){
		Chart chart = null;
		
		switch(t){
			case DEFECT:
				chart = new DefectPieChart();
				break;
			case TESTCASE:
				chart = new TestCasePieChart();
				break;
			case PHASE:
				chart = new PhaseGanttChart();
				break;
		
		}
		
		return chart;
	}
	
	/**
	 * Get populated pie chart panel.
	 * 
	 * @param t Populated chart type
	 * @return
	 */
	public PieChartPopulatedPanel getPopulatedChart(PopulatedType t){
		PieChartPopulatedPanel pop = null;
		
		switch(t){
		case DEFECT:
			pop = new DefectPiePopulatedPanel(new DefectPieChart());
			break;
		case TESTCASE:
			pop = new PieChartPopulatedPanel(new TestCasePieChart());
			break;
		}
		
		return pop;
	}
	
}
