package ual.hmis.sesion05.ejercicio6;

public class ConversionTemperatura {

	/**
	 * Method convertTemperature
	 * 
	 * Make a conversion between different units of temperature, including 
	 * Celsius, Fahrenheit and Kelvin.
	 * 
	 * @param temperature	The temperature in the initial unit.
	 * @param fromUnit	The initial unit.
	 * @param toUnit	The objective unit.
	 * @return	The temperature in the objective unit.
	 */
	public double convertTemperature(double temperature, String fromUnit, String toUnit) {
		fromUnit = fromUnit.toLowerCase();
	    toUnit = toUnit.toLowerCase();
	    
	    if(fromUnit.equals(toUnit)) return temperature;
		
	    if(fromUnit.equals("celsius")) {
	    	if(fromUnit.equals("fahrenheit")) return convertTemperatureCelsiusFahrenheit(temperature);
	    	if(fromUnit.equals("kelvin")) return convertTemperatureCelsiusKelvin(temperature);
	    }
	    
	    if(fromUnit.equals("kelvin")) {
	    	if(fromUnit.equals("fahrenheit")) return convertTemperatureKelvinFahrenheit(temperature);
	    	if(fromUnit.equals("celsius")) return convertTemperatureKelvinCelsius(temperature);
	    }
	    
	    if(fromUnit.equals("fahrenheit")) {
	    	if(fromUnit.equals("kelvin")) return convertTemperatureKelvinFahrenheit(temperature);
	    	if(fromUnit.equals("celsius")) return convertTemperatureKelvinCelsius(temperature);
	    }
	    
	    return Double.NaN;
	}
	
	/**
	 * Method convertTemperatureCelsiusFahrenheit
	 * 
	 * Define the formula to convert Celsius to Fahrenheit
	 */
	public double convertTemperatureCelsiusFahrenheit(double temperature) {
		if(temperature < -273.15) { // inferior limit of Celsius
			return Double.NaN;
		}
		
		return (temperature * 9/5) + 32;
	}
	
	/**
	 * Method convertTemperatureCelsiusKelvin
	 * 
	 * Define the formula to convert Celsius to Kelvin
	 */
	public double convertTemperatureCelsiusKelvin(double temperature) {
		if(temperature < -273.15) { // inferior limit of Celsius
			return Double.NaN;
		}
		
		return temperature + 273.15;
	}
		
	/**
	 * Method convertTemperatureKelvinCelsius
	 * 
	 * Define the formula to convert Kelvin to Celsius
	 */
	public double convertTemperatureKelvinCelsius(double temperature) {
	    if (temperature < 0) {  // inferior limit of Kelvin
	        return Double.NaN;
	    }

	    return temperature - 273.15;
	}

	/**
	 * Method convertTemperatureKelvinFahrenheit
	 * 
	 * Define the formula to convert Kelvin to Fahrenheit
	 */
	public double convertTemperatureKelvinFahrenheit(double temperature) {
	    if (temperature < 0) { // inferior limit of Kelvin
	        return Double.NaN;
	    }

	    return (temperature - 273.15) * 9/5 + 32;
	}
	
	/**
	 * Method convertTemperatureFahrenheitCelsius
	 * 
	 * Define the formula to convert Fahrenheit to Celsius
	 */
	public double convertTemperatureFahrenheitCelsius(double temperature) {
	    if (temperature < -459.67) { // inferior limit of Fahrenheit
	        return Double.NaN;
	    }

	    return (temperature - 32) * 5/9;
	}

	/**
	 * Method convertTemperatureFahrenheitKelvin
	 * 
	 * Define the formula to convert Fahrenheit to Kelvin
	 */
	public double convertTemperatureFahrenheitKelvin(double temperature) {
	    if (temperature < -459.67) {  // inferior limit of Fahrenheit
	        return Double.NaN;
	    }

	    return (temperature - 32) * 5/9 + 273.15;
	}
}
