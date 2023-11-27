package AppCrypto;

import controlador.ControladorCriptografia;
import vista.AppForm;

/**
 * Class CryptoMain
 * @author Diego Araya y Raul Alfaro
 */

public class CryptoMain {
    /***
     * Método Main
     * Este método se encarga de inicializar el proyecto cuando se ejecute 
     * @param args Una lista de String
     */
    public static void main (String[] args){
      AppForm form = new AppForm();
      ControladorCriptografia controlador = new ControladorCriptografia(form); // COntrolador 
      controlador.vista.setVisible(true);
      controlador.vista.setLocationRelativeTo(null);
    }
}
