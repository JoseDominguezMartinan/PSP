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
    String nick; // alamcenamos aqui o nome de usuario 
    String texto; // onde almacenaremos as mensaxes que seran xeradas para meter no chat 
    Calendar calendario; // para sacar la hora a la que se envio el mensaje por pantalla 
    int hora, minutos, segundos; // para almacenar e mostrar a hora da conexion e de envio dos mensaxes
    boolean primerMensaje = false; // si es el primer mensaje lo querremos formatear de una forma distinta 
    String historial = ""; // variable donde estara almacenada,en html , el historial de la conversacion
    String compTexto=""; // variable usada para comprobar o texto e que todo funcione ben
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

        System.out.println("Estableciendo la conexin");

        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
      
           clienteSocket.connect(addr); 
      
        // enviamos a mensaxe conforme iniciamos sesion coa nosa direccion e o noso porto 

        enviar(nick + " ha iniciado sesion"+" "+clienteSocket.getInetAddress()+" "+clienteSocket.getLocalPort());
    }

    /**
     *metodo para enviar as mensaxes
     * @param cadena
     */
    public void enviar(String cadena) {

        try {

            os = clienteSocket.getOutputStream();
            
            // Recogemos la hora con los minutos a la que el mensaje fue enviado
            calendario = new GregorianCalendar();
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            
           // se formatea o texto para a hora de que un cliente o mostre por pantalla o mostre como desexamos 
          
            // en caso de que non sexa o primer mensaxe o mostramos da forma adecuada
            if (primerMensaje == false) {
                cadena = nick + "#" + "false" + "#" + hora + ":" + minutos + ":" + segundos + ":  " + cadena + " " + "\n";
                primerMensaje = true;
            } else {
                cadena = nick + "#" + "true" + "#" + hora + ":" + minutos+":" + segundos + ":  " + cadena + " " + "\n";
            }
            
            os.write(cadena.getBytes());
            System.out.println("enviado"+cadena);
            
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public void recibir() throws IOException {
        //creamos un array de bytes para almacenar la información recibida
        byte[] mensajeCliente = new byte[2048];
        
            is = clienteSocket.getInputStream();
     
            is.read(mensajeCliente);
        
        String datos = new String(mensajeCliente);
        
        String[] cadena = datos.split("#");
// se recibimos o mensaxe cos usuarios conectados o reenviamos da forma correcta e non o mostramos por pantalla
        try {
            
            
            // en caso de mostralo por pantalla , o formateamos en html da forma desexada para mostrala no noso contedor 
            
            // cadena[1] e false cando e un mensaxe dunha nova conexion, polo que o mostraremos no centro, o mensaxe cambia se o que se conectou e o propio cliente ou outro 
            if (cadena[1].equalsIgnoreCase("false")) {
                if (cadena[0].equalsIgnoreCase(nick)) {
                    texto =  "<div align=center style=”padding:12px;margin-left:125px;margin-right:125px;background-color:#E0B86B;line-height:1.4;”>\n" 
                   + "Conectado a sala de chat" +
                    "</div><br>"; 
                }
                else{
                 texto =  "<div align=center style=”padding:12px;margin-left:125px;margin-right:125px;background-color:#E0B86B;line-height:1.4;”>\n" 
                   + cadena[2] +
                    "</div><br>";
                }
                // precisamos un historial , se non engadese a etiqueta de fin de html ao final e non podemos engadir liñas 
                historial += texto;
                InterfazSala.chatSala.setText(historial);
                // en caso de que sea un mensaxe da conversacion 
            } else {
                // se o mensaxe e do propio cliente, ( comparando o nick) mostrase na dereita e cun cor determinado 
                if (cadena[0].equalsIgnoreCase(nick)) {
                   
                    String texto = "<div align=right style=”padding:12px;margin-left:250px;background-color:#B7E595;line-height:1.4;”>\n" 
                    + cadena[2] +
                    "</div><br>";
                    historial += texto;
                    InterfazSala.chatSala.setText(historial);
                    // en caso de que sea de outro cliente mostrase na esquerda e con outro cor
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
