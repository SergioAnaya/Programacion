package org.example.vista;

import org.example.logica.Persona;
import org.example.vista.layout.LayoutListaPersona;

import javax.swing.*;
import java.awt.*;

public class ListaRenderer implements ListCellRenderer<Persona> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Persona> list, Persona value, int index, boolean isSelected, boolean cellHasFocus) {
        LayoutListaPersona layoutListaPersona = new LayoutListaPersona(value);
        JPanel panel = layoutListaPersona.getPanel();
        if (isSelected) {
            panel.setBackground(Color.GRAY);
        } else panel.setBackground(Color.WHITE);

        return layoutListaPersona.getPanel();
    }
}
