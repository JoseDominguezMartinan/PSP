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
public class Leer extends Thread{
    Correo c=new Correo();

    public Leer(Correo c) {
        this.c=c;
    }
    public void run(){
        try {
            String ler = c.ler(); // chamamos ao metodo ler e retornamos o mensaxe nun string 
            System.out.println(ler);// imprimimos o mensaxe por pantalla 
        } catch (InterruptedException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
