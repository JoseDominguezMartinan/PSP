/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcalculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *calculadora v2.0
 * clase para crear hilos por cada cliente
 * @author Jose
 */
public class Cliente extends Thread {
    private Socket socket;
    
    private InputStream is;
    private OutputStream os;
    Conexion conexion=new Conexion();
    private ServerSocket serversocket;
    
    public Cliente( ServerSocket serversocket) throws IOException {
        this.serversocket=serversocket;
        
    }
    
    
    @Override
    public void run() {
        
        try {
            socket = serversocket.accept();
            is = socket.getInputStream();
            os = socket.getOutputStream();
                try {
                    while(true){
                    conexion.recibir(is,os);
                }} catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
         }catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
