package modelo.cifradotelefonico;
import modelo.Criptografia;

/**
 * Class CodigoTelefonico
 * @authors Diego Araya & Raul Alfaro
 */
public class CodigoTelefonico extends Criptografia {
  @Override
  public  String encriptar(String texto){
    return "";
  }
  
  @Override
  public  String desencriptar(String texto){
    return "";
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificador.verificarNumeros(codigo);
  }
}
