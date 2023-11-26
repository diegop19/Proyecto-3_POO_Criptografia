package AppCrypto;

import controlador.ControladorCriptografia;
import vista.AppForm;

public class CryptoMain {
    public static void main (String[] args){
      AppForm form = new AppForm();
      ControladorCriptografia controlador = new ControladorCriptografia(form); // COntrolador 
      controlador.vista.setVisible(true);
      controlador.vista.setLocationRelativeTo(null);
    }
}
