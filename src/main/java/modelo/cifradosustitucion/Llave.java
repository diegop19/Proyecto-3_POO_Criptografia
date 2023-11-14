package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class CifradoLlave
 * @authors Diego Araya & Raul Alfaro
 */
public class Llave extends Criptografia{
  @Override
  public  String encriptar(String texto){
  return "";
  }
  
  @Override
  public  String desencriptar(String texto){
    return "";
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return false;
  }
  
  public boolean verificarCodigoEntrada(String codigo){
     return false ;
  }
}
