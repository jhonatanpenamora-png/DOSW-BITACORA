package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(7L, "Psyduck", "Agua", 25, 180, "Kanto", false),
                new Pokemon(8L, "Charmander", "Fuego", 15, 150, "Kanto", false),
                new Pokemon(9L, "Vulpix", "Fuego", 20, 160, "Kanto", false),
                new Pokemon(10L, "Bulbasaur", "Planta", 18, 170, "Kanto", false)
        );

        Map<String, List<String>> porTipo = equipo.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        porTipo.forEach((tipo, nombres) -> System.out.println(tipo + ":\t" + nombres));
    }
}
