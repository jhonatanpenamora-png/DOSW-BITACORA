package DOSW.Semana2.pokemon;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RetoMewtwo {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Arcanine", "Fuego", 50, 450, "Kanto", false),
                new Pokemon(2L, "Gyarados", "Agua", 55, 540, "Kanto", false),
                new Pokemon(3L, "Mewtwo", "Psíquico", 90, 680, "Kanto", true),
                new Pokemon(4L, "Typhlosion", "Fuego", 50, 500, "Johto", false)
        );


        Map<String, Double> poderTotalPorRegion = pokedex.stream()
                .filter(p -> !p.isLegendario())
                .map(p -> new AbstractMap.SimpleEntry<>(p.getRegion(), p.getPoderCombate()))
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.reducing(
                                0.0,
                                Map.Entry::getValue,
                                Double::sum
                        )
                ));

        poderTotalPorRegion.forEach((region, pcTotal) ->
                System.out.println("Región: " + region + " - PC Total Ordinario: " + pcTotal));
    }
}