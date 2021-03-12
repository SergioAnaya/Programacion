package RepasoExamen;

import RepasoExamen.Modelo.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Nomina {

    /**
     * Constantes
     */

    private final static String ARCHIVO_EMPLEADOS = "empleados.xml";
    private final static String ARCHIVO_SUELDO_BASE = "sueldo_base.csv";

    /**
     * Variables
     */

    static List<Empleado> listaEmpleados = new LinkedList<>();
    static List<Comisionado> listaComisionados = new LinkedList<>();
    static List<PorHora> listaPorHora = new LinkedList<>();
    static List<Asalariado> listaAsalariado = new LinkedList<>();


    /**
     * Carga el contenido de los archivos en una lista de objetos Empleado
     */

    public void cargarEmpleados () {
        inicializarXML();
        leerXML();
    }

    /**
     * Devuelve una lista de empleados
     */

    public List<Empleado> getEmpleados () {
        return listaEmpleados;
    }

    /**
     * Devuelve el sueldo de un empleado
     */

    public int calcularSueldo (int idEmpleado) {

        Empleado empleado = buscarPorId(idEmpleado);
        Comisionado comisionado = buscarPorComisionado(idEmpleado);
        PorHora porHora = buscarPorHora(idEmpleado);
        Asalariado asalariado = buscarPorAsalariado(idEmpleado);

        int resultado = 0;

        if (empleado.getTipo().equals(Empleado.COMISIONADO)) {
            int sueldoBase = Integer.parseInt(comisionado.sueldo());
            int extra = Integer.parseInt(comisionado.getExtra());
            int ventas = Integer.parseInt(comisionado.getVentas());
            resultado = sueldoBase + (extra * ventas);
        } else if (empleado.getTipo().equals(Empleado.POR_HORAS)) {
            int sueldoBase = Integer.parseInt(porHora.sueldo());
            int horas = Integer.parseInt(porHora.getHoras());
            resultado = sueldoBase * horas;
        } else if (empleado.getTipo().equals(Empleado.ASALARIADO)) {
            int sueldoBase = Integer.parseInt(asalariado.sueldo());
            resultado = sueldoBase;
        }

        return resultado;
    }

    /**
     * Permite cambiar el sueldo base de un tipo de empleado,
     * donde tipoEmpleado puede ser 1 (comisionado), 2 (por horas) o 3 (asalariado)
     */

    public void cambiarSueldoBase (int tipoEmpleado, double sueldo) throws IOException {

        int sueldoSinDecimales = (int) sueldo;

        for (Sueldo tipo : getTiposSueldos()) {
            if (tipoEmpleado == 1) {
                if (tipo.getTipo().equals(Empleado.COMISIONADO)) {
                    tipo.setValor(String.valueOf(sueldoSinDecimales));
                }
            } else if (tipoEmpleado == 2) {
                if (tipo.getTipo().equals(Empleado.POR_HORAS)) {
                    tipo.setValor(String.valueOf(sueldoSinDecimales));
                }
            } else if (tipoEmpleado == 3) {
                if (tipo.getTipo().equals(Empleado.ASALARIADO)) {
                    tipo.setValor(String.valueOf(sueldoSinDecimales));
                }
            }
        }
        escribirCSV();
    }

    /**
     * Guarda el sueldo base en el archivo de sueldos base
     */

    public void guardarSueldoBase () {

    }

    /**
     * Encuentra el empleado que tiene el mayor sueldo
     */

    /*public Empleado getEmpleadoMejorPagado () {

    }*/

    /**
     * Encuentra el empleado que tiene el menor sueldo
     */

    /*public Empleado getEmpleadoPeorPagado () {

    }*/

    /**
     * Métodos agregados
     */

    /**
     * Método para leer el archivo CSV
     */

    private final static char SEPARADOR = ';';

    Sueldo sueldo;

    static List<Sueldo> tiposSueldos = new LinkedList<>();

    public List<Sueldo> getTiposSueldos() {
        return tiposSueldos;
    }

    public void readCSV () throws IOException {
        String dir = System.getProperty("user.dir");
        BufferedReader lectorCSV = null;
        try {
            lectorCSV = new BufferedReader(new FileReader(dir + File.separator
                    + ARCHIVO_SUELDO_BASE));
            String linea = lectorCSV.readLine();
            while (null != linea){
                String[] campos = linea.split(String.valueOf(SEPARADOR));
                sueldo = new Sueldo(campos[0], campos[1]);
                tiposSueldos.add(sueldo);
                /*System.out.println(Arrays.toString(campos));*/
                linea = lectorCSV.readLine();
            }
            lectorCSV.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lectorCSV.close();
        }
    }

    /**
     * Variable del documento XML
     */

    private Document doc;

    /**
     * Se inicializa los empleados
     */

    Comisionado comisionado;
    PorHora porHora;
    Asalariado asalariado;

    /**
     * Método para inicializar el archivo XML
     */

    public void inicializarXML () {
        String dir = System.getProperty("user.dir");

        try {
            File inputFile = new File(dir + File.separator + ARCHIVO_EMPLEADOS);
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

    public void leerXML () {

        NodeList nl = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nl.item(i);
                if (el.getNodeName().contains("empleado")) {
                    String id = el.getAttribute("id");
                    String nombre = el.getAttribute("nombre");
                    String apellidos = el.getAttribute("apellidos");
                    String tipo = el.getAttribute("tipo");
                    String extra = el.getAttribute("extra");
                    String ventas = el.getAttribute("ventas");
                    String horas = el.getAttribute("horas");

                    if (tipo.equals("comisionado")) {
                        comisionado = new Comisionado(id, nombre, apellidos, tipo, extra, ventas);
                        listaEmpleados.add(comisionado);
                        listaComisionados.add(comisionado);
                    } else if (tipo.equals("por_horas")) {
                        porHora = new PorHora(id, nombre, apellidos, tipo, horas);
                        listaEmpleados.add(porHora);
                        listaPorHora.add(porHora);
                    } else if (tipo.equals("asalariado")) {
                        asalariado = new Asalariado(id, nombre, apellidos, tipo);
                        listaEmpleados.add(asalariado);
                        listaAsalariado.add(asalariado);
                    }
                }
            }
        }
    }

    /**
     * Método para buscar empleado por Id en la lista de empleados de todos los empleados
     */

    public Empleado buscarPorId (int idEmpleado) {
        Empleado resultado = null;
        for (Empleado empleado : getEmpleados()) {
            if (empleado.getId().equals(String.valueOf(idEmpleado))) {
                resultado = empleado;
            }
        }
        return resultado;
    }

    /**
     * Método para buscar empleado por Id en la lista de empleados de tipo Comisionado
     */

    public Comisionado buscarPorComisionado (int idEmpleado) {
        Comisionado resultado = null;
        for (Comisionado comisionado : getListaComisionados()) {
            if (comisionado.getId().equals(String.valueOf(idEmpleado))) {
                resultado = comisionado;
            }
        }
        return resultado;
    }

    public List<Comisionado> getListaComisionados() {
        return listaComisionados;
    }

    /**
     * Método para buscar empleado por Id en la lista de empleados de tipo Por Horas
     */

    public PorHora buscarPorHora (int idEmpleado) {
        PorHora resultado = null;
        for (PorHora porHora : getListaPorHora()) {
            if (porHora.getId().equals(String.valueOf(idEmpleado))) {
                resultado = porHora;
            }
        }
        return resultado;
    }

    public List<PorHora> getListaPorHora() {
        return listaPorHora;
    }

    /**
     * Método para buscar empleado por Id en la lista de empleados de tipo Asalariado
     */

    public Asalariado buscarPorAsalariado (int idEmpleado) {
        Asalariado resultado = null;
        for (Asalariado asalariado : getListaAsalariado()) {
            if (asalariado.getId().equals(String.valueOf(idEmpleado))) {
                resultado = asalariado;
            }
        }
        return resultado;
    }

    public List<Asalariado> getListaAsalariado() {
        return listaAsalariado;
    }

    /**
     * Método para sobreescribir el csv de sueldo_base
     */

    public void escribirCSV () throws IOException {
        FileWriter writer = new FileWriter(ARCHIVO_SUELDO_BASE);

        for (Sueldo tipo : getTiposSueldos()) {
            writer.write(String.valueOf(tipo));
        }
        writer.close();
    }

}