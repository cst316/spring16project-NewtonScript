package net.sf.memoranda;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import net.sf.memoranda.server.ServerInterface;

// Created by Doug Carroll 01/26/15
// This class handles client/server communications
public class ClientComm {
	
	  private Registry clientReg;
	  private static ServerInterface server;
	
	public ClientComm(String ip, int port){
		
		try {
			System.out.println("Connecting to server . . .");
			clientReg = LocateRegistry.getRegistry(ip, port);
			server = (ServerInterface)clientReg.lookup("memoServer");
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ServerInterface getServer(){
		return server;
	}
}
