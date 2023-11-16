package util;

import java.util.Properties;   
import javax.activation.*;
import javax.mail.internet.*;
import javax.mail.*; 
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Class Correo
 * @authors Diego Araya & Raul Alfaro
 */
public class Correo {
  private final String USUARIO = "encrpytapp@gmail.com";
  private final String CLAVE = "tdlm wvli jmko rkjx";
  private Properties propiedades;
  private String apiKey = "test_6c414e8f38bc88f6740f";
  
  public Correo(){
    propiedades = new Properties();
  }
  
  /**
   * Método abrirSesion()
   * @return Session
   */
  private Session abrirSesion() { 
    Session sesion = Session.getInstance(propiedades,
      new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(USUARIO, CLAVE);
        }
        
    });
    return sesion; 
  }
  
  /**
   * Método enviarCorreo()
   * @param destinario : direccion del Correo
     * @param mensaje
   */
  public void enviarCorreo(String destinario,String mensaje) {
    propiedades.put("mail.smtp.host", "smtp.gmail.com");
    propiedades.put("mail.smtp.port", "587");
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    
    Session sesion = abrirSesion();
    
    try {
      // Crea el objeto mensaje y asigna a quien se le va al destinario y remitente
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(USUARIO));
      message.setRecipients(
        Message.RecipientType.TO,
        InternetAddress.parse(destinario));
      
      message.setSubject("Mensaje Encriptado");
      message.setText(mensaje);
      
      // Envia el mensaje
      Transport.send(message);
    }
    catch (MessagingException e) {
      e.printStackTrace();
    }
    
  }
  
  private void verificarCorreo(){
  
  
  }
  
}