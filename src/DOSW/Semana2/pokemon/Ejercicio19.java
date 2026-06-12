package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Entrenador> entrenadores = Arrays.asList(
                new Entrenador(1L, "Gary", 10, Arrays.asList(new Pokemon(1L, "A", "B", 1, 2340, "C", false))),
                new Entrenador(2L, "Ash", 8, Arrays.asList(new Pokemon(2L, "A", "B", 1, 1850, "C", false))),
                new Entrenador(3L, "Dawn", 7, Arrays.asList(new Pokemon(3L, "A", "B", 1, 2100, "C", false))),
                new Entrenador(4L, "Brock", 6, Arrays.asList(new Pokemon(4L, "A", "B", 1, 1670, "C", false)))
        );

        Comparator<Entrenador> desempateTriple = Comparator
                .comparingInt(Entrenador::getMedallas)
                .thenComparingDouble(e -> e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum())
                .reversed()
                .thenComparing(Entrenador::getNombre);

        AtomicInteger ranking = new AtomicInteger(1);

        entrenadores.stream()
                .sorted(desempateTriple)
                .limit(3)
                .forEach(e -> {
                    int poder = (int) e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum();
                    System.out.println("#" + ranking.getAndIncrement() + " " + e.getNombre() + "\t- " + e.getMedallas() + " medallas, PC: " + poder);
                });
    }
}