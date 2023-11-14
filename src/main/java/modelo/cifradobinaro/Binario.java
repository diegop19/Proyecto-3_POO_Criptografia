package modelo.cifradobinaro;
import modelo.Criptografia;
import modelo.Verificador;

/**
 * Class Binario
 * @authors Diego Araya & Raul Alfaro
 */
public class Binario extends Criptografia{
  
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
      Verificador verificador = Verificador.getInstance(); // EJEMPLO
      boolean datosCorrectos = verificador.verficarASCII(texto);
    return false;
  }
  
  public boolean verificarCodigoEntrada(String codigo){
    return false ;
  }
  
  public String getAlgoritmo(){
    String msg = "Binario";
    return msg;
  }
  
  
}
