package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio18 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(5L, "Charizard", "Fuego", 70, 610, "Kanto", false)
        );

        AtomicInteger ranking = new AtomicInteger(1);

        pokedex.stream()
                .sorted(Comparator.comparingDouble(Pokemon::getPoderCombate).reversed())
                .limit(5)
                .forEach(p -> System.out.println("#" + ranking.getAndIncrement() + " " + p.getNombre() + "\t- PC: " + (int) p.getPoderCombate()));
    }
}