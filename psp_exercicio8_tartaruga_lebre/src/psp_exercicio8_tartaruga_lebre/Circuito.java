/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio8_tartaruga_lebre;

/**
 * exercicio lebre-tortuga
 * clase monitor onde temos os metodos sincronziados e os recursos aos que queremos acceder 
 * 
 * @author Jose dominguez Martiñan
 */
public class Circuito {
    private boolean available=true; // indica se pode acceder ou non 
    private int posibilidad; // para calcular se avanzamos ou retrocedemos e canto en funcion da probabilidade marcada 
    private int avance; // numero de casillas que avanzamos ou retrocedemos
    private boolean fin=false; // sera true cando un dos dous corredores chegue a meta primeiro

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
    /**
     * metodo sincronizado para avanzar ou retrocedder a tartaruga en funcion das suas posibilidades 
     * @param t obxeto de tipo tartaruga que avanzara ou retrocedera segundo a posibilidade 
     */
    
    public synchronized void Avancetartaruga(Tartaruga t){
        while(available==false){ // mentras non se poida acceder esperamos con un wait
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
        if (fin==false){ // en cso de que non chegara alguen o final executase o codigo 
        available=false; // cambise a condicion de acceso a false 
        posibilidad=(int) (Math.random()*100-1); // calculase un numero random do 1 ao 100 para calcular a posibilidade 
        
        if(posibilidad >0 && posibilidad<51){ // a tartaruga ten un 50 por cento de posibilidades de avanzar tres casillas 
            t.setPosicion(t.getPosicion()+3);
            avance=3;
        }
            
        if(posibilidad>=51 && posibilidad<=70){ // a tartaruga ten un 20 por cento de posibilidades de retroceder 6 casillas 
          if(t.getPosicion()>=6){ // en caso de que a posicion sexa 6 ou mais retrocedese 
                t.setPosicion(t.getPosicion()-6);
                avance=6;
          }
          else{ // se non chegou ainda a posicion 6 arrancara desde o principio 
                t.setPosicion(0);
                avance=t.getPosicion();
          }
        }
           
        if(posibilidad>70 && posibilidad<=100){ // ten un trinta por cento de posibilidades deavanzar unha casilla 
            if(t.getPosicion()>0){
              t.setPosicion(t.getPosicion()+1);
              avance=1;
            }
            
        }
        }
       notify(); // notifica a quen este esperando que pode acceder 
         
       
    
    }
    /**
     * metodo sincronizado chamado pola lebre para o seu avance segundo a sua posibilidade 
     * @param l obxeto lebre 
     */
    public synchronized void AvanceLebre(Lebre l){
        while(available==true){ // mentras non poda acceder espera co wait
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
        if(fin==false){ // en caso de que non haya chegado nadie a meta 
        available=true; // cambia a condicion de entrada 
        posibilidad=(int) (Math.random()*100+1); // calcula un numero aleatorio para avanzar en funcion da sua probabilidade 
        
        if(posibilidad >0 && posibilidad<21){ // ten un vinte por cento de probabilidades de non avanzar 
            avance=0;
        }
           
        if(posibilidad>=21 && posibilidad<=40){ // ten un vinte por cento de probabilidades de avanzar 9 posicions 
                l.setPosicion(l.getPosicion()+9);
                avance=9;
        }
        if(posibilidad>40 && posibilidad<=51){ // ten un 10 por cento de probabilidades de retroceder 12 posicions 
            if(l.getPosicion()>=12){ // se esta na posicion 12 ou superior retrocedera 
              l.setPosicion(l.getPosicion()-12);
              avance=12;
            }
            else{ // se esta antes da casilla doce volvera ao punto de partida 
                l.setPosicion(0);
                avance=l.getPosicion();
            }
        }
        if(posibilidad>51 && posibilidad<=80){// ten un trinta por cento de posibilidades de avanzar unha posicion 
            l.setPosicion(l.getPosicion()+1);
            avance=1;
        }
        if(posibilidad>=80&&posibilidad<=100){// ten un 20 por cento de probabilidades de retroceder duas posicions 
            if(l.posicion>2){ // se leva andado mais de duas casillas retrocede 
               l.setPosicion(l.getPosicion()-2);
               avance=2;
            }
            else{ // se non volve ao punto de inicio 
               l.setPosicion(0); 
               avance=l.getPosicion();
            }
            
        }
         notify(); // notifica a quen este esperando 
        
        }
 
      
   }
    
    
}
