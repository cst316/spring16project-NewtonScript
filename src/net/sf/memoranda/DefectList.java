package net.sf.memoranda;
import java.util.ArrayList;

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
	 * Create a new defect
	 * 
	 * @param id ID
	 * @param inj Injection 
	 * @param rem Removal
	 * @param hours Hours
	 * @param desc Description
	 * @param prog Progress
	 */
	public void createDefect(String id, String inj, String rem, double hours, 
			String desc, int prog, String section);
	
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
