package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ejercicio12 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 70, 610, "Kanto", false)
        );

        equipo.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .ifPresent(p -> System.out.println("Campeón: " + p.getNombre() + " con PC: " + (int) p.getPoderCombate()));
    }
}