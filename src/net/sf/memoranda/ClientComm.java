package net.sf.memoranda;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import net.sf.memoranda.server.ServerInterface;
import net.sf.memoranda.server.ServerStart;

// Created by Doug Carroll 01/26/15
// This class handles client/server communications
public class ClientComm {
	
	private static ClientComm instance;
	private Registry clientReg;
	private ServerInterface server;
	
	private ClientComm(String ip, int port){
		
		try {
			System.out.println("Connecting to server . . .");
			clientReg = LocateRegistry.getRegistry(ip, port);
			server = (ServerInterface)clientReg.lookup(ServerStart.SERVERNAME);
			if(server == null)
				throw new NullPointerException();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		} catch(NullPointerException e){
			System.out.println("Server not found!");
			e.printStackTrace();
		}
	}
	
	public static ClientComm getInstance(){
		if(instance == null){
			instance = new ClientComm(Start.DEFAULT_IP, Start.DEFAULT_PORT);
		}
		
		return instance;
	}
	
	public static ClientComm setServer(String ip, int port){
		instance = new ClientComm(ip, port);
		return instance;
	}
	
	public ServerInterface getServer(){
		return server;
	}
}
