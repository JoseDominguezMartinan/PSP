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
public class NumerosDosTres extends Thread {

    public NumerosDosTres(String name) {
        super(name);
    }
    int j=0;
    public void run(){
    for(int i=0;i<=1000;i++){
        if(i%10==2 || i%10==3 )
            j=j+i;
       
            
}
    System.out.println("a suma dos numeros terminados en dous e tres é: "+j);
    }
    
}
