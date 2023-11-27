package modelo.cifradobinaro;

import modelo.Criptografia;
import java.util.HashMap;

/**
 * Class Binario
 * @authors Diego Araya y Raul Alfaro
 */
public class Binario extends Criptografia{
  
  /***
   * Método encriptar(String texto)
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
  
  /***
   * Método desencriptar(String texto)
   * Se encarga de encriptar el mensaje que recibe mediante la técnica binaria
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena string
   */
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
  
  /***
   * Método verificarCodigoEntrada(String codigo)
   * Se encarga de verificar que la entrada del encriptado se ingrese datos validos
   * @param codigo
   * @return 
   */
  @Override
  public boolean verificarCodigoEntrada(String codigo){
    return verificador.verificarBinario(codigo);
  }
  
  /***
   * Método obtenerBinario(char letra)
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
