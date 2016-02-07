package net.sf.memoranda;

import nu.xom.Attribute;
import nu.xom.Element;

// Currently a phase only has a title
// Phase object is needed to allow phases with the same title
// Doug Carroll


public class Phase{
	
	private String title = "";
	
	public Phase(String title){this.title = title;}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){return title;}
	
	public Element toElement(){
		Element e = new Element("Phase");
		e.addAttribute(new Attribute("title", title));
		return e;
	}
}
