/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcalculadora;

import java.io.IOException;

/**
 *
 * @author Jose
 */
public class ServidorCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Conexion conexion=new Conexion();
        conexion.crearConexion();
        while(true)
        conexion.recibir();
        
    }
    
}
