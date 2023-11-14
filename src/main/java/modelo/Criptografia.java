package modelo;

/**
 * Abstract Class Criptografia
 * @authors Diego Araya & Raul Alfaro
 */
public abstract class Criptografia {
    
    /**
     * Metodos Abstractos Encriptar y DesEncriptar
     * @param texto
     * @return String
     */
  public abstract String encriptar(String texto);
  public abstract String desencriptar(String texto);
  public abstract boolean verificarTextoEntrada(String texto); 
  public abstract boolean verificarCodigoEntrada(String texto); 
  
}
