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
  
   /**
   * Metodo actionPerformed de la clase AcionListener
   * @param e 
   */
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
  
  /**
   * Metodo aplicarAlgoritmo()
   * Encargado de hacer las llamadas correspondientes para verificar
   * y aplicar el algoritmo especificado.
   */
  public void aplicarAlgoritmo(){
    if(!vista.datosCorrectos()){  // Verificar que la entrada no sea vacia 
      JOptionPane.showMessageDialog(vista, "La entrada no puede ser vacía");
    }
    else{
      String entrada = vista.txtEntrada.getText().replace("\n", ""); // remplaza los saltos de linea con caracter vacio 
  
      String algoritmo = (String) vista.boxAlgoritmo.getSelectedItem();  // algoritmo a utilizar
      
      tipoOperacion = (String) vista.boxTipoOperacion.getSelectedItem();  // tipo de operacion
      criptografia = seleccionarAlgoritmo(algoritmo);         // se inicializa criptografia con la clase correspondiente al algoritmo
      
      if(!verificarEntrada(entrada)){
        JOptionPane.showMessageDialog(vista, "El texto de entrada no es compatible con la operacion o el Algoritmo");
      }
      else{
        String salida = getSalida(entrada);
        mostrarResultado(salida);
      
      }
    }
  }
 
  /**
   * Metodo selccionarAlgoritmo()
   * Encargado de crear un objeto del tipo del algoritmo seleccionado
   * @param pAlgoritmo
   * @return Criptografia
   */
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
  
  /**
   * Metodo verificarEntrada()
   * Encargado de llamar a los metodos de verificacion de entradas
   * varía si se quiere encriptar o desencriptar. 
   * @param pEntrada
   * @return true si la entrada es valida, false si no 
   */
  public boolean verificarEntrada(String pEntrada){
    return switch(tipoOperacion){
      case "Encriptar" -> criptografia.verificarTextoEntrada(pEntrada);  // Aplicacion del concepto del polimorfismo Dinamico
      case "Desencriptar" -> criptografia.verificarCodigoEntrada(pEntrada); // Cada objeto reacciona diferente al mismo metodo de verificacion. 
      default -> false;
    };
  }

  /**
   * Metodo getSalida()
   * @param pEntrada
   * @return el texto de salida a mostrar en pantalla
   */
  public String getSalida(String pEntrada){
    return switch(tipoOperacion){
      case "Encriptar" -> criptografia.encriptar(pEntrada);
      case "Desencriptar" -> criptografia.desencriptar(pEntrada);
      default -> "";
    };
  }
  
  /**
   * Metodo mostraResultado()
   * Muestra el resultado en pantalla
   * @param pSalida 
   */
  public void mostrarResultado(String pSalida){
    vista.txtSalida.setText(pSalida);
  }
  
  /**
   * MetodoLimpiarTXT()
   * Limpia el texto existente en los cuadros de texto
   */
  public void limpiarTxt(){
    vista.txtEntrada.setText("");
    vista.txtSalida.setText("");
  }
  
  /**
   * Metodo crearControladorCorreo()
   * Encargado de Crear un controlador para enviar correos
   */
  public void crearControladorCorreo(){
    if(vista.txtSalida.getText().isEmpty()){  // Verifica que la salida no sea vacia.
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
