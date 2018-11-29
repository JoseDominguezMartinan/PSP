/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio1;

/**
 *
 * @author oracle
 */
public class PSP_exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // creamos os fios e chamamos ao metodo start para inicializalos 
        new ThreadExercicio1("fio1").start();
        new ThreadExercicio1("fio2").start();
    }
    
}
