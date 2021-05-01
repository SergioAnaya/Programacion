package org.example.vista;

import org.example.logica.Persona;
import org.example.logica.Personas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {

    private JPanel pnlMain;
    private JButton añadirButton;
    private JButton mostrarButton;
    private JTextField txtNombre;
    private JTextField txtDni;
    private JSpinner spnEdad;
    private JComboBox cmbCategoria;
    private Personas personas;

    public Ventana (final Personas personas) {
        this.personas = personas;

        for (String categoria : Persona.getCategorias()) {
            cmbCategoria.addItem(categoria);
        }

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int edad = (int) spnEdad.getValue();
                String dni = txtDni.getText();
                int categoria = Persona.getCategoriaByTag((String) cmbCategoria.getSelectedItem());
                Persona persona = new Persona(nombre, edad, dni, categoria);
                personas.add(persona);
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(personas.getListaPersonas());
            }
        });


    }

    public JPanel getPanel () {
        return pnlMain;
    }

}
