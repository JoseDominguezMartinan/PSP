/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecalculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class Conexion {

    // declaramos las variables que necesitaremos en todos los metodos 
    InputStream is;
    OutputStream os;
    Socket clienteSocket;

    /**
     * metodo para conectar co servidor, enviandolle porto e ip correspondente
     *
     * @throws IOException
     */
    public void crearConexion(String ip,int puerto) throws IOException {
        // creamos el socket cliente y establecemos la conexion , marcando el host, en este caso localhost, y el puerto por el que nos vamos a comuniccar

        System.out.println("Creando socket cliente");

         clienteSocket = new Socket();

        System.out.println("Estableciendo la conexi�n");

        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
        clienteSocket.connect(addr);

        
         

         

    }

    /**
     * metodo para enviar os datos ao servidor
     *
     * @throws IOException
     */
    public void enviar(String cadena) {

        try {
            System.out.println(cadena);
            os = clienteSocket.getOutputStream();
            os.write(cadena.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String recibir() {
        byte[] mensajeCliente = new byte[100];
        String resultado="e";
        try {
            is = clienteSocket.getInputStream();
            is.read(mensajeCliente);
            
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            try{
            DecimalFormat df = new DecimalFormat("#.##",simbolos);
            resultado =df.format(Float.parseFloat( new String(mensajeCliente)));
            }catch(NumberFormatException ex){
             resultado=new String(mensajeCliente);
            }
            
            
        
        } catch (IOException ex) {
            System.out.println("error");
        }
        return resultado;
    }

    /**
     * metodo para cerrar os sockets existentes
     *
     * @throws IOException
     */
    public void cerrarConexions() throws IOException {
        
        clienteSocket.close();
    }
}
