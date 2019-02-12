/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class Hilo extends Thread {

    Conexion conexion;
    
    
    public Hilo(Conexion conexion) {

        this.conexion = conexion;

    }

    @Override

    public void run() {
        boolean i=true;
        while (i==true) {

            try {
                InterfazSala.chatSala.setText(InterfazSala.chatSala.getText() + conexion.recibir());
            } catch (IOException ex) {
               i=false;
                
            }

        }
    }

    }
