package modelo;

public class Jugador {

    private String nombre;
    private Integer numero;
    private Posicion posicion;
    private Seleccion seleccion;

    public Jugador(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
}
