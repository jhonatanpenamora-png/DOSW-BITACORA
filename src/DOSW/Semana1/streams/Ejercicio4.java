package DOSW.Semana1.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Zack", 20, true),
                new User(2, "Ana", 17, false),
                new User(3, "Beatriz", 30, true),
                new User(4, "Pedro", 15, true)
        );

        List<String> mayoresDeEdad = users.stream()
                .filter(u -> u.age >= 18)
                .map(u -> u.name)
                .collect(Collectors.toList());

        System.out.println(mayoresDeEdad);
    }
}