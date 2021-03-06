/**
 * DefaultTask.java
 * Created on 12.02.2003, 15:30:40 Alex
 * Package: net.sf.memoranda
 *
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.Calendar;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.util.Util;
import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;

/**
 *
 */
/*$Id: TaskImpl.java,v 1.15 2005/12/01 08:12:26 alexeya Exp $*/
public class TaskImpl implements Task, Comparable {

    private Element _element = null;
    private TaskList _tl = null;
    private String owner;

    /**
     * Constructor for DefaultTask.
     */
    public TaskImpl(Element taskElement, TaskList tl) {
        _element = taskElement;
        _tl = tl;
    }

    public Element getContent() {
        return _element;
    }

    public CalendarDate getStartDate() {
		String str = _element.getAttribute("startDate").getValue();
		CalendarDate cal;
		if(str.isEmpty()){
			cal = null;
		} else {
			cal = new CalendarDate(str);
		}
		return cal;
    }

    public void setStartDate(CalendarDate date) {
           setAttr("startDate", date.toString());
    }
    
    public CalendarDate getEndDate() {
		String str = _element.getAttribute("endDate").getValue();
		CalendarDate cal;
		if(str.isEmpty()) {
			cal = null;
		} else {
			cal = new CalendarDate(str);
		}
		return cal;
    }
    
    // Sets the default start/end date based on the old getters functionality
    // This is how it should have been implemented.
    public void setDefaultDates(){
    	String ed = _element.getAttribute("endDate").getValue();
    	Task parent = this.getParentTask();
    	if(ed.isEmpty()){
    		Project pr = _tl.getProject();
    		if(parent != null && isSubTask()){
    			setEndDate(parent.getEndDate());
    			checkEndDate(parent);
        		checkStartDate(parent);
    		}
    		else if(pr.getEndDate() != null)
    			setEndDate(pr.getEndDate());
    		else
    			setEndDate(getStartDate());
    	}
    }
    
    // Checks the end date of a sub task to make sure it is before or equal to the parent
    // This is a double layer of protection in case end date goes above parents
    private void checkEndDate(Task parent){
    	CalendarDate parDate = parent.getEndDate();
    	if(this.getEndDate().after(parDate)){
    		this.setEndDate(parDate);
    	}
    }
    
    // Checks the start date of a sub task to make sure it is after or equal to the parent
    private void checkStartDate(Task parent){
    	CalendarDate parDate = parent.getStartDate();
    	if(this.getStartDate().before(parDate)){
    		this.setStartDate(parDate);
    	}
    }
    
    public boolean isSubTask(){
    	Task parent = this.getParentTask();
    	boolean result = false;
    	if(!(parent.getPhaseTitle().isEmpty()))
    		result = true;
    	return result;
    }
    
    public void setEndDate(CalendarDate date) {
		if (date == null)
			setAttr("endDate", "");
		else
			setAttr("endDate", date.toString());
    }

    public long getEffort() {
    	Attribute attr = _element.getAttribute("effort");
    	if (attr == null) {
    		return 0;
    	}
    	else {
    		try {
        		return Long.parseLong(attr.getValue());
    		}
    		catch (NumberFormatException e) {
    			return 0;
    		}
    	}
    }

    public void setEffort(long effort) {
        setAttr("effort", String.valueOf(effort));
    }
	
	/* 
	 * @see net.sf.memoranda.Task#getParentTask()
	 */
	public Task getParentTask() {
	    Element parent = getParentElem();
	    	if (parent.getLocalName().equalsIgnoreCase("task")){ 
	    	    return new TaskImpl(parent, _tl);
	    	}
    	return new Phase(parent, _tl);
	}
	
	// Get parent element
	public Element getParentElem() throws NullPointerException{
		Node parentNode = _element.getParent();
		Element res = null;
		if (parentNode instanceof Element) {
		    res = (Element) parentNode;
		}
		if(res == null)
			throw new NullPointerException();
		return res;
	}
	
	public String getParentId() {
		Task parent = this.getParentTask();
		if (parent != null)
			return parent.getID();
		return null;
	}

    public String getDescription() {
    	Element thisElement = _element.getFirstChildElement("description");
    	if (thisElement == null) {
    		return null;
    	}
    	else {
       		return thisElement.getValue();
    	}
    }

    public void setDescription(String s) {
    	Element desc = _element.getFirstChildElement("description");
    	if (desc == null) {
        	desc = new Element("description");
            desc.appendChild(s);
            _element.appendChild(desc);    	
    	}
    	else {
            desc.removeChildren();
            desc.appendChild(s);    	
    	}
    }

    /**s
     * @see net.sf.memoranda.Task#getStatus()
     */
    public int getStatus(CalendarDate date) {
        CalendarDate start = getStartDate();
        CalendarDate end = getEndDate();
        if (isFrozen())
            return Task.FROZEN;
        if (isCompleted())
                return Task.COMPLETED;
        
		if (date.inPeriod(start, end)) {
            if (date.equals(end))
                return Task.DEADLINE;
            else
                return Task.ACTIVE;
        }
		else if(date.before(start)) {
				return Task.SCHEDULED;
		}
		
		if(start.after(end)) {
			return Task.ACTIVE;
		}

        return Task.FAILED;
    }
    /**
     * Method isDependsCompleted.
     * @return boolean
     */
/*
    private boolean isDependsCompleted() {
        Vector v = (Vector) getDependsFrom();
        boolean check = true;
        for (Enumeration en = v.elements(); en.hasMoreElements();) {
            Task t = (Task) en.nextElement();
            if (t.getStatus() != Task.COMPLETED)
                check = false;
        }
        return check;
    }
*/
    public boolean isFrozen() {
        return _element.getAttribute("frozen") != null;
    }

    private boolean isCompleted() {
        return getProgress() == 100;
    }

    /**
     * @see net.sf.memoranda.Task#getID()
     */
    public String getID() {
        return _element.getAttribute("id").getValue();
    }

    /**
     * @see net.sf.memoranda.Task#getText()
     */
    public String getText() {
        return _element.getFirstChildElement("text").getValue();
    }

    public String toString() {
        return getText();
    }
    
    /**
     * @see net.sf.memoranda.Task#setText()
     */
    public void setText(String s) {
        _element.getFirstChildElement("text").removeChildren();
        _element.getFirstChildElement("text").appendChild(s);
    }

    /**
     * @see net.sf.memoranda.Task#freeze()
     */
    public void freeze() {
        setAttr("frozen", "yes");
    }

    /**
     * @see net.sf.memoranda.Task#unfreeze()
     */
    public void unfreeze() {
        if (this.isFrozen())
            _element.removeAttribute(new Attribute("frozen", "yes"));
    }

    /**
     * @see net.sf.memoranda.Task#getDependsFrom()
     */
    public Collection getDependsFrom() {
        Vector v = new Vector();
        Elements deps = _element.getChildElements("dependsFrom");
        for (int i = 0; i < deps.size(); i++) {
            String id = deps.get(i).getAttribute("idRef").getValue();
            Task t = _tl.getTask(id);
            if (t != null)
                v.add(t);
        }
        return v;
    }
    /**
     * @see net.sf.memoranda.Task#addDependsFrom(net.sf.memoranda.Task)
     */
    public void addDependsFrom(Task task) {
        Element dep = new Element("dependsFrom");
        dep.addAttribute(new Attribute("idRef", task.getID()));
        _element.appendChild(dep);
    }
    /**
     * @see net.sf.memoranda.Task#removeDependsFrom(net.sf.memoranda.Task)
     */
    public void removeDependsFrom(Task task) {
        Elements deps = _element.getChildElements("dependsFrom");
        for (int i = 0; i < deps.size(); i++) {
            String id = deps.get(i).getAttribute("idRef").getValue();
            if (id.equals(task.getID())) {
                _element.removeChild(deps.get(i));
                return;
            }
        }
    }
    /**
     * @see net.sf.memoranda.Task#getProgress()
     */
    public int getProgress() {
        return new Integer(_element.getAttribute("progress").getValue()).intValue();
    }
    /**
     * @see net.sf.memoranda.Task#setProgress(int)
     */
    public void setProgress(int p) {
        if ((p >= 0) && (p <= 100))
            setAttr("progress", new Integer(p).toString());
    }
    /**
     * @see net.sf.memoranda.Task#getPriority()
     */
    public int getPriority() {
        Attribute pa = _element.getAttribute("priority");
        if (pa == null)
            return Task.PRIORITY_NORMAL;
        return new Integer(pa.getValue()).intValue();
    }
    /**
     * @see net.sf.memoranda.Task#setPriority(int)
     */
    public void setPriority(int p) {
        setAttr("priority", String.valueOf(p));
    }

    private void setAttr(String a, String value) {
        Attribute attr = _element.getAttribute(a);
        if (attr == null)
           _element.addAttribute(new Attribute(a, value));
        else
            attr.setValue(value);
    }
    public void setOwner(String owner) {
    	setAttr("owner", owner);
    }
    public String getOwner() {
    	return _element.getAttribute("owner").getValue().toString();
    }

	/**
	 * A "Task rate" is an informal index of importance of the task
	 * considering priority, number of days to deadline and current 
	 * progress. 
	 * 
	 * rate = (100-progress) / (numOfDays+1) * (priority+1)
	 * @param CalendarDate
	 * @return long
	 */

	private long calcTaskRate(CalendarDate d) {
		Calendar endDateCal = getEndDate().getCalendar();
		Calendar dateCal = d.getCalendar();
		int numOfDays = (endDateCal.get(Calendar.YEAR)*365 + endDateCal.get(Calendar.DAY_OF_YEAR)) - 
						(dateCal.get(Calendar.YEAR)*365 + dateCal.get(Calendar.DAY_OF_YEAR));
		if (numOfDays < 0) return -1; //Something wrong ?
		return (100-getProgress()) / (numOfDays+1) * (getPriority()+1);
	}

    /**
     * @see net.sf.memoranda.Task#getRate()
     */
	 
     public long getRate() {
/*	   Task t = (Task)task;
	   switch (mode) {
		   case BY_IMP_RATE: return -1*calcTaskRate(t, date);
		   case BY_END_DATE: return t.getEndDate().getDate().getTime();
		   case BY_PRIORITY: return 5-t.getPriority();
		   case BY_COMPLETION: return 100-t.getProgress();
	   }
       return -1;
*/
		return -1*calcTaskRate(CurrentDate.get());
	 }
	   
	 /*
	  * Comparable interface
	  */
	  
	 public int compareTo(Object o) {
		 Task task = (Task) o;
		 	if(getRate() > task.getRate())
				return 1;
			else if(getRate() < task.getRate())
				return -1;
			else 
				return 0;
	 }
	 
	 public boolean equals(Object o) {
	     return ((o instanceof Task) && (((Task)o).getID().equals(this.getID())));
	 }

	/* 
	 * @see net.sf.memoranda.Task#getSubTasks()
	 */
	public ArrayList<Task> getSubTasks() {
		Elements subTasks = _element.getChildElements("task");
            return convertToTaskObjects(subTasks);
	}

	private ArrayList<Task> convertToTaskObjects(Elements tasks) {
        ArrayList<Task> v = new ArrayList<Task>();
        for (int i = 0; i < tasks.size(); i++) {
            Task t = new TaskImpl(tasks.get(i), _tl);
            v.add(t);
        }
        return v;
    }
	
	/* 
	 * @see net.sf.memoranda.Task#getSubTask(java.lang.String)
	 */
	public Task getSubTask(String id) {
		Elements subTasks = _element.getChildElements("task");
		for (int i = 0; i < subTasks.size(); i++) {
			if (subTasks.get(i).getAttribute("id").getValue().equals(id))
				return new TaskImpl(subTasks.get(i), _tl);
		}
		return null;
	}

	/* 
	 * @see net.sf.memoranda.Task#hasSubTasks()
	 */
	public boolean hasSubTasks(String id) {
		Elements subTasks = _element.getChildElements("task");
		for (int i = 0; i < subTasks.size(); i++) 
			if (subTasks.get(i).getAttribute("id").getValue().equals(id))
				return true;
		return false;
	}
	
	// Start phase implementation
	@Override
	public Phase getPhase(){
		PhaseList list = CurrentProject.getPhaseList();
		return list.getPhase(getPhaseTitle());
	}
	
	// Set the parent of this element
	public void setPhaseElem(Element e){
		try{
			Element parent = getParentElem();
			// If parent is a phase
			if(parent.getAttribute("phase").getValue().equals("")){
				// if it is a phase, lets swap this elements child.
				_element.detach();
				e.appendChild(_element);
				
				_tl.removeElement(_element);
				
				// Set the tasks tasklist to the new phases tasklist
				_tl = CurrentProject.getPhaseList().getPhase(e.getFirstChildElement("text").getValue()).getTaskList();
				_tl.addElement(_element);
				
			}
		}catch(NullPointerException ex){
			Util.debug("This element has no parent!");
			ex.printStackTrace();
		}
	}
	
	@Override
	public String getPhaseTitle() {
		return _element.getAttribute("phase").getValue();
	}
	
	@Override
	public void setPhaseTitle(String p) {
		setAttr("phase", p);
	}
	
	public boolean isPhase(){return false;}
	
	public boolean hasSubTasks(){
		Elements subTasks = _element.getChildElements("task");
		return subTasks.size() > 0;
	}
}
