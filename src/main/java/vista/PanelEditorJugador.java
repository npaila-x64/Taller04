package vista;

import controlador.ControladorEditorJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEditorJugador extends JPanel implements ActionListener {

    private ControladorEditorJugador controlador;

    public PanelEditorJugador(ControladorEditorJugador controlador) {
        this.controlador = controlador;
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
