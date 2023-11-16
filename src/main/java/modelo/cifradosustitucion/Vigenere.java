package modelo.cifradosustitucion;

import modelo.Criptografia;

/**
 * Class Cifrado Vigenere
 * @authors Diego Araya & Raul Alfaro
 */
public class Vigenere extends Criptografia{
    
  @Override
  public  String encriptar(String texto){
      texto = texto.toUpperCase();
      int clave = 23;
      boolean flag = true;
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
          
          if (flag) {
              if (Character.isLetter(letra)) {
                  int claveNum = clave / 10;
             
                  int letraNum = letra - 'A';
             
                  int codigo = (letraNum + claveNum) % 26;
             
                  char letraCifrada = (char) ('A' + codigo);
             
                  mensajeCifrado.append(letraCifrada);
                  flag = false;
                  
              } else {
                mensajeCifrado.append(letra);
                flag = true;
              } 
              
          } else {
            if (Character.isLetter(letra)) {
                int claveNum = clave % 10;
             
                int letraNum = letra - 'A';
             
                int codigo = (letraNum + claveNum) % 26;
             
                char letraCifrada = (char) ('A' + codigo);
             
                mensajeCifrado.append(letraCifrada);
                flag = true;
                
            } else {
               mensajeCifrado.append(letra);
               flag = true;
            }
          }
      }
      return mensajeCifrado.toString();
  }
  
  @Override
  public  String desencriptar(String texto){
      texto = texto.toUpperCase();
      int clave = 23;
      boolean flag = true;
      StringBuilder mensajeCifrado = new StringBuilder();
      
      for(int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
          
          if (flag) {
              if (Character.isLetter(letra)) {
                  int claveNum = clave / 10;
             
                  int letraNum = letra - 'A';
             
                  int codigo = (letraNum - claveNum + 26) % 26;
             
                  char letraCifrada = (char) ('A' + codigo);
             
                  mensajeCifrado.append(letraCifrada);
                  flag = false;
                  
              } else {
                mensajeCifrado.append(letra);
                flag = true;
              } 
              
          } else {
            if (Character.isLetter(letra)) {
                int claveNum = clave % 10;
             
                int letraNum = letra - 'A';
             
                int codigo = (letraNum - claveNum + 26) % 26;
             
                char letraCifrada = (char) ('A' + codigo);
             
                mensajeCifrado.append(letraCifrada);
                flag = true;
                
            } else {
               mensajeCifrado.append(letra);
               flag = true;
            }
          }
      }
      return mensajeCifrado.toString();
  }
  
}
