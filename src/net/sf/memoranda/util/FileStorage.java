/**
 * Storage.java
 * Created on 12.02.2003, 0:21:40 Alex
 * Package: net.sf.memoranda.util
 *
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import net.sf.memoranda.DefectList;
import net.sf.memoranda.DefectListImpl;
import net.sf.memoranda.EventsManager;
import net.sf.memoranda.Note;
import net.sf.memoranda.NoteList;
import net.sf.memoranda.NoteListImpl;
import net.sf.memoranda.PhaseList;
import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectManager;
import net.sf.memoranda.ResourcesList;
import net.sf.memoranda.ResourcesListImpl;
import net.sf.memoranda.TaskList;
import net.sf.memoranda.TaskListImpl;
import net.sf.memoranda.TestCaseList;
import net.sf.memoranda.TestCaseListImpl;
import net.sf.memoranda.UsersList;
import net.sf.memoranda.UsersListImpl;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ui.DailyItemsPanel;
import net.sf.memoranda.ui.ExceptionDialog;
import net.sf.memoranda.ui.TimeSheetPanel;
import net.sf.memoranda.ui.htmleditor.AltHTMLWriter;
import nu.xom.Builder;
import nu.xom.DocType;
import nu.xom.Document;


/**
 *
 */
/*$Id: FileStorage.java,v 1.15 2006/10/09 23:31:58 alexeya Exp $*/
public class FileStorage implements Storage {

    public static String JN_DOCPATH = Util.getEnvDir();
    private HTMLEditorKit editorKit = new HTMLEditorKit();

    public FileStorage() {
        /*The 'MEMORANDA_HOME' key is an undocumented feature for 
          hacking the default location (Util.getEnvDir()) of the memoranda 
          storage dir. Note that memoranda.config file is always placed at fixed 
          location (Util.getEnvDir()) anyway */
        String mHome = (String) Configuration.get("MEMORANDA_HOME");
        if (mHome.length() > 0) {
            JN_DOCPATH = mHome;
            /*DEBUG*/
        	System.out.println("[DEBUG]***Memoranda storage path has set to: " +
        	 JN_DOCPATH);
        }
    }

    public static void saveDocument(Document doc, String filePath) {
        /**
         * @todo: Configurable parameters
         */
        try {
            /*The XOM bug: reserved characters are not escaped*/
            //Serializer serializer = new Serializer(new FileOutputStream(filePath), "UTF-8");
            //serializer.write(doc);
            OutputStreamWriter fw =
                new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
            fw.write(doc.toXML());
            fw.flush();
            fw.close();
        }
        catch (IOException ex) {
            new ExceptionDialog(
                ex,
                "Failed to write a document to " + filePath,
                "");
        }
    }

    public static Document openDocument(InputStream in) throws Exception {
        Builder builder = new Builder();
        return builder.build(new InputStreamReader(in, "UTF-8"));
    }

    public static Document openDocument(String filePath) {
        try {
            return openDocument(new FileInputStream(filePath));
        }
        catch (Exception ex) {
            new ExceptionDialog(
                ex,
                "Failed to read a document from " + filePath,
                "");
        }
        return null;
    }

    public static boolean documentExists(String filePath) {
        return new File(filePath).exists();
    }

    /**
     * @see net.sf.memoranda.util.Storage#storeNote(net.sf.memoranda.Note)
     */
    public void storeNote(Note note, javax.swing.text.Document doc) {
        String filename =
            JN_DOCPATH + note.getProject().getID() + File.separator;
        doc.putProperty(
            javax.swing.text.Document.TitleProperty,
            note.getTitle());        
        CalendarDate d = note.getDate();

        filename += note.getId();//d.getDay() + "-" + d.getMonth() + "-" + d.getYear();
        /*DEBUG*/System.out.println("[DEBUG] Save note: "+ filename);

        try {
            OutputStreamWriter fw =
                new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
            AltHTMLWriter writer = new AltHTMLWriter(fw, (HTMLDocument) doc);
            writer.write();
            fw.flush();
            fw.close();
            //editorKit.write(new FileOutputStream(filename), doc, 0, doc.getLength());
            //editorKit.write(fw, doc, 0, doc.getLength());
        }
        catch (Exception ex) {
            new ExceptionDialog(
                ex,
                "Failed to write a document to " + filename,
                "");
        }
        /*String filename = JN_DOCPATH + note.getProject().getID() + "/";
        doc.putProperty(javax.swing.text.Document.TitleProperty, note.getTitle());
        CalendarDate d = note.getDate();
        filename += d.getDay() + "-" + d.getMonth() + "-" + d.getYear();
        try {
            long t1 = new java.util.Date().getTime();
            FileOutputStream ostream = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(ostream);
        
            oos.writeObject((HTMLDocument)doc);
        
            oos.flush();
            oos.close();
            ostream.close();
            long t2 = new java.util.Date().getTime();
            System.out.println(filename+" save:"+ (t2-t1) );
        }
            catch (Exception ex) {
                ex.printStackTrace();
            }*/

    }
    /**
     * @see net.sf.memoranda.util.Storage#openNote(net.sf.memoranda.Note)
     */
    public javax.swing.text.Document openNote(Note note) {

        HTMLDocument doc = (HTMLDocument) editorKit.createDefaultDocument();
        if (note == null)
            return doc;
        /*
                String filename = JN_DOCPATH + note.getProject().getID() + File.separator;
                CalendarDate d = note.getDate();
                filename += d.getDay() + "-" + d.getMonth() + "-" + d.getYear();
        */
        String filename = getNotePath(note);
        try {
            /*DEBUG*/

//            Util.debug("Open note: " + filename);
//        	Util.debug("Note Title: " + note.getTitle());
        	doc.setBase(new URL(getNoteURL(note)));
        	editorKit.read(
                new InputStreamReader(new FileInputStream(filename), "UTF-8"),
                doc,
                0);
        }
        catch (Exception ex) {
            //ex.printStackTrace();
            // Do nothing - we've got a new empty document!
        }
        
        return doc;
        /*HTMLDocument doc = (HTMLDocument)editorKit.createDefaultDocument();
        if (note == null) return doc;
        String filename = JN_DOCPATH + note.getProject().getID() + "/";
        CalendarDate d = note.getDate();
        filename += d.getDay() + "-" + d.getMonth() + "-" + d.getYear();
        try {
            long t1 = new java.util.Date().getTime();
            FileInputStream istream = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(istream);
            doc = (HTMLDocument)ois.readObject();
            ois.close();
            istream.close();
            long t2 = new java.util.Date().getTime();
            System.out.println(filename+" open:"+ (t2-t1) );
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return doc;*/
    }

    public String getNoteURL(Note note) {        
        return "file:" + JN_DOCPATH + note.getProject().getID() + "/" + note.getId();
    }

   public String getNotePath(Note note) {
        String filename = JN_DOCPATH + note.getProject().getID() + File.separator;
//        CalendarDate d = note.getDate();
        filename += note.getId();//d.getDay() + "-" + d.getMonth() + "-" + d.getYear();
	return filename;
   }


    public void removeNote(Note note) {
        File f = new File(getNotePath(note));
        /*DEBUG*/
        System.out.println("[DEBUG] Remove note:" + getNotePath(note));
        f.delete();
    }

    /**
     * @see net.sf.memoranda.util.Storage#openProjectManager()
     */
    public void openProjectManager() {
        if (!new File(JN_DOCPATH + ".projects").exists()) {
            ProjectManager._doc = null;
            return;
        }
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Open project manager: " + JN_DOCPATH + ".projects");
        ProjectManager._doc = openDocument(JN_DOCPATH + ".projects");
    }
    /**
     * @see net.sf.memoranda.util.Storage#storeProjectManager(nu.xom.Document)
     */
    public void storeProjectManager() {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save project manager: " + JN_DOCPATH + ".projects");
        saveDocument(ProjectManager._doc, JN_DOCPATH + ".projects");
    }
    /**
     * @see net.sf.memoranda.util.Storage#removeProject(net.sf.memoranda.Project)
     */
    public void removeProjectStorage(Project prj) {
        String id = prj.getID();
        File f = new File(JN_DOCPATH + id);
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++)
            files[i].delete();
        f.delete();
    }

    public PhaseList openPhaseList(Project prj) {
        String fn = JN_DOCPATH + prj.getID() + File.separator + ".tasklist";

        if (documentExists(fn)) {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Open task list: "
                    + JN_DOCPATH
                    + prj.getID()
                    + File.separator
                    + ".tasklist");
            
            Document tasklistDoc = openDocument(fn);
            /*DocType tasklistDoctype = tasklistDoc.getDocType();
            String publicId = null;
            if (tasklistDoctype != null) {
                publicId = tasklistDoctype.getPublicID();
            }
            boolean upgradeOccurred = TaskListVersioning.upgradeTaskList(publicId);
            if (upgradeOccurred) {
                // reload from new file
                tasklistDoc = openDocument(fn);
            }*/
            return new PhaseList(tasklistDoc, prj);   
        }
        else {
            /*DEBUG*/
            System.out.println("[DEBUG] New task list created");
            return new PhaseList(prj);
        }
    }

    public void storePhaseList(PhaseList phaselist, Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save task list: "
                + JN_DOCPATH
                + prj.getID()
                + File.separator
                + ".tasklist");
        Document tasklistDoc = phaselist.getXMLContent();
        //tasklistDoc.setDocType(TaskListVersioning.getCurrentDocType());
        saveDocument(tasklistDoc,JN_DOCPATH + prj.getID() + File.separator + ".tasklist");
        DailyItemsPanel.getStatsPanel().updateCharts();
    }
    /**
     * @see net.sf.memoranda.util.Storage#createProjectStorage(net.sf.memoranda.Project)
     */
    public void createProjectStorage(Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Create project dir: " + JN_DOCPATH + prj.getID());
        File dir = new File(JN_DOCPATH + prj.getID());
        dir.mkdirs();
    }
    /**
     * @see net.sf.memoranda.util.Storage#openNoteList(net.sf.memoranda.Project)
     */
    public NoteList openNoteList(Project prj) {
        String fn = JN_DOCPATH + prj.getID() + File.separator + ".notes";
        if (documentExists(fn)) {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Open note list: "
                    + JN_DOCPATH
                    + prj.getID()
                    + File.separator
                    + ".notes");
            return new NoteListImpl(openDocument(fn), prj);
        }
        else {
            /*DEBUG*/
            System.out.println("[DEBUG] New note list created");
            return new NoteListImpl(prj);
        }
    }
    /**
     * @see net.sf.memoranda.util.Storage#storeNoteList(net.sf.memoranda.NoteList, net.sf.memoranda.Project)
     */
    public void storeNoteList(NoteList nl, Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save note list: "
                + JN_DOCPATH
                + prj.getID()
                + File.separator
                + ".notes");
        saveDocument(
            nl.getXMLContent(),
            JN_DOCPATH + prj.getID() + File.separator + ".notes");
    }
    /**
     * @see net.sf.memoranda.util.Storage#openEventsList()
     */
    public void openEventsManager() {
        if (!new File(JN_DOCPATH + ".events").exists()) {
            EventsManager._doc = null;
            return;
        }
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Open events manager: " + JN_DOCPATH + ".events");
        EventsManager._doc = openDocument(JN_DOCPATH + ".events");
    }
    /**
     * @see net.sf.memoranda.util.Storage#storeEventsList()
     */
    public void storeEventsManager() {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save events manager: " + JN_DOCPATH + ".events");
        saveDocument(EventsManager._doc, JN_DOCPATH + ".events");
    }
    /**
     * @see net.sf.memoranda.util.Storage#openMimeTypesList()
     */
    public void openMimeTypesList() {
        if (!new File(JN_DOCPATH + ".mimetypes").exists()) {
            try {
                MimeTypesList._doc =
                    openDocument(
                        FileStorage.class.getResourceAsStream(
                            "resources/default.mimetypes"));
            }
            catch (Exception e) {
                new ExceptionDialog(
                    e,
                    "Failed to read default mimetypes config from resources",
                    "");
            }
            return;
        }
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Open mimetypes list: " + JN_DOCPATH + ".mimetypes");
        MimeTypesList._doc = openDocument(JN_DOCPATH + ".mimetypes");
    }
    /**
     * @see net.sf.memoranda.util.Storage#storeMimeTypesList()
     */
    public void storeMimeTypesList() {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save mimetypes list: " + JN_DOCPATH + ".mimetypes");
        saveDocument(MimeTypesList._doc, JN_DOCPATH + ".mimetypes");
    }
    /**
     * @see net.sf.memoranda.util.Storage#openResourcesList(net.sf.memoranda.Project)
     */
    public ResourcesList openResourcesList(Project prj) {
        String fn = JN_DOCPATH + prj.getID() + File.separator + ".resources";
        if (documentExists(fn)) {
            /*DEBUG*/
            System.out.println("[DEBUG] Open resources list: " + fn);
            return new ResourcesListImpl(openDocument(fn), prj);
        }
        else {
            /*DEBUG*/
            System.out.println("[DEBUG] New note list created");
            return new ResourcesListImpl(prj);
        }
    }
    /**
     * @see net.sf.memoranda.util.Storage#storeResourcesList(net.sf.memoranda.ResourcesList, net.sf.memoranda.Project)
     */
    public void storeResourcesList(ResourcesList rl, Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save resources list: "
                + JN_DOCPATH
                + prj.getID()
                + File.separator
                + ".resources");
        saveDocument(
            rl.getXMLContent(),
            JN_DOCPATH + prj.getID() + File.separator + ".resources");
    }
    /**
     * @see net.sf.memoranda.util.Storage#restoreContext()
     */
    public void restoreContext() {
        try {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Open context: " + JN_DOCPATH + ".context");
            Context.context.load(new FileInputStream(JN_DOCPATH + ".context"));
        }
        catch (Exception ex) {
            /*DEBUG*/
            System.out.println("Context created.");
        }
    }
    /**
     * @see net.sf.memoranda.util.Storage#storeContext()
     */
    public void storeContext() {
        try {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Save context: " + JN_DOCPATH + ".context");
            Context.context.save(new FileOutputStream(JN_DOCPATH + ".context"));
        }
        catch (Exception ex) {
            new ExceptionDialog(
                ex,
                "Failed to store context to " + JN_DOCPATH + ".context",
                "");
        }
    }
    

    public DefectList openDefectList(Project prj) {
        String fn = JN_DOCPATH + prj.getID() + File.separator + ".defectlist";

        if (documentExists(fn)) {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Open defect list: "
                    + JN_DOCPATH
                    + prj.getID()
                    + File.separator
                    + ".defectlist");
            
            Document doc = openDocument(fn);
            
            return new DefectListImpl(prj, doc);   
        }
        else {
            /*DEBUG*/
            System.out.println("[DEBUG] New defect list created");
            return new DefectListImpl(prj);
        }
    }
    
    public void storeDefectList(DefectList dl, Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save defect list: "
                + JN_DOCPATH
                + prj.getID()
                + File.separator
                + ".defectlist");
        Document doc = dl.getXMLContent();
        saveDocument(doc, JN_DOCPATH + prj.getID() + File.separator + ".defectlist");
        DailyItemsPanel.getStatsPanel().updateCharts();
    }

    public TestCaseList openTestCaseList(Project prj) {
        String fn = JN_DOCPATH + prj.getID() + File.separator + ".testcaselist";

        if (documentExists(fn)) {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Open testcase list: "
                    + JN_DOCPATH
                    + prj.getID()
                    + File.separator
                    + ".testcaselist");
            
            Document doc = openDocument(fn);
            
            return new TestCaseListImpl(prj, doc);   
        }
        else {
            /*DEBUG*/
            System.out.println("[DEBUG] New testcase list created");
            return new TestCaseListImpl(prj);
        }
        
    }
    
    public void storeTestCaseList(TestCaseList dl, Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save testcase list: "
                + JN_DOCPATH
                + prj.getID()
                + File.separator
                + ".testcaselist");
        Document doc = dl.getXMLContent();
        saveDocument(doc, JN_DOCPATH + prj.getID() + File.separator + ".testcaselist");
        DailyItemsPanel.getStatsPanel().updateCharts();
    }
    
    public TimeSheetPanel loadTimeSheet(Project prj){
    	String fn = JN_DOCPATH + prj.getID() + File.separator + ".timeSheet.ser";
    	TimeSheetPanel panel = null;
    	InputStream is = null;
    	File file = new File(fn);
    	if(file.exists()){
	    	try {
	    		is = new FileInputStream(fn);
				InputStream buff = new BufferedInputStream(is);
				ObjectInput in = new ObjectInputStream(buff);
				panel = (TimeSheetPanel) in.readObject();
				System.out.println("[DEBUG] Open time sheet: " + fn);
			} catch (FileNotFoundException e) {
				System.out.print("[DEBUG] FAILED to load time sheet page.\n");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.print("[DEBUG] FAILED to load time sheet page.\n");
				System.out.print("[DEBUG] Object import failed.\n");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.print("[DEBUG] FAILED to load time sheet page.\n");
				System.out.print("[DEBUG] Object deserialize failed.\n");
				e.printStackTrace();
			} finally {
					try {
						if(is != null)
							is.close();
					} catch (IOException e) {
						System.out.print("[DEBUG] FAILED to close file.\n");
						e.printStackTrace();
					}
			}
    	}
    	else{
    		try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.print("[DEBUG] FAILED to create ser file.\n");
				e.printStackTrace();
			}
    	}
    	
    	return panel;
    }
    
    // Save time sheet as serialized object
    // Extremely inefficient, but only real way to save the time sheet panel as of now.
    public void saveTimeSheet(TimeSheetPanel tsp, Project prj){
    	String fn = JN_DOCPATH + prj.getID() + File.separator + ".timeSheet.ser";
    	ObjectOutput out;
    	try {
			OutputStream os = new FileOutputStream(fn);
			OutputStream buff = new BufferedOutputStream(os);
			out = new ObjectOutputStream(buff);
			out.writeObject(tsp);
			out.close();
			System.out.println("[DEBUG] Save time sheet: " + fn);
			
		} catch (FileNotFoundException e) {
			System.out.print("[DEBUG] FAILED to save time sheet page.\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("[DEBUG] FAILED to save time sheet page.\n");
			System.out.print("[DEBUG] Object output failed.\n");
			e.printStackTrace();
		}
    }
    public UsersList openUsersList(Project prj) {
        String fn = JN_DOCPATH + prj.getID() + File.separator + ".userslist";

        if (documentExists(fn)) {
            /*DEBUG*/
            System.out.println(
                "[DEBUG] Open users list: "
                    + JN_DOCPATH
                    + prj.getID()
                    + File.separator
                    + ".userslist");
            
            Document doc = openDocument(fn);
            
            return new UsersListImpl(prj, doc);   
        }
        else {
            /*DEBUG*/
            System.out.println("[DEBUG] New users list created");
            return new UsersListImpl(prj);
        }
        
    }
    
    public void storeUsersList(UsersList dl, Project prj) {
        /*DEBUG*/
        System.out.println(
            "[DEBUG] Save users list: "
                + JN_DOCPATH
                + prj.getID()
                + File.separator
                + ".userslist");
        Document doc = dl.getXMLContent();
        saveDocument(doc, JN_DOCPATH + prj.getID() + File.separator + ".userslist");
    }
}
