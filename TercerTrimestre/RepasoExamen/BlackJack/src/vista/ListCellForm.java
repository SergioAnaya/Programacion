package vista;

import blackjack.Jugador;

import javax.swing.*;
import java.awt.*;

public class ListCellForm implements ListCellRenderer{
    private JPanel pnlMain;
    private JLabel lblNumeroTirada;
    private JLabel lblNumeroObtenido;

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        lblNumeroTirada.setText("Tirada " + index);
        lblNumeroObtenido.setText(String.valueOf(value));
        return pnlMain;
    }
}
