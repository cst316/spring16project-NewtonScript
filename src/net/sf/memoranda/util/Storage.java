/**
 * Storage.java
 * Created on 12.02.2003, 0:58:42 Alex
 * Package: net.sf.memoranda.util
 * 
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda.util;

import net.sf.memoranda.Note;
import net.sf.memoranda.NoteList;
import net.sf.memoranda.PhaseList;
import net.sf.memoranda.Project;
import net.sf.memoranda.ResourcesList;
import net.sf.memoranda.TaskList;
import net.sf.memoranda.TestCaseList;
import net.sf.memoranda.ui.TimeSheetPanel;
/**
 * 
 */
/*$Id: Storage.java,v 1.4 2004/01/30 12:17:42 alexeya Exp $*/
public interface Storage {
            
    PhaseList openPhaseList(Project prj);    
    void storePhaseList(PhaseList _tasklist, Project prj);
    
    NoteList openNoteList(Project prj);
    void storeNoteList(NoteList nl, Project prj);
    
    void storeNote(Note note, javax.swing.text.Document doc);    
    javax.swing.text.Document openNote(Note note);
    void removeNote(Note note);
    
    String getNoteURL(Note note);
    
    void openProjectManager();    
    void storeProjectManager();
    
    void openEventsManager();
    void storeEventsManager();
    
    void openMimeTypesList();
    void storeMimeTypesList();
    
    void createProjectStorage(Project prj);
    void removeProjectStorage(Project prj);
   
    ResourcesList openResourcesList(Project prj);
    void storeResourcesList(ResourcesList rl, Project prj);
    
    void restoreContext();
    void storeContext();
    
    /**
     * Used to open the TestCase list from the XML file
     * @return 
     */
    TestCaseList openTestCaseList(Project pr);
    
    /**
     * Used to save the TestCase list to an XML file
     */
    void storeTestCaseList(TestCaseList dl, Project pr);
    
    /**
     * Load time sheet panel from the serialized object file
     * 
     * @param prj
     * @return
     */
    public TimeSheetPanel loadTimeSheet(Project prj);
    
    /**
     * Save the time sheet panel to a serialized object
     * 
     * @param tsp
     * @param prj
     */
    public void saveTimeSheet(TimeSheetPanel tsp, Project prj);
       
}
