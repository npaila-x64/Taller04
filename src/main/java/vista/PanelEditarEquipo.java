package vista;

import controlador.ControladorEditarEquipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEditarEquipo extends JPanel implements ActionListener {

    private ControladorEditarEquipo controlador;

    public PanelEditarEquipo(ControladorEditarEquipo controlador) {
        this.controlador = controlador;
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
