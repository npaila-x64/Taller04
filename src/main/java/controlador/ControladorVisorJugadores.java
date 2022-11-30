package controlador;

import modelo.Jugador;
import modelo.Posicion;
import modelo.Seleccion;
import util.Utilidades;
import vista.JugadoresTableModel;
import vista.PanelVisorJugadores;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ControladorVisorJugadores {

    private PanelVisorJugadores vista;
    private ControladorAplicacion controlador;
    private Seleccion seleccion;
    private List<Jugador> jugadores;
    private JugadoresTableModel modeloDeTabla;

    public ControladorVisorJugadores(ControladorAplicacion controlador) {
        this.controlador = controlador;
        modeloDeTabla = new JugadoresTableModel();
        vista = new PanelVisorJugadores(this);
        this.controlador.agregarPanel(vista, "visorJugadores");
        this.jugadores = new ArrayList<>();
    }

    public void abrirVisorJugadores(Seleccion seleccion) {
        this.seleccion = seleccion;
        cargarJugadores();
        controlador.mostrarPanel("visorJugadores");
    }

    public void volverHaSidoSolicitado() {
        controlador.mostrarPanel("visorSelecciones");
    }

    private void cargarJugadores() {
        try {
            String contenidos = Utilidades.leerArchivo(
                    "src/main/datos/alineaciones/".concat(seleccion.getNombreArchivo()).concat(".txt"));
            obtenerJugadoresDeArchivo(contenidos);
            modeloDeTabla.setJugadores(jugadores);
        } catch (FileNotFoundException e) {
            mostrarJugadoresNoSePudieronCargar();
            e.printStackTrace();
        }
    }

    private void obtenerJugadoresDeArchivo(String contenidos) {
        for (String fila : contenidos.split("\\R")) {
            String[] campos = fila.split(";");
            Jugador jugador = new Jugador();
            jugador.setNumero(Integer.parseInt(campos[0]));
            jugador.setNombre(campos[1]);
            jugador.setPosicion(Posicion.encontrarPorNombre(campos[2]));
            jugadores.add(jugador);
        }
    }

    private void mostrarJugadoresNoSePudieronCargar() {
        JOptionPane.showMessageDialog(controlador.getMarco(),
                "Hubo un error al cargar las selecciones",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public TableModel getModeloDeTabla() {
        return modeloDeTabla;
    }

    public void playersHaSidoSolicitado() {
        controlador.abrirEditorJugador(jugadores);
    }
}
