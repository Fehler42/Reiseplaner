import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser {

	public static void parse() {
		File file = new File("features.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file); 
			System.out.println(document.getElementsByTagName("Suchleiste").item(0).getTextContent());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
      
		//String usr = document.getElementsByTagName("user").item(0).getTextContent();
		//String pwd = document.getElementsByTagName("password").item(0).getTextContent();
	}
}
