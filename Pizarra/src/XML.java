import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XML {

    public static void main(String[] args) {

        Document doc = getDocument("datos.xml");
        printDocument(doc);

    }

    public static Document getDocument (String fileName) {
        String dir = System.getProperty("user.dir");
        Document doc = null;

        try {
            File inputFile = new File(dir + File.separator + fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = (Document) dBuilder.parse(inputFile);

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
        return doc;
    }

    public static void printDocument (Document doc) throws XPathExpressionException {
        XPath XPath = XPathFactory.newInstance().newXPath();
        String xpathExpr = "/company/staff";
        NodeList nodeList = (NodeList) XPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
        List<Staff> staffList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nodeList.item(i);
                if (el.getNodeName().contains("staff")) {
                    Staff person = new Staff();
                    person.setName(el.getElementsByTagName("Name").item(0).getTextContent());
                }
            }
        }
    }

}
