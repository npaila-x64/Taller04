package modelo;

import javax.swing.*;
import java.util.List;

public class Seleccion {

    private String nombre;
    private String nombreArchivo;
    private Integer ranking;
    private ImageIcon icono;
    private List<Jugador> jugadores;

    public Seleccion() {
        this.nombre = "";
        this.nombreArchivo = "";
        this.ranking = 0;
        this.icono = new ImageIcon();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
}
