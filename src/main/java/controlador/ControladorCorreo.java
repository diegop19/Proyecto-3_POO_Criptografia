package controlador;
import vista.CorreoForm;
import util.Correo;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class ControladorCorreo
 * @author Diego Araya y Raul Alfaro
 */
public class ControladorCorreo implements ActionListener{
  public CorreoForm vista;
  public String mensaje;
  
  /**
   * Constructor de el ControladorCorreo
   * @param pVista vista del correo
     *@param pMensaje Mensaje del correo
   */
  public ControladorCorreo(CorreoForm pVista,String pMensaje){
    this.vista = pVista;
    this.mensaje = pMensaje;
    this.vista.btEnviar.addActionListener(this);
  }
  
  /**
   * Metodo actionPerformed de la clase AcionListener
   * @param e Parámetro de instancia de ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()){
      case "Enviar" -> {
            try {
                enviarCorreo();
            } catch (IOException ex) {
                Logger.getLogger(ControladorCorreo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      default -> {}
    }
  }
  
  /**
   * Metodo enviarCorreo()
   * @throws IOException 
   */
  public void enviarCorreo() throws IOException{
    if(!vista.datosCorrectos()){                  //Verifica que el dato de entrada no este vacio
      JOptionPane.showMessageDialog(vista, "Ingrese un Correo Electronico");
    }
    else{
      Correo correo = new Correo();
      String destinatario = vista.txtCorreo.getText();
      boolean enviado = correo.enviarCorreo(destinatario, mensaje);  // Envia el correo desde un objeto de tipo Correo
      if(!enviado){     // Si no se pudo enviar, es probable que el correo haya sido invalido
              JOptionPane.showMessageDialog(vista, "El Correo ingresado es invalido. No se puede enviar el correo.");
      }
      else{
        JOptionPane.showMessageDialog(vista, "Correo Enviado correctamente");
      }
    }
  }
}
