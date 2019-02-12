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
    int hora, minutos;
    /**
     * metodo para conectar co servidor, enviandolle porto e ip correspondente, e almacenando o nick
     *
     * @throws IOException
     */
    public void crearConexion(String ip, int puerto, String nick) throws IOException {
        // creamos el socket cliente y establecemos la conexion , marcando el host, en este caso localhost, y el puerto por el que nos vamos a comuniccar
       
        this.nick=nick;
        
        System.out.println("Creando socket cliente");

        clienteSocket = new Socket();

        System.out.println("Estableciendo la conexi�n");

        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
        clienteSocket.connect(addr);

    }
    /**
     * 
     * @param cadena 
     */
     public void enviar(String cadena) {

        try {
            os = clienteSocket.getOutputStream();
            // Recogemos la hora con los minutos a la que el mensaje fue enviado
            hora =calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            cadena=nick+": \n"+cadena+" "+hora+":"+minutos+"\n";
            os.write(cadena.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public String recibir() throws IOException{
        //creamos un array de bytes para almacenar la información recibida
        byte[] mensajeCliente=new byte[100];
        is=clienteSocket.getInputStream();
        is.read(mensajeCliente);
         
        String datos =new String(mensajeCliente);
        System.out.println(datos);
       return datos;
    }
     /**
      * 
      * @throws IOException 
      */
     public void cerrarConexions() throws IOException{
        clienteSocket.close();
        
    }
}