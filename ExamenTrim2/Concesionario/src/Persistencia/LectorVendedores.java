package Persistencia;

import Modelo.Vendedor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LectorVendedores {

    /**
     * Variable del doc
     */

    private Document doc;

    /**
     * Constructor
     */

    public LectorVendedores (String nombreArchivo) {

        String dir = System.getProperty("user.dir");

        try {
            File inputFile = new File(dir + File.separator + nombreArchivo);
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
     * Método para leer el archivo
     */

    public List<Vendedor> read () {

        List<Vendedor> listaVendedores = new LinkedList<>();

        XPath xPath = XPathFactory.newInstance().newXPath();
        String xPathString = "/vendedores/vendedor";

        try {
            NodeList nl = (NodeList) xPath.compile(xPathString).evaluate(doc,
                    XPathConstants.NODESET);

            for (int i = 0; i < nl.getLength(); i++) {
                Vendedor vendedor = getVendedor(nl.item(i));
                listaVendedores.add(vendedor);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return listaVendedores;
    }

    /**
     * Este método se usa para definir la estructura que se va a leer de cada vendedor
     */

    private Vendedor getVendedor (Node nodoVendedor) {

        Element elementoVendedor = (Element) nodoVendedor;

        int id = Integer.parseInt(elementoVendedor.getAttribute("id"));
        String nombre = elementoVendedor.getAttribute("nombre");
        String apellidos = elementoVendedor.getAttribute("apellidos");

        return new Vendedor(id, nombre, apellidos);
    }

    /**
     * Método para crear mapa de id de empleado y matricula
     */

    public Map<String, Integer> mapaMatriculasVentas () {
        Map<String, Integer> mapaMatriculasVentas = new HashMap<>();

        XPath xPath = XPathFactory.newInstance().newXPath();
        String xPathString = "/vendedores/vendedor/venta";

        try {
            NodeList nl = (NodeList) xPath.compile(xPathString).evaluate(doc,
                    XPathConstants.NODESET);

            for (int i = 0; i < nl.getLength(); i++) {
                mapaMatriculasVentas.put(getMatricula(nl.item(i)), getId(nl.item(i).getParentNode()));
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return mapaMatriculasVentas;
    }

    private int getId (Node nodoVendedor) {
        Element elementoVendedor = (Element) nodoVendedor;

        int id = Integer.parseInt(elementoVendedor.getAttribute("id"));

        return id;
    }

    private String getMatricula (Node nodoVendedor) {

        Element elementoVendedor = (Element) nodoVendedor;

        return elementoVendedor.getAttribute("matricula");

    }



}
