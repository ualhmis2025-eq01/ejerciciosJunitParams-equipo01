package ual.hmis;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.sesion05.ContadorDePalabras;

public class ContadorDePalabrasTest {
    
    @ParameterizedTest
    @CsvSource({
        "src/ual/hmis/sesion05/texto.txt"
    })
    public void testConstructor(String archivo) {
        ContadorDePalabras contador = new ContadorDePalabras(archivo);
        assertNotNull(contador, "El constructor no inicializa correctamente el objeto.");
    }

    @ParameterizedTest
    @CsvSource({
        "src/ual/hmis/sesion05/texto.txt"
    })
    public void testPalabrasOrdenadasAlfabeticamente(String archivo) throws IOException {
        ContadorDePalabras contador = new ContadorDePalabras(archivo);
        List<String> resultado = contador.palabrasOrdenadasAlfabeticamente();

        assertEquals(Arrays.asList("adios", "Hola", "hola", "hola", "Mundo", "mundo"), resultado);
    }



}



