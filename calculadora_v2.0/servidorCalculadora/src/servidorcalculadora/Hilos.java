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
 * calculadora v2.0 clase para crear hilos por cada cliente
 *
 * @author Jose
 */
public class Hilos extends Thread {


    private InputStream is;
    private OutputStream os;
    Conexion conexion = new Conexion();
    private Socket nsocket;

    public Hilos(Socket socket,InputStream ins,OutputStream ons) throws IOException {
        this.nsocket=socket;
        this.is=ins;
        this.os=ons;
    }

    @Override
    public void run() {
        
        try {
            //asignamos un socket nuevo para dejar libre al serversocket que tiene que seguir recibiendo respuestas
           
            is = nsocket.getInputStream();
            os = nsocket.getOutputStream();
         do{   

                conexion.recibir(is, os);
         }while(true);
            
        } catch (IOException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
