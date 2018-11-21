/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio7;

/**
 *
 * @author jose
 */
public class Psp_exercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Correo c=new Correo();
        Leer l1=new Leer(c);
        Escribir e1=new Escribir(c,"Hola, son o primer mensaxe");
        Leer l2=new Leer(c);
        Escribir e2=new Escribir(c,"Hola, son o segundo mensxe");
        Leer l3=new Leer(c);
        Escribir e3=new Escribir(c,"Hola, son o terceiro mensaxe");
        Leer l4=new Leer(c);
        Escribir e4=new Escribir(c,"Hola, son o cuarto mensaxe");
        l1.start();
        e1.start();
        l2.start();
        e2.start();
        l3.start();
        e3.start();
        l4.start();
        e4.start();
        
        
    }
    
}
