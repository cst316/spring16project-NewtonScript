package net.sf.memoranda.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Created by Doug Carroll 01/26/15
// Start the server from here - Server is Java RMI based
public class ServerStart {
	
	public static final int DEFAULT_PORT = 1099;
	public static final String DEFAULT_IP = "localhost";
	public static final String SERVERNAME = "memoServer";
	private static ServerStart instance;
	private static boolean running = false;
	private ServerCommCore comm;
	
	private ServerStart(){}
	
	public static ServerStart getInstance(){
		if(instance == null){
			instance = new ServerStart();
		}
		
		return instance;
	}
	
	// Check if the server is already running
	public boolean isRunning(){
		return running;
	}
	
	public void start() {
		
	    try {
	    	// Create the server
	    	System.out.println("\nStarting server on " + DEFAULT_IP + ":" + DEFAULT_PORT);
	    	System.setProperty("java.rmi.server.hostname", DEFAULT_IP);
			Registry reg = LocateRegistry.createRegistry(DEFAULT_PORT);
			comm = new ServerCommCore();
			reg.rebind(SERVERNAME, comm);
			System.out.println("Server running");
			running = true;
			
		} catch (RemoteException e) {
			System.out.println("[ERROR] Failed to create server core!");
			e.printStackTrace();
		}
    }
}


