package ual.hmis.sesion05.ejercicio3;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Ejercicio3Test {
  
  @CsvSource({
    "abc , password demasiado corto",
    "abcd , password demasiado corto",
    "abcde, ********", // Longitud 5
    "abcdef, ********", // Longitud 6
    "abcdefg, ********", // Longitud 7
    "abcdefgh, ********", // Longitud 8
    "abcdefghi, *********",
    "abcdefghij, **********",
    "abcdefghijklmno, ************",
    "abcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmno, password demasiado largo",
    "abcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmno, password demasiado largo",
  })
  @ParameterizedTest(name = "{index} => Con password ({0}) sale {1}")
  void testOcultPassword(String password, String result) {
    // Arrange
    Ejercicio3 e3 = new Ejercicio3();
    // Act
    // Assert
    assertEquals(result, e3.ocultPassword(password));
  
  }
}
