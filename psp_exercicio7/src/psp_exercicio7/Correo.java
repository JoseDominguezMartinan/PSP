/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio7;

/**
 *exercicio 7
 * @author jose Dominguez Martiñan
 */
public class Correo {
    private String mensaxe=null;
    private boolean vacio=true;
// constructor getes y setes 
    public Correo() {
    
    }

   

    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    @Override
    public String toString() {
        return "Correo{" + "mensaxe=" + mensaxe + '}';
    }
    
    // metodo para ler o correo entrante 
    public synchronized String ler() throws InterruptedException{
        while(vacio==true){ // se o correo esta vacio esperamos 
            wait();
        }
       notify();
        vacio=true; // unha vez lido marcamos o correo como vacio e o retornamos 
        return mensaxe;
    }
    // metodo para escribir mensaxes
    public synchronized String escribir(String mensaxe) throws InterruptedException{
        while(vacio==false) // en caso de que o mensaxe non este vacio 
            wait(); // esperamos
        this.mensaxe=mensaxe; // se esta vacio adjudicamos a mensaxe ao correo e o retornamos marcando que xa esta escrito
        notify();
        vacio=false;
        return mensaxe;
    }
    
    
}
