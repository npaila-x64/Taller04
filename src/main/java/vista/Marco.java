package vista;

import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame {

    private Container panel;
    private final CardLayout cl;

    public Marco() {
        cl = new CardLayout();
        configurarMarco();
        configurarPanel();
    }

    private void configurarPanel() {
        panel = getContentPane();
        panel.setLayout(cl);
    }

    private void configurarMarco() {
        setTitle("Visor de selecciones");
        setBounds(0, 0, 550, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void agregarPanel(Container panel, String nombre) {
        this.panel.add(nombre, panel);
    }

    public void mostrarPanel(String panel) {
        cl.show(this.panel, panel);
    }
}
