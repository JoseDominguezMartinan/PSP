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
public class compraArtigos extends Thread {
    Caixa c;
    int ingreso;
    
    public compraArtigos(Caixa c){
        this.c=c;
    }
    
    public void run(){
        // vamos a xenerar os 10 ingresos directamente dende aqui, para iso faremos un bucle:
        for(int i=0;i<10;i++){
            ingreso=(int)(Math.random()*100+1); // generamos un numero aleatorio entre 0 y 100 que sera el que ingresemos en caja
            c.poñer(ingreso);
            System.out.println("venta por valor de "+ingreso);
            System.out.println("diñeiro en caixa "+c.get());
        }
    }
}
