package controlador;
import modelo.*;
import vista.AppForm;
import javax.swing.*;
import java.awt.event.*;
import modelo.cifradobinaro.*;
import modelo.cifradomoderno.*;
import modelo.cifradosustitucion.*;
import modelo.cifradotelefonico.*;
import modelo.cifradotransposicion.*;


/**
 * Class ControloadorCriptografia
 * @authors Diego Araya & Raul Alfaro
 */
public class ControladorCriptografia implements ActionListener{
  public AppForm vista;
  public Criptografia criptografia;
  public String tipoOperacion;
  
  public ControladorCriptografia(AppForm pVista){
    this.vista = pVista;
    
    this.vista.btAplicarAlgoritmo.addActionListener(this);
    this.vista.btLimpiarTxt.addActionListener(this);
    this.vista.btEnviarPorCorreo.addActionListener(this);
    this.vista.btSALIR.addActionListener(this);

  }
  
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
        case "Aplicar Algoritmo":
            //aplicarAlgoritmo();
            break;
        case "Limpiar Texto":
            //Limpiartxt;
            break;
        case "Enviar por Correo":
            //enviarcorreo;
            break;
        case "SALIR":
            vista.salir();
            break;
        default:
            break;
    
    }
  }
  
  public void aplicarAlgoritmo(){
    if(!vista.datosCorrectos()){
      JOptionPane.showMessageDialog(vista, "Todos lo datos son requeridos");
    }
    else{
      String entrada = vista.txtEntrada.getText();
      String algoritmo = (String) vista.boxAlgoritmo.getSelectedItem();
      
      tipoOperacion = (String) vista.boxTipoOperacion.getSelectedItem();
      criptografia = seleccionarAlgoritmo(algoritmo);
      
      if(verificarEntrada(entrada)){}
      
      
     
      
    }
  }
 
  public Criptografia seleccionarAlgoritmo(String pAlgoritmo){
    return switch (pAlgoritmo){
       case "Cesár" -> new Cesar();
       case "Llave" -> new Llave();
       case "Vigenére" -> new Vigenere();
       case "Palabra Inversa" -> new PalabraInversa();
       case "Mensaje Inverso" -> new MensajeInverso();
       case "Codificación Binaria" -> new Binario();
       case "RSA" -> new RSA();
       case "DES" -> new DES();
       case "AES" -> new AES();
       default -> null;
    };
  }
  
public boolean verificarEntrada(String pEntrada){
  boolean datosCorrectos;
  return switch(tipoOperacion){
      case "Encriptar" -> datosCorrectos = criptografia.verificarTextoEntrada(pEntrada);
      case "Desencriptar" -> datosCorrectos = criptografia.verificarCodigoEntrada(pEntrada);
      default -> false;
  };

}

  
  
}
