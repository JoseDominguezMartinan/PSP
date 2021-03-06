/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio8_tartaruga_lebre;

/**
 *exemplo tartaruga-lebre
 * clase lebre 
 * @author Jose Dominguez Martiñan 
 */
public class Lebre extends Thread {

    int avance; // casillas que avanza a lebre 
    int posicion; // posicion actual do animal 
    Circuito c = new Circuito(); // obxeto monitor 

    public Lebre(Circuito c) {
        this.c = c;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Circuito getC() {
        return c;
    }

    public void setC(Circuito c) {
        this.c = c;
    }

    public void run() {
        while (c.isFin() == false) { // mentras un non acabase a carreira 
            int posicionI = posicion; // antes de avanzar gardase a posicion inicial 
            c.AvanceLebre(this); // avanzase no tableiro segun a probabilidade 

            if (c.isFin() == false) { // en caso de que alguen non acabase a carreira, e necesario porque pudo entrar
                //neste bucle e quedar en wait , , polo tanto cando o anterior o desperte non se executara nada
                //porque esta tratado no monitor, pero si fara as impresions por pantalla que aparecen a continuacion cos datos da anterior xogada

                if (posicion >= 70) {// se a posicion e 70 ou mais imprimese a mensaxe de gañador 
                    c.setFin(true);
                    System.out.println("--------a lebre gañou-------");
                    break;

                }
                if (posicionI < posicion) { // se a posicion na que quedou e maior que na que estaba , imprimise o que avanzou 
                    System.out.println("a lebre avanzou " + c.getAvance() + " posicions " + "esta na posicion " + posicion);
                } else if (posicionI > posicion) { // se a posicion na que quedou e menor que na que estaba imprimese o que retrocedeu
                    System.out.println("a lebre retrasouse " + c.getAvance() + " posicions " + "esta na posicion " + posicion);
                } else if (c.getAvance() == 0) {// se non avanzou nada imprimesee
                    System.out.println("a lebre non avanzou nada");
                }

            }
        }

    }

}
