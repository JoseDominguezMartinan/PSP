/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class FacerFios extends Thread {

    public FacerFios(String name) {
        super(name);
    }
    public void run(){
        
        if(getName().equals("1")){
            try {
            
                join(1);
               
                
        } catch (InterruptedException ex) {
                System.out.println("error");
        }
        }
        System.out.println("Hola son o fio numero "+getName());
    }

    
    
}
