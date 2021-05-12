package org.example.logica;

import java.util.ArrayList;
import java.util.List;

public class Personas {

    private List<Persona> listaPersonas;

    public Personas () {
        listaPersonas = new ArrayList<>();
    }

    public boolean add (Persona persona) {
        listaPersonas.add(persona);
        return false;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public boolean remove (int index) {
        listaPersonas.remove(index);
        return false;
    }

    public boolean removeByDni (String dni) {
        boolean respuesta = false;
        /*for (Persona persona : listaPersonas) {
            if (persona.getDni().equals(dni)) {
                listaPersonas.remove(persona);
            }
        }*/
        for (int i = 0; i < listaPersonas.size(); i++){
            if (listaPersonas.get(i).getDni().equals(dni)) {
                listaPersonas.remove(i);
                respuesta = true;
            }
        }
        return respuesta;
    }
}
