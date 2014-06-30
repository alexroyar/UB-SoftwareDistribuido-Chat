/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat.rmi.cliente;

import comun.ChatCliente;
import controlador.Conexion;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ChatRMICliente extends UnicastRemoteObject implements ChatCliente, Serializable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChatRMICliente();
    }
    
    public ChatRMICliente() {
        try{
            iniciar_conexion("127.0.0.1","1234","Alex",this);
        }catch (RemoteException){
            
        }
        
    }
    
    private void iniciar_conexion(String ip, String puerto, String nombre,ChatCliente cliente){
        Conexion c = new Conexion(ip,puerto,nombre,cliente);
    }
}
