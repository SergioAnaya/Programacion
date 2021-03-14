package Persistencia;

import Modelo.Asalariado;
import Modelo.Comisionado;
import Modelo.Empleado;
import Modelo.PorHoras;
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
import java.util.LinkedList;
import java.util.List;

public class LectorEmpleados {

    /**
     * Variable del doc
     */

    private Document doc;

    /**
     * Constructor
     */

    public LectorEmpleados (String nombreArchivo) {

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

    public List<Empleado> read () {

        List<Empleado> listaEmpleados = new LinkedList<>();

        XPath xPath = XPathFactory.newInstance().newXPath();
        String xPathString = "/empleados/empleado";

        try {
            NodeList nl = (NodeList) xPath.compile(xPathString).evaluate(doc,
                    XPathConstants.NODESET);

            for (int i = 0; i < nl.getLength(); i++) {
                Empleado empleado = getEmpleadoFromNodo(nl.item(i));
                listaEmpleados.add(empleado);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    /**
     * Este método se usa para leer la estructura de cada empleado
     */

    private Empleado getEmpleadoFromNodo (Node nodoEmpleado) {

        Element elementoEmpleado = (Element) nodoEmpleado;

        int id = Integer.parseInt(elementoEmpleado.getAttribute("id"));
        String nombre = elementoEmpleado.getAttribute("nombre");
        String apellidos = elementoEmpleado.getAttribute("apellidos");
        String tipo = elementoEmpleado.getAttribute("tipo");

        // El sueldo base se le indica en 0 por defecto para luego desde otro lado setearlo

        switch (tipo) {
            case "comisionado":
                double comision = Double.parseDouble(elementoEmpleado.getAttribute("extra"));
                int ventas = Integer.parseInt(elementoEmpleado.getAttribute("ventas"));
                return new Comisionado(id, nombre, apellidos, 0.0, comision, ventas);
            case "por_horas":
                double horasTrabajadas = Double.parseDouble(elementoEmpleado.getAttribute("horas"));
                return new PorHoras(id, nombre, apellidos, 0.0, horasTrabajadas);
            case "asalariado":
                return new Asalariado(id, nombre, apellidos, 0.0);
            default:
                return null;
        }
    }
}