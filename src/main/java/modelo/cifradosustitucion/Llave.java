package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class CifradoLlave
 * @authors Diego Araya & Raul Alfaro
 */
public class Llave extends Criptografia{
  @Override
  public  String encriptar(String texto){
      String clave = "tango";
      StringBuilder result = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char ch = texto.charAt(i);
          
          switch (ch) {        
           // xd
          }
      }
  return "";
  }
  
  @Override
  public  String desencriptar(String texto){
    return "";
  }
  
}
