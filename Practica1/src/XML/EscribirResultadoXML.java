package XML;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;


public class EscribirResultadoXML {


    public void EscribirResultadoXML(int[][] resultados) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        DOMImplementation implementation = db.getDOMImplementation();
        Document document = implementation.createDocument(null, "Liga.xml", null);
        document.setXmlVersion("1.0");
        //Crea y añade el nodo empleado al documento
        Element raiz = document.createElement("equipo");
        document.getDocumentElement().appendChild(raiz);
        //se añaden los hijos al nodo raiz
        for (int i = 0; i < resultados.length; i++) {
            CrearElemento("Puntos", String.valueOf(resultados[i][0]),raiz,document);
            CrearElemento("GolesFavor", String.valueOf(resultados[i][1]),raiz,document);
            CrearElemento("GolesContra", String.valueOf(resultados[i][2]),raiz,document);
        }
        Source source = new DOMSource(document);

        Result result = new StreamResult(new java.io.File("Liga.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.transform(source, result);

        Result console= new StreamResult(System.out);
        transformer.transform(source, console);
    }

    static void CrearElemento(String datoEmple, String valor,
                              Element raiz, Document document) {
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}
