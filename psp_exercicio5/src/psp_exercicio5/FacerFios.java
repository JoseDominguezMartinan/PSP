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
                // para o caso de join , facemolo durante o tempo determinado para que salte o segundo fio primeiro
                
//            try {
//                
//                join(1);
//
//                
//        } catch (InterruptedException ex) {
//                System.out.println("error");
//        }
//        }

// en caso de tratamento con prioridades:
            sleep(1); // durmimolo un milisegundo para que chegue a establecerse a prioridade do outro fio antes de que se execute o primeiro
            } catch (InterruptedException ex) {
                Logger.getLogger(FacerFios.class.getName()).log(Level.SEVERE, null, ex);
            }
        setPriority(1);
        
        }
        else{
            setPriority(10);
        }
        System.out.println("Hola son o fio numero "+getName());
        System.out.println(getPriority()); // para mostrar a prioridade e asi ver que se fai na orde que ten que ser 
    }

    
    
}
