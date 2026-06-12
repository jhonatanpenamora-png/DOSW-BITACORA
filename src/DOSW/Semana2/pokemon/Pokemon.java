package DOSW.Semana2.pokemon;

public class Pokemon {
    private Long id;
    private String nombre;
    private String tipo;
    private int nivel;
    private double poderCombate;
    private String region;
    private boolean legendario;
    private boolean puedeEvolucionar;

    public Pokemon(Long id, String nombre, String tipo, int nivel, double poderCombate, String region, boolean legendario) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.poderCombate = poderCombate;
        this.region = region;
        this.legendario = legendario;
    }

    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Pokemon(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Pokemon(String nombre, boolean puedeEvolucionar) {
        this.nombre = nombre;
        this.puedeEvolucionar = puedeEvolucionar;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public double getPoderCombate() {
        return poderCombate;
    }

    public String getRegion() {
        return region;
    }

    public boolean isLegendario() {
        return legendario;
    }

    public boolean isPuedeEvolucionar() {
        return puedeEvolucionar;
    }
}