package controlador;

import modelo.Jugador;
import modelo.Seleccion;
import vista.Marco;

import javax.swing.*;
import java.awt.*;

public class ControladorAplicacion {

    private Marco vista;
    private ControladorVisorSelecciones visorSelecciones;
    private ControladorEditorJugador editor;
    private ControladorVisorJugadores visorJugadores;

    public void iniciar() {
        vista = new Marco();
        crearControladores();
        vista.setVisible(true);
        visorSelecciones.abrir();
    }

    private void crearControladores() {
        visorSelecciones = new ControladorVisorSelecciones(this);
        editor = new ControladorEditorJugador(this);
        visorJugadores = new ControladorVisorJugadores(this);
    }

    public void abrirVisorSelecciones() {
        visorSelecciones.abrir();
    }

    public void abrirVisorJugadores(Seleccion seleccionSeleccionada) {
        visorJugadores.abrirVisorJugadores(seleccionSeleccionada);
    }

    public void abrirEditorJugador(Jugador jugador) {
        editor.abrirEditorJugador(jugador);
    }

    public void agregarPanel(Container panel, String nombre) {
        vista.agregarPanel(panel, nombre);
    }

    public JFrame getMarco() {
        return vista;
    }

    public void mostrarPanel(String panel) {
        vista.mostrarPanel(panel);
    }

    public void salirHaSidoSolicitado() {
        System.exit(0);
    }
}
