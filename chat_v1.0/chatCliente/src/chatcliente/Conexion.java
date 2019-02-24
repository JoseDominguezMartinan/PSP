/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * cliente de la sala de chat v1.0
 *
 * @author Jose
 */
public class Conexion {
    // declaramos las variables que necesitaremos en todos los metodos 

    InputStream is;
    OutputStream os;
    Socket clienteSocket;
    String nick;
    Calendar calendario = new GregorianCalendar(); // para sacar la hora a la que se envio el mensaje por pantalla 
    int hora, minutos, segundos;
    boolean primerMensaje = false; // si es el primer mensaje lo querremos formatear de una forma distinta 
    String historial = ""; // variable donde estara almacenada,en html , el historial de la conversacion

    /**
     * metodo para conectar co servidor, enviandolle porto e ip correspondente,
     * e almacenando o nick
     *
     * @throws IOException
     */
    public void crearConexion(String ip, int puerto, String nick) throws IOException {
        // creamos el socket cliente y establecemos la conexion , marcando el host, en este caso localhost, y el puerto por el que nos vamos a comuniccar

        this.nick = nick;

        System.out.println("Creando socket cliente");

        clienteSocket = new Socket();

        System.out.println("Estableciendo la conexi�n");

        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
      
           clienteSocket.connect(addr); 
      
        

        enviar(nick + " ha iniciado sesión");
    }

    /**
     *
     * @param cadena
     */
    public void enviar(String cadena) {

        try {

            os = clienteSocket.getOutputStream();
            // Recogemos la hora con los minutos a la que el mensaje fue enviado

            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            if (primerMensaje == false) {
                cadena = nick + "#" + "false" + "#" + hora + ":" + minutos + ":" + segundos + ":  " + cadena + " " + "\n";
                primerMensaje = true;
            } else {
                cadena = nick + "#" + "true" + "#" + hora + ":" + minutos+":" + segundos + ":  " + cadena + " " + "\n";
            }
            os.write(cadena.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void recibir() throws IOException {
        //creamos un array de bytes para almacenar la información recibida
        byte[] mensajeCliente = new byte[100];
        is = clienteSocket.getInputStream();
        is.read(mensajeCliente);
        String datos = new String(mensajeCliente);
        System.out.println(datos);
        String[] cadena = datos.split("#");

        try {
            System.out.println(cadena[0]);
            System.out.println(nick);
            if (cadena[1].equalsIgnoreCase("false")) {
                String texto =  "<div align=center style=”padding:12px;margin-left:125px;margin-right:125px;background-color:#E0B86B;line-height:1.4;”>\n" 
                   + cadena[2] +
                    "</div><br>";
                historial += texto;
                InterfazSala.chatSala.setText(historial);
            } else {
                if (cadena[0].equalsIgnoreCase(nick)) {
                   
                    String texto = "<div align=right style=”padding:12px;margin-left:250px;background-color:#B7E595;line-height:1.4;”>\n" 
                    + cadena[2] +
                    "</div><br>";
                    historial += texto;
                    InterfazSala.chatSala.setText(historial);
                } else {
                    String texto = "<div align=left style=”padding:12px;margin-right:250px;background-color:#D1D8CC;line-height:1.4;”>\n" 
                    + cadena[0]+"<br>"+cadena[2] +
                    "</div><br>";
                    historial += texto;
                    InterfazSala.chatSala.setText(historial);
                }
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("esperando a recibir mensaje");
        }

    }

    /**
     *
     * @throws IOException
     */
    public void cerrarConexions() throws IOException {
        clienteSocket.close();

    }

    /**
     * metodo para alinear el texto a la derecha o a la izquierda segun interese
     *
     * @param stc
     */
}
