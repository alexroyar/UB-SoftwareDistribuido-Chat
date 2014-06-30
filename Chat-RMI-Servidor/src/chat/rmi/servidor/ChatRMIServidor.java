/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat.rmi.servidor;

import comun.ChatCliente;
import comun.ChatServidor;
import controlador.Conexion;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ChatRMIServidor implements ChatServidor, Serializable{

    private ConcurrentHashMap<String, ChatCliente> clientes;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChatRMIServidor();
    }
    
    public ChatRMIServidor(){
        iniciar_conexion(1234);
        iniciar_variables();
    }
       
    @Override
    public ConcurrentHashMap registrar_cliente(String nombre, ChatCliente cliente) {
        System.out.print("Registrando cliente '" + nombre + "'...");

        if(!this.clientes.containsKey(nombre)){
            this.clientes.put(nombre, cliente);
            System.out.println(" ¡registrado!");
        } else {
            System.out.println(" usuario repetido.");
            return null;
        }

        return this.clientes;
    }

    private void iniciar_variables(){
        this.clientes = new ConcurrentHashMap<String, ChatCliente>();

    }
    
    private void iniciar_conexion(int puerto){
        try {
            Conexion c = new Conexion(puerto);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatRMIServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
