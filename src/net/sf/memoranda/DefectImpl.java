package net.sf.memoranda;

import net.sf.memoranda.date.CalendarDate;
import nu.xom.Attribute;
import nu.xom.Element;

public class DefectImpl implements Defect {
	
	private Element element;
	
	public DefectImpl(Element elem){
		element = elem;
	}
	
	@Override
	public String getNote() {
		return getAttr(NOTES);
	}

	@Override
	public void setNote(String note) {
		setAttr(NOTES, note);
	}
	
	@Override
	public CalendarDate getRemDate() {
		String str = getAttr(REMDATE);
		CalendarDate date = null;
		
		// If date is not empty
		if(!(str.equals(""))){
			date = new CalendarDate(str);
		}
		
		return date;
	}

	@Override
	public void setRemDate(CalendarDate rd) {
		if(!(rd == null)){
			setAttr(REMDATE, rd.toString());
		}
		else {
			setAttr(REMDATE, "");
		}
	}
	
	@Override
	public void open() {
		setRemDate(null); // Nullify the removal date
		setAttr(OPEN, "true");
	}

	@Override
	public void close(CalendarDate date) {
		setRemDate(date); // Get the current date
		setAttr(OPEN, "false");
	}

	@Override
	public boolean isOpen() {
		String str = getAttr(OPEN);
		boolean res = false;
		
		if(str.equals("true"))
			res = true;
		
		return res;
	}

	@Override
	public CalendarDate getDate() {
		return new CalendarDate(getAttr(DATE));
	}

	@Override
	public void setDate(CalendarDate date) {
		setAttr(DATE, date.toString());
	}
	
	// Translates to the enum value
	@Override
	public SEVERITY getSeverity() {
		String name = getAttr(SEV);
		SEVERITY s = SEVERITY.valueOf(SEVERITY.class, name);
		return s;
	}


	@Override
	public void setSeverity(SEVERITY s) {
		setAttr(SEV, s.toString());
	}


	@Override
	public TYPE getType() {
		String name = getAttr(TP);
		TYPE t = TYPE.valueOf(TYPE.class, name);
		return t;
	}


	@Override
	public void setType(TYPE tp) {
		setAttr(TP, tp.name());
	}


	@Override
	public DISCOVERY getDiscovery() {
		String name = getAttr(DIS);
		DISCOVERY d = DISCOVERY.valueOf(DISCOVERY.class, name);
		return d;
	}


	@Override
	public void setDiscovery(DISCOVERY d) {
		setAttr(DIS, d.name());
	}

	@Override
	public String getDesc() {
		return getAttr(DESC);
	}

	@Override
	public void setDesc(String desc) {
		setAttr(DESC, desc);
	}

	@Override
	public int getHours() {
		return Integer.parseInt(getAttr(HOURS));
	}

	@Override
	public void setHours(int hours) {
		setAttr(HOURS, Integer.toString(hours));
	}

	@Override
	public INJECTION getInj() {
		String name = getAttr(INJ);
		INJECTION i = INJECTION.valueOf(INJECTION.class, name);
		return i;
	}

	@Override
	public void setInj(INJECTION inj) {
		setAttr(INJ, inj.name());
	}

	@Override
	public String getID() {
		return getAttr(ID);
	}

	@Override
	public void setID(String id) {
		setAttr(ID, id);
	}

	@Override
	public Element getContent() {
		return element;
	}
	
	// Reused code from TaskImpl
    private void setAttr(String a, String value) {
        Attribute attr = element.getAttribute(a);
        if (attr == null)
           element.addAttribute(new Attribute(a, value));
        else
            attr.setValue(value);
    }
    
    // Get attribute for convenience
    private String getAttr(String key){
    	return element.getAttribute(key).getValue();
    }

	@Override
	public REMOVAL getRemoval() {
		String rem = getAttr(REM);
		REMOVAL result = REMOVAL.valueOf(REMOVAL.class, rem);
		return result;
	}

	@Override
	public void setRemoval(REMOVAL r) {
		setAttr(REM, r.name());
	}
}
