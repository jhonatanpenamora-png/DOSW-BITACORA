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
