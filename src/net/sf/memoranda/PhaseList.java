package net.sf.memoranda;

import java.io.Serializable;
import java.util.ArrayList;

// This class is responsible for saving the current available phases
// Doug Carroll

public class PhaseList implements Serializable{
	
	// List of phases
	private static ArrayList<Phase> phases = new ArrayList<Phase>();

	public static ArrayList<Phase> getPhases() {
		return phases;
	}

	public static void setPhases(ArrayList<Phase> phases) {
		PhaseList.phases = phases;
	}
	
	public static void addPhase(Phase e){phases.add(e);}
	
	public static void removePhase(Phase e){phases.remove(e);}
	
	// Add by string
	public static Phase addPhase(String e){
		Phase phase = new Phase(e);
		phases.add(phase);
		return phase;
	}
	
}
