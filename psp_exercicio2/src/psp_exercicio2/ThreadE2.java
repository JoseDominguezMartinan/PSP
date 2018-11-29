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
    // constructor do fio , pasamoslle o nome do fio 
    public ThreadE2(String name) {
        super(name);
    }
    public void run(){ // metodo equivalente ao main para os fios
        for(int i=0;i<5;i++){ // como ten que escribir cinco veces, facemos un bucle de cinco voltas
            System.out.println(i+getName());  // imprimese o seu nome e numero de interaccion
            try {
                sleep(1000); // durmese durante 1000 milisegundos 
            } catch (InterruptedException ex) {
                System.out.println("erro ao parar o proceso"); // en caso de erro lanzamos un mensaxe
            }
        }
    }
        
}
