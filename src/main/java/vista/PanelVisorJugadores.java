package vista;

import controlador.ControladorVisorJugadores;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVisorJugadores extends JPanel implements ActionListener {

    private ControladorVisorJugadores controlador;
    private JButton bBack;
    private JButton bPlayers;
    private JTable tJugadores;

    public PanelVisorJugadores(ControladorVisorJugadores controlador) {
        this.controlador = controlador;
        crearComponentes();
        setVisible(true);
    }

    private void crearComponentes() {
        configurarPanel();
        crearBotonEditPlayers();
        crearBotonExit();
        crearTablaJugadores();
    }

    private void crearTablaJugadores() {
        tJugadores = new JTable(controlador.getModeloDeTabla());
        tJugadores.setBounds(30, 40, 200, 300);
        tJugadores.setRowHeight(20);
        tJugadores.setCellSelectionEnabled(false);
        tJugadores.getColumnModel().getColumn(0).setPreferredWidth(100);
        tJugadores.getColumnModel().getColumn(1).setPreferredWidth(269);
        tJugadores.getColumnModel().getColumn(2).setPreferredWidth(100);
        tJugadores.setFont(new Font("Arial", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(tJugadores);
        scrollPane.setLocation(37, 38);
        scrollPane.setSize(469, 195);
        add(scrollPane);
    }

    private void configurarPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }

    private void crearBotonExit() {
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setFont(new Font("Arial", Font.PLAIN, 15));
        bBack.setLocation(31, 265);
        bBack.setSize(106, 36);
        bBack.setFocusable(false);
        this.add(bBack);
    }

    private void crearBotonEditPlayers() {
        bPlayers = new JButton("Edit players");
        bPlayers.addActionListener(this);
        bPlayers.setFont(new Font("Arial", Font.PLAIN, 15));
        bPlayers.setLocation(217, 265);
        bPlayers.setSize(174, 36);
        bPlayers.setFocusable(false);
        this.add(bPlayers);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bBack) {
            controlador.volverHaSidoSolicitado();
        }
    }
}
