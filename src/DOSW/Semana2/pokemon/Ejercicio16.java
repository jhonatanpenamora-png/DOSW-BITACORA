package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio16 {
    public static void main(String[] args) {
        List<Entrenador> entrenadores = Arrays.asList(
                new Entrenador(1L, "Ash", 8, Collections.emptyList()),
                new Entrenador(2L, "Misty", 5, Collections.emptyList()),
                new Entrenador(3L, "Brock", 6, Collections.emptyList()),
                new Entrenador(4L, "Gary", 10, Collections.emptyList()),
                new Entrenador(5L, "May", 3, Collections.emptyList()),
                new Entrenador(6L, "Dawn", 7, Collections.emptyList())
        );

        List<String> experimentados = entrenadores.stream()
                .filter(e -> e.getMedallas() > 5)
                .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
                .collect(Collectors.toList());

        System.out.println("Entrenadores con > 5 medallas:\n" + experimentados);
    }
}
