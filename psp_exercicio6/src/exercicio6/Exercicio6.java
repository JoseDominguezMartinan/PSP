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
public class Exercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Caixa c=new Caixa();
        PagoProvedores pago=new PagoProvedores(c);
        compraArtigos compra=new compraArtigos(c);
        
        pago.start();
        compra.start();
    }
    
}
