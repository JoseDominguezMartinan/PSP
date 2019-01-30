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
    
    public Cliente(Socket socket) throws IOException {
        this.socket=socket;
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }
    
    
    @Override
    public void run() {
        try {
            
            while(true)
            conexion.recibir(is,os);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
