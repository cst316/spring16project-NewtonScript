package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Hashtable;

import net.sf.memoranda.Defect.DISCOVERY;
import net.sf.memoranda.Defect.INJECTION;
import net.sf.memoranda.Defect.SEVERITY;
import net.sf.memoranda.Defect.TYPE;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.Util;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;

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
	public Defect getDefect(String id) {
		return new DefectImpl(elements.get(id));
	}
	
	@Override
	public Element getDefectElem(String id) {
		return elements.get(id);
	}
	
	@Override
	public Defect createDefect(Element e) {
		Defect d = new DefectImpl(e);
		
		rootElem.appendChild(e);
		elements.put(d.getID(), e);
		
		return new DefectImpl(e);
	}
	
	@Override
	public Defect createDefect(String id, String desc, 
			INJECTION inj, DISCOVERY dis, SEVERITY sev, TYPE type, 
			CalendarDate date) {
		
		Element elem = new Element("defect");
		elem.addAttribute(new Attribute(Defect.ID, id));
		elem.addAttribute(new Attribute(Defect.HOURS, ""));
		elem.addAttribute(new Attribute(Defect.DESC, desc));
		elem.addAttribute(new Attribute(Defect.INJ, inj.name()));
		elem.addAttribute(new Attribute(Defect.DIS, dis.name()));
		elem.addAttribute(new Attribute(Defect.SEV, sev.name()));
		elem.addAttribute(new Attribute(Defect.TP, type.name()));
		elem.addAttribute(new Attribute(Defect.DATE, date.toString()));
		elem.addAttribute(new Attribute(Defect.REMDATE, ""));
		elem.addAttribute(new Attribute(Defect.OPEN, "true"));
		
		rootElem.appendChild(elem);
		elements.put(id, elem);
		
		return new DefectImpl(elem);
	}
	
	@Override
	public Defect closeDefect(String id, CalendarDate remDate, String notes) {
		Defect defect = getDefect(id);
		defect.setRemDate(remDate);
		defect.close(remDate);
		defect.setNote(notes);
		
		return defect;
	}
	
	@Override
	public void removeDefect(String id){
		Node node = getDefect(id).getContent();
		elements.remove(id);
		rootElem.removeChild(node);
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
	
	public int getDefectNum(){
		return elements.size();
	}
	
	public int getOpenDefectNum(){
		ArrayList<Defect> dl = getAllDefects();
		int res = 0;
		
		for(Defect d : dl){
			if(d.isOpen()){
				res++;
			}
		}
		
		return res;
	}
	

	@Override
	public Document getXMLContent() {
		return doc;
	}

}
