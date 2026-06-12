package DOSW.Semana2.pokemon;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {
    public static void main(String[] args) {
        List<String> pokemons = Arrays.asList(
                "Squirtle", "Pikachu", "Mewtwo",
                "Bulbasaur", "Charmander", "Abra"
        );

        List<String> ordenados = pokemons.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ordenados);
    }
}
