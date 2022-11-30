package controlador;

import modelo.Jugador;
import modelo.Seleccion;
import vista.PanelEditorJugador;
import vista.PanelVisorJugadores;

public class ControladorEditorJugador {

    private PanelEditorJugador vista;
    private ControladorAplicacion controlador;
    private Seleccion seleccion;

    public ControladorEditorJugador(ControladorAplicacion controlador) {
        this.controlador = controlador;
        vista = new PanelEditorJugador(this);
        this.controlador.agregarPanel(vista, "visorJugadores");
    }

    public void abrirVisorJugadores(Seleccion seleccion) {
        this.seleccion = seleccion;
        controlador.mostrarPanel("visorJugadores");
    }

    public void abrirEditorJugado(Jugador jugador) {
        controlador.mostrarPanel("editorJugador");
    }

    public void abrirEditorJugador(Jugador jugador) {
    }
}
