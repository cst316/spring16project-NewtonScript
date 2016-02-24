package net.sf.memoranda;

import nu.xom.Attribute;
import nu.xom.Element;

public class DefectImpl implements Defect {
	
	private Element element;
	
	public DefectImpl(Element elem){
		element = elem;
	}
	
	@Override
	public String getSection() {
		return getAttr(SEC);
	}

	@Override
	public void setSection(String sec) {
		setAttr(SEC, sec);
	}
	
	@Override
	public int getProgress() {
		return Integer.parseInt(getAttr(PROG));
	}

	@Override
	public void setProgress(int p) {
		setAttr(PROG, Integer.toString(p));
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
	public double getHours() {
		return Double.parseDouble(getAttr(HOURS));
	}

	@Override
	public void setHours(double hours) {
		setAttr(HOURS, Double.toString(hours));
	}

	@Override
	public String getRemoval() {
		return getAttr(REM);
	}

	@Override
	public void setRemoval(String rem) {
		setAttr(REM, rem);
	}

	@Override
	public String getInj() {
		return getAttr(INJ);
	}

	@Override
	public void setInj(String inj) {
		setAttr(INJ, inj);
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

}
