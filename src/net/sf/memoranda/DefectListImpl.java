package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Hashtable;

import net.sf.memoranda.util.Util;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

public class DefectListImpl implements DefectList{
	
	private Project project;
	private Element rootElem;
	private Document doc;
	private Hashtable<String, Element> elements = new Hashtable<String, Element>();
	
	// Constructor for a new list
	public DefectListImpl(Project prj){
		project = prj;
		rootElem = new Element("DefectList");
		doc = new Document(rootElem);
	}
	
	// Constructor to load the elements from the file
	public DefectListImpl(Project prj, Document d){
		project = prj;
		doc = d;
		rootElem = doc.getRootElement();
		buildElements();
	}
	
	// Load the elements from the file
	private void buildElements(){
		Elements els = rootElem.getChildElements("defect");
		for (int i = 0; i < els.size(); i++) {
			Element el = els.get(i);
			String id = el.getAttribute(Defect.ID).getValue();
			Util.debug("Adding defect:" + id);
			elements.put(id, el);
		}
	}
	
	@Override
	public Project getProject() {
		return project;
	}

	@Override
	public void createDefect(String id, String inj, String rem, double hours,
			String desc, int prog, String sec) {
		
		Element elem = new Element("defect");
		elem.addAttribute(new Attribute(Defect.ID, id));
		elem.addAttribute(new Attribute(Defect.INJ, inj));
		elem.addAttribute(new Attribute(Defect.REM, rem));
		elem.addAttribute(new Attribute(Defect.HOURS, Double.toString(hours)));
		elem.addAttribute(new Attribute(Defect.DESC, desc));
		elem.addAttribute(new Attribute(Defect.PROG, Integer.toString(prog)));
		elem.addAttribute(new Attribute(Defect.SEC, sec));
		
		elements.put(id, elem);
	}

	@Override
	public Defect getDefect(String id) {
		return new DefectImpl(elements.get(id));
	}
	
	@Override
	public Element getDefectElem(String id) {
		return elements.get(id);
	}

	@Override
	public ArrayList<Defect> getAllDefects() {
		// Get the entire hash table as an arraylist of the elements
		ArrayList<Element> elems = new ArrayList<Element>(elements.values());
		ArrayList<Defect> list = new ArrayList<Defect>();
		
		for(Element e : elems){
			list.add(new DefectImpl(e));
		}
		
		return list;
	}

	@Override
	public Document getXMLContent() {
		return doc;
	}

}
