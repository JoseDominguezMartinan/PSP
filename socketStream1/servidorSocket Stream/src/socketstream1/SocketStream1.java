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
			System.out.println("Creando socket servidor");
	
			ServerSocket serverSocket=new ServerSocket();

			System.out.println("Realizando el bind");

			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");

			Socket newSocket= serverSocket.accept();

			System.out.println("Conexi�n recibida");

			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();

			byte[] mensajeCliente=new byte[25];
			is.read(mensajeCliente);

			System.out.println("Mensaje recibido: "+new String(mensajeCliente));
                        
                        String mensajeServidor="hola";
                        
                        os.write(mensajeServidor.getBytes());
                        System.out.println("mensaje enviado:"+mensajeServidor);
                        
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

			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
			}
		}

    
    
}
