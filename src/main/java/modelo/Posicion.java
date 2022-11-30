package modelo;

import java.util.List;

public enum Posicion {

    GK,
    DF,
    MF,
    FW;

    public static List<Posicion> getPosiciones() {
        return List.of(GK, DF, MF, FW);
    }

    public static Posicion encontrarPorNombre(String value){
        for(Posicion v : getPosiciones()){
            if(v.toString().toLowerCase().equals(value.toLowerCase())){
                return v;
            }
        }
        return null;
    }
}
