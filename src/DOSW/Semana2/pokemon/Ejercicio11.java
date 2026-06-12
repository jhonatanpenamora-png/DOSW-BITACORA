package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Ejercicio11 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 70, 610, "Kanto", false)
        );

        double promedioPC = equipo.stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .average()
                .orElse(0.0);

        System.out.println("Poder de combate promedio: " + String.format(Locale.US, "%.2f", promedioPC));
    }
}