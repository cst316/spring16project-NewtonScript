package net.sf.memoranda;

import nu.xom.Attribute;
import nu.xom.Element;

public class TestCaseImpl implements TestCase{
	
	private Element element;
	
	public TestCaseImpl(Element e){
		element = e;
	}
	
	@Override
	public String getID() {
		return getAttr(TestCase.ID);
	}

	@Override
	public String getMethod() {
		return getAttr(TestCase.METHOD);
	}

	@Override
	public String getDescription() {
		return getAttr(TestCase.DES);
	}

	@Override
	public String getTestCase() {
		return getAttr(TestCase.TC);
	}

	@Override
	public String getExpectedRes() {
		return getAttr(TestCase.ER);
	}

	@Override
	public String getActualRes() {
		return getAttr(TestCase.AR);
	}
	
	@Override
	public void setID(String id) {
		setAttr(TestCase.ID, id);
	}

	@Override
	public void setMethod(String m) {
		setAttr(TestCase.METHOD, m);
	}

	@Override
	public void setDescription(String des) {
		setAttr(TestCase.DES, des);
	}

	@Override
	public void setTestCase(String tc) {
		setAttr(TestCase.TC, tc);
	}

	@Override
	public void setExpectedRes(String e) {
		setAttr(TestCase.ER, e);
	}

	@Override
	public void setActualRes(String ar) {
		setAttr(TestCase.AR, ar);
	}

	@Override
	public STATUS getStatus() {
		String str = getAttr(TestCase.PASS);
		STATUS res = STATUS.valueOf(STATUS.class, str);
		return res;
	}

	@Override
	public void setStatus(STATUS s) {
		setAttr(TestCase.PASS, (s).name());
	}

	@Override
	public void fail() {
		setAttr(TestCase.PASS, (STATUS.FAILED).name());		
	}

	@Override
	public void pass() {
		setAttr(TestCase.PASS, (STATUS.PASSED).name());
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
