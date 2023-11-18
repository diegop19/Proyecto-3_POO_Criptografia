package controlador;
import modelo.*;
import vista.*;
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
  
  /**
   * Connstructor de el ControladorCriptografia
   * @param pVista 
   */
  public ControladorCriptografia(AppForm pVista){
    this.vista = pVista;
    
    this.vista.btAplicarAlgoritmo.addActionListener(this);
    this.vista.btLimpiarTxt.addActionListener(this);
    this.vista.btEnviarPorCorreo.addActionListener(this);
    this.vista.btSALIR.addActionListener(this);

  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
        case "Aplicar Algoritmo" -> aplicarAlgoritmo();
        case "Limpiar Texto" -> limpiarTxt();
        case "Enviar por Correo" -> crearControladorCorreo();
        case "SALIR" -> vista.salir();
        default -> {}
    }
  }
  
  public void aplicarAlgoritmo(){
    if(!vista.datosCorrectos()){
      JOptionPane.showMessageDialog(vista, "La entrada no puede ser vacía");
    }
    else{
      String entrada = vista.txtEntrada.getText().replace("\n", "");
      
      System.out.println(entrada);
      String algoritmo = (String) vista.boxAlgoritmo.getSelectedItem();
      
      tipoOperacion = (String) vista.boxTipoOperacion.getSelectedItem();
      criptografia = seleccionarAlgoritmo(algoritmo);
      
      if(!verificarEntrada(entrada)){
        JOptionPane.showMessageDialog(vista, "El texto de entrada no es compatible con la operacion o el Algoritmo");
      }
      else{
        String salida = getSalida(entrada);
        mostrarResultado(salida);
      
      }
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
       case "Codificacion por Código Telefónico" -> new CodigoTelefonico();
       case "RSA" -> new RSA();
       case "DES" -> new DES();
       case "AES" -> new AES();
       default -> null;
    };
  }
  
public boolean verificarEntrada(String pEntrada){
  return switch(tipoOperacion){
      case "Encriptar" -> criptografia.verificarTextoEntrada(pEntrada);
      case "Desencriptar" -> criptografia.verificarCodigoEntrada(pEntrada);
      default -> false;
  };
}

public String getSalida(String pEntrada){
  return switch(tipoOperacion){
      case "Encriptar" -> criptografia.encriptar(pEntrada);
      case "Desencriptar" -> criptografia.desencriptar(pEntrada);
      default -> "";
  };
}

public void mostrarResultado(String pSalida){
  vista.txtSalida.setText(pSalida);
}

public void limpiarTxt(){
  vista.txtEntrada.setText("");
  vista.txtSalida.setText("");
}

public void crearControladorCorreo(){
   if(vista.txtSalida.getText().isEmpty()){
     JOptionPane.showMessageDialog(vista, "Para enviar un correo es nesesaria una salida");
   }
   else{
      CorreoForm form = new CorreoForm();
      ControladorCorreo controlador = new ControladorCorreo(form,vista.txtSalida.getText());
      controlador.vista.setVisible(true);
      controlador.vista.setLocationRelativeTo(null);
   }
}
  
  
}
