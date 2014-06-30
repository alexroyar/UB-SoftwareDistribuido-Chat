/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import comun.ChatCliente;
import comun.ChatServidor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Conexion extends UnicastRemoteObject {
    
    private ChatServidor servidor;
    
    public Conexion(String ip, String puerto,String nombre, ChatCliente cliente) throws RemoteExcepcion{
        iniciar_conexion(ip,puerto,nombre,cliente);
    }
    
    private void iniciar_conexion(String ip, String puerto,String nombre,ChatCliente cliente)
    {
        try {
            String url = "rmi://"+ip+":"+puerto+"/ChatServer";
            this.servidor = (ChatServidor) Naming.lookup(url);
            this.servidor.registrar_cliente(nombre,(comun.ChatCliente)cliente);
        } catch (NotBoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public void iniciar_conexion(String ip, String puerto) throws NotBoundException,
                                                              MalformedURLException,
                                                              RemoteException,
                                                              ExceptionUsuarioRegistrado {
        String url_rmi = "rmi://" + ip + ":" + puerto + "/ChatServer";
        this.server = (ChatServidor) Naming.lookup(url_rmi);
        ConcurrentHashMap<String, ChatCliente> lista =
                this.server.registrar_peer(this.mi_nombre, (comun.ChatCliente) this);

        if (lista == null){
            throw new ExceptionUsuarioRegistrado("Ya hay un usuario registrado con este "
                    + "nombre: " + this.mi_nombre + ".");
        }

        this.lista_clientes.set_lista(lista);
    }
    */

}
