package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Hashtable;

import net.sf.memoranda.TestCase.STATUS;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.Util;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

public class TestCaseListImpl implements TestCaseList {
	private Project project;
	private Element rootElem;
	private Document doc;
	private Hashtable<String, Element> elements = new Hashtable<String, Element>();
	
	// Constructor for a new list
	public TestCaseListImpl(Project prj){
		project = prj;
		rootElem = new Element("TestCaseList");
		doc = new Document(rootElem);
	}
	
	// Constructor to load the elements from the file
	public TestCaseListImpl(Project prj, Document d){
		project = prj;
		doc = d;
		rootElem = doc.getRootElement();
		buildElements();
	}
	
	// Load the elements from the file
	private void buildElements(){
		Elements els = rootElem.getChildElements("testcase");
		for (int i = 0; i < els.size(); i++) {
			Element el = els.get(i);
			String id = el.getAttribute(TestCase.ID).getValue();
			Util.debug("Adding test case:" + id);
			elements.put(id, el);
		}
	}
	
	@Override
	public Project getProject() {
		return project;
	}
	
	@Override
	public TestCase getTestCase(String id) {
		return new TestCaseImpl(elements.get(id));
	}
	
	@Override
	public Element getTestCaseElem(String id) {
		return elements.get(id);
	}
	
	@Override
	public TestCase createTestCase(Element e) {
		return new TestCaseImpl(e);
	}
	
	@Override
	public TestCase createTestCase(String id, String method, 
			String des, String testCase, String ex, 
			String ac) {
		
		Element elem = new Element("testcase");
		elem.addAttribute(new Attribute(TestCase.ID, id));
		elem.addAttribute(new Attribute(TestCase.METHOD, method));
		elem.addAttribute(new Attribute(TestCase.DES, des));
		elem.addAttribute(new Attribute(TestCase.TC, testCase));
		elem.addAttribute(new Attribute(TestCase.ER, ex));
		elem.addAttribute(new Attribute(TestCase.AR, ac));
		elem.addAttribute(new Attribute(TestCase.PASS, 
				STATUS.INPROGRESS.name()));
		
		elements.put(id, elem);
		
		return new TestCaseImpl(elem);
	}
	
	@Override
	public void removeTestCase(String id){
		elements.remove(id);
	}

	@Override
	public ArrayList<TestCase> getAllTestCases() {
		// Get the entire hash table as an arraylist of the elements
		ArrayList<Element> elems = new ArrayList<Element>(elements.values());
		ArrayList<TestCase> list = new ArrayList<TestCase>();
		
		for(Element e : elems){
			list.add(new TestCaseImpl(e));
		}
		
		return list;
	}

	@Override
	public Document getXMLContent() {
		return doc;
	}
}
