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
      String tipoOperacion = (String) vista.boxTipoOperacion.getSelectedItem();
      String algoritmo = (String) vista.boxAlgoritmo.getSelectedItem();
      
      Criptografia Ncriptografia = seleccionarAlgoritmo(tipoOperacion);
      boolean verificar = Ncriptografia.verificarEntrada(entrada);
      // Aca verifica si los valores ingresados corresponden al tipo de encriptacion 
      // PENDIENTE:  es nesesario validar si lo que se ingresa es para codificar o decode,
      // pq las validaciones deberian ser diferentes
      
    }
  }
 
  public Criptografia seleccionarAlgoritmo(String pTipoOperacion){
    return switch (pTipoOperacion){
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

  
  
}
