/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * clase para a conexion sockets servidor sala de chat v 1.0
 *
 * @author Jose
 */
public class Conexion {

    // declaramos las variables que necesitaremos en todos los metodos 
    InputStream is;
    OutputStream os;
    ServerSocket serverSocket;
    String datos = "";
    String resultado = "";
    String comprobacion = "@";
    int conexiones = 0; // para controlar el numero de clientes con sesion iniciada en el servidor
    boolean contains;
    Socket socket;

    /**
     * metodo para crear o socket e aceptar a conexion do socket cliente
     *
     * @throws IOException
     */
    public void crearConexion() throws IOException {

        System.out.println("Creando socket servidor");

        serverSocket = new ServerSocket();

        System.out.println("Realizando el bind");

        String puerto = JOptionPane.showInputDialog("Inserte el puerto servidor");
        InetSocketAddress addr = new InetSocketAddress("localhost", Integer.parseInt(puerto));
        serverSocket.bind(addr);

        do { 
            if (conexiones < 3) {
               
                socket = serverSocket.accept();
                System.out.println("Aceptando conexiones");

                new Hilos(socket, is, os).start();
                conexiones++;
            }else {
                try {
                    Thread.sleep(200); // el sleep es necesario para que funcionen las conexiones y desconexiones con el numero maximo 
                } catch (InterruptedException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            

        } while (true);

    }

    /**
     *
     * @param is
     *
     * @throws IOException
     */
    public void recibir(InputStream is, OutputStream os) throws IOException {
        
        
        do {
            if (is.available() == 0) {
                if (!resultado.equalsIgnoreCase(comprobacion)) {
                    enviar(os);
                }
                comprobacion = resultado;
                
            } else {

                byte[] mensajeCliente = new byte[1024];
                is.read(mensajeCliente);
                datos = new String(mensajeCliente);
                resultado = datos;
                contains = resultado.contains("se ha desconectado");
                if (contains == true) {
                    conexiones--; // si un cliente se ha desconectado se elimina una conexion de nuestra variable 
                    System.out.println(conexiones);
                }

            }

        } while (true);
       

    }

    public void enviar(OutputStream os) throws IOException {

        os.write(resultado.getBytes());
        System.out.println(resultado);
        comprobacion = "[]";
    }

    /**
     * metodo para cerrar os sockets existentes
     *
     * @throws IOException
     */
    public void cerrarConexions() throws IOException {
        serverSocket.close();

    }

    public class Hilos extends Thread {

        private InputStream is;
        private OutputStream os;
        private Socket nsocket;

        public Hilos(Socket socket, InputStream ins, OutputStream ons) throws IOException {
            this.nsocket = socket;
            this.is = ins;
            this.os = ons;

        }

        @Override
        public void run() {

            try {
                //asignamos un socket nuevo para dejar libre al serversocket que tiene que seguir recibiendo respuestas

                is = nsocket.getInputStream();
                os = nsocket.getOutputStream();

                recibir(is, os);

            } catch (IOException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
