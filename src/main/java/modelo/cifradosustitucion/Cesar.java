package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cesar
 * @authors Diego Araya & Raul Alfaro
 */
public class Cesar extends Criptografia{

  @Override
  public  String encriptar(String texto){
  return "ola cesar encriptao";
  }
  
  @Override
  public  String desencriptar(String texto){
    return "ola cesar desencriptao";
  }
 
}
