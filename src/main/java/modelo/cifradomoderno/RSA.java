package modelo.cifradomoderno;
import modelo.Criptografia;

/**
 * Class RSA
 * @authors Diego Araya & Raul Alfaro
 */

public class RSA extends Criptografia{
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
    return verificador.verificarASCII(texto);
  } 
  
  public boolean verificarCodigoEntrada(String codigo){
     return verificarTextoEntrada(codigo);
  }
}
