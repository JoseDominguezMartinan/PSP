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
    Socket socket;

    String datos = "";
    String resultado = "";
    String comprobacion = "@"; // para realizar comprobacions e que o mesmo mensaxe non salga duas veces 
    

    int conexiones = 0; // para controlar el numero de clientes con sesion iniciada en el servidor

    boolean containsDesconectado; // variable que usaremos a la hora de comprobar si un cliente se ha desconectado
    boolean containsConectado = false; // variable que usaremos a la hora de comprobar si un cliente se ha conectado 

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
            // mostramos un mensaxe no servidor no caso de non ter clientes 
            if (conexiones < 1) {
                System.out.println("ningún usuario conectado");
            }
            // se as conexions son menos das permitidas
            if (conexiones < 3) {

                socket = serverSocket.accept();
                System.out.println("Aceptando conexiones");

                new Hilos(socket).start();
                conexiones++;
            } else {
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
                // si hay mensaxes dispoñibles para enviar
            if (is.available() == 0) {
                // no caso de que non haxan sido enviadas ainda enviamos 
                if (!resultado.equalsIgnoreCase(comprobacion)) {
                    enviar(os);
                    System.out.println("enviado" + resultado);

                }
                   // si o mensaxe indica que alguen iniciou sesion , se mandan o numero de usuarios conectados
                containsConectado = resultado.contains(" ha iniciado sesion");
                if (containsConectado == true) {
                    resultado = "" + "#" + " hay " + conexiones + "#" + "usuarios conectados";
                  
                    containsConectado = false;
                }
            } else {
                   // en caso contrario lemos para ter mensaxes que enviar 
                byte[] mensajeCliente = new byte[2048];
                is.read(mensajeCliente);
                datos = new String(mensajeCliente);
                resultado = datos;
                enviar(os);
                System.out.println(resultado + " recibido");
                // se o mensaxe indica que un usuario desconectouse, restamolo na nosa variable 
                containsDesconectado = resultado.contains("se ha desconectado");
                if (containsDesconectado == true) {
                    conexiones--; // si un cliente se ha desconectado se elimina una conexion de nuestra variable 
                    if (conexiones < 1) {
                        System.out.println("ningún usuario conectado");
                    }
                   
                }

            }

        } while (true);

    }
    /**
     * metodo para enviar datos dende o servidor 
     * @param os
     * @throws IOException 
     */

    public void enviar(OutputStream os) throws IOException {

        os.write(resultado.getBytes());
        comprobacion = resultado;
        System.out.println(resultado + "enviado por el metodo enviar");

        
    }

    /**
     * metodo para cerrar os sockets existentes
     *
     * @throws IOException
     */
    public void cerrarConexions() throws IOException {
        serverSocket.close();

    }
/**
 * clase que xestiona o fio que recibira en bucle os mensaxes dos clientes 
 */
    public class Hilos extends Thread {

        private InputStream is;
        private OutputStream os;
        private Socket nsocket;

        public Hilos(Socket sockets) throws IOException {
            this.nsocket = socket;

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
