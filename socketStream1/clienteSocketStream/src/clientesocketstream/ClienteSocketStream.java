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
 *
 * @author Jose
 */
public class ClienteSocketStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
			System.out.println("Creando socket cliente");
			Socket clienteSocket=new Socket();
			System.out.println("Estableciendo la conexi�n");
			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");

			String mensajeCliente="Hola";
			os.write(mensajeCliente.getBytes());
                        System.out.println("mensaje enviado:"+mensajeCliente);
                        
                        byte[] mensajeServidor=new byte[25];
                        
                        is.read(mensajeServidor);
                        
                        System.out.println("mensaje recibido: "+new String(mensajeServidor));
                        
                        mensajeCliente="¿que tal?";
                        
                        os.write(mensajeCliente.getBytes());
                        System.out.println("mensaje enviado:"+mensajeCliente);
                        
                        is.read(mensajeServidor);
                        
                        System.out.println("mensaje recibido:"+new String(mensajeServidor));
                        
                        mensajeCliente="bien tambien";
                        
                        os.write(mensajeCliente.getBytes());
                        System.out.println("mensaje enviado:"+mensajeCliente);
                        

			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
				e.printStackTrace();
			}
	}

    
    
}
