package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon("Pikachu", 45),
                new Pokemon("Charmander", 62),
                new Pokemon("Squirtle", 38),
                new Pokemon("Snorlax", 90),
                new Pokemon("Mewtwo", 88)
        );

        Optional<Pokemon> alfa = equipo.stream()
                .max(Comparator.comparingInt(Pokemon::getNivel));

        alfa.ifPresent(p ->
                System.out.println("Pokémon Alfa: " + p.getNombre() + " (nivel " + p.getNivel() + ")")
        );
    }
}