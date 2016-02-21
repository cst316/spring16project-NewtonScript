package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.util.Util;
import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;

// Phase implements task so it can be handled as a task in the table
// Doug Carroll


public class Phase implements Task{
	
	private Element phaseElement;
	private TaskList taskList;
	
	public Phase(Element el, TaskList taskl){
		phaseElement = el;
		taskList = taskl;
	}

	
	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	public String getTitle() {
		return phaseElement.getFirstChildElement("text").getValue();
	}

	public void setTitle(String title) {
		phaseElement.getFirstChildElement("text").removeChildren();
		phaseElement.getFirstChildElement("text").appendChild(title);
	}
	
	public String toString(){return getTitle();}
	
	public Element toElement(){
		return phaseElement;
	}
	
	// Does this phase contain any tasks?
	public boolean hasSubTasks(){
		Elements subTasks = phaseElement.getChildElements("task");
		return subTasks.size() > 0;
	}
	
	// Get task element in this phase by ID
	public Element getTaskElementByID(String ID) {
		Elements els = phaseElement.getChildElements("task");
		Element res = null;
		for(int i = 0; i < els.size(); i++){
			Element temp = els.get(i);
			if(temp.getAttributeValue("id").equals(ID)){
				res = temp;
			}
		}
		return res;
	}
	
	public String getID(){
		return phaseElement.getAttribute("id").getValue();
	}
	
	public Elements getChildren(){
		return  phaseElement.getChildElements();
	}

	@Override
	public CalendarDate getStartDate() {
		String str = phaseElement.getAttribute("startDate").getValue();
		CalendarDate cal;
		if(str.isEmpty())
			cal = null;
		else
			cal = new CalendarDate(str);
		return cal;
	}
	
	// Sets the phase dates
	public void setPhaseDates(){
		setStartDate();
		setEndDate();
	}
	
	// Sets the earliest start date from the children tasks
	private void setStartDate(){
		Elements els = phaseElement.getChildElements("task");
		Calendar cal = Calendar.getInstance(); // In case there are no tasks
		CalendarDate resDate = new CalendarDate(cal);
		// If there is only one task, set the start date to that tasks
		if(els.size() > 0){
			if(els.size() == 1){
				resDate = new CalendarDate(els.get(0).getAttribute("startDate").getValue());
			}
			// Only search if there are multiple tasks in this phase
			else {
				CalendarDate date = null;
				for(int i = 0; i < els.size() - 1; i++){
					Element temp = els.get(i);
					Element temp2 = els.get(i + 1);
					date = new CalendarDate(temp.getAttribute("startDate").getValue());
					CalendarDate nextDate = new CalendarDate(temp2.getAttribute("startDate").getValue());
					if(date.after(nextDate) || date.equals(nextDate)){
						 resDate = nextDate;
					}
					else{
						resDate = date;
					}
				}
			}
			setStartDate(resDate);
		}
		// If there are no tasks, make the start date empty
		else
			setStartDate(null);
	}
	
	
	@Override
	public void setStartDate(CalendarDate date) {
		if (date == null)
			setAttr("startDate", "");
		else
			setAttr("startDate", date.toString());
	}
	
	// Sets the end date based on the latest end date of its tasks
	private void setEndDate() {
		Elements els = phaseElement.getChildElements("task");
		Calendar cal = Calendar.getInstance(); // In case there are no tasks
		CalendarDate resDate = new CalendarDate(cal);
		// If there is only one task, set the start date to that tasks
		if(els.size() > 0){
			if(els.size() == 1){
				resDate = new CalendarDate(els.get(0).getAttribute("endDate").getValue());
			}
			// Only search if there are multiple tasks in this phase
			else {
				CalendarDate date = null;
				for(int i = 0; i < els.size() - 1; i++){
					Element temp = els.get(i);
					Element temp2 = els.get(i + 1);
					date = new CalendarDate(temp.getAttribute("endDate").getValue());
					CalendarDate nextDate = new CalendarDate(temp2.getAttribute("endDate").getValue());
					if(date.before(nextDate) || date.equals(nextDate)){
						 resDate = nextDate;
					}
					else{
						resDate = date;
					}
				}
			}
			setEndDate(resDate);
		}
		// If there are no tasks, make the end date empty
		else
			setEndDate(null);
	}

	@Override
	public void setEndDate(CalendarDate date) {
		if (date == null)
			setAttr("endDate", "");
		else
			setAttr("endDate", date.toString());
	}
	
	@Override
	public CalendarDate getEndDate() {
		String str = phaseElement.getAttribute("endDate").getValue();
		CalendarDate cal;
		if(str.isEmpty())
			cal = null;
		else
			cal = new CalendarDate(str);
		return cal;
	}

	@Override
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
	
	// If progress of all tasks is 100
	private boolean isCompleted() {
		return getProgress() == 100;
	}

	public int getProgress() {
		return new Integer(phaseElement.getAttribute("progress").getValue());
	}
	
	@Override
	public void setProgress(int p) {
		if ((p >= 0) && (p <= 100))
            setAttr("progress", new Integer(p).toString());
	}
	
	// Calculate current progress and then set it.
	// Round the progress to the nearest int
	public void calculateProgress(){
		float sum = 0;
		float result = 0;
		ArrayList<Task> tasks = getSubTasks();
		for(Task t : tasks){
			sum += t.getProgress();
		}
		result = sum / (tasks.size() * 100); // actual / total
		setProgress(Math.round(result * 100));
	}
	
	// Return phase priority
	@Override
	public int getPriority() {
		Attribute pa = phaseElement.getAttribute("priority");
        if (pa == null)
            return Task.PRIORITY_PHASE;
        return new Integer(pa.getValue()).intValue();
	}
	
	@Override
	public void setPriority(int p) {
		setAttr("priority", String.valueOf(p));
	}

	@Override
	public String getText() {
		return getTitle();
	}

	@Override
	public void setText(String s) {
		setTitle(s);
		
	}

	@Override
	public ArrayList<Task> getSubTasks() {
		Elements subTasks = phaseElement.getChildElements("task");
        return convertToTaskObjects(subTasks);
	}
	
	private ArrayList<Task> convertToTaskObjects(Elements tasks) {
		ArrayList<Task> v = new ArrayList<Task>();
        for (int i = 0; i < tasks.size(); i++) {
            Task t = new TaskImpl(tasks.get(i), taskList);
            v.add(t);
        }
        return v;
    }

	@Override
	public Task getSubTask(String id) {
		return taskList.getTask(id);
	}
	
	// If the task is in this phase
	@Override
	public boolean hasSubTasks(String id) {
		Element e = getTaskElementByID(id);
		boolean exists = false;
		if(e != null)
			exists = true;
		return exists;
	}
	
	
	// TODO make effort a total of all sub task efforts.
	@Override
	public void setEffort(long effort) {
		
	}
	
	// TODO make effort a total of all sub task efforts.
	@Override
	public long getEffort() {
		return 0;
	}

	@Override
	public void setDescription(String description) {
		Element desc = phaseElement.getFirstChildElement("description");
    	if (desc == null) {
        	desc = new Element("description");
            desc.appendChild(description);
            phaseElement.appendChild(desc);    	
    	}
    	else {
            desc.removeChildren();
            desc.appendChild(description);    	
    	}
	}

	@Override
	public String getDescription() {
		Element thisElement = phaseElement.getFirstChildElement("description");
		String res = null;
		
    	if (!(thisElement == null)) 
    		res = thisElement.getValue();
    	
    	return res;
	}
	
	// Phases cannot have other tasks as parents (YET!)
	@Override
	public Task getParentTask() {
		return null;
	}
	
	// Phases cannot have other tasks as parents (YET!)
	@Override
	public String getParentId() {
		return null;
	}

	@Override
	public void freeze() {
		setAttr("frozen", "yes");
	}

	@Override
	public void unfreeze() {
		 if (this.isFrozen())
			 phaseElement.removeAttribute(phaseElement.getAttribute("frozen"));
	}
	
	public boolean isFrozen() {
        return phaseElement.getAttribute("frozen") != null;
    }
	
	// TODO Make average of all tasks
	@Override
	public long getRate() {
		return 0;
	}

	@Override
	public Element getContent() {
		return toElement();
	}

	@Override
	public Phase getPhase() {
		return this;
	}

	@Override
	public String getPhaseTitle() {
		return getTitle();
	}
	
	private void setAttr(String a, String value) {
        Attribute attr = phaseElement.getAttribute(a);
        if (attr == null)
           phaseElement.addAttribute(new Attribute(a, value));
        else
            attr.setValue(value);
    }
	public boolean isPhase(){return true;}
	
	@Override
	public void setPhaseTitle(String p) {
		setAttr("phase", p);
	}

	// This should never return the parent, the parent of all phases is root
	@Override
	public Element getParentElem() {
		return null;
	}

	// This should do nothing here because phases are not in phases
	@Override
	public void setPhaseElem(Element e) {}


	@Override
	public void setOwner(String owner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getOwner() {
		return "";
	}

	// Default should always be empty
	@Override
	public void setDefaultDates() {
		setAttr("endDate", "");
	}

	// Always return false for phases
	@Override
	public boolean isSubTask() {
		return false;
	}
	
}
