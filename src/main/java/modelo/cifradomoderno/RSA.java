package modelo.cifradomoderno;

import modelo.Criptografia;
import java.util.Random;

/**
 * Class RSA
 * @authors Diego Araya & Raul Alfaro
 */

public class RSA extends Criptografia{
  private Integer claveN;
  private Integer claveD;
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica RSA
   * @param texto
   * @return String: Devuelve valores numéricos como una cadena de String
   */
  @Override
  public  String encriptar(String texto){
    StringBuilder mensajeCifrado = new StringBuilder();
    texto = texto.toUpperCase();
    int p = 61; //generarNumeroPrimo();
    int q = 53; //generarNumeroPrimo();
    int n = 3233; //p * q;
    int euler = 3120; //(p - 1) * (q - 1);
    int e = 17; //generarNumeroCoPrimo(euler);
    int d = 2753; //generarNumeroD(e, euler);
    
    for(int i = 0; i < texto.length(); i++) {
        char letra = texto.charAt(i);
        int valorASCII = (int) letra;
        int codigo = 1;
        
        for(int j = 0; j < e; j++) {
            codigo *= valorASCII;
        }
        
        mensajeCifrado.append(codigo);
    }
    
    claveN = n;
    claveD = d;
    return mensajeCifrado.toString();
  }
  
  @Override
  public  String desencriptar(String texto){
    String[] Texto = texto.split("\\*");
    StringBuilder mensajeDescifrado = new StringBuilder();
    int n = getClave1();
    double d = getClave2();
    
    for(String valores: Texto) {
        double valorRSA = Integer.parseInt(valores);
        double codigo = (Math.pow(valorRSA, d) % n);
        int codigoInt = Double.valueOf(codigo).intValue();       
        char letra = (char) (codigo);
        mensajeDescifrado.append(letra);
    }
    
    return mensajeDescifrado.toString();
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return verificador.verificarASCII(texto);
  } 
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificarTextoEntrada(codigo);
  }
  
  /***
   * Métod generarNumeroPrimo
   * Se encarga de generar un numero primo aleatorio
   * @param --
   * @return int: Devuelve un valor numérico primo
   */
  public static int generarNumeroPrimo() {
    Random num = new Random();
    int numeroAleatorio;
    
    do {
       numeroAleatorio = num.nextInt(Integer.MAX_VALUE);
       
    } while (!esPrimo(numeroAleatorio));
    
    return numeroAleatorio;
  }
  
  /***
   * Métod generarNumero
   * Se encarga de generar un número aleatorio que sea coprimo con el valor euler
   * @param limite
   * @return int: Devuelve un valor numérico
   */
  public static int generarNumeroCoPrimo(int limite) {
    Random num = new Random();
    int numeroAleatorio;
    
    do { 
       numeroAleatorio = num.nextInt(limite);
       
    } while (!esCoPrimo(numeroAleatorio, limite));
    
    return numeroAleatorio;
  }
  
  /***
   * Métod generarNumeroD
   * Se encarga de generar un valor que cumpla la condición de divisibilidad de euler
     * @param eAux
     * @param eulerAux
   * @param --
   * @return int: Devuelve un valor numérico
   */
  public static int generarNumeroD(int eAux, int eulerAux) {
    Random num = new Random();
    int numeroAleatorio;
    
    do {
       numeroAleatorio = num.nextInt(Integer.MAX_VALUE);
       
    } while (!esDivisiblePorEuler(numeroAleatorio, eAux, eulerAux));
    
    return numeroAleatorio;
  }
  
  /***
   * Métod esPrimo
   * Se encarga de verificar si el número ingresado es un primo
   * @param numero
   * @return boolean: Devuelve true si el número es primo, de lo contrario devuelve un false
   */
  public static boolean esPrimo(int numero) {
    if (numero <= 1) {
      return false;
    }
    
    for(int i = 2; i <= Math.sqrt(numero); i++) {
        if (numero % i == 0) {
          return false;
        }
    }
    
    return true;
  }
  
  /***
   * Métod esCoPrimo
   * Se encarga de verificar si el número ingresado es un primo
   * @param a
   * @param b
   * @return boolean: Devuelve true si el número es primo, de lo contrario devuelve un false
   */
  public static boolean esCoPrimo(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    
    return a == 1;
  }
  
  /***
   * Métod esDivisiblePorEuler
   * Se encarga de verificar si el número ingresado cumple con la condición de divisbilidad de Euler
   * @param numero
   * @param a
   * @param b
   * @return boolean: Devuelve true si el número cumple la condición, de lo contrario devuelve un false
   */
  public static boolean esDivisiblePorEuler(int numero, int a, int b) {
      return ((numero * a) - 1) % b == 0;
  }
  
  public Integer getClave1(){
    return claveN;
  }
  
  public Integer getClave2(){
    return claveD;
  }
}
