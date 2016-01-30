package net.sf.memoranda.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import net.sf.memoranda.ui.ExceptionDialog;

// Created by Doug Carroll 01/26/15
// Start the server from here - Server is Java RMI based
public class ServerStart {
	
	public static final int DEFAULT_PORT = 1099;
	
	private static boolean running = false;
	
	// Check if the server is already running
	public static boolean isRunning(){
		return running;
	}
	
	public static void main(String[] args) {
		
	    try {
	    	// Create the server
			Registry reg = LocateRegistry.createRegistry(DEFAULT_PORT);
			ServerCommCore comm = new ServerCommCore();
			reg.rebind("memoServer", comm);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
}


