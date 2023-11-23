package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cifrado Vigenere
 * @authors Diego Araya & Raul Alfaro
 */
public class Vigenere extends Criptografia{
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica Vigenere
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){
      texto = texto.toUpperCase();
      int clave = 23;
      boolean flag = true;
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
          
          if (flag) {
              if (Character.isLetter(letra)) {
                  int claveNum = clave / 10;
             
                  int letraNum = letra - 'A';
             
                  int codigo = (letraNum + claveNum) % 26;
             
                  char letraCifrada = (char) ('A' + codigo);
             
                  mensajeCifrado.append(letraCifrada);
                  flag = false;
                  
              } else {
                mensajeCifrado.append(letra);
                flag = true;
              } 
              
          } else {
            if (Character.isLetter(letra)) {
                int claveNum = clave % 10;
             
                int letraNum = letra - 'A';
             
                int codigo = (letraNum + claveNum) % 26;
             
                char letraCifrada = (char) ('A' + codigo);
             
                mensajeCifrado.append(letraCifrada);
                flag = true;
                
            } else {
               mensajeCifrado.append(letra);
               flag = true;
            }
          }
      }
      return mensajeCifrado.toString();
  }
  
  /***
   * Método desencriptar
   * Se encarga de el desencriptar el mensaje que recibe mediante la técnica Vigenere
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena string
   */
  @Override
  public  String desencriptar(String texto){
      texto = texto.toUpperCase();
      int clave = 23;
      boolean flag = true;
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
          
          if (flag) {
              if (Character.isLetter(letra)) {
                  int claveNum = clave / 10;
             
                  int letraNum = letra - 'A';
             
                  int codigo = (letraNum - claveNum + 26) % 26;
             
                  char letraCifrada = (char) ('A' + codigo);
             
                  mensajeCifrado.append(letraCifrada);
                  flag = false;
                  
              } else {
                mensajeCifrado.append(letra);
                flag = true;
              } 
              
          } else {
            if (Character.isLetter(letra)) {
                int claveNum = clave % 10;
             
                int letraNum = letra - 'A';
             
                int codigo = (letraNum - claveNum + 26) % 26;
             
                char letraCifrada = (char) ('A' + codigo);
             
                mensajeCifrado.append(letraCifrada);
                flag = true;
                
            } else {
               mensajeCifrado.append(letra);
               flag = true;
            }
          }
      }
      return mensajeCifrado.toString();
  }
  
}
