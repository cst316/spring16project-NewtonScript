package net.sf.memoranda;

import net.sf.memoranda.date.CalendarDate;
import nu.xom.Element;


/**
 * Interface for defects
 * 
 * @author Douglas Carroll
 */
public interface Defect {
	
	// Reference strings for element keys
	public static final String TP = "type";
	public static final String DIS = "discovery";
	public static final String INJ = "injection";
	public static final String SEV = "severity";
	public static final String DESC = "description";
	public static final String HOURS = "hours";
	public static final String ID = "id";
	public static final String OPEN = "open";
	public static final String DATE = "date";
	public static final String REMDATE = "remDate";
	public static final String NOTES = "notes";
	
	// Enums for defect values
	public static enum TYPE { 
		DOCUMENTATION,
		SYNTAX,
		BUILD,
		PACKAGE,
		ASSIGNMENT,
		INTERFACE,
		CHECKING,
		DATA,
		FUNCTION,
		SYSTEM,
		ENVIORNMENT
	}
	
	public static enum INJECTION { 
		REQUIREMENTS,
		DESIGN,
		IMPLEMENTATION,
		TEST
	}
	
	public static enum DISCOVERY { 
		REQUIREMENTS,
		DESIGN,
		IMPLEMENTATION,
		TEST
	}
	
	public static enum SEVERITY {
		LOW,
		MEDIUM,
		HIGH
	}
	
	/**
	 * Get the removal note for the defect
	 * 
	 * @return String note for defect
	 */
	public String getNote();
	
	/**
	 * Set the removel note for the defect
	 * 
	 * @param note
	 */
	public void setNote(String note);
	
	/**
	 * Get the removal date, returns null if no removal date is applied
	 * 
	 * @return CalendarDate or null if there is no removal date
	 */
	public CalendarDate getRemDate();
	
	/**
	 * Set the removal date
	 * 
	 * @param rd
	 */
	public void setRemDate(CalendarDate rd);
	
	/**
	 * Open the defect
	 * 
	 */
	public void open();
	
	/**
	 * Close the defect
	 * 
	 */
	public void close(CalendarDate date);
	
	/**
	 * Returns true if the defect is open, false if not.
	 * 
	 * @return true if the defect is open
	 */
	public boolean isOpen();
	
	/**
	 * Get the creation date for the defect
	 * 
	 * @return CalendarDate 
	 */
	public CalendarDate getDate();
	
	/**
	 * Set the creation date of the defect
	 * 
	 * @param date
	 */
	public void setDate(CalendarDate date);
	
	/**
	 * Returns the severity for this defect
	 * 
	 * @return SEVERITY type of severity
	 */
	public SEVERITY getSeverity();
	
	/**
	 * Set the severity for the defect
	 * 
	 * @param s Severity of the defect
	 */
	public void setSeverity(SEVERITY s);
	
	/**
	 * Get the defects section
	 * 
	 * @return TYPE Section
	 */
	public TYPE getType();
	
	/**
	 * Set the defects section
	 * 
	 * @param ty Section
	 */
	public void setType(TYPE ty);
	
	/**
	 * Get the progress for this defect
	 * 
	 * @return DISCOVERY Progress
	 */
	public DISCOVERY getDiscovery();
	
	/**
	 * Set defect discovery
	 * 
	 * @param d Progress
	 */
	public void setDiscovery(DISCOVERY d);
	
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
	 * @return int Hours
	 */
	public int getHours();
	
	/**
	 * Set hours for the defect
	 * 
	 * @param hours Hours for the defect
	 */
	public void setHours(int hours);
	
	/**
	 * Get the injection of the defect
	 * 
	 * @return String Injection
	 */
	public INJECTION getInj();
	
	/**
	 * Set the injection for the defect
	 * 
	 * @param inj
	 */
	public void setInj(INJECTION inj);
	
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
