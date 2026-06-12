package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio14 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(11L, "Chikorita", "Planta", 15, 140, "Johto", false),
                new Pokemon(12L, "Torchic", "Fuego", 16, 155, "Hoenn", false),
                new Pokemon(13L, "Piplup", "Agua", 14, 135, "Sinnoh", false),
                new Pokemon(8L, "Charmander", "Fuego", 15, 150, "Kanto", false),
                new Pokemon(14L, "Totodile", "Agua", 18, 165, "Johto", false)
        );

        Map<String, List<String>> porRegion = equipo.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getRegion,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        porRegion.forEach((region, nombres) -> System.out.println(region + ":\t" + nombres));
    }
}