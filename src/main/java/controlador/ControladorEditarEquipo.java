package controlador;

import vista.PanelEditarEquipo;

public class ControladorEditarEquipo {

    private PanelEditarEquipo vista;
    private ControladorAplicacion controlador;

    public ControladorEditarEquipo(ControladorAplicacion controlador) {
        this.controlador = controlador;
        vista = new PanelEditarEquipo(this);
        this.controlador.agregarPanel(vista, "editor");
    }

    public void abrir() {
        controlador.mostrarPanel("editor");
    }
}
