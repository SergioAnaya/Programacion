package org.example.logica;

import java.util.ArrayList;
import java.util.List;

public class Personas {

    private List<Persona> listaPersonas;

    public Personas () {
        listaPersonas = new ArrayList<>();
    }

    public void add (Persona persona) {
        listaPersonas.add(persona);
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
