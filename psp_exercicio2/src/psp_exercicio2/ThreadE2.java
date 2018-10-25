/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio2;

/**
 *PSP: Exercicio2 fios
 * @author JoseDominguezMartiñan
 */
public class ThreadE2 extends Thread {

    public ThreadE2(String name) {
        super(name);
    }
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(i+getName()); 
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("erro ao parar o proceso");;
            }
        }
    }
        
}
