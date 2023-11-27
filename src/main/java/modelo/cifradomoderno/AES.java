package modelo.cifradomoderno;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import modelo.Criptografia;
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
 * Class AES
 * @authors Diego Araya y Raul Alfaro
 */
public class AES extends Criptografia{ 
  private SecretKey claveSecreta;
  
  /***
   * Método encriptar
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena String mediante la técnica AES 
   */
  @Override
  public  String encriptar(String texto) {
    texto = texto.toUpperCase();
    StringBuilder mensajeCifrado = new StringBuilder();

    KeyGenerator keyGenerator;
      try {
          keyGenerator = KeyGenerator.getInstance("AES");
          keyGenerator.init(256);
          SecretKey secretKey = keyGenerator.generateKey();
          claveSecreta = secretKey;

          Cipher cipher = generarCipher();

          cipher.init(Cipher.ENCRYPT_MODE, secretKey);
          byte[] codigo = cipher.doFinal(texto.getBytes());

          String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(codigo);
          mensajeCifrado.append(mensajeCifradoBase64);
          
      } catch (Exception ex) {
          Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
      }

    return mensajeCifrado.toString();
  }
  
  
  /***
   * Método desencriptar
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena String mediante la técnica AES 
   */
  @Override
  public  String desencriptar(String texto) {
    StringBuilder mensajeDescifrado = new StringBuilder();

    SecretKey clave = getClaveSecreta();
    Cipher cipher;
      try {
          cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
          cipher.init(Cipher.DECRYPT_MODE, clave);
          byte[] codigo = cipher.doFinal(Base64.getDecoder().decode(texto));
          mensajeDescifrado.append(new String(codigo));
      } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
          Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
      }
    return mensajeDescifrado.toString();
  }
  
  /***
   * Método verificarTextoEntrada(String texto)
   * @param texto
   * @return Boolean: Devuelve true si la entrada a encriptar es válida, de lo contrario un false
   */
  @Override
  public  boolean verificarTextoEntrada(String texto){
    return verificador.verificarASCII(texto);
  }
  
  /***
   * Método verificarCodigoEntrada(String codigo)
   * @param codigo
   * @return Boolean: Devuelve true si la entrada a desencriptar es válida, de lo contrario un false
   */
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificarTextoEntrada(codigo);
  }
  
  /***
   * Método generarKey()
   * Se encarga de crear la instancia de la clave para el cifrado de tipo AES
   * @throws java.lang.Exception
   * @return KayGenerator: Devuelve la instancia como un objeto de tipo KayGenerator
   */
  public KeyGenerator generarKey() throws Exception {
    KeyGenerator clave = KeyGenerator.getInstance("AES");
    return clave;
  }
  
  /***
   * Método generarCipher()
   * Se encarga de crear la instancia del cifrado de tipo AES
   * @throws java.lang.Exception
   * @return Cipher: Devuelve la instancia como un objeto de tipo KayGenerator
   */
  public Cipher generarCipher() throws Exception {
     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
     return cipher;
  }
  
  /***
   * Método getClaveSecreta()
   * @return SecreyKey: Devuelve la clave guardada en la variable claveSecreta
   */
  public SecretKey getClaveSecreta() {
    return claveSecreta;
  }
}
