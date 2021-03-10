package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.xpath.XPathExpressionException;

import java.io.File;
import java.io.IOException;

public class LecturaXML {

    String nombreArchivo = "archivoXML.xml";

    public void read () {
        String dir = System.getProperty("user.dir");
        try {
            File inputFile = new File(dir + File.separator + nombreArchivo);
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();


            NodeList nl = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);
                    if (el.getNodeName().contains("staff")) {
                        String name =
                                el.getElementsByTagName("name").item(0).getTextContent();
                        String phone =
                                el.getElementsByTagName("phone").item(0).getTextContent();
                        String email =
                                el.getElementsByTagName("email").item(0).getTextContent();
                        String area =
                                el.getElementsByTagName("area").item(0).getTextContent();
                        String city =
                                el.getElementsByTagName("city").item(0).getTextContent();
                        System.out.println(name + phone);
                    }
                }
            }



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
}