package DOSW.Semana2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Pokemon> equipo = Arrays.asList(
                new Pokemon("Pikachu", "Eléctrico"),
                new Pokemon("Charmander", "Fuego"),
                new Pokemon("Squirtle", "Agua"),
                new Pokemon("Vulpix", "Fuego"),
                new Pokemon("Bulbasaur", "Planta"),
                new Pokemon("Flareon", "Fuego")
        );

        List<String> tipoFuego = equipo.stream()
                .filter(p -> p.getTipo().equals("Fuego"))
                .map(Pokemon::getNombre)
                .collect(Collectors.toList());

        System.out.println(tipoFuego);
    }
}
