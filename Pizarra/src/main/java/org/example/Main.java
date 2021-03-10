package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException {

        LecturaCSV csv = new LecturaCSV();
        LecturaXML xml = new LecturaXML();

        csv.read();
        xml.read();

    }

}