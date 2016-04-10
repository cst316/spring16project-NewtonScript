package net.sf.memoranda;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Hashtable;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.Util;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;

public class UsersListImpl implements UsersList {
	private Project project;
	private Element rootElem;
	private Document doc;
	private Hashtable<String, Element> elements = new Hashtable<String, Element>();
	
	// Constructor for a new list
	public UsersListImpl(Project prj){
		project = prj;
		rootElem = new Element("UserList");
		doc = new Document(rootElem);
	}
	
	// Constructor to load the elements from the file
	public UsersListImpl(Project prj, Document d){
		project = prj;
		doc = d;
		rootElem = doc.getRootElement();
		buildElements();
	}
	
	// Load the elements from the file
	private void buildElements(){
		Elements els = rootElem.getChildElements("users");
		for (int i = 0; i < els.size(); i++) {
			Element el = els.get(i);
			String id = el.getAttribute(Users.ID).getValue();
			Util.debug("Adding user:" + id);
			elements.put(id, el);
		}
	}
	
	@Override
	public Project getProject() {
		return project;
	}
	
	@Override
	public Users getUser(String id) {
		return new UsersImpl(elements.get(id));
	}
	
	@Override
	public Element getUserElem(String id) {
		return elements.get(id);
	}
	
	@Override
	public Users createUser(Element e) {
		Users user = new UsersImpl(e);
		
		rootElem.appendChild(e);
		elements.put(user.getID(), e);
		
		return user;
	}
	
	@Override
	public Users createUser(String id, String first, 
			String last, String depart, String title, 
			String email, String phone) {
		
		Element elem = new Element("users");
		elem.addAttribute(new Attribute(Users.ID, id));
		elem.addAttribute(new Attribute(Users.FIRST, first));
		elem.addAttribute(new Attribute(Users.LAST, last));
		elem.addAttribute(new Attribute(Users.DEPART, depart));
		elem.addAttribute(new Attribute(Users.TITLE, title));
		elem.addAttribute(new Attribute(Users.EMAIL, email));
		elem.addAttribute(new Attribute(Users.PHONE, phone));
		
		rootElem.appendChild(elem);
		elements.put(id, elem);
		
		return new UsersImpl(elem);
	}
	
	@Override
	public void removeUser(String id){
		
		Node node = getUser(id).getElement();
		
		elements.remove(id);
		rootElem.removeChild(node);
	}

	@Override
	public ArrayList<Users> getAllUsers() {
		// Get the entire hash table as an arraylist of the elements
		ArrayList<Element> elems = new ArrayList<Element>(elements.values());
		ArrayList<Users> list = new ArrayList<Users>();
		
		for(Element e : elems){
			list.add(new UsersImpl(e));
		}
		
		return list;
	}
	@Override
	public Vector<String> getUserNames() {
		ArrayList<Users> myUsers = getAllUsers();
		Vector<String> userNames = new Vector<String>();
		
		for(Users user : myUsers) {
			userNames.add(user.getFirstName() + " " + user.getLastName());
		}
		return userNames;
	}
	
	public boolean hasUser(String id){
		System.out.println(elements.containsKey(id));
		return elements.containsKey(id);
	}

	@Override
	public Document getXMLContent() {
		return doc;
	}
}