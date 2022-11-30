package modelo;

import java.util.List;

public enum Posicion {

    GK,
    DF,
    MF,
    FW;

    private String posicion;

    public static List<Posicion> getPosiciones() {
        return List.of(GK, DF, MF, FW);
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return posicion;
    }

}
