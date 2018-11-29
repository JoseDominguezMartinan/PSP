/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *exercicio 6
 * @author jose Dominguez Martiñan
 */
public class Caixa {
    private int cartos=600; // variable que indica os cartos que hay na caixa
    private boolean available=false; 

    public Caixa() {
    }

   

    public void setCartos(int cartos) {
        this.cartos = cartos;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    // creamos un metodo get sincronizado,un metodo que devolve os cartos que temos na caixa, e ao que so pode acceder un fio a vez
    public synchronized int get(){
        while(available==false){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
           
        }
            available=false;
            notify(); // notificamos que xa se pode acceder ao metodo
            return cartos;
    }
    
    public synchronized void poñer(int valor){ // metodo para inserir unha cantidade de cartos (valor) na caixa 
        while(available==true){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("error");
            }
        }
        cartos=cartos+valor;
        available=true;
        notify();
    }
    
    public synchronized void quitar(int valor){ // metodo para quitar diñeiro da caixa para pago a proovedores
        while(available==true){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("error");
            }
        }
        if(cartos>=valor) // comprobamos que o diñeiro que hai na caixa sexa suficiente para non quedar en numeros vermellos
            cartos=cartos-valor;
        else
            System.out.println("non se pudo retirar o diñeiro, non hai cartos suficientes");
        
        available=true;
        notify();
    }   
}
