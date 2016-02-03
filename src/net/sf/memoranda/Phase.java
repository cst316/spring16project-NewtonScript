package net.sf.memoranda;

import java.io.Serializable;

// Currently a phase only has a title
// Phase object is needed to allow phases with the same title
// Doug Carroll
public class Phase implements Serializable{
	
	private String title = "";
	
	public Phase(String title){this.title = title;}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){return title;}
}
