package net.sf.memoranda;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
