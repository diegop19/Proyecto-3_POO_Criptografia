package util;
import java.util.regex.Pattern;

/**
 * Singleton Verificador
 * @authors Diego Araya y Raul Alfaro
 */
public class Verificador {
  private static Verificador instance;
  
  private Verificador(){
  }
 
 /***
  * Método getInstance()
  * @return instance: Devuelve la instancia creada, si no la hay, genera una nueva y la devuelve
  */
 public static Verificador getInstance() {
    if (instance == null) {
      instance = new Verificador();
    }
    return instance;
  }
  
    /**
     * Metodo VerificarAbecedario
     * Encargado de verificar si el texto ingresado esta compuesto unicamente
     * por el abecedario y espacios.
     * @param input
     * @return Boolean
     */
  public boolean  verificarAbecedario(String input){
    return input.matches("^[a-zA-Z ]*$"); 
  }
  
  /**
   * Metodo verificarASCII()
   * Encagado de verificar si el texto se compone de caracteres validos de la tabla ASCII
   * @param input
   * @return Boolean
   */
  public boolean verificarASCII(String input){
    Pattern ascii = Pattern.compile("^[ -~]*$");
    return ascii.matcher(input).matches();
  }
  
  /**
   * Metodo verificarBinario()
   * Encargado de verificar que el texto este compuesto por valores binarios, por "*" o esapcios en blanco. 
   * @param input
   * @return Boolean
   */
  public boolean verificarBinario(String input){
    String patron = "^[01* ]*$";
    return Pattern.matches(patron, input);
  }
  
  /**
   * Metodo verificarNumero()
   * Encargado de verificar que texto este compuesto por numeros por "*" y espacios en blanco
   * @param input
   * @return Boolean
   */
  public boolean verificarNumeros(String input){
    String patron = "^[0-9* ]*$";
    return Pattern.matches(patron, input);
  }
  
}
