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

<img width="297" height="120" alt="image" src="https://github.com/user-attachments/assets/9553ca8b-0679-4c4a-8794-b0e54236085e" />


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

<img width="348" height="124" alt="image" src="https://github.com/user-attachments/assets/71be3d89-3ec4-4b91-a00b-2fcf9611557e" />


**Explicación:** 

A partir de una lista de `String`, se genera un flujo evaluado mediante `filter()` para retener cadenas con un `length() > 4`. Las palabras restantes mutan mediante `map(String::toUpperCase)` para convertirlas en mayúsculas y son ordenadas alfabéticamente a través de `sorted()`. El resultado se consolida ejecutando la función terminal `count()`.


### Ejercicio 03 — Obtener nombres de usuarios
Enunciado del Ejercicio

Dada una lista de usuarios con los atributos: id, name, age, active.
Filtra únicamente los usuarios activos, obtén una lista con los nombres en mayúscula y ordenada alfabéticamente.


**Código implementado:**

    package DOSW.semana1.streams;
    
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

**Captura de ejecución:** (imagen)

**Explicación:** 

Dada una lista de objetos `User`, el Stream se filtra con `filter(u -> u.active)` reteniendo únicamente usuarios activos. Con `map(u -> u.name.toUpperCase())` se extrae la propiedad del nombre de cada objeto y se convierte a mayúsculas. Esta nueva lista de cadenas se ordena mediante la función intermedia `sorted()` y finaliza con `collect()`.


### Ejercicio 04 — Nombre del Ejercicio
Enunciado del Ejercicio
**Código implementado:** (pegar el código aquí)
**Captura de ejecución:** (imagen)
**Explicación:** (breve descripción de la solución

### Ejercicio 05 — Nombre del Ejercicio
Enunciado del Ejercicio
**Código implementado:** (pegar el código aquí)
**Captura de ejecución:** (imagen)
**Explicación:** (breve descripción de la solución
---
# SEMANA No 2 — Bitácora Pokémon
## Datos de Entrenador:
- Nombre y Apellido:
- Código de Estudiante:
- Curso:
---
### Ejercicio 01 — Nombre del Ejercicio
Enunciado del Ejercicio
**Código implementado:** (pegar el código aquí)
**Captura de ejecución:** (imagen)
**Explicación:** (breve descripción de la solución)
### Ejercicio 02 — Nombre del Ejercicio
...
NOTA: SE DEBE SEGUIR ESTA ESTRUCTURA POR LOS 15 EJERCICIOS CORRESPONDIENTES - DE
ESTE TALLER
---

## Retos Especiales (si aplica)
- [ ] Reto Legendario — Method References
- [ ] Reto Shiny — Buenas prácticas de commits
- [ ] Reto Mewtwo — Ejercicio propuesto
