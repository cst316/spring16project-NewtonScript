package net.sf.memoranda;

import nu.xom.Element;


/**
 * Interface for defects
 * 
 * @author Douglas Carroll
 */
public interface Defect {
	
	// Reference strings for element keys
	public static final String SEC = "section";
	public static final String PROG = "progress";
	public static final String INJ = "injection";
	public static final String REM = "removal";
	public static final String DESC = "description";
	public static final String HOURS = "hours";
	public static final String ID = "id"; 
	
	/**
	 * Get the defects section
	 * 
	 * @return String Section
	 */
	public String getSection();
	
	/**
	 * Set the defects section
	 * 
	 * @param sec Section
	 */
	public void setSection(String sec);
	
	/**
	 * Get the progress for this defect
	 * 
	 * @return int Progress
	 */
	public int getProgress();
	
	/**
	 * Set defect progress
	 * 
	 * @param p Progress
	 */
	public void setProgress(int p);
	
	/**
	 * Get the description for this defect
	 * 
	 * @return String description
	 */
	public String getDesc();
	
	/**
	 * Set the description for the defect
	 * 
	 * @param desc Description
	 */
	public void setDesc(String desc);
	
	/**
	 * Get the hours for this defect
	 * 
	 * @return double Hours
	 */
	public double getHours();
	
	/**
	 * Set hours for the defect
	 * 
	 * @param hours Hours for the defect
	 */
	public void setHours(double hours);
	
	/**
	 * Get the removal of the defect
	 * 
	 * @return String Removal
	 */
	public String getRemoval();
	
	/**
	 * Set the removal for the description
	 * 
	 * @param rem Removal
	 */
	public void setRemoval(String rem);
	
	/**
	 * Get the injection of the defect
	 * 
	 * @return String Injection
	 */
	public String getInj();
	
	/**
	 * Set the injection for the defect
	 * 
	 * @param inj
	 */
	public void setInj(String inj);
	
	/**
	 * Get the ID of the defect
	 * 
	 * @return String ID
	 */
	public String getID();
	
	/**
	 * Set the ID for the defect
	 * 
	 * @param id ID
	 */
	public void setID(String id);
	
	/**
	 * Get the element for the defect
	 * 
	 * @return nu.xom.Element
	 */
	public Element getContent();
	
}
