package Pizarra;

import Pizarra.XML.EscribirXML;
import Pizarra.XML.LeerXML;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Scanner teclado = new Scanner(System.in);

    /**
     * Se instancia el objeto de coche
     */

    Coches coche;

    /**
     * Se crea una lista ESTÁTICA y su correspondiente getter
     */

    static List<Coches> listaCoches = new LinkedList<>();

    public List<Coches> getListaCoches() {
        return listaCoches;
    }

    /**
     * Método para agregar el objeto por teclado
     */

    public void addCoches () {
        System.out.print("Marca: ");
        String marca = teclado.next();
        System.out.print("Modelo: ");
        String modelo = teclado.next();
        System.out.print("Cilindrada: ");
        String cilindrada = teclado.next();

        coche = new Coches(marca, modelo, cilindrada);
        listaCoches.add(coche);

    }

    public static void main(String[] args) {

        Main main = new Main();

        main.addCoches();

        EscribirXML escribirXML = new EscribirXML();
        escribirXML.escribirXML("Concesionario.xml");

        LeerXML leerXML = new LeerXML("Concesionario.xml");
        leerXML.read();

    }
}