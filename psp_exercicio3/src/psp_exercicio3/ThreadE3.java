/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PSP exercicio3
 *
 * @author JoseDominguezMartinan
 */


public class ThreadE3 extends Thread {

    // creamos o constructor para o fio 
    public ThreadE3(String name) {
        super(name);
    }
    // arrancamos o noso contador en 1 porque o primer fio que facemos dende o main chamamolo cero
    int i = 1;

    // metodo set para poder dar a variable i do fillo o valor da variable i do pai e asi non reinicializar o contador
    public void setI(int i) {
        this.i = i;
    }

   
    

    public void run() {
        {
            System.out.println(getName() + " se está executando"); // unha vez que arranca o fio indica que se esta executando en pantalla
            // se non é o ultimo fillo, crea un fillo e o arranca, ademais chama ao metodo imprimir
            if (i <5) {
                ThreadE3 fio = new ThreadE3(("fio" + Integer.toString(i)));
                fio.setI(i+1);
                fio.start();
                imprimir();
                 try { // esperamos a que o fille acabe 
                 fio.join();
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadE3.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
            }
            else{ // se e o ultimo fillo so se chama ao metodo imprimir 
                imprimir();
              
            }
              System.out.println(getName() + " terminou de executarse"); // indicase que se chegou ao final da execución
            

        }
    }
    // metodo no cal temos os pasos que ten que dar o fillo unha vez xa creou o seu respetivo fillo, ou se e o ultimo 
    public void imprimir(){
        // imprimimos dez veces o seu nome esperando un tempo determinado entre vez e vez
        for (int j = 0; j < 10; j++) {
                try {
                    sleep((long) (Math.random() * 600 + 100));

                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadE3.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(getName());
            }

           
    }
}
