package Pizarra.XML;

import Pizarra.Main;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscribirXML {

    public void escribirXML (String nombreArchivo) {

        Main main = new Main();

        try {

            /**
             * Inicializamos el archivo
             */

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            /**
             * Se define el elemento raíz del documento
             */

            Element elementoRaiz = doc.createElement("concesionario");
            doc.appendChild(elementoRaiz);

            /**
             * Se definen los nodos que contendrán los elementos
             */

            Element elementoCoche = doc.createElement("coche");
            elementoRaiz.appendChild(elementoCoche);

            Element elementoCoche2 = doc.createElement("coche");
            elementoRaiz.appendChild(elementoCoche2);

            /**
             * Se define un atributo para el nodo coche
             */

            Attr atributoCoche = doc.createAttribute("id");
            atributoCoche.setValue("1");
            elementoCoche.setAttributeNode(atributoCoche);

            Attr atributoCoche2 = doc.createAttribute("id");
            atributoCoche2.setValue("2");
            elementoCoche2.setAttributeNode(atributoCoche2);

            /**
             * Se define cada uno de los elementos y se le asigna un valor
             */

            Element elementoMarca = doc.createElement("marca");
            elementoMarca.appendChild(doc.createTextNode(main.getListaCoches().get(0).getMarca()));
            elementoCoche.appendChild(elementoMarca);

            Element elementoModelo = doc.createElement("modelo");
            elementoModelo.appendChild(doc.createTextNode(main.getListaCoches().get(0).getModelo()));
            elementoCoche.appendChild(elementoModelo);

            Element elementoCilindrada = doc.createElement("cilindrada");
            elementoCilindrada.appendChild(doc.createTextNode(main.getListaCoches().get(0).getCilindrada()));
            elementoCoche.appendChild(elementoCilindrada);

            Element elementoMarca2 = doc.createElement("marca");
            elementoMarca2.appendChild(doc.createTextNode("Ferrari"));
            elementoCoche2.appendChild(elementoMarca2);

            Element elementoModelo2 = doc.createElement("modelo");
            elementoModelo2.appendChild(doc.createTextNode("458"));
            elementoCoche2.appendChild(elementoModelo2);

            Element elementoCilindrada2 = doc.createElement("cilindrada");
            elementoCilindrada2.appendChild(doc.createTextNode("4.5"));
            elementoCoche2.appendChild(elementoCilindrada2);

            /**
             * Se crea el archivo
             */

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nombreArchivo));

            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
