/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exercicio4;

/**
 *
 * @author oracle
 */
public class fios extends Thread {

    public fios(String name) {
        super(name);
    }
    int j=0;
    int f=0;

    public void setF(int f) {
        this.f = f;
    }
    
    
    
    public void run(){
    if(f==0){
        for(int i=0;i<=1000;i++){
            if(i%2==0){
                j=j+i;
                
            }
            System.out.println("a suma dos numeros pares é: "+j);
        }
        fios fio = new fios("fio2");
                fio.setF(1);
                fio.start();
    }
    if(f==1){
        for(int i=0;i<=1000;i++){
            if(i%2!=0){
                j=j+i;
                
            }
            System.out.println("a suma dos numeros impares é: "+j);
        }
        fios fio=new fios("fio3");
                fio.setF(2);
                fio.start();
    }
    if(f==2){
        for(int i=0;i<=1000;i++){
        if(i%10==2 || i%10==3 )
            j=j+i;
       
      System.out.println("a suma dos numeros terminados en dous e tres é: "+j);      
}
    
    
    }
    }      

}
