package ual.hmis.sesion05.ejercicio5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio5 {


    public ArrayList<String> palabrasOrdenadasAlfabeticamente(String filename) {
        
        if (filename == null || filename.isEmpty()) throw new IllegalArgumentException("El nombre del archivo no puede ser nulo o vacío");
        
        ArrayList<String> result = new ArrayList<>();
    
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] temp = line.toLowerCase().split(" ");
                Collections.addAll(result, temp);
            }
        } catch (IOException e) {
            return e.getMessage().contains("NoSuchFileException") ? null : result;
        }
    
        result.sort(String::compareTo);
        return result;
    }

    public ArrayList<Pair<String, Integer>> palabrasOrdenadasPorFrecuencia(String filename) {
        
        if (filename == null || filename.isEmpty()) throw new IllegalArgumentException("El nombre del archivo no puede ser nulo o vacío");

        Map<String, Integer> frecuencia = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] temp = line.toLowerCase().split(" ");
                for (String palabra : temp) {
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }
        } catch (IOException e) {
            return e.getMessage().contains("NoSuchFileException") ? null : new ArrayList<>();
        }

        ArrayList<Pair<String, Integer>> result = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : frecuencia.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result.add(new Pair<>(key, value));
        }

        result.sort((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()));

        return result;
    }
}
