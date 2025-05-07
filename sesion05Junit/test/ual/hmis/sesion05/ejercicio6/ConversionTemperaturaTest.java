package ual.hmis.sesion05.ejercicio6;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.sesion05.ejercicio3.Ejercicio3;

public class ConversionTemperaturaTest {

	@CsvSource({
		"0, celsius, fahrenheit, 32.0",
		"100, celsius, kelvin, 373.15",
		"32, fahrenheit, celsius, 0.0",
	    "212, fahrenheit, kelvin, 373.15",
	    "273.15, kelvin, celsius, 0.0",
	    "0, kelvin, fahrenheit, -459.67",

	    "25, celsius, celsius, 25.0",
	    "300, kelvin, kelvin, 300.0",
	    "77, fahrenheit, fahrenheit, 77.0",

	    "-274, celsius, kelvin, NaN",
	    "-500, fahrenheit, celsius, NaN",
	    "-1, kelvin, fahrenheit, NaN",

	    "100, patata, celsius, NaN",
	    "100, celsius, mango, NaN",
	  })
	  @ParameterizedTest(name = "{index} => Con {0} {1} sale {3} {2}")
	  void testConversionTemperatura(double initTemperature, String fromUnit, String toUnit, 
			  double finalTemperature) {
	  
	    ConversionTemperatura ct = new ConversionTemperatura();
	    
	    // Incluye un delta como margen de error 0.0001
	    assertEquals(finalTemperature, ct.convertTemperature(initTemperature, fromUnit, toUnit), 0.0001);  
	  }
}
