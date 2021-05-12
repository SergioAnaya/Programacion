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
    private JList listaPersonas;
    private JButton borrarButton;
    private Personas personas;

    public Ventana (final Personas personas) {
        this.personas = personas;

        /**
         * Crear un modelo de lista
         */

        /*final DefaultListModel<Persona> modeloLista = new DefaultListModel<>();
        for (Persona persona : personas.getListaPersonas()) {
            modeloLista.addElement(persona);
        }*/

        /**
         * Se usa una clase de plantilla para usar la propia lista de la clase Personas (Para trabajar sobre una misma lista)
         */

        final ModeloListaPersonas modeloLista = new ModeloListaPersonas(personas);
        listaPersonas.setModel(modeloLista);

        /**
         *
         */

        ListaRenderer listaRenderer = new ListaRenderer();
        listaPersonas.setCellRenderer(listaRenderer);

        /**
         * Rellenar el combo
         */

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
                modeloLista.addElement(persona);
            }
        });

        /**
         * Botón para mostrar la lista
         */

        /*mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(personas.getListaPersonas());
            }
        });*/

        /**
         * Botón para borrar el elemento seleccionado de la lista
         */

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaPersonas.getSelectedIndex();
                if (index > -1) {
                    modeloLista.remove(index);
                    System.out.println(index);
                } else {
                    JOptionPane.showMessageDialog(borrarButton, "Debe haber una persona seleccionada.");
                }
            }
        });

    }

    public JPanel getPanel () {
        return pnlMain;
    }

}
