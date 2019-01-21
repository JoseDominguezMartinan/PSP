/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketstream1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jose
 */
public class SocketStream1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
                        // creamos el socket e indicamos host y puerto 
			System.out.println("Creando socket servidor");
	
			ServerSocket serverSocket=new ServerSocket();

			System.out.println("Realizando el bind");

			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");
                        
			Socket newSocket= serverSocket.accept();

			System.out.println("Conexi�n recibida");
                        // declaramos el input y el output stream para la tranmision de informacion 
			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();
                        // los mensajes recibidos los almaccenaremos en un array de bytes, para posteriormente convertirlos a string e imprimirlos por la salida standard
			byte[] mensajeCliente=new byte[25];
                        // recibimos el mensaje del cliente y lo almacenamos en el array e imprimimos por pantalla 
			is.read(mensajeCliente);

			System.out.println("Mensaje recibido: "+new String(mensajeCliente));
                        
                        //generamos un mensaje nuevo para ser enviado, que guardamos en un string 
                        String mensajeServidor="hola";
                        // obtenemos los bytes del string y lo enviamos con el output stream 
                        os.write(mensajeServidor.getBytes());
                        System.out.println("mensaje enviado:"+mensajeServidor);
                        // realizamos los mismos pasos con el resto de mensajes 
                        is.read(mensajeCliente);
                        
                        System.out.println("mensaje recibido: "+new String(mensajeCliente));
                        
                        mensajeServidor="bien, ¿y tu?";
                        
                        os.write(mensajeServidor.getBytes());
                        System.out.println("mensaje enviado:"+mensajeServidor);
                        
                        is.read(mensajeCliente);
                        
                        System.out.println("mensaje recibido:"+new String(mensajeCliente));
                        
                        mensajeServidor="me alegro";
                        
                        os.write(mensajeServidor.getBytes());
                        System.out.println("mensaje enviado:"+mensajeServidor);
                        
                        
			System.out.println("Cerrando el nuevo socket");
                        // ccerra,ps eñ socket 
			newSocket.close();

			System.out.println("Cerrando el socket servidor");
                        // cerramos el socket
			serverSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
			}
		}

    
    
}
