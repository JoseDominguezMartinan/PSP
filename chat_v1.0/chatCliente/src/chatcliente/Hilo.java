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
                String texto = "<div align=center style=”padding:12px;margin-left:125px;margin-right:125px;background-color:#E0B86B;line-height:1.4;”>\n"
                    + 
                    "el servidor se  ha desconectado, vuelvase a conectar mas tarde"
                    + "</div><br>";
            conexion.historial += texto;
            InterfazSala.chatSala.setText(conexion.historial);

            }

        }
    }

}
