package net.sf.memoranda;

import nu.xom.Attribute;
import nu.xom.Element;

public class UsersImpl implements Users{
	
	private Element element;
	
	public UsersImpl(Element e){
		element = e;
	}
	
	@Override
	public String getID() {
		return getAttr(Users.ID);
	}

	@Override
	public String getFirstName() {
		return getAttr(Users.FIRST);
	}

	@Override
	public String getLastName() {
		return getAttr(Users.LAST);
	}

	@Override
	public String getDepartment() {
		return getAttr(Users.DEPART);
	}

	@Override
	public String getTitle() {
		return getAttr(Users.TITLE);
	}

	@Override
	public String getEmailAddress() {
		return getAttr(Users.EMAIL);
	}
	
	@Override
	public String getPhoneNumber() {
		return getAttr(Users.PHONE);
	}
	
	@Override
	public void setID(String id) {
		setAttr(Users.ID, id);
	}

	@Override
	public void setFirstName(String first) {
		setAttr(Users.FIRST, first);
	}

	@Override
	public void setLastName(String last) {
		setAttr(Users.LAST, last);
	}

	@Override
	public void setDepartment(String depart) {
		setAttr(Users.DEPART, depart);
	}

	@Override
	public void setTitle(String title) {
		setAttr(Users.TITLE, title);
	}

	@Override
	public void setEmailAddress(String email) {
		setAttr(Users.EMAIL, email);
	}
	
	@Override
	public void setPhoneNumber(String phone) {
		setAttr(Users.PHONE, phone);
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
	public Element getElement() {
		return element;
	}

}