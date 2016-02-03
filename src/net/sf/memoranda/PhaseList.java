package net.sf.memoranda;

import java.util.ArrayList;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

// This class is responsible for saving the current available phases
// Doug Carroll

public class PhaseList {
	
	// List of phases
	private ArrayList<Phase> phases;
	private Document _doc = null;
	private Project _project = null;
	private Element _root = null;
	
	public PhaseList(Project _prj){
		_project = _prj;
		_root = new Element("phaselist");
        _doc = new Document(_root);
        phases = new ArrayList<Phase>();
        addNewPhase(new Phase("default")); // Create the default phase
	}
	

	public PhaseList(Document _d, Project _prj){
		_project = _prj;
		_doc = _d;
		_root = _doc.getRootElement();
		phases = new ArrayList<Phase>();
		buildElements();
	}
	
	// Build the list from file
	private void buildElements(){
		Elements els = _root.getChildElements();
		
		for(int i = 0; i < els.size(); i++){
			Element e = els.get(i);
			String title = e.getAttribute("title").getValue();
			addPhase(new Phase(title));
		}
	}

	public ArrayList<Phase> getPhases() {
		return phases;
	}

	public void setPhases(ArrayList<Phase> phases) {
		this.phases = phases;
	}
	
	// Adds phases locally to build the object
	private void addPhase(Phase e){
		phases.add(e);
	}
	
	// Adds a phase to be saved
	public void addNewPhase(Phase e) {
		_root.appendChild(e.toElement());
		addPhase(e);
	}
	
	public void removePhase(Phase e){
		phases.remove(e);
	}
	
	// Add new phase by string
	public Phase addNewPhase(String e){
		Phase phase = new Phase(e);
		addNewPhase(phase);
		return phase;
	}
	
	// Returns the phase by title
	public Phase getPhase(String title){
		Phase ph = null;
		
		for(Phase p : phases){
			if(p.getTitle().equals(title))
				ph = p;	
		}
		
		return ph;
	}
	
	// Returns the default phase
	public Phase getDefault(){
		return phases.get(0);
	}
	
	// Get XML document for this list
	public Document getXMLContent() {
		return _doc;
	}
	
}
