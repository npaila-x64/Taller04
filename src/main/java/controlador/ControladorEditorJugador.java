package controlador;

import modelo.Jugador;
import modelo.Seleccion;
import vista.PanelEditorJugador;

import java.util.List;

public class ControladorEditorJugador {

    private PanelEditorJugador vista;
    private ControladorAplicacion controlador;
    private Seleccion seleccion;

    public ControladorEditorJugador(ControladorAplicacion controlador) {
        this.controlador = controlador;
        vista = new PanelEditorJugador(this);
        this.controlador.agregarPanel(vista, "visorJugadores");
    }

    public void abrirEditorJugador(List<Jugador> jugadores) {
        vista.cargarListaDeJugadores(jugadores);
        controlador.mostrarPanel("editorJugador");
    }

    public void volverHaSidoSolicitado() {
    }

    public void guardarHaSidoSolicitado() {
    }
}
