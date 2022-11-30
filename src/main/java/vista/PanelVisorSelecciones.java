package vista;

import controlador.ControladorVisorSelecciones;
import modelo.Seleccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVisorSelecciones extends JPanel implements ActionListener {

    private ControladorVisorSelecciones controlador;
    private JComboBox cSelecciones;
    private JLabel iconoSeleccion;
    private JLabel lChoose;
    private JLabel lRanking;
    private JTextField tRanking;
    private JButton bExit;
    private JButton bPlayers;

    public PanelVisorSelecciones(ControladorVisorSelecciones controlador) {
        this.controlador = controlador;
        crearComponentes();
        setVisible(true);
    }

    private void crearComponentes() {
        configurarPanel();
        crearListaDeSelecciones();
        crearEtiquetaChooseTeam();
        crearEtiquetaRanking();
        crearCampoDeTextoRanking();
        crearIconoSeleccion();
        crearBotonPlayers();
        crearBotonExit();
    }

    private void configurarPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }

    private void crearListaDeSelecciones() {
        cSelecciones = new JComboBox<>();
        cSelecciones.setFont(new Font("Arial", Font.PLAIN, 16));
        cSelecciones.setLocation(187, 50);
        cSelecciones.setSize(173, 34);
        cSelecciones.setEditable(false);
        cSelecciones.setFocusable(false);
        cSelecciones.addActionListener(this);
        add(cSelecciones);
    }

    private void crearIconoSeleccion() {
        iconoSeleccion = new JLabel();
        iconoSeleccion.setLocation(396, 43);
        iconoSeleccion.setSize(149, 98);
        iconoSeleccion.setHorizontalAlignment(JLabel.CENTER);
        iconoSeleccion.setVerticalAlignment(JLabel.CENTER);
        this.add(iconoSeleccion);
    }

    private void crearEtiquetaChooseTeam() {
        lChoose = new JLabel("Choose team");
        lChoose.setFont(new Font("Arial", Font.PLAIN, 16));
        lChoose.setLocation(35, 54);
        lChoose.setSize(151, 29);
        this.add(lChoose);
    }

    private void crearEtiquetaRanking() {
        lRanking = new JLabel("Ranking FIFA");
        lRanking.setFont(new Font("Arial", Font.PLAIN, 16));
        lRanking.setLocation(35, 120);
        lRanking.setSize(151, 29);
        this.add(lRanking);
    }

    private void crearCampoDeTextoRanking() {
        tRanking = new JTextField();
        tRanking.setFont(new Font("Arial", Font.PLAIN, 16));
        tRanking.setLocation(186, 115);
        tRanking.setSize(100, 29);
        tRanking.setEditable(false);
        this.add(tRanking);
    }

    private void crearBotonExit() {
        bExit = new JButton("Exit");
        bExit.addActionListener(this);
        bExit.setFont(new Font("Arial", Font.PLAIN, 15));
        bExit.setLocation(330, 265);
        bExit.setSize(141, 36);
        bExit.setFocusable(false);
        this.add(bExit);
    }

    private void crearBotonPlayers() {
        bPlayers = new JButton("Players");
        bPlayers.addActionListener(this);
        bPlayers.setFont(new Font("Arial", Font.PLAIN, 15));
        bPlayers.setLocation(90, 265);
        bPlayers.setSize(141, 36);
        bPlayers.setFocusable(false);
        this.add(bPlayers);
    }

    public void cargarListaDeSelecciones(java.util.List<Seleccion> selecciones) {
        for (Seleccion t : selecciones) {
            cSelecciones.addItem(t.getNombre());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cSelecciones) {
            controlador.cargarEquipoHaSidoSolicitado(cSelecciones.getSelectedItem());
        }
        if (e.getSource() == bExit) {
            controlador.salirHaSidoSolicitado();
        }
        if (e.getSource() == bPlayers) {
            controlador.editarJugadoresHaSidoSolicitado();
        }
    }

    public void cargarSeleccion(Seleccion seleccion) {
        tRanking.setText(String.valueOf(seleccion.getRanking()));
        iconoSeleccion.setIcon(seleccion.getIcono());
    }
}
