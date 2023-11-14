package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cifrado Vigenere
 * @authors Diego Araya & Raul Alfaro
 */
public class Vigenere extends Criptografia{
  @Override
  public  String encriptar(String texto){
    return "ola vigenere";
  }
  
  @Override
  public  String desencriptar(String texto){
    return "";
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return true;
  }
  
  public boolean verificarCodigoEntrada(String codigo){
     return false ;
  }
  
}
