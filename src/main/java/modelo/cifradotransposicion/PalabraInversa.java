package modelo.cifradotransposicion;

import modelo.Criptografia;

/**
 * Class Cifrado PalabraInversa
 * @authors Diego Araya & Raul Alfaro
 */
public class PalabraInversa extends Criptografia{
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica de palabra inversa
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){
      String[] palabras = texto.split(" ");
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(String palabra: palabras) {
          mensajeCifrado.append(invertirPalabra(palabra)).append(" ");
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
      StringBuilder mensajeDescifrado = new StringBuilder();
      
      for(String palabra: palabras) {
          mensajeDescifrado.append(invertirPalabra(palabra)).append(" ");
      }
      
      return mensajeDescifrado.toString();
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return true;
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
   return true;
  }
  
  public String invertirPalabra(String palabra) {
    StringBuilder palabraInvertida = new StringBuilder();
    
    for(int i = palabra.length() - 1; i >= 0; i--) {
      palabraInvertida.append(palabra.charAt(i));
    }
    
    return palabraInvertida.toString();
  }
  
}
