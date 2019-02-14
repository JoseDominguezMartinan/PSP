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
                String[] datos = conexion.recibir();
                try {
                    if (datos[0].equalsIgnoreCase(conexion.nick)) {
                        conexion.alineacion(StyleConstants.ALIGN_RIGHT);
                        InterfazSala.chatSala.setText(InterfazSala.chatSala.getText() + datos[0] + "\n" + datos[1]);
                    } else {
                        conexion.alineacion(StyleConstants.ALIGN_LEFT);
                        InterfazSala.chatSala.setText(InterfazSala.chatSala.getText() + datos[0] + "\n" + datos[1]);
                    }
                } catch (ArrayIndexOutOfBoundsException error) {
                    System.out.println("esperando a recibir mensaje");
                }

            } catch (IOException ex) {
                i = false;

            }

        }
    }

}
