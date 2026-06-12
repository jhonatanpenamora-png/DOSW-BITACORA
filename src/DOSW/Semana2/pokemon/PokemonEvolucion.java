package DOSW.Semana2.pokemon;


public class PokemonEvolucion {
    private String nombre;
    private boolean puedeEvolucionar;

    public PokemonEvolucion(String nombre, boolean puedeEvolucionar) {
        this.nombre = nombre;
        this.puedeEvolucionar = puedeEvolucionar;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPuedeEvolucionar() {
        return puedeEvolucionar;
    }
}
