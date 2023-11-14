package modelo.cifradobinaro;
import modelo.Criptografia;


/**
 * Class Binario
 * @authors Diego Araya & Raul Alfaro
 */
public class Binario extends Criptografia{
  
  @Override
  public  String encriptar(String texto){ 
    return "ola binario";
  }
  
  @Override
  public  String desencriptar(String texto){
    return "";
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
    return verificador.verificarBinario(codigo);
  }
  
  public String getAlgoritmo(){
    return "Binario";
  }
  
  
}
