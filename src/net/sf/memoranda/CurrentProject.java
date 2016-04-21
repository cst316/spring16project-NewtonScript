/**
 * CurrentProject.java
 * Created on 13.02.2003, 13:16:52 Alex
 * Package: net.sf.memoranda
 *
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 *
 */
package net.sf.memoranda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

import net.sf.memoranda.ui.AppFrame;
import net.sf.memoranda.ui.TimeSheetPanel;
import net.sf.memoranda.ui.WorkPanel;
import net.sf.memoranda.util.Context;
import net.sf.memoranda.util.CurrentStorage;
import net.sf.memoranda.util.Storage;

/**
 *
 */
/*$Id: CurrentProject.java,v 1.6 2005/12/01 08:12:26 alexeya Exp $*/
public class CurrentProject {

    private static Project _project = null;
    private static TaskList _tasklist = null;
    private static NoteList _notelist = null;
    private static PhaseList _phaseList = null;
    private static TestCaseList _testCaseList = null;
    private static UsersList _usersList = null;
    private static ResourcesList _resources = null;
    private static TimeSheetPanel tsp = null;
    private static DefectList _defectList = null;
    private static Vector projectListeners = new Vector();

        
    static {
        String prjId = (String)Context.get("LAST_OPENED_PROJECT_ID");
        if (prjId == null) {
            prjId = "__default";
            Context.put("LAST_OPENED_PROJECT_ID", prjId);
        }
        //ProjectManager.init();
        _project = ProjectManager.getProject(prjId);
		
		if (_project == null) {
			// alexeya: Fixed bug with NullPointer when LAST_OPENED_PROJECT_ID
			// references to missing project
			_project = ProjectManager.getProject("__default");
			if (_project == null) 
				_project = (Project)ProjectManager.getActiveProjects().get(0);						
            Context.put("LAST_OPENED_PROJECT_ID", _project.getID());
			
		}		
		
        _notelist = CurrentStorage.get().openNoteList(_project);
        _resources = CurrentStorage.get().openResourcesList(_project);
        _phaseList = CurrentStorage.get().openPhaseList(_project);
        _testCaseList = CurrentStorage.get().openTestCaseList(_project);
        _usersList = CurrentStorage.get().openUsersList(_project);
        _tasklist = _phaseList.getAllTasks();
        tsp = CurrentStorage.get().loadTimeSheet(_project);
        _defectList = CurrentStorage.get().openDefectList(_project);
        AppFrame.addExitListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();                                               
            }
        });
    }
        

    public static Project get() {
        return _project;
    }

    public static NoteList getNoteList() {
            return _notelist;
    }
    
    public static ResourcesList getResourcesList() {
            return _resources;
    }
    
    public static PhaseList getPhaseList(){
    	return _phaseList;
    }
    
    public static DefectList getDefectList(){
    	return _defectList;
	}
    public static TestCaseList getTestCaseList(){
    	return _testCaseList;
    }
    public static UsersList getUsersList(){
    	return _usersList;
    }
    
    public static TimeSheetPanel getTimeSheet(){
    	return tsp;
    }

    public static void set(Project project) {
        if (project.getID().equals(_project.getID())) return;
        NoteList newnotelist = CurrentStorage.get().openNoteList(project);
        ResourcesList newresources = CurrentStorage.get().openResourcesList(project);
        PhaseList newPhases = CurrentStorage.get().openPhaseList(project);
        TestCaseList newTestCases = CurrentStorage.get().openTestCaseList(project);
        UsersList newUsers = CurrentStorage.get().openUsersList(project);
        TaskList newtasklist = newPhases.getAllTasks();
        DefectList newDefects = CurrentStorage.get().openDefectList(project);
        notifyListenersBefore(project, newnotelist, newtasklist, 
        		newresources, newPhases, newTestCases, newDefects, newUsers);
        _project = project;
        _tasklist = newtasklist;
        _notelist = newnotelist;
        _resources = newresources;
        _phaseList = newPhases;
        _defectList = newDefects;
        _testCaseList = newTestCases;
        _usersList = newUsers;
        notifyListenersAfter();
        Context.put("LAST_OPENED_PROJECT_ID", project.getID());
    }

    public static void addProjectListener(ProjectListener pl) {
        projectListeners.add(pl);
    }

    public static Collection getChangeListeners() {
        return projectListeners;
    }

    private static void notifyListenersBefore(Project project, NoteList nl, TaskList tl, ResourcesList rl, PhaseList ph, TestCaseList newTestCases, DefectList dl, UsersList ul) {

        for (int i = 0; i < projectListeners.size(); i++) {
            ((ProjectListener)projectListeners.get(i)).projectChange(project, nl, tl, rl, ph, newTestCases, dl, ul);
            /*DEBUGSystem.out.println(projectListeners.get(i));*/
        }
    }
    
    private static void notifyListenersAfter() {
        for (int i = 0; i < projectListeners.size(); i++) {
            ((ProjectListener)projectListeners.get(i)).projectWasChanged();            
        }
    }

    public static void save() {
        Storage storage = CurrentStorage.get();

        storage.storeNoteList(_notelist, _project);
        storage.storeResourcesList(_resources, _project);
        storage.storePhaseList(_phaseList, _project); // Save the phase list to a file
        storage.saveTimeSheet(WorkPanel.getTimeSheetPanel(), _project);
        storage.storeDefectList(_defectList, _project); // Save the defect list to a file
        storage.storeUsersList(_usersList, _project);
        storage.storeProjectManager();
    }
    
    public static void free() {
        _project = null;
        _tasklist = null;
        _notelist = null;
        _resources = null;
    }
}
