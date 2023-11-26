package modelo;
import util.Verificador;

/**
 * Abstract Class Criptografia
 * @authors Diego Araya & Raul Alfaro
 */
public abstract class Criptografia {
  protected Verificador verificador = Verificador.getInstance();  // Instancia unica de la clase Verificador. 
    
  /**
   * Metodos Abstractos encriptar y desencriptar
   * @param texto
   * @return String
     * @throws java.lang.Exception
  */
  public abstract String encriptar(String texto);
  public abstract String desencriptar(String texto);
  
  /**
   * Metodo concreto verificarTextoEntrada()
   * Encargado de verificar el caso más básico de entrada. 
   * Esto en el caso de que se desee encriptar.
   * @param texto
   * @return true si la verificacion fue exitosa, false si no. 
   */
  public boolean verificarTextoEntrada(String texto){
      return verificador.verificarAbecedario(texto);
  }
  
  /**
   * Metodo concreto verificarTextoEntrada()
   * Encargado de verificar el caso más básico de entrada. 
   * Esto en el caso de que se desee encriptar.
   * @param texto
   * @return true si la verificacion fue exitosa, false si no. 
   */
  public boolean verificarCodigoEntrada(String texto){
    return verificarTextoEntrada(texto);
  }
  
  @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  // Referencia al mismo objeto
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  // Tipos diferentes o objeto nulo
        }

        return true;  // Ambos objetos son de la misma clase
    }
}
