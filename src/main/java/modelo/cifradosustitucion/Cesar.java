package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cesar
 * @authors Diego Araya & Raul Alfaro
 */
public class Cesar extends Criptografia{

  @Override
  public  String encriptar(String texto){
  return "ola estoy funcionando";
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
