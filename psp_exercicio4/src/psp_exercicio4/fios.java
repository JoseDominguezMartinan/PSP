/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio4;

/**
 * Exercicio 4
 * @author Jose Dominguez Martiñan
 */
public class fios extends Thread {

    // constructor da clase fio a que lle pasamos o nome que lle queremos dar 
    public fios(String name) {
        super(name);
    }
    int j=0; // nesta variable almacenaremos o numero que o fio ten que ir sumando 
    int f=0; // con esta variable controlaremos o fio que ten que ser creado

    public void setF(int f) {
        this.f = f;
    }
    
    
    // metodo co codigo que se executara no fio 
    public void run(){
    if(f==0){ // se e o primer fio que creamos dende o main 
        fios fio = new fios("fio2"); // creamos un novo fio
                fio.setF(1); // marcamos a variable F do fio como 1
                fio.start();
        for(int i=0;i<=1000;i++){ // realizamos as operacions necesarias para sumar os numeros pares ata o 1000
            if(i%2==0){
                j=j+i;
                
            }
            // imprimimos por pantalla o resultado da suma 
            System.out.println("a suma dos numeros pares é: "+j);
        }
        
    }
    if(f==1){ // se a variable de control e 1 , creamos o seguinte fio 
        fios fio=new fios("fio3"); // creamos o nomo fio 
                fio.setF(2); // cambiamos a variable f
                fio.start();
        for(int i=0;i<=1000;i++){ // contamos os numeros impares 
            if(i%2!=0){
                j=j+i;
                
            }
            System.out.println("a suma dos numeros impares é: "+j);
        }
        
    }
    if(f==2){ // en caso de que a condicion se cumpla creamos o terceiro fillo
        for(int i=0;i<=1000;i++){
        if(i%10==2 || i%10==3 ) // condicion pasa saber os numeros que terminan en dous e tres 
            j=j+i;
       
      System.out.println("a suma dos numeros terminados en dous e tres é: "+j);      
}
    
    
    }
    }      

}
