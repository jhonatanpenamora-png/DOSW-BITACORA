package DOSW.Semana1.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(3, 8, 10, 12, 15, 18, 20);

        List<Integer> paresMayoresADiez = numeros.stream()
                .filter(n -> n % 2 == 0 && n > 10)
                .collect(Collectors.toList());

        System.out.println(paresMayoresADiez);
    }
}