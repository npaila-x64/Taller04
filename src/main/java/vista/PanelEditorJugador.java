package vista;

import controlador.ControladorEditorJugador;
import modelo.Jugador;
import modelo.Seleccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEditorJugador extends JPanel implements ActionListener {

    private ControladorEditorJugador controlador;
    private JComboBox cJugadores;
    private JComboBox cPosiciones;
    private JLabel lChoose;
    private JLabel lRanking;
    private JLabel lPosicion;
    private JTextField tNombre;
    private JButton bBack;
    private JButton bChanges;

    public PanelEditorJugador(ControladorEditorJugador controlador) {
        this.controlador = controlador;
        crearComponentes();
        setVisible(true);
    }

    private void crearComponentes() {
        configurarPanel();
        crearListaDeJugadores();
        crearListaDePosiciones();
        crearEtiquetaNumero();
        crearEtiquetaNombre();
        crearEtiquetaPosicion();
        crearBotonSaveChanges();
        crearCampoDeTextoNombre();
        crearBotonBack();
    }

    private void crearEtiquetaPosicion() {
        lPosicion = new JLabel("Position");
        lPosicion.setFont(new Font("Arial", Font.PLAIN, 16));
        lPosicion.setLocation(100, 183);
        lPosicion.setSize(151, 29);
        this.add(lPosicion);
    }

    private void configurarPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }

    private void crearListaDeJugadores() {
        cJugadores = new JComboBox<>();
        cJugadores.setFont(new Font("Arial", Font.PLAIN, 16));
        cJugadores.setLocation(252, 53);
        cJugadores.setSize(104, 34);
        cJugadores.setEditable(false);
        cJugadores.setFocusable(false);
        cJugadores.addActionListener(this);
        add(cJugadores);
    }

    private void crearListaDePosiciones() {
        cPosiciones = new JComboBox<>();
        cPosiciones.setFont(new Font("Arial", Font.PLAIN, 16));
        cPosiciones.setLocation(252, 181);
        cPosiciones.setSize(173, 34);
        cPosiciones.setEditable(false);
        cPosiciones.setFocusable(false);
        cPosiciones.addActionListener(this);
        add(cPosiciones);
    }

    private void crearEtiquetaNombre() {
        lChoose = new JLabel("Name");
        lChoose.setFont(new Font("Arial", Font.PLAIN, 16));
        lChoose.setLocation(100, 121);
        lChoose.setSize(151, 29);
        this.add(lChoose);
    }

    private void crearEtiquetaNumero() {
        lRanking = new JLabel("Number");
        lRanking.setFont(new Font("Arial", Font.PLAIN, 16));
        lRanking.setLocation(100, 56);
        lRanking.setSize(151, 29);
        this.add(lRanking);
    }

    private void crearCampoDeTextoNombre() {
        tNombre = new JTextField();
        tNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        tNombre.setLocation(253, 119);
        tNombre.setSize(173, 34);
        tNombre.setEditable(false);
        this.add(tNombre);
    }

    private void crearBotonBack() {
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setFont(new Font("Arial", Font.PLAIN, 15));
        bBack.setLocation(31, 265);
        bBack.setSize(101, 36);
        bBack.setFocusable(false);
        this.add(bBack);
    }

    private void crearBotonSaveChanges() {
        bChanges = new JButton("Save changes");
        bChanges.addActionListener(this);
        bChanges.setFont(new Font("Arial", Font.PLAIN, 15));
        bChanges.setLocation(217, 265);
        bChanges.setSize(174, 36);
        bChanges.setFocusable(false);
        this.add(bChanges);
    }

    public void cargarListaDeJugadores(java.util.List<Jugador> jugadores) {
        for (Jugador t : jugadores) {
            cJugadores.addItem(t.getNombre());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bBack) {
            controlador.volverHaSidoSolicitado();
        }
        if (e.getSource() == bChanges) {
            controlador.guardarHaSidoSolicitado();
        }
    }

    public void cargarJugador(Jugador jugador) {
        cJugadores.setSelectedItem(String.valueOf(jugador.getNumero()));
        tNombre.setText(jugador.getNombre());
        cPosiciones.setSelectedItem(jugador.getPosicion());
    }
}
