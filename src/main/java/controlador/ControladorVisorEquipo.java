package controlador;

import vista.PanelVisorEquipos;

public class ControladorVisorEquipo {

    private PanelVisorEquipos vista;
    private ControladorAplicacion controlador;

    public ControladorVisorEquipo(ControladorAplicacion controlador) {
        this.controlador = controlador;
        vista = new PanelVisorEquipos(this);
        this.controlador.agregarPanel(vista, "visor");
    }

    public void abrir() {
        controlador.mostrarPanel("visor");
    }
}
