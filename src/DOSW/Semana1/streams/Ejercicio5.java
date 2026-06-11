package DOSW.Semana1.streams;

import java.util.Arrays;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TX1", 1500.0, true),
                new Transaction("TX2", 200.0, true),
                new Transaction("TX3", 50.0, false)
        );

        boolean tieneNoAprobadas = transactions.stream()
                .peek(t -> System.out.println("Procesando: " + t))
                .anyMatch(t -> !t.approved);

        boolean loteValido = !tieneNoAprobadas;
        System.out.println("Lote válido: " + loteValido);
    }
}