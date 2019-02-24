/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.IOException;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
        boolean i = true;
        while (i == true) {

            try {
                
                conexion.recibir();
              

            } catch (IOException ex) {
                i = false;

            }

        }
    }

}
