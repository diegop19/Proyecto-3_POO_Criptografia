package modelo;

import util.Verificador;

/**
 * Abstract Class Criptografia
 * @authors Diego Araya & Raul Alfaro
 */
public abstract class Criptografia {
    protected Verificador verificador = Verificador.getInstance();
    
    /**
     * Metodos Abstractos Encriptar y DesEncriptar
     * @param texto
     * @return String
     */
  public abstract String encriptar(String texto);
  public abstract String desencriptar(String texto);
  
  public boolean verificarTextoEntrada(String texto){
      return verificador.verificarAbecedario(texto);
  }
  public boolean verificarCodigoEntrada(String texto){
    return verificarTextoEntrada(texto);
  }
  
}
