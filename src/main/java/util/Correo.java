package util;

import java.util.Properties;   
import javax.mail.internet.*;
import javax.mail.*; 
import java.io.IOException;
import org.apache.http.client.fluent.*;
import org.json.*;

/**
 * Class Correo
 * @authors Diego Araya y Raul Alfaro
 */
public class Correo {
  private final String USUARIO = "encrpytapp@gmail.com";  //Correo electronico de la app
  private final String CLAVE = "tdlm wvli jmko rkjx";     // token de acceso 
  private Properties propiedades;
  
  /***
   * Constructor de la clase
   */
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
   * @return true si se envio correctamente, false si no 
   * @throws java.io.IOException
   */
  public boolean enviarCorreo(String destinario,String mensaje) throws IOException {
    if(!verificarCorreo(destinario)){  // Verifica que el correo sea valido. 
      return false;
    }
    else{
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

          message.setSubject("Mensaje Cifrado");
          message.setText(mensaje);  

          // Envia el mensaje
          Transport.send(message);
          
        }
        catch (MessagingException e) {
          e.printStackTrace();
        }
        return true;
    }
    
  }
  
  /**
   * Metodo verificarCorreo()
   * Se Utiliza la API "abstract" para la verificacion de los correos electronicos. 
   * @param email
   * @return true si el correo es valido, false si no.
   * @throws IOException 
   */
  private boolean verificarCorreo(String email) throws IOException{
    String uri = "https://emailvalidation.abstractapi.com/v1/?api_key=abdc67fa23e24938974cdd3a107c5d42&email=" + email;
    try{
      Content content = Request.Get(uri).execute().returnContent();
      JSONObject jsonContent = new JSONObject(content.toString());
      
      String deliverability = jsonContent.getString("deliverability");
      
      JSONObject jsonSmtpValid = jsonContent.getJSONObject("is_smtp_valid");
      boolean smtpValid = jsonSmtpValid.getBoolean("value");
      
      JSONObject jsonFormat = jsonContent.getJSONObject("is_valid_format");
      boolean format = jsonFormat.getBoolean("value");
      
      if("DELIVERABLE".equals(deliverability) && smtpValid && format){  // Verifica el formato, el protocolo smtp y si es enviable 
        return true;
      }     
    }
    catch(IOException error){
    }
    return false;
  }
  
}