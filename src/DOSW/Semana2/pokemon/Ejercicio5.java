package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon("Pikachu", 45),
                new Pokemon("Mewtwo", 88),
                new Pokemon("Dragonite", 82),
                new Pokemon("Squirtle", 38),
                new Pokemon("Mew", 85),
                new Pokemon("Charmander", 62)
        );

        long cantidad = equipo.stream()
                .filter(p -> p.getNivel() > 80)
                .count();

        String nombres = equipo.stream()
                .filter(p -> p.getNivel() > 80)
                .map(Pokemon::getNombre)
                .collect(Collectors.joining(", "));

        System.out.println("Pokémon con nivel > 80: " + cantidad + " (" + nombres + ")");
    }
}