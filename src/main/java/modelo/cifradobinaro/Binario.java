package modelo.cifradobinaro;

import modelo.Criptografia;
import java.util.HashMap;
import java.io.BufferedInputStream;
/**
 * Class Binario
 * @authors Diego Araya & Raul Alfaro
 */
public class Binario extends Criptografia{
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica binaria
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){ 
    texto = texto.toUpperCase();
    StringBuilder mensajeCifrado = new StringBuilder();
    HashMap<Character, String> mapaBinario = new HashMap();
    
    for(char letra = 'A'; letra <= 'Z'; letra++) {
        mapaBinario.put(letra, obtenerBinario(letra));
    }
    
    for(int i = 0; i < texto.length(); i++) {
        char letra = texto.charAt(i);
        
        if (Character.isLetter(letra)) {
        String binario = mapaBinario.get(Character.toUpperCase(letra));
        mensajeCifrado.append(binario).append(" ");
        
        } else {
          mensajeCifrado.append(" * ");
        }
    }
    
    return mensajeCifrado.toString();
  }
  
  @Override
  public  String desencriptar(String texto){
    String[] codigo = texto.split(" ");
    StringBuilder mensajeDescifrado = new StringBuilder();
    HashMap<String, Character> mapaBinario = new HashMap();
    
    for(char letra = 'A'; letra <= 'Z'; letra++) {
        String binario = String.format("%5s", Integer.toBinaryString(letra - 'A')).replace(' ', '0');
        mapaBinario.put(binario,letra);
    }
    
    for(String binario: codigo) {
        if (mapaBinario.containsKey(binario)) {
          char letra = mapaBinario.get(binario);
          mensajeDescifrado.append(letra);
          
        } else {
           mensajeDescifrado.append(" ");
}
    }
    
    return mensajeDescifrado.toString();
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
    return verificador.verificarBinario(codigo);
  }
  
  /***
   * Método obtenerBinario
   * Se encarga de obtener el valor binario de la letra que se ingresa de acuerdo a su posición en el alfabeto
   * Esta método es llamado por la función encriptar
   * @param letra
   * @return String: Devuelve el valor binario de la letra como un String
   */
  public static String obtenerBinario(char letra) {
    int valor = letra - 'A';
    return String.format("%5s", Integer.toBinaryString(valor)).replace(' ', '0');
  }
  
}
