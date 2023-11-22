package modelo.cifradotransposicion;
import modelo.Criptografia;

/**
 * Class Cifrado PalabraInversa
 * @authors Diego Araya & Raul Alfaro
 */
public class MensajeInverso extends Criptografia{
  @Override
  public  String encriptar(String texto){
    String[] palabras = texto.split(" ");
    StringBuilder mensajeCifrado = new StringBuilder();
    
    for(int i = palabras.length - 1; i >= 0; i--) {
        mensajeCifrado.append(invertirPalabra(palabras[i])).append(" ");
    }
    
    return mensajeCifrado.toString();
  }
  
  @Override
  public  String desencriptar(String texto){
    String[] palabras = texto.split(" ");
    StringBuilder mensajeCifrado = new StringBuilder();
    
    for(int i = palabras.length - 1; i >= 0; i--) {
        mensajeCifrado.append(invertirPalabra(palabras[i])).append(" ");
    }
    
    return mensajeCifrado.toString();
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return true;
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
    return true;
  }
  
  public String invertirPalabra(String palabra) {
    StringBuilder palabraInvertida = new StringBuilder();
    
    for(int i = palabra.length() - 1; i >= 0; i--) {
      palabraInvertida.append(palabra.charAt(i));
    }
    
    return palabraInvertida.toString();
  }
}
