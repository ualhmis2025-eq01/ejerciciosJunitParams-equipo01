package ual.hmis.sesion05.ejercicio5;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Ejercicio5Test {

    @Test
    public void testPalabrasOrdenadasAlfabeticamente_conNuevoTexto() {
        Ejercicio5 ejercicio5 = new Ejercicio5();
        String ruta = (System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "resources" + File.separator + "texto.txt");

        List<String> expected = Arrays.asList("de", "es", "esto", "hola", "hola", "prueba.", "texto", "un");
        List<String> result = ejercicio5.palabrasOrdenadasAlfabeticamente(ruta);

        assertEquals(expected, result);
    }

    @Test
    public void testPalabrasOrdenadasPorFrecuencia_conNuevoTexto() {
        Ejercicio5 ejercicio5 = new Ejercicio5();
        String ruta = (System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "resources" + File.separator + "texto.txt");

        List<Pair<String, Integer>> result = ejercicio5.palabrasOrdenadasPorFrecuencia(ruta);

        List<Pair<String, Integer>> expected = Arrays.asList(
            new Pair<>("hola", 2),
            new Pair<>("esto", 1),
            new Pair<>("es", 1),
            new Pair<>("un", 1),
            new Pair<>("texto", 1),
            new Pair<>("de", 1),
            new Pair<>("prueba.", 1)
        );

        assertEquals(expected.size(), result.size());
        for (Pair<String, Integer> pair : expected) {
            assertTrue(result.contains(pair), "Falta par: " + pair.getKey() + ", " + pair.getValue());
        }
    }

    @Test
    public void testNombreArchivoVacioONulo() {
        Ejercicio5 ejercicio5 = new Ejercicio5();

        assertThrows(IllegalArgumentException.class, () -> {
            ejercicio5.palabrasOrdenadasAlfabeticamente("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ejercicio5.palabrasOrdenadasAlfabeticamente(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ejercicio5.palabrasOrdenadasPorFrecuencia("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ejercicio5.palabrasOrdenadasPorFrecuencia(null);
        });
    }

    @Test
    public void testArchivoNoExiste() {
        Ejercicio5 ejercicio5 = new Ejercicio5();

        assertNull(ejercicio5.palabrasOrdenadasAlfabeticamente("hola.txt"));
        assertNull(ejercicio5.palabrasOrdenadasPorFrecuencia("hola.txt"));
    }
}
