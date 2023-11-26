package modelo.cifradomoderno;

import modelo.Criptografia;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * Class DES
 * @authors Diego Araya & Raul Alfaro
 */
public class DES extends Criptografia{ 
  private SecretKey claveSecreta;
  
  /***
   * Método encriptar
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena String mediante la técnica RSA
   * @throws Exception 
   */
  @Override
  public  String encriptar(String texto) throws Exception{
    texto = texto.toUpperCase();
    StringBuilder mensajeCifrado = new StringBuilder();
    KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
    SecretKey secretKey = keyGenerator.generateKey();
    claveSecreta = secretKey;

    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    byte[] codigo = cipher.doFinal(texto.getBytes());

    String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(codigo);
    mensajeCifrado.append(mensajeCifradoBase64);
    
    return mensajeCifrado.toString();
  }
  
  /***
   * Método dsencriptar
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena String mediante la técnica RSA
   * @throws Exception 
   */
  @Override
  public  String desencriptar(String texto) throws Exception {
    texto = texto.toUpperCase();
    StringBuilder mensajeDescifrado = new StringBuilder();
    SecretKey clave = getClaveSecreta();
    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    
    cipher.init(Cipher.DECRYPT_MODE, clave);
    byte[] codigo = cipher.doFinal(Base64.getDecoder().decode(texto));
    mensajeDescifrado.append(codigo);
    
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
