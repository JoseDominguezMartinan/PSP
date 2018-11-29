/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio8_tartaruga_lebre;

/**
 *
 * @author oracle
 */
public class Psp_exercicio8_tartaruga_lebre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circuito c=new Circuito();
        Tartaruga tartaruga=new Tartaruga(c);
        Lebre lebre=new Lebre(c);
        tartaruga.start();
        lebre.start();
        
    }
    
}
