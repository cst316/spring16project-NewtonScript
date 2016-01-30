/**
 * Start.java
 * Created on 19.08.2003, 20:40:08 Alex
 * Package: net.sf.memoranda
 *
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import net.sf.memoranda.server.ServerInterface;
import net.sf.memoranda.server.ServerStart;
import net.sf.memoranda.ui.*;

/**
 *
 */
/*$Id: Start.java,v 1.7 2004/11/22 10:02:37 alexeya Exp $*/
public class Start {
    
    static App app = null;
    static boolean checkIfAlreadyStartet = true;
    public static final String DEFAULT_IP = "localhost";
	public static final int DEFAULT_PORT = 1099;
    
    public static void main(String[] args) {
        
        try {
        	
        	// DEBUG ONLY -- START SERVER HERE
        	System.out.println("Starting server");
    		class Server extends Thread {
    		    public void run(){
    		      ServerStart.main(args);
    		    }
    		  }
    		Server serv = new Server();
    		serv.start();
    		// END DEBUG
        	
    		// Connect to the server
        	ClientComm comm = new ClientComm(DEFAULT_IP, DEFAULT_PORT);	
            
            if ((args.length == 0) || (!args[0].equals("-m"))) {
                app = new App(true);
            }
            else{
                app = new App(false);
            }
            
            // Shutdown hook to gracefully exit no matter how the program closes.
            AppFrame.addExitListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				
    			}
            });
          
            
        } catch (Exception e) {
            System.out.println("Socket not opened, cannot connect to server! Is server up?");
            e.printStackTrace();
        }
	}
}


