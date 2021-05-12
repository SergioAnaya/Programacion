package org.example.vista.layout;

import org.example.logica.Persona;

import javax.swing.*;

public class LayoutListaPersona {
    private JPanel pnlMain;
    private JLabel lblNombre;
    private JLabel lblCategoria;
    private JLabel lblDni;
    private JLabel lblEdad;

    public LayoutListaPersona (Persona persona) {
        lblNombre.setText(persona.getNombre());
        lblCategoria.setText(Persona.getCategoriaById(persona.getCategoria()));
        lblEdad.setText(String.valueOf(persona.getEdad()));
        lblDni.setText(persona.getDni());
    }

    public JPanel getPanel () {
        return pnlMain;
    }
}
