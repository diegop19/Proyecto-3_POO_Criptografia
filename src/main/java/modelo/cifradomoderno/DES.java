package modelo.cifradomoderno;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import modelo.Criptografia;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Class DES
 * @authors Diego Araya & Raul Alfaro
 */
public class DES extends Criptografia{ 
  private SecretKey claveSecreta;
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica DES
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena String
   */
  @Override
  public  String encriptar(String texto){
    texto = texto.toUpperCase();
    StringBuilder mensajeCifrado = new StringBuilder();
    KeyGenerator keyGenerator;
      try {
          keyGenerator = KeyGenerator.getInstance("DES");
          SecretKey secretKey = keyGenerator.generateKey();
          claveSecreta = secretKey;
          Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

          cipher.init(Cipher.ENCRYPT_MODE, secretKey);
          byte[] codigo = cipher.doFinal(texto.getBytes());

          String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(codigo);
          mensajeCifrado.append(mensajeCifradoBase64);
          
      } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
          Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
      }
    return mensajeCifrado.toString();
  }
  
 /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica DES
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena String
   */
  @Override
  public  String desencriptar(String texto){
    StringBuilder mensajeDescifrado = new StringBuilder();
    SecretKey clave = getClaveSecreta();
    Cipher cipher;
      try {
          cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
          cipher.init(Cipher.DECRYPT_MODE, clave);
          byte[] codigo = cipher.doFinal(Base64.getDecoder().decode(texto));
          mensajeDescifrado.append(new String (codigo));
      } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
          Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
      }
    return mensajeDescifrado.toString();
  }
  
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return verificador.verificarASCII(texto);
  }
  
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificarTextoEntrada(codigo);
  }
  
  public SecretKey getClaveSecreta() {
    return claveSecreta;
  }
}
