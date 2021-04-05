package Pizarra.XML;

import Pizarra.Coches;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeerXML {

    /**
     * Variable del doc
     */

    private Document doc;

    private List<Coches> listaCoches;
    private HashMap<Integer, List<String>> mapaCoches;

    /**
     * Constructor para CARGAR el archivo
     */

    public LeerXML (String file) {

        listaCoches = new LinkedList<>();
        mapaCoches = new HashMap<>();

        String dir = System.getProperty("user.dir");

        try {
            File inputFile = new File(dir + File.separator + file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nl = doc.getElementsByTagName("coche");

            fill(nl);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para LEER el archivo
     */

    public void fill (NodeList nlCoches) {

        for (int i = 0; i < nlCoches.getLength(); i++) {

            Node nodoCoche = nlCoches.item(i);

            if (nodoCoche.getNodeType() == Node.ELEMENT_NODE) {
                Coches coches = getCoche(nodoCoche);
                listaCoches.add(coches);

                if (nodoCoche.hasChildNodes()) {
                    mapaCoches.put(i, crearLista(nodoCoche));
                }
            }
        }
    }

    private Coches getCoche (Node nodoCoche) {
        return new Coches(getMarca(nodoCoche), getModelo(nodoCoche), getCilindrada(nodoCoche));
    }

    private String getMarca (Node nodoCoche) {
        String marca = null;
        if (nodoCoche.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) nodoCoche;
            marca = element.getElementsByTagName("marca").item(0).getTextContent();
        }
        return marca;
    }

    private String getModelo (Node nodoCoche) {

        String modelo = null;

        if (nodoCoche.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) nodoCoche;

            modelo = element.getElementsByTagName("modelo").item(0).getTextContent();

        }
        return modelo;
    }

    private String getCilindrada (Node nodoCoche) {

        String cilindrada = null;

        if (nodoCoche.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) nodoCoche;

            cilindrada = element.getElementsByTagName("cilindrada").item(0).getTextContent();

        }

        return cilindrada;
    }

    /**
     * Método para crear una lista
     */

    private List<String> crearLista (Node nodoCoche) {
        List<String> lista = new LinkedList<>();

        lista.add(getMarca(nodoCoche));
        lista.add(getCilindrada(nodoCoche));

        return lista;

    }

    /**
     * Getters
     */

    public List<Coches> getListaCoches() {
        return listaCoches;
    }

    public HashMap<Integer, List<String>> getMapaCoches() {
        return mapaCoches;
    }


}