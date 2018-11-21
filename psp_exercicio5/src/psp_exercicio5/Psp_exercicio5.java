/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio5;

/**
 *
 * @author oracle
 */
public class Psp_exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        FacerFios fio1=new FacerFios("1");
        FacerFios fio2=new FacerFios("2");
        
        
        
        fio1.start();
       
        fio2.start();
        
        
        
    }
    
}
