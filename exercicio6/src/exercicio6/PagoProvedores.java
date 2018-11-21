/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;

/**
 *
 * @author jose
 */
public class PagoProvedores extends Thread {
    Caixa c;
    int quitar;
    
    public PagoProvedores(Caixa c){
        this.c=c;
    }
    public void run(){
        // facemos un bucle para os cinco pagos que queremos realizar:
        for(int i=0;i<5;i++){
            quitar=(int)(Math.random()*100+1);
            c.quitar(quitar);
            System.out.println("pago realizado de "+quitar+" con exito");
            System.out.println("diñeiro disponible "+c.get());
        }
    }
}
