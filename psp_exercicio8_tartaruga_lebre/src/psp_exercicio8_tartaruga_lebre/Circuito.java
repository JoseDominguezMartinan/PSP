/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio8_tartaruga_lebre;

/**
 *
 * @author oracle
 */
public class Circuito {
    private boolean available=true; 
    private int posibilidad;
    private int avance;
    private boolean fin=false;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isFin() {
        return fin;
    }

    public int getPosibilidad() {
        return posibilidad;
    }

    public int getAvance() {
        return avance;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }
    
    
    public synchronized void Avancetartaruga(Tartaruga t){
        while(available==false){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
        if (fin==false){
        available=false;
        posibilidad=(int) (Math.random()*100-1);
        
        if(posibilidad >0 && posibilidad<51){
            t.setPosicion(t.getPosicion()+3);
            avance=3;
        }
            
        if(posibilidad>=51 && posibilidad<=70){
          if(t.getPosicion()>=6){
                t.setPosicion(t.getPosicion()-6);
                avance=6;
          }
          else{
                t.setPosicion(0);
                avance=t.getPosicion();
          }
        }
           
        if(posibilidad>70 && posibilidad<=100){
            if(t.getPosicion()>0){
              t.setPosicion(t.getPosicion()+1);
              avance=1;
            }
            
        }
        }
       notify();
         
       
    
    }
    public synchronized void AvanceLebre(Lebre l){
        while(available==true){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
        if(fin==false){
        available=true;
        posibilidad=(int) (Math.random()*100+1);
        
        if(posibilidad >0 && posibilidad<21){
            avance=0;
        }
           
        if(posibilidad>=21 && posibilidad<=40){
                l.setPosicion(l.getPosicion()+9);
                avance=9;
        }
        if(posibilidad>40 && posibilidad<=51){
            if(l.getPosicion()>=12){
              l.setPosicion(l.getPosicion()-12);
              avance=12;
            }
            else{
                l.setPosicion(0);
                avance=l.getPosicion();
            }
        }
        if(posibilidad>51 && posibilidad<=80){
            l.setPosicion(l.getPosicion()+1);
            avance=1;
        }
        if(posibilidad>=80&&posibilidad<=100){
            if(l.posicion>2){
               l.setPosicion(l.getPosicion()-2);
               avance=2;
            }
            else{
               l.setPosicion(0); 
               avance=l.getPosicion();
            }
            
        }
         notify();
        
        }
 
      
   }
    
    
}
