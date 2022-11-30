package vista;

import modelo.Jugador;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JugadoresTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Number", "Name", "Position"};
    private final Class[] columnClass = new Class[] {Integer.class, String.class, String.class};

    private List<Jugador> jugadores;

    public JugadoresTableModel() {
        this.jugadores = new ArrayList<>();
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return Optional.of(jugadores).orElse(new ArrayList<>()).size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return switch (col) {
            case 0 -> jugadores.get(row).getNumero();
            case 1 -> jugadores.get(row).getNombre();
            case 2 -> jugadores.get(row).getPosicion();
            default -> throw new IllegalStateException();
        };
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
