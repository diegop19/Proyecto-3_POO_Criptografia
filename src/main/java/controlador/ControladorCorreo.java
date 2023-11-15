package controlador;
import vista.CorreoForm;
import util.Correo;
import javax.swing.*;
import java.awt.event.*;
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
      case "Enviar" -> enviarCorreo();
      default -> {}
    }
  }
  
  public void enviarCorreo(){
    Correo correo = new Correo();
    String destinatario = vista.txtCorreo.getText();
    correo.enviarCorreo(destinatario, mensaje);
  }
  
  
}
