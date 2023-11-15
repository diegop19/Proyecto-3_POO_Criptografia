package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cesar
 * @authors Diego Araya & Raul Alfaro
 */
public class Cesar extends Criptografia{

  @Override
  public  String encriptar(String texto){
      int shift = 3;
      StringBuilder result = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
        char ch = texto.charAt(i);
        
        char encryptedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
        result.append(encryptedChar);
      }
      
      return result.toString();
  }
  
  @Override
  public  String desencriptar(String texto){
      int shift = 3;
      StringBuilder result = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
        char ch = texto.charAt(i);
        
        char desencryptedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
        result.append(desencryptedChar);
      }
      
      return result.toString();
  }
 
}
