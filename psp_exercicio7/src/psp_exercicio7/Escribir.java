/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Escribir extends Thread {
    String mensaxe; // contido do correo electronico 
    Correo c=new Correo(); // obxeto correo que vamos a tratar 

    public Escribir(Correo c, String mensaxe ) {
        this.c=c;
        this.mensaxe=mensaxe;
    }
    
    public void run(){
        try {
            c.escribir(mensaxe); // chamamos ao metodo correspondente pasando o mensaxe 
            System.out.println("mensaxe enviado con exito");
        } catch (InterruptedException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
