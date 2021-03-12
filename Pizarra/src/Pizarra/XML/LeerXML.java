package Pizarra.XML;

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

public class LeerXML {

    /**
     * Variable del doc
     */

    private Document doc;

    /**
     * Constructor para CARGAR el archivo
     */

    public LeerXML (String file) {

        String dir = System.getProperty("user.dir");

        try {
            File inputFile = new File(dir + File.separator + file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

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

    public void read () {

        NodeList nl = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nl.item(i);
                if (el.getNodeName().contains("coche")) {
                    String marca = el.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = el.getElementsByTagName("modelo").item(0).getTextContent();
                    String cilindrada = el.getElementsByTagName("cilindrada").item(0).getTextContent();
                    System.out.println(marca + ", " + modelo + ", " + cilindrada);
                }
            }
        }
    }
}