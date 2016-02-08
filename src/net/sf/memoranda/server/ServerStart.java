package net.sf.memoranda.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Created by Doug Carroll 01/26/15
// Start the server from here - Server is Java RMI based
public class ServerStart {
	
	public static final int DEFAULT_PORT = 1099;
	public static final String DEFAULT_IP = "localhost";
	
	private static boolean running = false;
	
	// Check if the server is already running
	public static boolean isRunning(){
		return running;
	}
	
	public static void main(String[] args) {
		
	    try {
	    	// Create the server
	    	System.out.println("\nStarting server on " + DEFAULT_IP + ":" + DEFAULT_PORT);
	    	System.setProperty("java.rmi.server.hostname", DEFAULT_IP);
			Registry reg = LocateRegistry.createRegistry(DEFAULT_PORT);
			ServerCommCore comm = new ServerCommCore();
			reg.rebind("memoServer", comm);
			System.out.println("Server running");
			running = true;
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
}


