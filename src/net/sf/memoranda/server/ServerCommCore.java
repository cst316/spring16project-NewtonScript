package net.sf.memoranda.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import org.json.JSONObject;
import org.json.JSONTokener;

// Created by Doug Carroll 01/26/15
// Handles communication between the client and the server
// Server method implementation found here.
public class ServerCommCore extends UnicastRemoteObject implements ServerInterface{
	
	// RMI
	private static final long serialVersionUID = 1L;
	// JSON files
	public static final String MOTD_FILE = "lib/ServerFiles/MOTD.json";
	// Object names for the JSON file
	public static final String MOTD_OBJ_NAME = "MOTD";
	public static final String MOTD_AUTHOR_NAME = "author";
	
	
	public ServerCommCore() throws RemoteException {
		super(Registry.REGISTRY_PORT);
		// TODO Auto-generated constructor stub
	}
	
	// Returns the 'message of the day' stored in the local JSON file
	public String getMOTD(){
		String MOTD = "";
		
		try {
			System.out.println("MOTD requested by " + super.getClientHost());
			FileInputStream inFile = new FileInputStream(MOTD_FILE);
			// Convert file to Json object
			JSONObject obj = new JSONObject(new JSONTokener(inFile));
			// Get the MOTD from the json object
			MOTD = obj.getString(MOTD_OBJ_NAME);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
		
		return MOTD;
		
	}
	
	// Sets the MOTD and author
	public void setMOTD(String message){
		try {
			System.out.println("MOTD change requested by " + super.getClientHost());
			PrintWriter outFile = new PrintWriter(MOTD_FILE);
			JSONObject obj = new JSONObject();
			obj.put(MOTD_OBJ_NAME, message);
			outFile.print(obj.toString(1));
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
	}
	
	public void exit(){
		try {
			Naming.unbind(ServerStart.SERVERNAME);
			UnicastRemoteObject.unexportObject(this, true);
			System.exit(0);
		} catch (Exception e){
			System.out.println("[ERROR] Server failed to exit!");
			e.printStackTrace();
		}
	}
}
