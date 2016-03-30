package net.sf.memoranda;

import net.sf.memoranda.date.CalendarDate;
import nu.xom.Element;


/**
 * Interface for defects.
 * 
 * @author Douglas Carroll
 */
public interface Defect {
	
	// Reference strings for element keys
	String TP = "type";
	String DIS = "discovery";
	String INJ = "injection";
	String SEV = "severity";
	String REM = "removal";
	String DESC = "description";
	String HOURS = "hours";
	String ID = "id";
	String OPEN = "open";
	String DATE = "date";
	String REMDATE = "remDate";
	String NOTES = "notes";
	
	// Enums for defect values
	enum Type { 
		DOCUMENTATION("Documentation"),
		SYNTAX("Syntax"),
		BUILD("Build"),
		PACKAGE("Package"),
		ASSIGNMENT("Assignment"),
		INTERFACE("Interface"),
		CHECKING("Checking"),
		DATA("Data"),
		FUNCTION("Function"),
		SYSTEM("System"),
		ENVIRONMENT("Environment");
		
		private String name;
		
		Type(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	enum Injection { 
		REQUIREMENTS("Requirements"),
		DESIGN("Design"),
		IMPLEMENTATION("Implementation"),
		TEST("Test");
		
		private String name;
		
		Injection(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	enum Discovery { 
		REQUIREMENTS("Requirements"),
		DESIGN("Design"),
		IMPLEMENTATION("Implementation"),
		TEST("Test");
		
		private String name;
		
		Discovery(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	enum Severity {
		LOW("Low"),
		MEDIUM("Medium"),
		HIGH("High");
		
		private String name;
		
		Severity(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	enum Removal { 
		OPEN("Open"),
		REQUIREMENTS("Requirements"),
		DESIGN("Design"),
		IMPLEMENTATION("Implementation"),
		TEST("Test");
		
		private String name;
		
		Removal(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return this.name;
		}
	}
	
	/**
	 * Get the removal note for the defect.
	 * 
	 * @return String note for defect
	 */
	String getNote();
	
	/**
	 * Set the removel note for the defect.
	 * 
	 * @param note
	 */
	void setNote(String note);
	
	/**
	 * Get the removal date, returns null if no removal date is applied.
	 * 
	 * @return CalendarDate or null if there is no removal date
	 */
	CalendarDate getRemDate();
	
	/**
	 * Set the removal date.
	 * 
	 * @param rd
	 */
	void setRemDate(CalendarDate rd);
	
	/**
	 * Open the defect.
	 * 
	 */
	void open();
	
	/**
	 * Close the defect.
	 * 
	 */
	void close(CalendarDate date);
	
	/**
	 * Returns true if the defect is open, false if not.
	 * 
	 * @return true if the defect is open
	 */
	boolean isOpen();
	
	/**
	 * Get the creation date for the defect.
	 * 
	 * @return CalendarDate 
	 */
	CalendarDate getDate();
	
	/**
	 * Set the creation date of the defect.
	 * 
	 * @param date
	 */
	void setDate(CalendarDate date);
	
	/**
	 * Returns the severity for this defect.
	 * 
	 * @return SEVERITY type of severity
	 */
	Severity getSeverity();
	
	/**
	 * Set the severity for the defect.
	 * 
	 * @param s Severity of the defect
	 */
	void setSeverity(Severity s);
	
	/**
	 * Get the defects section.
	 * 
	 * @return TYPE Section
	 */
	Type getType();
	
	/**
	 * Set the defects section.
	 * 
	 * @param ty Section
	 */
	void setType(Type ty);
	
	/**
	 * Get the progress for this defect.
	 * 
	 * @return DISCOVERY Progress
	 */
	Discovery getDiscovery();
	
	/**
	 * Set defect discovery.
	 * 
	 * @param d Progress
	 */
	void setDiscovery(Discovery d);
	
	/**
	 * Get the description for this defect.
	 * 
	 * @return String description
	 */
	String getDesc();
	
	/**
	 * Set the description for the defect.
	 * 
	 * @param desc Description
	 */
	void setDesc(String desc);
	
	/**
	 * Get the hours for this defect.
	 * 
	 * @return int Hours
	 */
	int getHours();
	
	/**
	 * Set hours for the defect.
	 * 
	 * @param hours Hours for the defect
	 */
	void setHours(int hours);
	
	/**
	 * Get the injection of the defect.
	 * 
	 * @return String Injection
	 */
	Injection getInj();
	
	/**
	 * Set the injection for the defect.
	 * 
	 * @param inj
	 */
	void setInj(Injection inj);
	
	/**
	 * Get the ID of the defect.
	 * 
	 * @return String ID
	 */
	String getId();
	
	/**
	 * Set the ID for the defect.
	 * 
	 * @param id ID
	 */
	void setId(String id);
	
	/**
	 * Get the removal stage of this defect.
	 * 
	 * @return
	 */
	Removal getRemoval();
	
	/**
	 * Set the removal stage for this defect.
	 * 
	 * @param r
	 */
	void setRemoval(Removal r);
	/**
	 * Get the element for the defect.
	 * 
	 * @return nu.xom.Element
	 */
	Element getContent();
	
}
