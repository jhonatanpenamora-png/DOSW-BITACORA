package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ejercicio17 {
    public static void main(String[] args) {
        List<Entrenador> entrenadores = Arrays.asList(
                new Entrenador(1L, "Ash", 8, Arrays.asList(new Pokemon(1L, "Pikachu", "Eléctrico", 45, 1850, "Kanto", false))),
                new Entrenador(2L, "Gary", 10, Arrays.asList(new Pokemon(2L, "Blastoise", "Agua", 50, 2340, "Kanto", false))),
                new Entrenador(3L, "Brock", 6, Arrays.asList(new Pokemon(3L, "Onix", "Roca", 40, 1670, "Kanto", false)))
        );

        entrenadores.stream()
                .max(Comparator.comparingDouble(e -> e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum()))
                .ifPresent(e -> {
                    double poderTotal = e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum();
                    System.out.println("Entrenador más poderoso: " + e.getNombre());
                    System.out.println("Poder acumulado del equipo: " + (int) poderTotal);
                });
    }
}