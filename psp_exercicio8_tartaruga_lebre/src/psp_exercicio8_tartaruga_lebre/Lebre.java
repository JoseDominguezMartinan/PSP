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
public class Lebre extends Thread {

    int avance;
    int posicion;
    Circuito c = new Circuito();

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
        while (c.isFin() == false) {
            int posicionI = posicion;
            c.AvanceLebre(this);

            if (c.isFin() == false) {

                if (posicion >= 70) {
                    c.setFin(true);
                    System.out.println("--------a lebre gañou-------");
                    break;

                }
                if (posicionI < posicion) {
                    System.out.println("a lebre avanzou " + c.getAvance() + " posicions " + "esta na posicion " + posicion);
                } else if (posicionI > posicion) {
                    System.out.println("a lebre retrasouse " + c.getAvance() + " posicions " + "esta na posicion " + posicion);
                } else if (c.getAvance() == 0) {
                    System.out.println("a lebre non avanzou nada");
                }

            }
        }

    }

}
