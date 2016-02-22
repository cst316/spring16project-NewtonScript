package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Vector;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.CurrentStorage;
import net.sf.memoranda.util.Util;
import nu.xom.Attribute;
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
	private Hashtable<String, Element> elements = new Hashtable<String, Element>();
	
	public PhaseList(){phases = new ArrayList<Phase>();}
	
	public PhaseList(Project _prj){
		_project = _prj;
		_root = new Element("tasklist");
        _doc = new Document(_root);
        phases = new ArrayList<Phase>();
        addNewPhase("Default");
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
		Elements els = _root.getChildElements("task");
		for(int i = 0; i < els.size(); i++){
			Element e = els.get(i);
			TaskList list = new TaskListImpl(e, _project);
			Util.debug("Adding phase:" + e.getFirstChildElement("text").getValue());
			elements.put(e.getAttribute("id").getValue(), e);
			addPhase(new Phase(e, list));
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
		addPhase(e);
	}
	
	public void removePhase(Phase e){
		phases.remove(e);
	}
	
	// Add new phase by string
	public Phase addNewPhase(String e){
		Phase phase = createPhase(e);
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
	
	// Returns the phase element by title
	public Element getPhaseElem(String title){
		return getPhase(title).getContent();
	}
	
	// Returns the default phase
	public Phase getDefault(){
		Phase ph = null;
		
		try{
			if(phases.size() == 0)
				throw new NullPointerException();
			ph = phases.get(0);
			
		}catch(NullPointerException e){
			System.out.println("There are no phases! Something went wrong.");
			e.printStackTrace();
		}
		
		return ph;
	}
	
	// Returns a task list of all the tasks
	// Careful that this does not save anywhere
	public TaskList getAllTasks(){
		Element root = new Element("tasklist");
		TaskList list = new TaskListImpl(root, _project);
		for(Phase p : phases){
			if(p.hasSubTasks()){
				TaskList tempList = p.getTaskList();
				for(Object t : tempList.getTopLevelTasks()){
					Task task = (Task) t;
					list.getTopLevelTasks().add(task.getContent());
				}
			}
		}
		
		return list;
	}
	
	// Method to return an arraylist of all the tasks in the phases, including phases
	public ArrayList<Task> getAllTaskslist(){
		ArrayList<Task> tasks = new ArrayList<Task>();
		for(Phase p : phases){
			tasks.add(p);
			if(p.hasSubTasks()){
				tasks.addAll(p.getSubTasks());
			}
		}
		return tasks;
	}
	
	
	// No generic type set as this is how it was done by the caller
	public Collection getAllActiveTasks(String taskId, CalendarDate date){
		Collection list;
		HashSet set = new HashSet();
		for(Phase ph : phases){
			Collection temp = ph.getTaskList().getActiveSubTasks(taskId, date);
			set.addAll(temp);
		}
		list = new Vector(set);
		
		return list;
	}
	
	// Get Phase element by ID
	private Element getPhaseByID(String ID){
		Element res = null;
		res = elements.get(ID);
		return res;
	}
	
	// Get any task element by ID (Including phases)
	public Element getElementByID(String ID){
		Element res = getPhaseByID(ID);
		if(res == null){
			for(Phase ph : phases){
				Element temp = ph.getSubTask(ID).getContent();
				if(temp != null)
					res = ph.getSubTask(ID).getContent();
			}
		}
		return res;
	}
	
	
	// Get any task by ID (Including phases)
	public Task getAllByID(String ID){
		Task res;
		Element e = getElementByID(ID);
		String phaseName = e.getAttribute("phase").getValue();
		if(phaseName.equals("")){
			res = getPhase(e.getFirstChildElement("text").getValue());
		}
		else{
			Phase ph = getPhase(phaseName);
			TaskList tl = ph.getTaskList();
			res = new TaskImpl(e, tl);
		}
		return res;
	}
	
	
	public Phase createPhase(String text) {
        Element el = new Element("task");
        el.addAttribute(new Attribute("startDate", ""));
        el.addAttribute(new Attribute("endDate", ""));
		String id = Util.generateId();
        el.addAttribute(new Attribute("id", id));
        el.addAttribute(new Attribute("progress", "0"));
        el.addAttribute(new Attribute("effort", "0"));
        el.addAttribute(new Attribute("priority","5"));
        el.addAttribute(new Attribute("phase","")); // Phases have no phase
        
        Element txt = new Element("text");
        txt.appendChild(text);
        el.appendChild(txt);

        Element desc = new Element("description");
        desc.appendChild("");
        el.appendChild(desc);
       
        _root.appendChild(el);
       
        Util.debug("Created phase " + text);
        
        TaskList list = new TaskListImpl(el, _project); // New task list for this element
        elements.put(id, el); // Add this phase to the list
        
        Phase phase = new Phase(el, list);
        
        return phase;
    }
	
	// Get XML document for this list
	public Document getXMLContent() {
		return _doc;
	}
	
	// Remove task or phase
	public void removeTask(Task task) {
        String parentTaskId = task.getParentId();
        if (parentTaskId == null) {
            _root.removeChild(task.getContent());            
        }
        else {
            Element parentNode = getElementByID(parentTaskId);
            parentNode.removeChild(task.getContent());
        }
		elements.remove(task.getID());
		if(task.isPhase())
			phases.remove(getPhase(task.getText()));
    }
	
	// Returns if the element exists for not
	public boolean contains(String ID){
		Element e = getElementByID(ID);
		boolean res = false;
		if(e != null){
			res = true;
		}
		return res;	
	}
	
}
