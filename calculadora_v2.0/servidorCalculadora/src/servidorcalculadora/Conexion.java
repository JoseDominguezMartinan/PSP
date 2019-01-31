/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcalculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 * Metodos de conexion socket PSP
 * calculadora v 2.0
 * @author Jose
 */
public class Conexion {
    
    // declaramos las variables que necesitaremos en todos los metodos 
    InputStream is;
    OutputStream os;
    ServerSocket serverSocket;
    String resultado;
    Socket socket;
    
    /**
     * metodo para crear o socket e aceptar a conexion do socket cliente 
     * @throws IOException 
     */
    public void crearConexion() throws IOException{
       
        System.out.println("Creando socket servidor");

        serverSocket = new ServerSocket();

        System.out.println("Realizando el bind");
        
        String puerto=JOptionPane.showInputDialog("Inserte el puerto servidor");
        InetSocketAddress addr = new InetSocketAddress("localhost",Integer.parseInt(puerto));
        serverSocket.bind(addr);
         socket = serverSocket.accept();
        System.out.println("Aceptando conexiones");

        
      
        new Cliente(socket,is,os).start();
        
        
    }
    
    /**
     * metodo que recibe os datos e chama a operacion pertinente
     * @throws IOException 
     */
    
    public void recibir(InputStream is,OutputStream os) throws IOException{
        //creamos un array de bytes para almacenar la información recibida
        byte[] mensajeCliente=new byte[100];
        is.read(mensajeCliente);
        String datos = new String(mensajeCliente);
        System.out.println(datos);
        //separamos los datos por el separador definido 
        String[] cadena = datos.split(" ");
      
        //el primer campo de la cadena tiene que ser el operador, segun el cual y siempre cuando el array tenga todos los numeros necesarios y no mas, se realizara la operación determinada
       switch (cadena[0]){
           case "/":
            if(cadena.length==3)
                resultado=Operacions.dividir(cadena[1],cadena[2]);
            else
                resultado="error:operacion valida para dos numeros";
            break;
           case "r":
               if(cadena.length==2)
                resultado=Operacions.raiz(cadena[1]);
               else
                resultado="error:operacion valida para un unico numero";
            break;
           default:
               if(cadena.length==3)
                resultado=Operacions.sumaRestaMul(cadena[1], cadena[2], cadena[0]);
               
               else
                resultado="error:operación valida para dos numeros";
            
               break;
       }
       os.write(resultado.getBytes());
    }
    
    /**
     * metodo para cerrar os sockets existentes
     * @throws IOException 
     */
    public void cerrarConexions() throws IOException{
        serverSocket.close();
        
    }
    
}
