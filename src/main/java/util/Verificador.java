package util;
import java.util.regex.Pattern;

/**
 * Class Verificador
 * @authors Diego Araya & Raul Alfaro
 */
public class Verificador {
  private static Verificador instance;
  
  private Verificador(){
  }
  
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
     * @return
     */
    public boolean  verificarAbecedario(String input){
    return input.matches("^[a-zA-Z ]*$"); 
  }
  
  public boolean verificarASCII(String input){
    Pattern ascii = Pattern.compile("^[ -~]*$");
    return ascii.matcher(input).matches();
  }
  
  public boolean verificarBinario(String input){
    String patron = "^[01* ]*$";
    return Pattern.matches(patron, input);
  }
  
  public boolean verificarNumeros(String input){
    String patron = "^[0-9* ]*$";
    return Pattern.matches(patron, input);
  }
  
}
