package ual.hmis.sesion05.ejercicio3;

public class Ejercicio3 {

  /**
   * The method ocultPassword.
   * 
   * It is used to hide the password.
   * 
   * @param password
   * @return The password hidden.
   */
  public String ocultPassword(String password){
    if(password.length() < 5) {
      return "password demasiado corto";
    } else if(password.length() >= 5 && password.length() <= 8) {
      return "********";
    } else if(password.length() >= 12 && password.length() <= 40) {
      return "************";
    } else if(password.length() > 40) {
      return "password demasiado largo";
    } 

    return password.replaceAll(".", "*");
     
  }
}
