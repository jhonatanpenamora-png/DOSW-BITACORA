package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio15 {
    public static void main(String[] args) {
        List<Entrenador> entrenadores = Arrays.asList(
                new Entrenador(1L, "Ash", 8, Collections.emptyList()),
                new Entrenador(2L, "Misty", 5, Collections.emptyList()),
                new Entrenador(3L, "Brock", 6, Collections.emptyList()),
                new Entrenador(4L, "Gary", 10, Collections.emptyList())
        );

        entrenadores.stream()
                .max(Comparator.comparingInt(Entrenador::getMedallas))
                .ifPresent(e -> {
                    System.out.println("Campeón de gimnasios: " + e.getNombre());
                    System.out.println("Medallas obtenidas: " + e.getMedallas());
                });
    }
}