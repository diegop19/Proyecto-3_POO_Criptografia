package modelo.cifradotelefonico;
import modelo.Criptografia;
import java.util.HashMap;

/**
 * Class CodigoTelefonico
 * @authors Diego Araya y Raul Alfaro
 */
public class CodigoTelefonico extends Criptografia {
    
  /***
   * Método HashMap
   * Instancia cada palabra del Alfabeto con su respectivo código telefónico
   * @return String: Devuelve la llave o el codigo según como se acceda
   */
  private static final HashMap<Character, String> teclado = new HashMap<>();

    static {
        teclado.put('A', "21");
        teclado.put('B', "22");
        teclado.put('C', "23");
        teclado.put('D', "31");
        teclado.put('E', "32");
        teclado.put('F', "33");
        teclado.put('G', "41");
        teclado.put('H', "42");
        teclado.put('I', "43");
        teclado.put('J', "51");
        teclado.put('K', "52");
        teclado.put('L', "53");
        teclado.put('M', "61");
        teclado.put('N', "62");
        teclado.put('O', "63");
        teclado.put('P', "71");
        teclado.put('Q', "72");
        teclado.put('R', "73");
        teclado.put('S', "74");
        teclado.put('T', "81");
        teclado.put('U', "82");
        teclado.put('V', "83");
        teclado.put('W', "91");
        teclado.put('X', "92");
        teclado.put('Y', "93");
        teclado.put('Z', "94");
        teclado.put(' ', "*");
    }
    
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica telefónica
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena string
   */
  @Override
  public  String encriptar(String texto){
    texto = texto.toUpperCase();
    StringBuilder mensajeCifrado = new StringBuilder();
    
    for(int i = 0; i < texto.length(); i++) {
        char letra = texto.charAt(i);
        
        if (teclado.containsKey(letra)) {
            mensajeCifrado.append(teclado.get(letra)).append(" ");
        }
    }
    
    return mensajeCifrado.toString();
  }
  
  /***
   * Método encriptar
   * Se encarga de desencriptar el mensaje que recibe mediante la técnica Vigenere
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena string
   */
  @Override
  public  String desencriptar(String texto){
    StringBuilder mensajeDescifrado = new StringBuilder();
    texto = texto.toUpperCase();
    String[] codigos = texto.split(" ");
    
    for(String codigo: codigos) {
        for(Character key: teclado.keySet()) {
            if (teclado.get(key).equals(codigo)) {
                mensajeDescifrado.append(key);
                break;
            }
        }
        
        if (codigo.equals("*")) {
            mensajeDescifrado.append(" ");
        }
    }
    
    return mensajeDescifrado.toString();
  }
  
  /***
   * Método verificarCodigoEntrada(String codigo)
   * @param codigo
   * @return Boolean: Devuelve true si la entrada a desencriptar es válida, de lo contrario un false
   */
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificador.verificarNumeros(codigo);
  }

}
