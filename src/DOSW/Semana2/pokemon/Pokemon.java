package DOSW.Semana2.pokemon;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int nivel;

    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Pokemon(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
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
}

