/**
 * TaskList.java
 * Created on 21.02.2003, 12:25:16 Alex
 * Package: net.sf.memoranda
 * 
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda;
import java.util.Collection;

import net.sf.memoranda.date.CalendarDate;
import nu.xom.Document;
import nu.xom.Element;
/**
 * 
 */
/*$Id: TaskList.java,v 1.8 2005/12/01 08:12:26 alexeya Exp $*/
public interface TaskList {

	Project getProject();
    Task getTask(String id);

    Task createTask(CalendarDate startDate, CalendarDate endDate, String text, int priority, long effort, String description, String parentTaskId, String phase);

    Task createTask(CalendarDate startDate, CalendarDate endDate, String text,
			int priority, long effort, String description, Task defaultPhase,
			String text2);
    
    void removeTask(Task task);
    
    Element getRoot();

    public boolean hasSubTasks(String id);
    
	public boolean hasParentTask(String id);

	public Collection getTopLevelTasks();
	
    public Collection getAllSubTasks(String taskId);
    public Collection getActiveSubTasks(String taskId,CalendarDate date);
    
//    public void adjustParentTasks(Task t);
    
    public long calculateTotalEffortFromSubTasks(Task t);
    public CalendarDate getLatestEndDateFromSubTasks(Task t);
    public CalendarDate getEarliestStartDateFromSubTasks(Task t);
    public long[] calculateCompletionFromSubTasks(Task t);
    
    public int size();
	public void addElement(Element e);
	public void removeElement(Element _element);

}
