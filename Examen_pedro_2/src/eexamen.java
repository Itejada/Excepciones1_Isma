import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class eexamen {

        public static void main(String argv[]) {
            try {
                DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();



                Element Film = doc.createElement("Film");
                doc.appendChild(Film);
                Attr produced = doc.createAttribute("produced");
                produced.setValue("2014");
                Film.setAttributeNode(produced);

            
                Element titol = doc.createElement("Title");
                Film.appendChild(titol);
                titol.appendChild(doc.createTextNode("The imitation geme"));

                Element director = doc.createElement("Director");
                Film.appendChild(director);
                director.appendChild(doc.createTextNode("Morten Tyldum"));

                Element country = doc.createElement("Country");
                Film.appendChild(country);
                country.appendChild(doc.createTextNode("USA"));

                

             



                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result= new StreamResult(new File("C:\\Users\\ismae\\OneDrive\\Escritorio\\films.xml"));
                transformer.transform(source, result);
                StreamResult consoleResult= new StreamResult(System.out);
                transformer.transform(source, consoleResult);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }



