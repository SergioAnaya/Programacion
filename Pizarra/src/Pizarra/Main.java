package Pizarra;

import Pizarra.XML.EscribirXML;
import Pizarra.XML.LeerXML;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LeerXML leerXML = new LeerXML("Concesionario.xml");
        System.out.println(leerXML.getListaCoches());

        System.out.print(leerXML.getMapaCoches());

        //leerXML.prueba();
    }
}