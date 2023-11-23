package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class CifradoLlave
 * @authors Diego Araya & Raul Alfaro
 */

public class Llave extends Criptografia{
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica de Llave
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){
      texto = texto.toUpperCase();
      String clave = "TANGO";
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(int i = 0, j = 0; i < texto.length(); i++) {
          
          if (j > clave.length()) {
            j = 0;
          }
          
          char letra = texto.charAt(i);
          char claveLetra = clave.charAt(j);
          
          if (Character.isLetter(letra)) {
             int letraNum = letra - 'A';
             int claveNum = claveLetra - 'A';
             
             int codigo = (letraNum + claveNum) % 26;
             
             char letraCifrada = (char) ('A' + codigo);
             
             mensajeCifrado.append(letraCifrada);
             j++;
             
          } else {
            mensajeCifrado.append(letra);
          }
      }
      return mensajeCifrado.toString();
  }
  
  /***
   * Método desencriptar
   * Se encarga de el encriptar el mensaje que recibe mediante la técnica de Llave
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena string
   */
  @Override
  public  String desencriptar(String texto){
      texto = texto.toUpperCase();
      String clave = "TANGO";
      StringBuilder mensajeDescifrado = new StringBuilder();
      
      for(int i = 0, j = 0; i < texto.length(); i++) {
          
          if (j > clave.length()) {
            j = 0;
          }
          
          char letra = texto.charAt(i);
          char claveLetra = texto.charAt(j);
          
          if (Character.isLetter(letra)) {
             int letraNum = letra - 'A';
             int claveNum = claveLetra - 'A';
             
             int codigo = (letraNum - claveNum + 26) % 26;
             
             char letraDescifrada = (char) ('A' + codigo);
             
             mensajeDescifrado.append(letraDescifrada);
             j++;
             
          } else {
            mensajeDescifrado.append(letra);
          }
      }
      return mensajeDescifrado.toString();
  }
  
}
