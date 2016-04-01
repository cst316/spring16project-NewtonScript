 package net.sf.memoranda;
import java.util.ArrayList;

import net.sf.memoranda.Defect.*;
import net.sf.memoranda.date.CalendarDate;
import nu.xom.Document;
import nu.xom.Element;


/**
 * Interface to handle the list of defects.
 * 
 * @author Douglas Carroll
 */

public interface DefectList {
	
	/**
	 * Get the current project.
	 * 
	 * @return Project Current project
	 */
	Project getProject();
	
	/**
	 * Get a defect by ID
	 * 
	 * @param id defect ID.
	 * @return Defect defect with the same ID
	 */
	Defect getDefect(String id);
	
	/**
	 * Return the element for the defect by ID.
	 * 
	 * @param id ID of element
	 * @return Element
	 */
	Element getDefectElem(String id);
	
	/**
	 * Create a defect with an element.
	 * 
	 * @param e Pre-made element
	 * @return Defect
	 */
	Defect createDefect(Element e);
	
	/**
	 * Create a new defect.
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
	Defect createDefect(String id, String desc, 
			Injection inj, Discovery dis, Severity sev, 
			Type type, CalendarDate date);
	
	/**
	 * Close a defect by ID.
	 * 
	 * @param id
	 * @param remDate The removal date for the defect
	 * @param notes Removal notes
	 * @return Defect The defect that was closed
	 */
	Defect closeDefect(String id, CalendarDate remDate, String notes,  int hours, Removal rem);
	
	/**
	 * Remove defect by ID.
	 * 
	 * @param id
	 */
	void removeDefect(String id);
	
	/**
	 * Get an ArrayList of all the defects.
	 * 
	 * @return ArrayList List of defects
	 */
	ArrayList<Defect> getAllDefects();
	
	/**
	 * Get the number of defects.
	 * 
	 * @return total number of defects
	 */
	public int getDefectNum();
	
	/**
	 * Get the number of open defects
	 * 
	 * @return
	 */
	public int getOpenDefectNum();
	
	/**
	 * Get the XML content for this list
	 * Get the next available ID for defects.
	 * This will return the highest ID number + 1.
	 * 
	 * @return
	 */
	int getNextid();
	
	/**
	 * Get the XML content for this list.
	 * 
	 * @return Document XML document
	 */
	Document getXMLContent();
	
}

