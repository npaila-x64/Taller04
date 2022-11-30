package controlador;

import modelo.Seleccion;
import util.Utilidades;
import vista.PanelVisorEquipos;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ControladorVisorEquipo {

    private PanelVisorEquipos vista;
    private ControladorAplicacion controlador;
    private List<Seleccion> selecciones;

    public ControladorVisorEquipo(ControladorAplicacion controlador) {
        this.controlador = controlador;
        vista = new PanelVisorEquipos(this);
        this.controlador.agregarPanel(vista, "visor");
        this.selecciones = new ArrayList<>();
    }

    private void cargarSelecciones() {
        try {
            String contenidos = Utilidades.leerArchivo("src/main/datos/teams.txt");
            obtenerSeleccionesDeArchivo(contenidos);
            vista.cargarListaDeSelecciones(selecciones);
        } catch (FileNotFoundException e) {
            mostrarSeleccionesNoSePudieronCargar();
            e.printStackTrace();
        }
    }

    private void obtenerSeleccionesDeArchivo(String contenidos) {
        for (String fila : contenidos.split("\\R")) {
            String[] campos = fila.split(";");
            Seleccion seleccion = new Seleccion();
            seleccion.setNombre(campos[1]);
            seleccion.setRanking(Integer.parseInt(campos[2]));
            ImageIcon icono = new ImageIcon("src/main/datos/banderas/".concat(campos[3]));
            seleccion.setIcono(icono);
            selecciones.add(seleccion);
        }
    }

    private void mostrarSeleccionesNoSePudieronCargar() {
        JOptionPane.showMessageDialog(controlador.getMarco(),
                "Hubo un error al cargar las selecciones",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void abrir() {
        cargarSelecciones();
        controlador.mostrarPanel("visor");
    }

    public void cargarEquipoHaSidoSolicitado(Object nombre) {
        vista.cargarSeleccion(selecciones
                .stream()
                .filter(t -> t.getNombre().equals(nombre))
                .findFirst().orElse(new Seleccion()));
    }

    public void salirHaSidoSolicitado() {
        controlador.salirHaSidoSolicitado();
    }

    public void editarJugadoresHaSidoSolicitado() {

    }
}
