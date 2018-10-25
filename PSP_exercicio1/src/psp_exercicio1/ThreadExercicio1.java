/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *PSP:Exercicio1 fios 11/10/18
 * @author JoseDominguezMartiñan
 */
public class ThreadExercicio1 extends Thread {

    public ThreadExercicio1(String name) {
        super(name);
    }
    /**
     * metodo que ao ser executado imprime dez veces o numero de execucion e o nome do fio
     */
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i+getName()); 
            try {
                sleep((long)(Math.random()+1));
              //  sleep((long)(Math.random()*(100000-10000+1)+10000)); Poño valores iniciales e finales moi altos para poder probar ben que funcione
            } catch (InterruptedException ex) {
                System.out.println("erro ao parar o proceso");;
            }
        }
    }
}
