package net.sf.memoranda.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.JSONObject;
import org.json.JSONTokener;

// Created by Doug Carroll 01/26/15
// Handles communication between the client and the server
// Server method implementation found here.
public class ServerCommCore extends UnicastRemoteObject implements ServerInterface{
	
	protected ServerCommCore() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	// JSON files
	public static final String MOTD_FILE = "lib/ServerFiles/MOTD.json";
	
	// Object names for the JSON file
	public static final String MOTD_OBJ_NAME = "MOTD";
	public static final String MOTD_AUTHOR_NAME = "author";
	
	// Returns the 'message of the day' stored in the local JSON file
	public String getMOTD(){
		String MOTD = "";
		
		try {
			FileInputStream inFile = new FileInputStream(MOTD_FILE);
			// Convert file to Json object
			JSONObject obj = new JSONObject(new JSONTokener(inFile));
			// Get the MOTD from the json object
			MOTD = obj.getString(MOTD_OBJ_NAME);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return MOTD;
		
	}
	
	// Sets the MOTD and author
	public void setMOTD(String message, String author){
		try {
			
			PrintWriter outFile = new PrintWriter(MOTD_FILE);
			JSONObject obj = new JSONObject();
			obj.put(MOTD_OBJ_NAME, message);
			obj.put(MOTD_AUTHOR_NAME, author);
			outFile.print(obj.toString(1));
			outFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
