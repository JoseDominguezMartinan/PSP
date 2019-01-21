/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorsocketstream2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * PSP Exercicio2 Socket Stream enviar cinco numeros ao servidor e este devolva
 * a suma deles
 *
 * @author JoseDominguezMartinan
 */
public class ServidorSocketStream2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here

        // variable donde iremos almacenando la suma de los numeros 
        int numTotal = 0;
        try {
            // creamos el socket e indicamos host y puerto 
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = serverSocket.accept();

            System.out.println("Conexion recibida");
            // declaramos el input y el output stream para la tranmision de informacion 
            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();
            
            // array de bytes para recibir os datos 
            byte[] mensajeCliente=new byte[20];

           is.read(mensajeCliente);
            // recibimos los cinco numeros y los almacenamos en la variable numTotalbyte[] mensajeCliente=new byte[5];
            String numeros = new String(mensajeCliente);
            // separamos a cadea polo seu separador, neste caso e un espazo en branco 
            String[] cadena = numeros.split(" ");
             // recorremos o array e imos sumando na nosa variable 
            for (int i = 0; i < cadena.length - 1; i++) {

                String numero = cadena[i];

                int num = Integer.valueOf(numero);

                numTotal = numTotal + num;

            }

            System.out.println("La suma es : " + numTotal);
            
            // enviamos o resultado da suma o noso cliente
            os.write(String.valueOf(numTotal).getBytes());

            System.out.println("Cerrando el nuevo socket");
            // ccerramos o socket
            newSocket.close();

            System.out.println("Cerrando el socket servidor");
            // cerramos el socket
            serverSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
        }
    }

}
