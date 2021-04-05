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
import java.util.*;

public class LectorVendedores {

    /**
     * Variable del doc
     */

    private Document doc;
    private List<Vendedor> listaVendedores;
    private HashMap<Vendedor, List<String>> mapaVentas;

    /**
     * Constructor
     */

    public LectorVendedores (String nombreArchivo) {

        /**
         * Se inicializan las listas
         */

        listaVendedores = new LinkedList<Vendedor>();
        mapaVentas = new HashMap<Vendedor, List<String>>();

        String dir = System.getProperty("user.dir");

        try {
            File inputFile = new File(dir + File.separator + nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            /**
             * Se crea una lista de nodos de Vendedores (sin XPath)
             */

            NodeList listaVendedores = doc.getElementsByTagName("vendedor");

            /**
             * Se crea una lista de nodos de Vendedores (con XPath)
             */

            /*XPath xPath = XPathFactory.newInstance().newXPath();
            String xPathString = "/vendedores/vendedor";

            NodeList nl = (NodeList) xPath.compile(xPathString).evaluate(doc, XPathConstants.NODESET);*/

            /**
             * Se llama al método que rellena las listas
             */

            fill(listaVendedores);

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
     * Método que rellena la lista de vendedores y el mapa de ventas
     */

    private void fill (NodeList nlVendedores) {

        /**
         * Se recorre la lista de nodos de los vendedores
         */

        for (int i = 0; i < nlVendedores.getLength(); i++) {

            /**
             * Se saca el nodo de CADA vendedor
             */

            Node nodoVendedor = nlVendedores.item(i);

            /**
             * Si el vendedor es un nodo de tipo elemento lo añade a la lista vendedor
             */

            if (nodoVendedor.getNodeType() == Node.ELEMENT_NODE) {
                Vendedor vendedor = getVendedor(nodoVendedor);
                listaVendedores.add(vendedor);

                /**
                 * Si el nodo tiene hijos los añade al mapa de las ventas
                 */

                if (nodoVendedor.hasChildNodes()) {
                    mapaVentas.put(vendedor, getMatriculas(nodoVendedor));
                }
            }
        }
    }

    /**
     * Getters de las listas
     */

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public HashMap<Vendedor, List<String>> getMapaVentas() {
        return mapaVentas;
    }

    /**
     * Método para leer un vendedor
     */

    private Vendedor getVendedor (Node nodoVendedor) {

        Element elementoVendedor = (Element) nodoVendedor;
        elementoVendedor.getElementsByTagName("vendedor");

        int id = Integer.parseInt(elementoVendedor.getAttribute("id"));
        String nombre = elementoVendedor.getAttribute("nombre");
        String apellidos = elementoVendedor.getAttribute("apellidos");

        return new Vendedor(id, nombre, apellidos);
    }

    /**
     * Método para crear una lista de las matriculas por vendedor
     */

    private List<String> getMatriculasPorVendedor (Node nodoVendedor) {

        List<String> listaMatriculas = new LinkedList<>();

        /**
         * Se recorren todos los nodos hijos de cada Nodo VENDEDOR
         */

        NodeList listaNodosHijos = nodoVendedor.getChildNodes();

        /**
         * Búcle para sacar todas las ventas de cada vendedor
         */

        for (int i = 0; i < listaNodosHijos.getLength(); i++) {

            /**
             * Vamos sacando cada venta con esta variable
             */

            Node nodoVenta = listaNodosHijos.item(i);

            /**
             * Si la venta es un nodo de tipo elemento lo añade a la lista
             */

            if (nodoVenta.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoVenta = (Element) nodoVenta;
                elementoVenta.getElementsByTagName("venta");
                String matricula = elementoVenta.getAttribute("matricula");
                listaMatriculas.add(matricula);

            }
        }
        return listaMatriculas;
    }

    private List<String> getMatriculas (Node nodoVendedor) {

        List<String> listaMatriculas = new ArrayList<>();

        NodeList nl = nodoVendedor.getChildNodes();

        for (int i = 0; i < nl.getLength(); i++) {

            Node nodoVenta = nl.item(i);

            if (nodoVenta.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoMatricula = (Element) nodoVenta;
                String matricula = elementoMatricula.getAttribute("matricula");
                listaMatriculas.add(matricula);
            }

        }
        return listaMatriculas;
    }
}