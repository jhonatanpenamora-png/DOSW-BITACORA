# DOSW-BITACORA
## SEMANA No 1 — DOSW Manejo de Streams
## Datos personales:
- Nombre y Apellido: Jhonatan Stiven Peña Mora
- Código de Estudiante: 1000097603
- Curso: DOSW
---
### Ejercicio 01 — Números Pares mayores a diez
Enunciado del Ejercicio:

Dada una lista de números enteros, necesitamos obtener una nueva lista solo con los números pares mayores a 10.


**Código implementado:**

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
**Captura de ejecución:** 

<img width="302" height="110" alt="image" src="https://github.com/user-attachments/assets/e1598c4e-56a8-423b-9b36-0f56da23a735" />


**Explicación:**

Se utiliza un origen de datos de tipo `List<Integer>`. La colección se convierte en un Stream para aplicar la operación intermedia `filter()`, la cual evalúa que el residuo de la división entre 2 sea cero (`n % 2 == 0`) y que el número sea estrictamente mayor a 10 (`n > 10`). Finalmente, se recolectan los datos con `collect(Collectors.toList())`.

### Ejercicio 02 — Cantidad de palabras con más de 4 letras

Enunciado del Ejercicio

Dada una lista de palabras, se requiere:

● Filtrar las palabras que tengan más de 4 caracteres

● Convertirlas en Mayúsculas

● Ordenarlas alfabéticamente

● Obtener la cantidad total de palabras resultantes

**Código implementado:**

    package DOSW.Semana1.streams;
    
    import java.util.Arrays;
    import java.util.List;
    
    public class Ejercicio2 {
    public static void main(String[] args) {
    List<String> palabras = Arrays.asList("java", "stream", "api", "functional", "code", "git");
    
            long cantidad = palabras.stream()
                    .filter(p -> p.length() > 4)
                    .map(String::toUpperCase)
                    .sorted()
                    .count();
    
            System.out.println("Cantidad de palabras resultantes: " + cantidad);
        }
    }
**Captura de ejecución:** 

<img width="352" height="121" alt="image" src="https://github.com/user-attachments/assets/bd60085c-1c00-4f26-bae1-3f7e708dd306" />


**Explicación:**

A partir de una lista de `String`, se genera un flujo evaluado mediante `filter()` para retener cadenas con un `length() > 4`. Las palabras restantes mutan mediante `map(String::toUpperCase)` para convertirlas en mayúsculas y son ordenadas alfabéticamente a través de `sorted()`. El resultado se consolida ejecutando la función terminal `count()`.


### Ejercicio 03 — Obtener nombres de usuarios

Enunciado del Ejercicio

Dada una lista de usuarios con los atributos: id, name, age, active.
Filtra únicamente los usuarios activos, obtén una lista con los nombres en mayúscula y ordenada alfabéticamente.


**Código implementado:**

    package DOSW.Semana1.streams;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio3 {
    public static void main(String[] args) {
    List<User> users = Arrays.asList(
    new User(1, "Zack", 20, true),
    new User(2, "Ana", 17, false),
    new User(3, "Beatriz", 30, true),
    new User(4, "Carlos", 25, true)
    );
    
            List<String> sortedUsers = users.stream()
                    .filter(u -> u.active)
                    .map(u -> u.name.toUpperCase())
                    .sorted()
                    .collect(Collectors.toList());
    
            System.out.println(sortedUsers);
        }
    }

**Captura de ejecución:** 

<img width="322" height="119" alt="image" src="https://github.com/user-attachments/assets/3ea9743b-7af3-4cb4-9db2-453185fc64a6" />


**Explicación:**

Dada una lista de objetos `User`, el Stream se filtra con `filter(u -> u.active)` reteniendo únicamente usuarios activos. Con `map(u -> u.name.toUpperCase())` se extrae la propiedad del nombre de cada objeto y se convierte a mayúsculas. Esta nueva lista de cadenas se ordena mediante la función intermedia `sorted()` y finaliza con `collect()`.


### Ejercicio 04 — Personas mayores de edad

Enunciado del Ejercicio

Dado un listado de Usuarios y utilizando los mismos atributos anteriores, filtrar las personas mayores de edad y obtener
sus nombres.

**Código implementado:**

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
**Captura de ejecución:** 

<img width="384" height="128" alt="image" src="https://github.com/user-attachments/assets/93bd6cbd-0655-4e81-bf7c-9f564b316521" />


**Explicación:**

Aprovechando la estructura de la clase `User`, se inicializa el Stream para filtrar con `filter(u -> u.age >= 18)`. A diferencia del ejercicio anterior, aquí se utiliza `map(u -> u.name)` simplemente para extraer la propiedad del nombre tal cual se encuentra estructurada, devolviendo una nueva lista con la operación `collect()`.

### Ejercicio 05 — Transacciones Bancarias

Enunciado del Ejercicio

Dada una lista de transacciones bancarias representadas por objetos:

**class Transaction { String id; double amount; boolean approved; }**

Se requiere procesar la lista usando Streams para:

● Usar peek para ver cada transacción procesada (Utilizar System.out.println para ver la transacción)

● Verificar si existe al menos una transacción no aprobada

● Retornar true o false indicando si el lote de transacciones es válido.

**Código implementado:**

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

**Captura de ejecución:** 

<img width="547" height="202" alt="image" src="https://github.com/user-attachments/assets/78a2ce5b-2704-465b-82d1-0e5ba177e4c2" />


**Explicación:**

Implementación sobre un modelo `Transaction`. Se evalúa el lote a través del Stream invocando primero la función `peek(t -> System.out.println(...))` para imprimir el estado de las transacciones procesadas sin mutar los datos. Seguidamente, la operación de corto circuito `anyMatch(t -> !t.approved)` determina si en todo el flujo existe alguna transacción denegada, retornando un booleano que define la validez general del lote procesado.

---
# SEMANA No 2 — Bitácora Pokémon

## Datos de Entrenador:

- Nombre y Apellido: Jhonatan Stiven Peña Mora
- Código de Estudiante: 1000097603
- Curso: DOSW

---
## Nivel 1 - Entrenador Novato

### Ejercicio 01 — Pokémon Tipo Fuego

Enunciado del Ejercicio

Dada una lista de Pokémon con nombre y tipo, obtener únicamente aquellos cuyo tipo sea Fuego.

**Código implementado:** 

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

**Captura de ejecución:** 

<img width="343" height="140" alt="image" src="https://github.com/user-attachments/assets/d9e2666d-57e4-47f0-b960-e745489165dc" />


**Explicación:** 

partir de una colección de objetos `Pokemon`, se inicia un Stream para aplicar la operación `filter(p -> p.getTipo().equals("Fuego"))`. Una vez retenidos únicamente los objetos que cumplen la condición, se extrae el nombre de cada uno mediante `map(Pokemon::getNombre)` y se consolida el resultado en una nueva lista usando `collect(Collectors.toList())`.

### Ejercicio 02 — Pokédex Gritona

Enunciado del Ejercicio

Transformar todos los nombres de Pokémon a mayúsculas.

**Código implementado:** 
 
    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio2 {
    public static void main(String[] args) {
    List<String> nombres = Arrays.asList("Pikachu", "Charmander", "Squirtle", "Bulbasaur");
    
            String nombresMayusculas = nombres.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.joining(", "));
    
            System.out.println(nombresMayusculas);
        }
    }

**Captura de ejecución:** 

<img width="406" height="123" alt="image" src="https://github.com/user-attachments/assets/39d0162a-ebe4-4f4d-80f8-453cb38f34f7" />

**Explicación:** 

Se procesa una lista directa de cadenas de texto (nombres). Se utiliza la operación intermedia `map(String::toUpperCase)` para transformar cada elemento iterado a mayúsculas. Posteriormente, en lugar de retornar una lista, se utiliza `collect(Collectors.joining(", "))` para concatenar los resultados en un solo String separado por comas, tal como se solicita en la salida esperada.

### Ejercicio 03 — Poder Total del Equipo

Enunciado del Ejercicio

Dada una lista de niveles de Pokémon, calcular la suma total de niveles del equipo.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    
    public class Ejercicio3 {
    public static void main(String[] args) {
    List<Integer> niveles = Arrays.asList(45, 62, 38, 71, 55, 29);
    
            int sumaTotal = niveles.stream()
                    .reduce(0, Integer::sum);
    
            System.out.println("Suma total de niveles: " + sumaTotal);
        }
    }

**Captura de ejecución:**

<img width="410" height="124" alt="image" src="https://github.com/user-attachments/assets/7a8ac262-ccbd-43b3-bd53-77f9391e6f6b" />

**Explicación:** 

Dado un arreglo de números enteros (`Integer`), se emplea la operación terminal de reducción `reduce()`. Se establece `0` como valor de identidad inicial y se pasa el método referenciado `Integer::sum` como función acumuladora para sumar todos los niveles iterados en el Stream, obteniendo un valor primitivo final.

### Ejercicio 04 — Pokémon Alfa

Enunciado del Ejercicio

Encontrar el Pokémon con el nivel más alto dentro del equipo.

**Código implementado:**

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    import java.util.Optional;
    
    public class Ejercicio4 {
    public static void main(String[] args) {
    List<Pokemon> equipo = Arrays.asList(
    new Pokemon("Pikachu", 45),
    new Pokemon("Charmander", 62),
    new Pokemon("Squirtle", 38),
    new Pokemon("Snorlax", 90),
    new Pokemon("Mewtwo", 88)
    );
    
            Optional<Pokemon> alfa = equipo.stream()
                    .max(Comparator.comparingInt(Pokemon::getNivel));
    
            alfa.ifPresent(p ->
                    System.out.println("Pokémon Alfa: " + p.getNombre() + " (nivel " + p.getNivel() + ")")
            );
        }
    }

**Captura de ejecución:** 

<img width="452" height="120" alt="image" src="https://github.com/user-attachments/assets/599d5090-cce2-49b4-a93b-142b8346b1fd" />

**Explicación:** 

Para encontrar el Pokémon con el nivel más alto, se evalúa el flujo de objetos usando la función de reducción `max()`. A esta función se le suministra un comparador específico mediante `Comparator.comparingInt(Pokemon::getNivel)`, el cual evalúa el atributo numérico de cada objeto. El resultado se devuelve en un contenedor `Optional` para prevenir errores de nulos, procesando la salida con `ifPresent()`.

### Ejercicio 05 — Pokémon Legendarios

Enunciado del Ejercicio

Contar cuántos Pokémon del equipo tienen nivel superior a 80.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio5 {
    public static void main(String[] args) {
    List<Pokemon> equipo = Arrays.asList(
    new Pokemon("Pikachu", 45),
    new Pokemon("Mewtwo", 88),
    new Pokemon("Dragonite", 82),
    new Pokemon("Squirtle", 38),
    new Pokemon("Mew", 85),
    new Pokemon("Charmander", 62)
    );
    
            long cantidad = equipo.stream()
                    .filter(p -> p.getNivel() > 80)
                    .count();
    
            String nombres = equipo.stream()
                    .filter(p -> p.getNivel() > 80)
                    .map(Pokemon::getNombre)
                    .collect(Collectors.joining(", "));
    
            System.out.println("Pokémon con nivel > 80: " + cantidad + " (" + nombres + ")");
        }
    }

**Captura de ejecución:** 

<img width="420" height="115" alt="image" src="https://github.com/user-attachments/assets/f1bc24c2-ab29-46c1-9fad-fcf1548d9e55" />

**Explicación:** 

Este reto combina dos operaciones. Primero, se cuenta el total iterando el Stream con `filter(p -> p.getNivel() > 80)` y aplicando la operación terminal `count()`. Segundo, se vuelve a generar un Stream paralelo con el mismo filtro, pero utilizando `map(Pokemon::getNombre)` y `collect(Collectors.joining(", "))` para extraer y agrupar los nombres de los Pokémon resultantes en una sola cadena de texto formateada.

---

## Nivel 2 - Entrenador Intermedio

### Ejercicio 06 — Pokédex Sin Duplicados

Enunciado del Ejercicio

Dada una lista de Pokémon con elementos repetidos, generar una nueva colección donde cada Pokémon
aparezca una sola vez

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio6 {
    public static void main(String[] args) {
    List<String> pokemons = Arrays.asList(
    "Pikachu", "Charmander", "Pikachu",
    "Squirtle", "Charmander", "Mewtwo"
    );
    
            List<String> sinDuplicados = pokemons.stream()
                    .distinct()
                    .collect(Collectors.toList());
    
            System.out.println(sinDuplicados);
        }
    }


**Captura de ejecución:** 

<img width="405" height="124" alt="image" src="https://github.com/user-attachments/assets/f98f9435-4d2d-4ae9-8dcb-abe2ab167199" />

**Explicación:** 

A partir de una lista de cadenas de texto (`String`) que contiene nombres repetidos, se inicializa un Stream para aplicar la operación intermedia `distinct()`. Esta función evalúa los elementos internamente (usando el método `equals`) y permite que solo pasen al flujo resultante aquellos que no hayan aparecido previamente, garantizando elementos únicos que finalmente se recolectan con `collect(Collectors.toList())`.

### Ejercicio 07 — Orden del Profesor Oak

Enunciado del Ejercicio

El Profesor Oak quiere su Pokédex organizada. Ordenar alfabéticamente los nombres de los Pokémon.


**Código implementado:** 

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


**Captura de ejecución:** 

<img width="516" height="116" alt="image" src="https://github.com/user-attachments/assets/5b633f70-c01b-4a50-b004-6478354e5b7d" />

**Explicación:** 

Dada una colección de nombres desordenados, se invoca el Stream y se emplea la operación intermedia `sorted()`. Al tratarse de objetos `String`, la función utiliza el orden natural (alfabético) implícito en la clase para reorganizar los elementos en el flujo. La lista final se consolida ejecutando la función terminal `collect(Collectors.toList())`.

### Ejercicio 08 — Evoluciones Preparadas

Enunciado del Ejercicio

Dada una lista de Pokémon que incluye si pueden evolucionar (boolean puedeEvolucionar), obtener
únicamente los que estén listos para evolucionar.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio8 {
    public static void main(String[] args) {
    List<PokemonEvolucion> equipo = Arrays.asList(
    new PokemonEvolucion("Pikachu", true),
    new PokemonEvolucion("Raichu", false),
    new PokemonEvolucion("Charmander", true),
    new PokemonEvolucion("Charizard", false),
    new PokemonEvolucion("Squirtle", true),
    new PokemonEvolucion("Blastoise", false)
    );
    
            List<String> listosParaEvolucionar = equipo.stream()
                    .filter(PokemonEvolucion::isPuedeEvolucionar)
                    .map(PokemonEvolucion::getNombre)
                    .collect(Collectors.toList());
    
            System.out.println("Listos para evolucionar: " + listosParaEvolucionar);
        }
    }


**Captura de ejecución:** 

<img width="483" height="112" alt="image" src="https://github.com/user-attachments/assets/62fdd996-0c20-47ee-8815-f2a34a58b679" />

**Explicación:** 

Se crea un modelo `PokemonEvolucion` con un atributo booleano para identificar su estado. El flujo se filtra mediante la operación `filter(PokemonEvolucion::isPuedeEvolucionar)`, permitiendo continuar únicamente a los objetos cuyo retorno sea `true`. Seguidamente, se ejecuta una transformación estructural con `map(PokemonEvolucion::getNombre)` para extraer exclusivamente el atributo del nombre en formato `String` y recolectarlo en una nueva lista.

---

## Nivel 3 - Líder de Gimnasio

### Ejercicio 09 — Equipo Élite

Enunciado del Ejercicio

Mostrar únicamente los Pokémon cuyo poderCombate sea superior a 500.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio9 {
    public static void main(String[] args) {
    List<Pokemon> equipo = Arrays.asList(
    new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
    new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
    new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
    new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
    new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
    new Pokemon(6L, "Charizard", "Fuego", 70, 610, "Kanto", false)
    );
    
            List<String> equipoElite = equipo.stream()
                    .filter(p -> p.getPoderCombate() > 500)
                    .map(p -> p.getNombre() + "(" + (int) p.getPoderCombate() + ")")
                    .collect(Collectors.toList());
    
            System.out.println("Equipo Élite (PC > 500): " + equipoElite);
        }
    }

**Captura de ejecución:** 

<img width="627" height="210" alt="image" src="https://github.com/user-attachments/assets/57bb566c-6c66-422b-a213-71cd8f6f842d" />

**Explicación:** 

Se restringe la colección mediante `filter()` para aprobar únicamente los objetos cuyo atributo `poderCombate` sea superior a 500. El resultado pasa por un `map()` para crear una cadena de texto personalizada que concatena el nombre con el valor numérico casteado a entero, permitiendo recolectarlo en una lista final.

### Ejercicio 10 — Pokédex Compacta

Enunciado del Ejercicio

Generar una lista que contenga únicamente los nombres de todos los Pokémon del equipo.

**Código implementado:**

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio10 {
    public static void main(String[] args) {
    List<Pokemon> equipo = Arrays.asList(
    new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
    new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
    new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
    new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
    new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
    new Pokemon(6L, "Charizard", "Fuego", 70, 610, "Kanto", false)
    );
    
            List<String> nombres = equipo.stream()
                    .map(Pokemon::getNombre)
                    .collect(Collectors.toList());
    
            System.out.println(nombres);
        }
    }

**Captura de ejecución:** 

<img width="510" height="192" alt="image" src="https://github.com/user-attachments/assets/ba4bc922-793c-415f-9a91-ba8bfdef321f" />

**Explicación:** 

Extrae rápidamente un único atributo de un objeto estructurado. Al utilizar la función `map(Pokemon::getNombre)`, el Stream transforma los tipos de dato (de `Pokemon` a `String`), generando una colección liviana y puramente textual usando `collect()`.

### Ejercicio 11 — Poder Promedio

Enunciado del Ejercicio

Calcular el promedio de poderCombate de todos los Pokémon del equipo.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.Locale;
    
    public class Ejercicio11 {
    public static void main(String[] args) {
    List<Pokemon> equipo = Arrays.asList(
    new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
    new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
    new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
    new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
    new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
    new Pokemon(6L, "Charizard", "Fuego", 70, 610, "Kanto", false)
    );
    
            double promedioPC = equipo.stream()
                    .mapToDouble(Pokemon::getPoderCombate)
                    .average()
                    .orElse(0.0);
    
            System.out.println("Poder de combate promedio: " + String.format(Locale.US, "%.2f", promedioPC));
        }
    }

**Captura de ejecución:** 

<img width="373" height="203" alt="image" src="https://github.com/user-attachments/assets/6f40fc6f-40ea-441f-8cae-2033ee1060b3" />

**Explicación:** 

Implementa especializaciones de Stream para tipos primitivos. La colección de objetos utiliza `mapToDouble()` apuntando al método `getPoderCombate`. Esto devuelve un `DoubleStream`, el cual tiene acceso directo a la operación de reducción terminal `average()`.

### Ejercicio 12 — Campeón Regional

Enunciado del Ejercicio

Obtener el Pokémon con mayor poderCombate de toda la lista.

**Código implementado:** 

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

**Captura de ejecución:** 

<img width="331" height="196" alt="image" src="https://github.com/user-attachments/assets/3ed61060-92ed-4b30-957d-d9dd16e65a2b" />

**Explicación:** 

Reutiliza la lógica de reducción de comparadores empleada previamente, pero aplicándola a un atributo de punto flotante en lugar de un entero. La operación `max(Comparator.comparingDouble(Pokemon::getPoderCombate))` itera y evalúa el atributo `poderCombate`, regresando el objeto contenedor completo si está presente.

### Ejercicio 13 — Organizar por Tipo

Enunciado del Ejercicio

Agrupar todos los Pokémon por su tipo y mostrar el listado por grupo.

**Código implementado:** 

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


**Captura de ejecución:**

<img width="433" height="210" alt="image" src="https://github.com/user-attachments/assets/5658c929-4a3a-4a75-9ff3-8f879664b060" />

**Explicación:** 

Introduce la clasificación de datos a través de la interfaz `Collectors.groupingBy()`.
El primer parámetro del agrupador define la llave (Clasificación por tipo `Pokemon::getTipo` o por región `Pokemon::getRegion`).

### Ejercicio 14 — Organizar por Región

Enunciado del Ejercicio

Agrupar los Pokémon según su región de origen.

**Código implementado:** 

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

**Captura de ejecución:** 

<img width="492" height="249" alt="image" src="https://github.com/user-attachments/assets/027474c4-735c-4df6-a5f2-3e3cdba79f40" />

**Explicación:** 

El segundo parámetro (Downstream) ejecuta la colección secundaria `Collectors.mapping(...)` asegurando que en el diccionario `Map` resultante, los valores agrupados sean directamente los nombres (cadenas de texto) en lugar del objeto `Pokemon` completo.

--- 

## Nivel 4 - Alto Mando
A partir de este nivel se implementa la clase `Entrenador` con el atributo `List<Pokemon> equipo` para manipular objetos anidados.

### Ejercicio 15 — Maestro de Gimnasios

Enunciado del Ejercicio

Dado un listado de entrenadores con sus medallas, encontrar el entrenador con más medallas.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.List;
    
    public class Ejercicio15 {
    public static void main(String[] args) {
    List<Entrenador> entrenadores = Arrays.asList(
    new Entrenador(1L, "Ash", 8, Collections.emptyList()),
    new Entrenador(2L, "Misty", 5, Collections.emptyList()),
    new Entrenador(3L, "Brock", 6, Collections.emptyList()),
    new Entrenador(4L, "Gary", 10, Collections.emptyList())
    );
    
            entrenadores.stream()
                    .max(Comparator.comparingInt(Entrenador::getMedallas))
                    .ifPresent(e -> {
                        System.out.println("Campeón de gimnasios: " + e.getNombre());
                        System.out.println("Medallas obtenidas: " + e.getMedallas());
                    });
        }
    }

**Captura de ejecución:** 

<img width="353" height="133" alt="image" src="https://github.com/user-attachments/assets/3fe7e440-e4aa-409b-be00-7b13720f3c60" />

**Explicación:** 

Se procesa la colección de entrenadores invocando `max()`. Haciendo uso del Reto Legendario, se implementa Method Reference `Comparator.comparingInt(Entrenador::getMedallas)` para encontrar el objeto con el mayor atributo entero e imprimirlo si existe mediante `ifPresent()`.

### Ejercicio 16 — Entrenadores Experimentados

Enunciado del Ejercicio

Mostrar únicamente los entrenadores que posean más de 5 medallas.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class Ejercicio16 {
    public static void main(String[] args) {
    List<Entrenador> entrenadores = Arrays.asList(
    new Entrenador(1L, "Ash", 8, Collections.emptyList()),
    new Entrenador(2L, "Misty", 5, Collections.emptyList()),
    new Entrenador(3L, "Brock", 6, Collections.emptyList()),
    new Entrenador(4L, "Gary", 10, Collections.emptyList()),
    new Entrenador(5L, "May", 3, Collections.emptyList()),
    new Entrenador(6L, "Dawn", 7, Collections.emptyList())
    );
    
            List<String> experimentados = entrenadores.stream()
                    .filter(e -> e.getMedallas() > 5)
                    .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
                    .collect(Collectors.toList());
    
            System.out.println("Entrenadores con > 5 medallas:\n" + experimentados);
        }
    }


**Captura de ejecución:**

<img width="361" height="160" alt="image" src="https://github.com/user-attachments/assets/6b36c776-923d-461f-8836-007855762e69" />

**Explicación:** 

Se discrimina la lista usando un `filter(e -> e.getMedallas() > 5)` y se transforma con `map()` estructurando una cadena de texto combinando nombre y cantidad de medallas, para finalmente recopilar en una lista los entrenadores aprobados.

### Ejercicio 17 — Maestro de Gimnasios

Enunciado del Ejercicio

Calcular cuál entrenador tiene la suma total de poderCombate más alta entre todos sus Pokémon.

**Código implementado:**

    package DOSW.Semana2.pokemon;
    
    
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    
    public class Ejercicio17 {
    public static void main(String[] args) {
    List<Entrenador> entrenadores = Arrays.asList(
    new Entrenador(1L, "Ash", 8, Arrays.asList(new Pokemon(1L, "Pikachu", "Eléctrico", 45, 1850, "Kanto", false))),
    new Entrenador(2L, "Gary", 10, Arrays.asList(new Pokemon(2L, "Blastoise", "Agua", 50, 2340, "Kanto", false))),
    new Entrenador(3L, "Brock", 6, Arrays.asList(new Pokemon(3L, "Onix", "Roca", 40, 1670, "Kanto", false)))
    );
    
            entrenadores.stream()
                    .max(Comparator.comparingDouble(e -> e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum()))
                    .ifPresent(e -> {
                        double poderTotal = e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum();
                        System.out.println("Entrenador más poderoso: " + e.getNombre());
                        System.out.println("Poder acumulado del equipo: " + (int) poderTotal);
                    });
        }
    }

**Captura de ejecución:** 

<img width="375" height="214" alt="image" src="https://github.com/user-attachments/assets/9675e05a-6baf-4481-9272-b17d6b67d61e" />

**Explicación:** 

Aplica anidación funcional. Se usa `max()` evaluando dinámicamente un cálculo interno del objeto: dentro del comparador de punto flotante se abre un segundo stream `e.getEquipo().stream()` sobre la lista de Pokémon de cada entrenador, mapeando sus poderes y totalizando con `sum()`.

## Nivel 5 - Campeón de la Liga DOSW

### Ejercicio 18 — Top 5 Pokémon Más Fuertes

Enunciado del Ejercicio

Generar un ranking de los cinco Pokémon con mayor poderCombate de toda la Pokédex.

**Código implementado:** 

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

**Captura de ejecución:** 

<img width="396" height="275" alt="image" src="https://github.com/user-attachments/assets/0ef75452-5415-4119-a4e1-50ae21e935a7" />

**Explicación:** 

Introduce límites en el flujo. La lista completa se somete a `sorted()` invirtiendo el orden natural con `.reversed()` sobre un Method Reference del Poder de Combate. Seguidamente, se ejecuta `limit(5)` para truncar el Stream y permitir únicamente el paso de los primeros 5 elementos al `forEach`.

### Ejercicio 19 — Top 3 Entrenadores

Enunciado del Ejercicio

Generar un ranking de los 3 mejores entrenadores considerando: 1° más medallas, 2° mayor poder
acumulado, 3° orden alfabético como criterio de desempate.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    import java.util.concurrent.atomic.AtomicInteger;
    
    public class Ejercicio19 {
    public static void main(String[] args) {
    List<Entrenador> entrenadores = Arrays.asList(
    new Entrenador(1L, "Gary", 10, Arrays.asList(new Pokemon(1L, "A", "B", 1, 2340, "C", false))),
    new Entrenador(2L, "Ash", 8, Arrays.asList(new Pokemon(2L, "A", "B", 1, 1850, "C", false))),
    new Entrenador(3L, "Dawn", 7, Arrays.asList(new Pokemon(3L, "A", "B", 1, 2100, "C", false))),
    new Entrenador(4L, "Brock", 6, Arrays.asList(new Pokemon(4L, "A", "B", 1, 1670, "C", false)))
    );
    
            Comparator<Entrenador> desempateTriple = Comparator
                    .comparingInt(Entrenador::getMedallas)
                    .thenComparingDouble(e -> e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum())
                    .reversed()
                    .thenComparing(Entrenador::getNombre);
    
            AtomicInteger ranking = new AtomicInteger(1);
    
            entrenadores.stream()
                    .sorted(desempateTriple)
                    .limit(3)
                    .forEach(e -> {
                        int poder = (int) e.getEquipo().stream().mapToDouble(Pokemon::getPoderCombate).sum();
                        System.out.println("#" + ranking.getAndIncrement() + " " + e.getNombre() + "\t- " + e.getMedallas() + " medallas, PC: " + poder);
                    });
        }
    }

**Captura de ejecución:** 

<img width="330" height="237" alt="image" src="https://github.com/user-attachments/assets/7a0295c7-8035-4090-bfc1-ba7889834618" />

**Explicación:** 

Se diseña un ordenamiento compuesto (`Comparator`). Primero clasifica descendentemente por número de medallas, encadena un desempate `thenComparingDouble()` que calcula iterativamente la sumatoria del PC del equipo anidado, y finaliza con un tercer desempate natural `thenComparing(Entrenador::getNombre)` antes de limitar a los 3 superiores.

### Ejercicio 20 — Pokédex Analítica

Enunciado del Ejercicio

Construir una estructura que muestre: cantidad de Pokémon por tipo, por región, cantidad de legendarios,
promedio de nivel y el Pokémon más fuerte. Todo usando únicamente Streams.

**Código implementado:** 

    package DOSW.Semana2.pokemon;
    
    
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    import java.util.Locale;
    import java.util.Map;
    import java.util.stream.Collectors;
    
    public class Ejercicio20 {
    public static void main(String[] args) {
    List<Pokemon> pokedex = Arrays.asList(
    new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
    new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
    new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
    new Pokemon(4L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
    new Pokemon(5L, "Charizard", "Fuego", 70, 610, "Kanto", false)
    );
    
            Map<String, Long> porTipo = pokedex.stream().collect(Collectors.groupingBy(Pokemon::getTipo, Collectors.counting()));
            Map<String, Long> porRegion = pokedex.stream().collect(Collectors.groupingBy(Pokemon::getRegion, Collectors.counting()));
            long legendarios = pokedex.stream().filter(Pokemon::isLegendario).count();
            double promedioNivel = pokedex.stream().mapToInt(Pokemon::getNivel).average().orElse(0.0);
            Pokemon masFuerte = pokedex.stream().max(Comparator.comparingDouble(Pokemon::getPoderCombate)).orElse(null);
    
            System.out.println("Por tipo:\t" + porTipo);
            System.out.println("Por región:\t" + porRegion);
            System.out.println("Legendarios:\t" + legendarios);
            System.out.println("Promedio niv:\t" + String.format(Locale.US, "%.1f", promedioNivel));
            if (masFuerte != null) {
                System.out.println("Más fuerte:\t" + masFuerte.getNombre() + " (PC: " + (int) masFuerte.getPoderCombate() + ")");
            }
        }
    }

**Captura de ejecución:** 

<img width="560" height="278" alt="image" src="https://github.com/user-attachments/assets/3e9a2539-1c81-485b-a3b6-2fd166c5f8f6" />

**El output es distinto al esperado devido a la lista de pokemones proporcionada**

**Explicación:** 

Implementación paralela de distintos métodos terminales y downstream collectors sobre un mismo set de datos. Se generan mapas de frecuencias usando `groupingBy()` junto a `Collectors.counting()`, conteos numéricos con `filter().count()`, y estadísticas usando `mapToInt().average()`. Todos aprovechan Azúcar Sintáctico (Method References) para cumplir el **Reto Legendario**.

---
## Retos Especiales

### ✨ Reto Legendario (+0.5 Puntos)
Se reemplazaron satisfactoriamente las funciones Lambda tradicionales por Method References a lo largo de los ejercicios. Ejemplos aplicados:
* `Entrenador::getMedallas` (Ej. 15, Ej. 19)
* `Pokemon::getPoderCombate` (Ej. 17, Ej. 18, Ej. 20)
* `Pokemon::isLegendario`, `Pokemon::getNivel`, `Pokemon::getTipo` (Ej. 20)

### 🧬 Reto Mewtwo (+1.0 Punto)
Para evidenciar el uso concurrente de `filter()`, `map()`, `sorted()`, `groupingBy()` y `reduce()`, se diseñó una solución que calcula el poder sumado de los ejércitos regionales.
1. Excluye anomalías filtrando Pokémon legendarios.
2. Mapea la abstracción a Entradas Key-Value (`SimpleEntry`).
3. Ordena el flujo por la llave (Región).
4. Agrupa en un diccionario las llaves terminales usando `groupingBy()`.
5. Ejecuta `Collectors.reducing()` como función final downstream asimilando cada valor y reduciéndolo sumativamente a un `Double`.

Código implementado:

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

<img width="376" height="223" alt="image" src="https://github.com/user-attachments/assets/61f7f6ba-c095-4814-a55c-172bcde5b218" />

## SEMANA No 3 — DOSW Patrones de Diseño Combinados

### Ejercicio 01 — Plataforma de Pagos Inteligentes

Enunciado del Ejercicio:

Una aplicación de e-commerce permite pagar con tarjeta, PSE, Nequi, PayPal y transferencia bancaria. Cada
medio tiene una lógica distinta pero el flujo de compra es el mismo. Además, según el país del usuario, el
sistema construye el proveedor de pago correcto (Colombia → PSE/Nequi, USA → PayPal/Stripe).

**Captura de ejecución:**

<img width="665" height="571" alt="image" src="https://github.com/user-attachments/assets/ece696ec-cacf-4139-af95-d5391be3ace3" />

**Explicación:**

**1. Explicación del rol de cada patrón:**

+ **Strategy:** Encapsula la lógica específica de cada método de pago (el cómo pagar) en clases independientes que implementan una misma interfaz. Esto permite intercambiar el algoritmo de procesamiento en tiempo de ejecución de forma transparente para el sistema.

+ **Factory Method:** Centraliza y encapsula la lógica de creación de las estrategias (el quién construye el método). Delega la responsabilidad de instanciar la clase concreta a fábricas especializadas de acuerdo con la región (país) del usuario.

**2. Descripción de la interacción**

El módulo centralizador (Checkout) requiere procesar un pago pero no debe acoplarse a los proveedores específicos.

1. Según el país del usuario, el sistema asigna la fábrica correspondiente (ej. ColombiaPaymentFactory).
2. La fábrica recibe la selección de pago del usuario y construye la estrategia requerida (ej. PseStrategy).
3. La fábrica retorna la instancia al Checkout bajo la interfaz abstracta PaymentStrategy.
4. El Checkout simplemente invoca el contrato strategy.process(amount). La fábrica asume la toma de decisiones estructurales y la estrategia ejecuta la acción; el Checkout nunca cambia.

**Justificación de superioridad frente a una solución sin patrones:**

Sin patrones de diseño, el código dependería de múltiples estructuras de control condicionales anidadas (if/else o switch) para evaluar el país y, seguidamente, el método de pago. Esta combinación de Strategy y Factory Method garantiza el cumplimiento del Principio de Responsabilidad Única (SRP) y el Principio Abierto/Cerrado (OCP) de la arquitectura SOLID. Integrar un nuevo país o una nueva pasarela de pagos no requiere modificar el código existente en producción, únicamente añadir las nuevas clases que implementen las interfaces base.


### Ejercicio 02 — Sistema de Notificaciones Multicanal

Enunciado del Ejercicio:

Cuando un pedido cambia de estado (pendiente → enviado → entregado), el sistema notifica por correo,
SMS, WhatsApp y push. No todos los usuarios tienen activos los mismos canales. Cada canal tiene su
propia forma de construir y formatear el mensaje.

**Captura de ejecución:**

<img width="1172" height="495" alt="image" src="https://github.com/user-attachments/assets/88394354-bdf5-4c34-8842-82e8a05a619c" />


**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Observer:** Desacopla el objeto comercial principal (Pedido / Subject) de los diversos canales de comunicación (EmailNotifier, SmsNotifier, PushNotifier), los cuales actúan como observadores. Permite que se puedan añadir o remover canales dinámicamente en tiempo de ejecución de acuerdo con las preferencias del usuario sin alterar la lógica de negocio del pedido.
+ **Factory Method:** Centraliza y aísla la responsabilidad de construcción y formateo del cuerpo del mensaje nativo de cada canal de notificación (EmailMessageFactory, SmsMessageFactory, PushMessageFactory). Esto evita que el observador contenga reglas rígidas o condicionales embebidos para estructurar textos planos, HTML o payloads en formato JSON.

**2. Descripción de la interacción**
1. Cuando un Pedido experimenta una transición o cambio en su estado interno (pendiente, enviado, entregado), este actúa como el disparador del evento central.
2. El Pedido realiza una iteración sobre todos sus observadores activos y despacha una notificación invocando el método notify(OrderEvent event).
3. Cada observador concreto recibe la alerta y delega la instanciación de su estructura de datos a su respectiva fábrica de mensajes (MessageFactory.build(event)).
4. La fábrica procesa los metadatos del evento y retorna un objeto de tipo genérico Message adaptado al protocolo correspondiente (HTML para correos, texto plano limitado para SMS, JSON estructurado para Push).
5. Finalmente, el observador toma el objeto retornado por su fábrica y efectúa el proceso físico de envío al usuario final.

**Justificación de superioridad frente a una solución sin patrones:** 

Sin la combinación de estos patrones, el objeto Pedido tendría la responsabilidad directa de instanciar cada canal de comunicación de forma manual, generando un alto acoplamiento rígido. Por otra parte, sin el uso de fábricas dedicadas, los notificadores acumularían bloques extensos de lógica dispersa para codificar manualmente formatos asimétricos (HTML, JSON o strings limpios), violando de forma directa el Principio de Responsabilidad Única (SRP) y provocando código redundante difícil de mantener.

### Ejercicio 03 — Sistema de Reportes Empresariales

Enunciado del Ejercicio:

La empresa genera reportes en PDF, Excel y CSV. Todos siguen los mismos 4 pasos: obtener datos →
procesar información → aplicar formato → exportar archivo. Pero cada formato implementa 'aplicar formato' y
'exportar' de forma diferente. Además, el sistema decide dinámicamente qué tipo de reporte crear.

**Captura de ejecución:**

<img width="765" height="527" alt="image" src="https://github.com/user-attachments/assets/ea5fb644-d9f9-4627-b5d0-62f28b5fa048" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Template Method:** Define la estructura fija e inalterable del algoritmo global para la generación de reportes en la clase base abstracta (ReportGenerator), exponiendo un método de plantilla final (generate()). Su rol fundamental es centralizar los pasos comunes e invariables (obtener y procesar datos) , mientras delega los pasos variables (formatear y exportar) mediante firmas abstractas a las subclases.
+ **Factory Method:** Centraliza e individualiza la creación dinámica de las instancias de los reportes correspondientes sin acoplar al cliente a las clases concretas (PdfReport, ExcelReport, CsvReport). Su función es evaluar el parámetro solicitado y retornar el generador bajo la abstracción genérica de la clase base.

**2. Descripción de la interacción**
1. El cliente solicita a la fábrica (ReportFactory) un formato de reporte específico (ejemplo: "PDF") sin conocer la clase concreta subyacente.
2. La fábrica evalúa la cadena, construye la instancia correspondiente (PdfReport) y la retorna tipada como el padre abstracto ReportGenerator.
3. El cliente invoca el método definitivo report.generate().
4. El método plantilla de la clase base toma el control secuencial absoluto: ejecuta de manera directa los métodos fijos fetchData() y processData() , y posteriormente despacha la ejecución polimórfica de applyFormat() y exportFile() que fueron sobreescritos específicamente por la subclase instanciada.

**Justificación de superioridad frente a una solución sin patrones:** 

Sin la aplicación de estos patrones, cada formato de reporte tendría que duplicar el flujo completo de los 4 pasos o depender de una clase utilitaria saturada de condicionales cruzados para determinar qué formato aplicar. Al combinar Template Method y Factory Method, el esqueleto algorítmico se escribe una sola vez, garantizando que se cumpla de forma estricta la secuencia del negocio. Agregar un nuevo formato (como un reporte en JSON) se limita a extender la clase base implementando únicamente sus dos pasos variables y agregando su mapeo a la fábrica, sin arriesgar ni alterar en absoluto el código existente de la plataforma.

### Ejercicio 04 — Plataforma de Videojuegos — Personajes

Enunciado del Ejercicio:

Un videojuego crea guerreros, magos y arqueros. Cada personaje puede tener habilidades especiales,
armadura, arma y mejoras temporales (escudo de hielo, velocidad extra, invisibilidad). El personaje se
construye al inicio de la partida, pero sus poderes pueden aumentar dinámicamente durante el juego.

**Captura de ejecución:**

<img width="885" height="571" alt="image" src="https://github.com/user-attachments/assets/b3ecbffd-b664-4e20-a506-0a4bf7882a68" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Builder:** Se encarga de construir el personaje paso a paso al inicio de la partida. Dado que un personaje puede tener múltiples atributos configurables (armadura, arma, habilidades), el Builder evita el uso de constructores complejos o engorrosos (anti-patrón Telescoping Constructor con múltiples parámetros) permitiendo una inicialización fluida y legible.
+ **Decorator:** Permite agregar poderes y mejoras temporales de manera dinámica en tiempo de ejecución (runtime) sin modificar la clase base del personaje. Envuelve (hace un wrap) al objeto base para añadir comportamientos adicionales, como un escudo de hielo o velocidad extra.

**Descripción de la interacción**
1. La configuración inicial ocurre a través del Builder, el cual crea y retorna el personaje base definitivo antes de entrar a la arena de combate.
2. Durante el transcurso del juego, el personaje base es inyectado dentro de los Decoradores que actúan como "capas" de poderes temporales.
3. Cuando el cliente (el juego) invoca la acción attack(), la llamada atraviesa la cadena de decoradores (aplicando los efectos adicionales) hasta llegar al método base del personaje. Al terminar el efecto, el wrapper simplemente se descarta, manteniendo intacto al personaje original.

**Justificación de superioridad frente a una solución sin patrones:**

Si no se usara Decorator, modelar cada posible combinación de poderes requeriría usar herencia múltiple o crear una subclase por cada variante posible. Como indica el ejercicio, para 5 poderes combinables, se generaría una explosión combinatoria resultando en $2^5 = 32$ subclases. Al implementar Decorator, el sistema se reduce a solo 6 clases (5 decoradores específicos + 1 clase base).

### Ejercicio 05 — Integración con Sistema Bancario Antiguo

Enunciado del Ejercicio:

El sistema moderno usa PaymentProcessor con métodos modernos. El banco antiguo expone
LegacyBankService con métodos incompatibles (executeTransaction, verifyBalance en centavos). Además,
usar LegacyBankService directamente requiere 8 pasos de inicialización que los desarrolladores no
deberían conocer.

**Captura de ejecución:**

<img width="689" height="796" alt="image" src="https://github.com/user-attachments/assets/b001e662-6725-40ab-96c4-8a0d03015fca" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Adapter:** Actúa como un traductor entre el código moderno y el sistema heredado (legacy). Su rol es hacer que la clase antigua LegacyBankService sea compatible con la interfaz moderna PaymentProcessor que espera el sistema. Internamente se encarga de adaptar la firma de los métodos y transformar los tipos de datos (por ejemplo, convertir montos de tipo double a enteros en centavos).
+ **Facade:** Proporciona una interfaz de alto nivel que oculta la complejidad estructural del subsistema subyacente. Su rol es exponer un único método simple, como procesarPago(monto), abstrayendo al desarrollador de tener que conocer y ejecutar manualmente los 8 pasos obligatorios de inicialización que requiere el banco antiguo.

**2. Descripción de la interacción**
1. El desarrollador del sistema moderno invoca el método simplificado BankFacade.procesarPago(monto) sin preocuparse por la lógica interna.
2. Internamente, la Facade toma el control y orquesta la inicialización del sistema bancario, ejecutando los pasos requeridos (establecer conexión, abrir sesión, configurar contexto, etc.).
3. Una vez el sistema antiguo está inicializado, la Facade delega la operación al Adapter (LegacyBankAdapter).
4. El Adapter recibe la orden bajo el contrato moderno, traduce el monto a centavos y ejecuta el método incompatible legacy.executeTransaction("ACC", cents). El sistema moderno jamás toca o interactúa directamente con el LegacyBankService.

**Justificación de superioridad frente a una solución sin patrones:**

Si no se aplicara el Adapter, la lógica de conversión de datos (de decimal a centavos) y las llamadas a métodos obsoletos contaminarían las capas superiores de negocio del sistema moderno, dificultando futuras migraciones a otras pasarelas. Si no se usara la Facade, cada módulo que necesitara procesar un pago tendría que duplicar las 8 líneas de inicialización de conexión y configuración del banco antiguo, lo que generaría un acoplamiento crítico y un código muy frágil ante cambios. Al usar ambos, la complejidad se encapsula y las interfaces se estandarizan (Adapter habla el idioma del otro, Facade simplifica el uso).

### Ejercicio 06 —  Motor de Recomendaciones

Enunciado del Ejercicio:

Una plataforma tipo Netflix usa algoritmos de recomendación por género, historial, popularidad y similitud
con otros usuarios. El usuario puede cambiar sus preferencias de recomendación en cualquier momento.
Cuando esto ocurre, la página principal, las notificaciones y la lista de 'sugeridos' deben actualizarse
automáticamente.

**Captura de ejecución:**

<img width="1000" height="418" alt="image" src="https://github.com/user-attachments/assets/284d8687-744c-4c1a-bb5b-1e24ee1852bc" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Strategy:** Responde a la pregunta de "cómo recomendar". Encapsula los diferentes algoritmos de sugerencia de contenido (por género, por historial, por popularidad) permitiendo que el motor intercambie la estrategia en tiempo de ejecución sin necesidad de reiniciar la aplicación.
+ **Observer:** Responde a la pregunta de "a quién avisar" cuando la estrategia cambia. Permite que los diferentes componentes del sistema (página principal, servicio de notificaciones, lista de sugeridos) se suscriban a los eventos del usuario y se actualicen automáticamente cuando este modifica sus preferencias.

**Descripción de la interacción**

Ambos patrones son completamente ortogonales y se complementan:
1. El usuario modifica su configuración, lo que provoca un cambio en el algoritmo RecommendationAlgorithm (Strategy) asignado a su perfil.
2. Inmediatamente, el perfil del usuario (que actúa como el Subject del Observer) dispara un evento de notificación a todos los componentes visuales o de backend suscritos.
3. Cada componente (HomePageComponent, NotificationService) recibe la alerta onPreferenceChanged(User user) y le pide al perfil del usuario la nueva lista de recomendaciones calculada con el nuevo algoritmo.
4. La interfaz de usuario (UI) se reactualiza con el nuevo contenido de forma reactiva, eliminando la necesidad de hacer polling (consultas periódicas al servidor).

**Justificación de superioridad frente a una solución sin patrones:** 

Sin Strategy, la lógica de cálculo de recomendaciones sería un método gigantesco lleno de bloques switch o condicionales anidados, violando el principio de responsabilidad única. Sin Observer, los componentes gráficos de la plataforma estarían fuertemente acoplados a la lógica del perfil de usuario y tendrían que "adivinar" o preguntar constantemente si las preferencias cambiaron, lo cual degradaría enormemente el rendimiento y dificultaría la agregación de nuevas vistas.

### Ejercicio 07 — Flujo de Aprobación de Documentos

Enunciado del Ejercicio:

Los documentos pasan por: revisión del autor, revisión del líder, revisión jurídica, revisión financiera y
aprobación final. No todos pasan por todas las etapas. Además, el documento tiene estados propios:
borrador, en revisión, aprobado, rechazado. La transición de estado depende del resultado de cada handler
de la cadena.

**Captura de ejecución:**

<img width="697" height="685" alt="image" src="https://github.com/user-attachments/assets/c4381659-5083-4d88-a02f-0082f0ae5b00" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Chain of Responsibility:** Su rol es encadenar jerárquicamente a los diferentes validadores u objetos responsables de revisar el documento (AutorHandler, LiderHandler, JuridicoHandler). Esto permite que cada eslabón decida autónomamente si tiene la competencia para procesar el documento (según su tipo o contenido) o si debe pasarlo al siguiente validador en la cadena, desacoplando al emisor de los receptores.
+ **State:** Su función es gobernar y encapsular las transiciones de estado internas del documento (DraftState, InReviewState, ApprovedState, RejectedState). Permite que el documento delegue su comportamiento a la instancia del estado en el que se encuentra actualmente, eliminando por completo la necesidad de mantener largos y rígidos bloques lógicos de switch(estado) o múltiples if/else.

**2. Descripción de la interacción**
1. El documento entra a la secuencia e inicia su recorrido a través del eslabón base del Chain of Responsibility.
2. El manejador en turno evalúa mediante un método booleano (canHandle(doc)) si debe procesarlo. Si no es su responsabilidad, lo delega al siguiente eslabón.
3. Si el validador decide procesarlo, aplica su lógica de negocio y, dependiendo del resultado de su auditoría, invoca directamente los métodos de transición document.approve() o document.reject().
4. El documento recibe la orden pero no la procesa por sí mismo, sino que delega la acción a su objeto State actual.
5. El estado encapsulado (InReviewState, por ejemplo) ejecuta las reglas correspondientes a su fase y cambia la referencia del estado en el contexto hacia la nueva etapa lógica (ApprovedState o RejectedState), permitiendo que el documento fluya orgánicamente sin enterarse de su propia complejidad transicional.

**Justificación de superioridad frente a una solución sin patrones:**

Si no se aplicara la Cadena de Responsabilidad, la lógica de asignación obligaría a tener una súper-clase que conozca absolutamente a todos los departamentos de la empresa y coordine quién revisa qué con excesivos if(doc.type == "Legal") { juridico.revisar() }. Esto violaría el principio de Abierto/Cerrado. Por otro lado, si no se utilizara el patrón State, cada vez que el documento fuera aprobado o rechazado, la clase Document requeriría sentencias condicionales (if (estado == BORRADOR) {...} else if (estado == EN_REVISION) {...}) para determinar a qué nuevo estado debe transicionar. La combinación de ambos aísla perfectamente quién revisa el flujo (Chain) de la máquina de estados del documento (State).

### Ejercicio 08 — Sistema de Pedidos en Restaurante

Enunciado del Ejercicio:

El cliente construye una hamburguesa eligiendo ingredientes, tamaño, tipo de pan, acompañamientos y
extras. Después de confirmado el pedido, el sistema debe notificar a cocina (preparar), a facturación
(generar cuenta) y al domiciliario (preparar ruta) sin que el pedido los conozca directamente.

**Captura de ejecución:**

<img width="580" height="264" alt="image" src="https://github.com/user-attachments/assets/dc8afbad-fabd-43b1-9dd7-0572556b0ea1" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Builder:** Se encarga de construir la estructura compleja del pedido de forma secuencial y legible. Al tener múltiples atributos opcionales (tipo de pan, tamaño, múltiples acompañamientos, extras), el Builder evita el antipatrón de un constructor masivo ("constructor caótico") y garantiza que el objeto final (Order) sea inmutable y completamente válido antes de existir en el sistema.
+ **Observer:** Gestiona la comunicación reactiva una vez que el pedido está listo. Notifica automáticamente a múltiples subsistemas interesados (KitchenService, BillingService, DeliveryService) cuando ocurre el evento de confirmación, desacoplando completamente a la entidad del pedido de la lógica de preparación, cobro y logística.

**2. Descripción de la interacción**
1. El cliente inicia un encadenamiento de métodos mediante el OrderBuilder, configurando gradualmente las especificaciones de su hamburguesa y acompañamientos.
2. Se invoca el método build(), el cual valida la configuración y retorna una instancia inmutable de Order.
3. Los diferentes departamentos del restaurante (Cocina, Facturación, Domicilios) se suscriben al pedido recién creado utilizando order.addObserver(...).
4. Cuando el cliente presiona el botón de confirmar, el sistema invoca order.confirm(). En este punto, el pedido itera sobre su lista de observadores y dispara la notificación a todos los subsistemas simultáneamente. Cada servicio reacciona de manera independiente y asíncrona sin que el pedido conozca su existencia.

**Justificación de superioridad frente a una solución sin patrones:**

Sin el patrón Builder, tendríamos que usar un constructor con decenas de parámetros nulos (new Order("Grande", "Doble", null, null, "Papas", null)), lo cual es propenso a errores humanos, o usar setters directos que dejarían al pedido en un estado inconsistente y mutable. Sin el patrón Observer, el método confirm() del pedido tendría que instanciar y llamar explícitamente a cocina.preparar(), facturacion.cobrar() y domicilio.rutear(), creando un acoplamiento rígido que obligaría a modificar la clase base del pedido cada vez que el restaurante abra un nuevo departamento (por ejemplo, un MarketingService para acumular puntos).


### Ejercicio 09 — Sistema de Autenticación Empresarial

Enunciado del Ejercicio:

La empresa tiene 5 métodos de autenticación: usuario/contraseña, Google, Microsoft, token empresarial y
biometría. Según el tipo de usuario, el sistema selecciona el mecanismo correcto. Una vez autenticado, la
solicitud pasa por: validación de credenciales, validación de permisos, validación de ubicación y validación de
horario laboral.

**Captura de ejecución:**

<img width="1022" height="723" alt="image" src="https://github.com/user-attachments/assets/79a8fb9f-84a5-4e3c-a1dc-9e4ee977c388" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Strategy:** Responde a la fase de autenticación (quién eres). Su rol es encapsular de manera independiente los diferentes mecanismos técnicos para verificar la identidad del usuario (usuario/contraseña, Google, Microsoft, token empresarial, biometría). El servicio central de autenticación interactúa únicamente con la interfaz AuthStrategy, permitiendo añadir o cambiar mecanismos de verificación sin modificar el flujo principal.
+ **Chain of Responsibility:** Responde a la fase de autorización y control de políticas (qué puedes hacer y bajo qué condiciones). Su rol es pasar la solicitud de acceso a través de una cadena secuencial de validadores independientes (credenciales, permisos, ubicación geográfica y horario laboral). Cada eslabón evalúa una regla de negocio específica y decide autónomamente si permite continuar al siguiente control o si detiene el flujo interrumpiendo el acceso.

**2. Descripción de la interacción**

Ambos patrones dividen el proceso de acceso en dos etapas claramente diferenciadas y secuenciales:
1. El usuario envía su solicitud. El AuthService determina dinámicamente el tipo de usuario y selecciona la Strategy correcta para validar su identidad (por ejemplo, GoogleStrategy).
2. Si la estrategia confirma que la identidad es legítima, el resultado exitoso se transfiere de inmediato al primer eslabón de la Chain of Responsibility.
3. La solicitud viaja por los validadores: CredentialValidator $\rightarrow$ PermissionValidator $\rightarrow$ LocationValidator $\rightarrow$ TimeValidator.
4. Si algún validador detecta una infracción (por ejemplo, el usuario está fuera de su horario laboral), interrumpe el flujo arrojando una excepción (AccessDeniedException). El acceso total se concede únicamente si la estrategia valida la identidad y toda la cadena aprueba las políticas de seguridad.

**Justificación de superioridad frente a una solución sin patrones:**

Sin Strategy, la clase central de autenticación se vería inundada de condicionales acoplados a librerías externas de terceros (SDK de Google, Azure AD de Microsoft, APIs biométricas), volviéndose sumamente inestable. Sin la Cadena de Responsabilidad, los controles de seguridad post-autenticación estarían mezclados en un único bloque monolítico; si el día de mañana se requiere omitir la validación de ubicación para directivos o agregar un control de doble factor (2FA), se tendría que reescribir todo el núcleo del sistema, aumentando drásticamente el riesgo de introducir brechas de seguridad. La separación estructural ("Strategy elige la llave, Chain inspecciona el equipaje") garantiza modularidad absoluta.

### Ejercicio 10 — Aplicación de Edición de Imágenes

Enunciado del Ejercicio:

La app permite aplicar filtros acumulativos: blanco y negro, sepia, brillo, contraste y reducción de ruido. El
usuario puede aplicar varios filtros sobre la misma imagen en cualquier orden. Además, cada acción debe
poder deshacerse de manera individual (no solo deshacer la última).

**Captura de ejecución:**

<img width="1111" height="585" alt="image" src="https://github.com/user-attachments/assets/54686282-f72e-4c59-881e-41cca0b4d834" />

**Explicación:**

**1. Explicación del rol de cada patrón**

+ **Decorator:** Su rol es permitir la adición de filtros visuales (blanco y negro, sepia, brillo, contraste) sobre una imagen de forma dinámica, acumulativa y en cualquier orden combinatorio. En lugar de modificar la imagen original o crear sub-clases para cada combinación de filtros, cada filtro actúa como un contenedor (wrapper) que envuelve la imagen base y altera su renderizado en tiempo de ejecución.
+ **Command:** Su rol es encapsular la acción de aplicar un filtro como un objeto autónomo (ImageCommand). Al transformar la operación en un objeto, se vuelve posible almacenar las acciones en una lista de historial, permitiendo no solo registrar qué filtros se han colocado, sino también invocar su método undo() de manera aislada para revertir o remover un filtro específico en cualquier posición del historial.

**2. Descripción de la interacción**
1. El usuario decide aplicar un filtro (por ejemplo, Sepia) a una imagen base.
2. El sistema instancia un ApplyFilterCommand, asociándolo al decorador correspondiente (SepiaDecorator).
3. Al ejecutarse el comando mediante execute(), este envuelve la representación de la imagen actual con el nuevo decorador y se registra a sí mismo en el historial de comandos activos.
4. Cuando el usuario solicita un deshecho (undo) de un filtro individual (incluso si no fue el último aplicado), se localiza el comando específico en el historial y se invoca su método undo(). El comando remueve su decorador asociado del pipeline de renderizado de la imagen y actualiza la vista, logrando una edición no destructiva y selectiva.

**Justificación de superioridad frente a una solución sin patrones:**

Sin Decorator, intentar soportar 5 filtros combinables en cualquier orden provocaría una explosión combinatoria de subclases ($2^5 = 32$ combinaciones fijas distintas) o requeriría una matriz compleja de banderas lógicas dentro de una única clase de imagen, haciendo inviable añadir nuevos filtros en el futuro. Sin el patrón Command, gestionar un historial de modificaciones y permitir la eliminación selectiva de un filtro intermedio obligaría a guardar copias completas de mapas de bits en memoria por cada paso (consumiendo gigabytes de RAM de forma ineficiente) o a acoplar rígidamente la interfaz gráfica con algoritmos reversibles manuales sumamente complejos.

