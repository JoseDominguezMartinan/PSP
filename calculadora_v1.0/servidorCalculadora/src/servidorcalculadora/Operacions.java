/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcalculadora;

/**
 *exercicio calculadora v 1.0 PSP
 * @author Jose
 */
public class Operacions {
    
    
    
    static float resultado; // variable para almacenar o resultado das operacions
    // variable para almacenar os numeros cos que vamos a operar unha vez casteados
    static float numero1; 
    static float numero2;
    // mensaxe que imos devolver para mostrar por pantalla 
    static String devolver;
    
    
    // creamos un metodo para cada operacion,para asi poder controlar os erros das operacions xa dentro de cada metodo,
    //tamen será aqui onde parseemos os string recibidos e asi operar, e devolvemos un string para amosalo por pantalla 
    
    /**
     * metodo que segundo o operador que nos mande o cliente fara a operacion correspondente 
     * @param num1 primer numero da operacion 
     * @param num2 segundo numero da operacion 
     * @param operador operacion que temos que realizar 
     * @return devolver mensaxe que se mostrara por pantalla 
     */
    public static String sumaRestaMul(String num1, String num2,String operador){
        numero1=Float.parseFloat(num1);
        numero2=Float.parseFloat(num2);
        switch(operador){
            case "+":
               resultado=numero1+numero2;
               devolver=String.valueOf(resultado);
            case "-" :
               resultado=numero1-numero2;
               devolver=String.valueOf(resultado);
            case "x":
                resultado=numero1*numero2;
                devolver=String.valueOf(resultado);
            default:
                devolver="operacion non valida";
                
        }
        return devolver;
    }
    /**
     * metodo para dividir dous numeros 
     * @param num1 dividendo
     * @param num2 divisor
     * @return resultado casteado en string 
     */
   public static String dividir(String num1,String num2){
       numero1=Float.parseFloat(num1);
       numero2=Float.parseFloat(num2);
       
       if(numero2==0){ //el divisor no puede ser cero
           devolver="operacion non valida";
       }
       else{
           resultado=numero1/numero2;
           devolver=String.valueOf(resultado);
       }
       
       return devolver;
   }
   /**
    * raiz cuadrada de un numero
    * @param num numero al que realizar la operacion 
    * @return resultado en string para mostrar por pantalla 
    */
   
   public static String raiz(String num){
       numero1=Float.parseFloat(num);
       
       if(numero1<0){ // no se puede realizar la raiz de numeros negativos 
           devolver="operación non valida";
       }
       else{
          resultado=(float)Math.sqrt(numero1);
          devolver=String.valueOf(resultado);
       }
       
       return devolver;
   }
    
    
}
