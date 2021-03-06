package featureList;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser {
	public static List<String> parse(List<String> features) {
		File file = new File("features.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);

			fillList(features, document,"Unterkunft_buchen");
			fillList(features, document,"Hotel");
			fillList(features, document,"Ferienhaus");
			fillList(features, document,"Campingplatz");
			fillList(features, document,"Bungalow");
			fillList(features, document,"Stellplatz");
			fillList(features, document,"Reise_buchen");
			fillList(features, document,"Busreise");
			fillList(features, document,"Auto_mieten");
			fillList(features, document,"Route_planen");
			fillList(features, document,"Flug");
			fillList(features, document,"Kreuzfahrt");
			fillList(features, document,"Kreditkarte");
			fillList(features, document,"PayPal");
			fillList(features, document,"GiroPay");
			fillList(features, document,"Waehrungsrechner");
			fillList(features, document, "Aktivitaet");
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return features;
	}

	private static void fillList(List<String> features, Document document, String name) {
		features.add((document.getElementsByTagName(name).item(0).getTextContent()));
	}

}
