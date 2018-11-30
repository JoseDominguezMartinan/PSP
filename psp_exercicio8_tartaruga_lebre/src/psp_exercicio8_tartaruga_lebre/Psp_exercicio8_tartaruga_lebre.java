/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio8_tartaruga_lebre;

/**
 *exercicio tartaruga_lebre
 * clase principal, instancia dos obxetos e chamada dos metodo start 
 * @author Jose DOminguez Martinan
 */
public class Psp_exercicio8_tartaruga_lebre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // obxeto circuito o cal pasaremos a ambos animais para que traballen sobre o mesmo , sera o monitor 
        Circuito c=new Circuito();
        // tartaruga sera un fio e lebre outro , cada un ten a sua clase que extende de thread 
        Tartaruga tartaruga=new Tartaruga(c);
        Lebre lebre=new Lebre(c);
        tartaruga.start();
        lebre.start();
        
    }
    
}
