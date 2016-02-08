package net.sf.memoranda.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Created by Doug Carroll on 01/26/2016
// Interface for the server, need a method? Find it here!
public interface ServerInterface extends Remote{
	
	// Gets the Message of the day
	public String getMOTD() throws RemoteException;
	
	// Sets the message of the day
	public void setMOTD(String message) throws RemoteException;
	
}
