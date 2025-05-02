package ual.hmis.sesion05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContadorDePalabras {
    private static final String archivo = "src/ual/hmis/sesion05/archivo.txt";
    
      public List<String> palabrasOrdenadasAlfabeticamente() throws IOException {
        List<String> palabras = leerArchivo();
        palabras.sort(String::compareToIgnoreCase);
        return palabras;
    }

    public List<String> palabrasOrdenadasPorFrecuencia() throws IOException {
        List<String> palabras = leerArchivo();
        Map<String, Long> frecuencia = palabras.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return frecuencia.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<String> leerArchivo() throws IOException {
        String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
        return Arrays.asList(contenido.split("\\s+"));
    }
}
