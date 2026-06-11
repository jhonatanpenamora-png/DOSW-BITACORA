package DOSW.Semana1.streams;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("java", "stream", "api", "functional", "code", "git");

        long cantidad = palabras.stream()
                .filter(p -> p.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .count();

        System.out.println("Cantidad de palabras resultantes: " + cantidad);
    }
}