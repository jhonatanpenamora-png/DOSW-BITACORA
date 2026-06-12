package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Pikachu", "Charmander", "Squirtle", "Bulbasaur");

        String nombresMayusculas = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(nombresMayusculas);
    }
}