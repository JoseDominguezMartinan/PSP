/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio2;

/**
 *
 * @author oracle
 */
public class Psp_exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ThreadE2 fio1=new ThreadE2("fio1");
        fio1.start();
        //fio1.join(); // dependendo de onde poñamos o join , se despois de cada start ou ao final , esperara a terminar este fio so ou todos so fios 
        ThreadE2 fio2=new ThreadE2("fio2");
        fio2.start();
        //fio2.join();
        ThreadE2 fio3=new ThreadE2("fio3");
        fio3.start();
        //fio3.join();
        ThreadE2 fio4=new ThreadE2("fio4");
        fio4.start();
        //fio4.join();
        fio1.join();
        fio2.join();
        fio3.join();
        fio4.join(); 
        System.out.println("os fillos terminaron");// sout de proba para demostrar que se esperou polos fillos
    }
    
    
}
