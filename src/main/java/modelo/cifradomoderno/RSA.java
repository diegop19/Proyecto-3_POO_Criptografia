package modelo.cifradomoderno;

import java.security.InvalidKeyException;
import modelo.Criptografia;
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Class RSA
 * @authors Diego Araya y Raul Alfaro
 */

public class RSA extends Criptografia{
  private PublicKey claveN;
  private PrivateKey claveD;
  
  /***
   * Método encriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica RSA
   * @param texto
   * @return String: Devuelve el mensaje encriptado como una cadena String
   */
  @Override
  public  String encriptar(String texto){
    texto = texto.toUpperCase();
    StringBuilder mensajeCifrado = new StringBuilder();
    try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Tamaño de clave, puede variar
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey clavePublica = keyPair.getPublic();
            PrivateKey clavePrivada = keyPair.getPrivate();
            claveN = clavePublica;
            claveD = clavePrivada;
            
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
            byte[] textoEncriptado = cipher.doFinal(texto.getBytes());
            String mensaje = Base64.getEncoder().encodeToString(textoEncriptado);
            mensajeCifrado.append(mensaje);
            return mensajeCifrado.toString();
            
    } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
    }
    
    return mensajeCifrado.toString();
  }
  
  /***
   * Método desencriptar
   * Se encarga de encriptar el mensaje que recibe mediante la técnica RSA
   * @param texto
   * @return String: Devuelve el mensaje desencriptado como una cadena String
   */
  @Override
  public  String desencriptar(String texto){
    StringBuilder mensajeDescifrado = new StringBuilder();
    PrivateKey clavePrivada = getClave2();
    try {
         Cipher cipher = Cipher.getInstance("RSA");
         cipher.init(Cipher.DECRYPT_MODE, clavePrivada);
         byte[] textoEnBytes = Base64.getDecoder().decode(texto);
         byte[] textoDesencriptado = cipher.doFinal(textoEnBytes);
         mensajeDescifrado.append(new String(textoDesencriptado));
         return mensajeDescifrado.toString();
         
    } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        return null;
    }
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
   * Método verificarTextoEntrada(String codigo)
   * @param codigo
   * @return Boolean: Devuelve true si la entrada a desencriptar es válida, de lo contrario un false
   */
  @Override
  public boolean verificarCodigoEntrada(String codigo){
     return verificarTextoEntrada(codigo);
  }
  
  /***
   * Método getClave1()
   * @return PublicKey: Devuelve la clave guardada en la variable claveN
   */
  public PublicKey getClave1(){
    return claveN;
  }
  
  /***
   * Método getClave2()
   * @return PrivateKey: Devuelve la clave guardada en la variable claveD
   */
  public PrivateKey getClave2(){
    return claveD;
  }
}
