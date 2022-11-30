package controlador;

import vista.Marco;

import javax.swing.*;
import java.awt.*;

public class ControladorAplicacion {

    private Marco vista;
    private ControladorVisorEquipo visor;
    private ControladorEditarEquipo editor;

    public void iniciar() {
        vista = new Marco();
        crearControladores();
        vista.setVisible(true);
        visor.abrir();
    }

    private void crearControladores() {
        visor = new ControladorVisorEquipo(this);
        editor = new ControladorEditarEquipo(this);
    }

    public void abrirVisor() {
        visor.abrir();
    }

    public void abrirEditor() {
        editor.abrir();
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
