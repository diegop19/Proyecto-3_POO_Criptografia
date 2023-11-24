package modelo.cifradomoderno;
import modelo.Criptografia;

/**
 * Class AES
 * @authors Diego Araya & Raul Alfaro
 */
public class AES extends Criptografia{
    
  public AES(){}  
  
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
