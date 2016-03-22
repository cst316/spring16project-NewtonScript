 package net.sf.memoranda;
import java.util.ArrayList;

import net.sf.memoranda.Defect.*;
import net.sf.memoranda.date.CalendarDate;
import nu.xom.Document;
import nu.xom.Element;


/**
 * Interface to handle the list of defects
 * 
 * @author Douglas Carroll
 */

public interface DefectList {
	
	/**
	 * Get the current project
	 * 
	 * @return Project Current project
	 */
	public Project getProject();
	
	/**
	 * Get a defect by ID
	 * 
	 * @param id defect ID
	 * @return Defect defect with the same ID
	 */
	public Defect getDefect(String id);
	
	/**
	 * Return the element for the defect by ID
	 * 
	 * @param id ID of element
	 * @return Element
	 */
	public Element getDefectElem(String id);
	
	/**
	 * Create a defect with an element
	 * 
	 * @param e Pre-made element
	 * @return Defect
	 */
	public Defect createDefect(Element e);
	
	/**
	 * Create a new defect
	 * 
	 * @param id
	 * @param rem
	 * @param hours
	 * @param desc
	 * @param inj
	 * @param dis
	 * @param sev
	 * @param type
	 * @return Defect
	 */
	public Defect createDefect(String id, String desc, 
			INJECTION inj, DISCOVERY dis, SEVERITY sev, 
			TYPE type, CalendarDate date);
	
	/**
	 * Close a defect by ID
	 * 
	 * @param id
	 * @param remDate The removal date for the defect
	 * @param notes Removal notes
	 * @return Defect The defect that was closed
	 */
	public Defect closeDefect(String id, CalendarDate remDate, String notes);
	
	/**
	 * Remove defect by ID
	 * 
	 * @param id
	 */
	public void removeDefect(String id);
	
	/**
	 * Get an ArrayList of all the defects
	 * 
	 * @return ArrayList List of defects
	 */
	public ArrayList<Defect> getAllDefects();
	
	/**
	 * Get the XML content for this list
	 * 
	 * @return Document XML document
	 */
	public Document getXMLContent();
	
	
}

