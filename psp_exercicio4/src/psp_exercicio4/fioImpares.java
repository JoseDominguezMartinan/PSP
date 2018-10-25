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
public class fioImpares extends Thread {
    public fioImpares(String name) {
        super(name);
    }
    int j=0;
    public void run(){
        for(int i=0;i<=1000;i++){
            if(i%2!=0){
                j=j+i;
                        
            }
            System.out.println("a suma dos numeros impares é: "+j);
        }
        
    }
}
