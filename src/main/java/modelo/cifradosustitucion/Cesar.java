package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cesar
 * @authors Diego Araya & Raul Alfaro
 */
public class Cesar extends Criptografia{
      
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica césar
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){
      texto = texto.toUpperCase();
      int shift = 3;
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
          
          if (Character.isLetter(letra)) {
             char encryptedChar = (char) ((letra - 'A' + shift) % 26 + 'A');
             mensajeCifrado.append(encryptedChar);
             
          } else {
            mensajeCifrado.append(letra);
          }
      }
      
      return mensajeCifrado.toString();
  }
  
  /***
   * Método desencriptar
   * Se encarga de desencriprtar el mensaje que recibe mediante la técnica césar
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena string
   */
  @Override
  public  String desencriptar(String texto){
      texto = texto.toUpperCase();
      int shift = 3;
      StringBuilder mensajeDescifrado = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
          
          if (Character.isLetter(letra)) {
            char desencryptedChar = (char) ((letra - 'A' - shift + 26) % 26 + 'A');
            mensajeDescifrado.append(desencryptedChar);
            
          } else {
            mensajeDescifrado.append(letra);
          }
      }
      return  mensajeDescifrado.toString();
  }
 
}
