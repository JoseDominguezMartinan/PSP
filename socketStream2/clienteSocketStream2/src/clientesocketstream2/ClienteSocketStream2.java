/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesocketstream2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *PSP: Ecercicio SocketStream1 21/01/19
 * @author JoseDominguezMartinan
 */
public class ClienteSocketStream2 {

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
                        
                        
                        // array de bytes para reccibir informacion
                       byte[] mensajeServidor=new byte[20];

			System.out.println("Enviando mensaje");
                        
                        // string cos cinco numeros que queremos que o noso servidor sume 
                       String mensaje="1 2 3 4 5 ";

                       os.write(mensaje.getBytes());
                       // recibimos a suma dos numeros e a mostramos por pantalla 
                       is.read(mensajeServidor);
                       System.out.println("a suma dos numeros enviados é: "+new String(mensajeServidor));
                       
                        // cerramos el socket una vez concluida la transmision de mensajes 
			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
				e.printStackTrace();
			}
	}

    
    
}
