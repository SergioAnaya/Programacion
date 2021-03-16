import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class Prueba {

    /**
     * Variable del documento
     */

    private Document doc;

    /**
     * Método para leer
     * @param nombreArchivo
     */

    public void leerXML (String nombreArchivo) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new File(nombreArchivo));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que contiene los datos que vamos a AÑADIR
     */

    public void addElementos () {

        /**
         * Esta línea se usa para sacar el nodo raíz en este caso concesionario
         */

        Node nodoRaiz = doc.getElementsByTagName("concesionario").item(0);

        Element elementoCoche = doc.createElement("coche");
        nodoRaiz.appendChild(elementoCoche);

        Element elementoMarca = doc.createElement("marca");
        elementoMarca.appendChild(doc.createTextNode("Audi"));
        elementoCoche.appendChild(elementoMarca);

        Element elementoModelo = doc.createElement("modelo");
        elementoModelo.appendChild(doc.createTextNode("R8"));
        elementoCoche.appendChild(elementoModelo);

        Element elementoCilindrada = doc.createElement("cilindrada");
        elementoCilindrada.appendChild(doc.createTextNode("8.0"));
        elementoCoche.appendChild(elementoCilindrada);

    }

    public void escribirXML (String nombreArchivo) {

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File(nombreArchivo));
            Source input = new DOMSource(doc);
            transformer.transform(input, output);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void elementosHandler (String nombreArchivo) {
        leerXML(nombreArchivo);
        addElementos();
        escribirXML(nombreArchivo);
    }



    public static void main(String[] args) {
        Prueba prueba = new Prueba();
        prueba.elementosHandler("Concesionario.xml");
    }

}
