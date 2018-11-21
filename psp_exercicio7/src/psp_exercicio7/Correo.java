/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio7;

/**
 *
 * @author jose
 */
public class Correo {
    private String mensaxe=null;
    private boolean vacio=true;

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
    
    public synchronized String ler() throws InterruptedException{
        while(vacio==true){
            wait();
        }
       notify();
        vacio=true;
        return mensaxe;
    }
    
    public synchronized String escribir(String mensaxe) throws InterruptedException{
        while(vacio==false)
            wait();
        this.mensaxe=mensaxe;
        notify();
        vacio=false;
        return mensaxe;
    }
    
    
}
