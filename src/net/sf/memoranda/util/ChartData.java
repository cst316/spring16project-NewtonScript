package net.sf.memoranda.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Monitors changes in statistics data
 * 
 * @author Douglas Carroll
 */
public class ChartData {

	private static Vector<ActionListener> listeners = new Vector<ActionListener>();
	
	public static void addChangeListener(ActionListener a){
		listeners.add(a);
	}
	
	public static Vector<ActionListener> getListeners(){
		return listeners;
	}
	
	/**
	 * Update all charts
	 */
	public static void updateCharts(){
		for(ActionListener a : listeners){
			a.actionPerformed(new ActionEvent(a, 0, null));
		}
	}
}
