package Persistencia;

import Modelo.Ciudad;
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

public class XMLReader {

    /**
     * Variables
     */

    String nombreArchivo = "establecimientos.xml";
    String dir = System.getProperty("user.dir");

    /**
     * Métodos
     */

    public Node read () {
        Node nodo = null;

        try {
            File archivo = new File(dir + File.separator + nombreArchivo);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            document.getDocumentElement().normalize();

            NodeList listaEstablecimientos = document.getElementsByTagName("concesionario");
            for (int temp = 0; temp < listaEstablecimientos.getLength(); temp++) {
                nodo = listaEstablecimientos.item(temp);
                System.out.println("Elemento:" + nodo.getNodeName());
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("Nombre: " + element.getElementsByTagName("marca").item(0).getTextContent());
                }

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return nodo;
    }

    public static void main(String[] args) {
        XMLReader xml = new XMLReader();
        System.out.println(xml.read());
    }
}