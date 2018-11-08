/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio4;

/**
 *
 * @author oracle
 */
public class Psp_exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fioImpares fio1=new fioImpares("fio1");
        fioPares fio2=new fioPares("fio2");
        NumerosDosTres fio3=new NumerosDosTres("fio3");
        fio1.start();
        fio2.start();
        fio3.start();
    }
    
}
