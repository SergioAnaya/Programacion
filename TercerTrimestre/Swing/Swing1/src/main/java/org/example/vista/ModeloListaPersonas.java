package org.example.vista;

import org.example.logica.Persona;
import org.example.logica.Personas;

import javax.swing.*;

public class ModeloListaPersonas extends AbstractListModel<Persona> {

    private Personas personas;

    public ModeloListaPersonas (Personas personas) {
        this.personas = personas;
    }

    @Override
    public int getSize() {
        return personas.getListaPersonas().size();
    }

    @Override
    public Persona getElementAt(int index) {
        return personas.getListaPersonas().get(index);
    }

    public boolean addElement (Persona persona) {
       boolean added = personas.add(persona);
       if (added) {
           fireIntervalAdded(this, personas.getListaPersonas().size()-1, personas.getListaPersonas().size()-1); // Actualizar la lista
       }
        return added;
    }

    public boolean remove (int index) {
       boolean removed = personas.remove(index);
        if (removed) {
            fireIntervalAdded(this, index, index); // Actualizar la lista
        }
        return removed;
    }
}
