package modelo;

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
 
  public boolean  verficarASCII(String texto){
    // codigo para verificar que todos los cacarteres pertenezcan a la tabla ASCII
    return false;
  }
}
