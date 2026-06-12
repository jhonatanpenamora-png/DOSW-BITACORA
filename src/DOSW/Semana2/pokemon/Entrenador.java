package DOSW.Semana2.pokemon;

import java.util.List;

public class Entrenador {
    private Long id;
    private String nombre;
    private int medallas;
    private List<Pokemon> equipo;

    public Entrenador(Long id, String nombre, int medallas, List<Pokemon> equipo) {
        this.id = id;
        this.nombre = nombre;
        this.medallas = medallas;
        this.equipo = equipo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMedallas() { return medallas; }
    public List<Pokemon> getEquipo() { return equipo; }
}