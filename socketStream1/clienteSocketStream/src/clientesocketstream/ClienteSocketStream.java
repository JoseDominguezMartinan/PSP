/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesocketstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *PSP: Ecercicio SocketStream1 21/01/19
 * @author JoseDominguezMartinan
 */
public class ClienteSocketStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
                         // creamos el socket cliente y establecemos la conexion , marcando el host, en este caso localhost, y el puerto por el que nos vamos a comuniccar
			System.out.println("Creando socket cliente");
			Socket clienteSocket=new Socket();
			System.out.println("Estableciendo la conexi�n");
			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			clienteSocket.connect(addr);
                        
                        // declaramos el input y el output stream para la comunicacion de entrada y salida 
			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");
                        
                        // en este caso que queremos enviar un string , lo declaramos
			String mensajeCliente="Hola";
                        // y enviamos los bytes del mensaje por el outputStream
			os.write(mensajeCliente.getBytes());
                        // imprimimos la información por la salida estandard
                        System.out.println("mensaje enviado:"+mensajeCliente);
                        // creamos un array de bytes para poder recibir los mensajes del otro host que participa en la comunicacion
                        byte[] mensajeServidor=new byte[25];
                        //almacenamos el mensaje recibido en el array de bytes 
                        is.read(mensajeServidor);
                        // y lo imprimimos creando un string con los bytes recibidos 
                        System.out.println("mensaje recibido: "+new String(mensajeServidor));
                        // generamos y recibimos el resto de mensajes de la misma forma 
                        mensajeCliente="¿que tal?";
                        
                        os.write(mensajeCliente.getBytes());
                        System.out.println("mensaje enviado:"+mensajeCliente);
                        
                        is.read(mensajeServidor);
                        
                        System.out.println("mensaje recibido:"+new String(mensajeServidor));
                        
                        mensajeCliente="bien tambien";
                        
                        os.write(mensajeCliente.getBytes());
                        System.out.println("mensaje enviado:"+mensajeCliente);
                        
                        // cerramos el socket una vez concluida la transmision de mensajes 
			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
				e.printStackTrace();
			}
	}

    
    
}
