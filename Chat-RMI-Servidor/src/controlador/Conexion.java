/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Conexion extends UnicastRemoteObject{
    
    public Conexion(int puerto) throws RemoteException{
        try {
            LocateRegistry.createRegistry(puerto);
            String url = "rmi://localhost:"+puerto+"/ChatServer";
            Naming.rebind(url,this);
            System.out.println(url);
        } catch (RemoteException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
