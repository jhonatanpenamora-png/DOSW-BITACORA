package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio20 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(5L, "Charizard", "Fuego", 70, 610, "Kanto", false)
        );

        Map<String, Long> porTipo = pokedex.stream().collect(Collectors.groupingBy(Pokemon::getTipo, Collectors.counting()));
        Map<String, Long> porRegion = pokedex.stream().collect(Collectors.groupingBy(Pokemon::getRegion, Collectors.counting()));
        long legendarios = pokedex.stream().filter(Pokemon::isLegendario).count();
        double promedioNivel = pokedex.stream().mapToInt(Pokemon::getNivel).average().orElse(0.0);
        Pokemon masFuerte = pokedex.stream().max(Comparator.comparingDouble(Pokemon::getPoderCombate)).orElse(null);

        System.out.println("Por tipo:\t" + porTipo);
        System.out.println("Por región:\t" + porRegion);
        System.out.println("Legendarios:\t" + legendarios);
        System.out.println("Promedio niv:\t" + String.format(Locale.US, "%.1f", promedioNivel));
        if (masFuerte != null) {
            System.out.println("Más fuerte:\t" + masFuerte.getNombre() + " (PC: " + (int) masFuerte.getPoderCombate() + ")");
        }
    }
}