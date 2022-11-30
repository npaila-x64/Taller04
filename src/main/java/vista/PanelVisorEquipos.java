package vista;

import controlador.ControladorVisorEquipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVisorEquipos extends JPanel implements ActionListener {

    private ControladorVisorEquipo controlador;
    private JComboBox cSelecciones;
    private JLabel eisapre;
    private JLabel efonasa;
    private JTextField trut;
    private JButton bExit;
    private JButton bPlayers;

    public PanelVisorEquipos(ControladorVisorEquipo controlador) {
        this.controlador = controlador;
        crearComponentes();
        setVisible(true);
    }

    private void crearComponentes() {
        configurarPanel();
        crearListaDeSelecciones();

    }

    private void configurarPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }

    private void crearListaDeSelecciones() {
        cSelecciones = new JComboBox<>();
        cSelecciones.setFont(new Font("Arial", Font.PLAIN, 16));
        cSelecciones.setLocation(171, 51);
        cSelecciones.setSize(145, 34);
        cSelecciones.setEditable(false);
        cSelecciones.setFocusable(false);
        cSelecciones.addActionListener(this);
        add(cSelecciones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
