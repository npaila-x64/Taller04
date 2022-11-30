package modelo;

import javax.swing.*;

public class Seleccion {

    private String nombre;
    private Integer ranking;
    private ImageIcon icono;

    public Seleccion() {
        this.nombre = "";
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
}
