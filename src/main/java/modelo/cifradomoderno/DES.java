package modelo.cifradomoderno;
import modelo.Criptografia;

/**
 * Class DES
 * @authors Diego Araya & Raul Alfaro
 */
public class DES extends Criptografia{
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
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificarTextoEntrada(codigo);
  }
}
