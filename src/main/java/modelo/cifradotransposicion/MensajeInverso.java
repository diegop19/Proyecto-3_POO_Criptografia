package modelo.cifradotransposicion;

import modelo.Criptografia;

/**
 * Class Cifrado PalabraInversa
 * @authors Diego Araya & Raul Alfaro
 */
public class MensajeInverso extends Criptografia{
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica mensaje inverso
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){
    String[] palabras = texto.split(" ");
    StringBuilder mensajeCifrado = new StringBuilder();
    
    for(int i = palabras.length - 1; i >= 0; i--) {
        mensajeCifrado.append(invertirPalabra(palabras[i])).append(" ");
    }
    
    return mensajeCifrado.toString();
  }
  
  /***
   * Método desencriptar
   * Se encarga de desencriptar el mensaje que recibe mediante la técnica Vigenere
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena string
   */
  @Override
  public  String desencriptar(String texto){
    String[] palabras = texto.split(" ");
    StringBuilder mensajeCifrado = new StringBuilder();
    
    for(int i = palabras.length - 1; i >= 0; i--) {
        mensajeCifrado.append(invertirPalabra(palabras[i])).append(" ");
    }
    
    return mensajeCifrado.toString();
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return true;
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
    return true;
  }
  
  /***
   * Método encriptar
   * Se encarga de invertir la palabra que recibe. Esta función es llamada por las funciones encriptar y desencriptar
   * @param palabra
   * @return String: Devuelve la palabra invertida como una cadena de string
   */
  public String invertirPalabra(String palabra) {
    StringBuilder palabraInvertida = new StringBuilder();
    
    for(int i = palabra.length() - 1; i >= 0; i--) {
      palabraInvertida.append(palabra.charAt(i));
    }
    
    return palabraInvertida.toString();
  }
}
