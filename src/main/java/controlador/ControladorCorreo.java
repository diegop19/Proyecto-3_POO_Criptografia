package controlador;
import vista.CorreoForm;
import util.Correo;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author daray
 */
public class ControladorCorreo implements ActionListener{
  public CorreoForm vista;
  public String mensaje;
  
  /**
   * Connstructor de el ControladorCorreo
   * @param pVista 
     * @param pMensaje  
   */
  public ControladorCorreo(CorreoForm pVista,String pMensaje){
    this.vista = pVista;
    this.mensaje = pMensaje;
    this.vista.btEnviar.addActionListener(this);
   
  }
  
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
  
  public void enviarCorreo() throws IOException{
    if(!vista.datosCorrectos()){
      JOptionPane.showMessageDialog(vista, "Ingrese un Correo Electronico");
    }
    else{
      Correo correo = new Correo();
      String destinatario = vista.txtCorreo.getText();
      boolean enviado = correo.enviarCorreo(destinatario, mensaje);
      if(!enviado){
              JOptionPane.showMessageDialog(vista, "Ingrese un Correo Electronico");
      }
      else{
        JOptionPane.showMessageDialog(vista, "Correo Enviado correctamente");
      }
    }
  }
  
  
  
}
