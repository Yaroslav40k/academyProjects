package com.andersen.XML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/*
 * Works with "Roman Legions Updated.xml" via DOM way
 * 
 * @method  addNewLegion , adds new Legion to the XML
 * @method  writeDocument, writes new information to the XML
 * @method  showDocument, shows XML content in console
 */
public class DOMparser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		File file = new File("src/main/java/com/andersen/XML/Roman Legions Updated.xml");
		Document document = documentBuilder.parse(file);

		// for (int i = 3; i<= 100; i++) {
		// addNewLegion(document, ArabicIntToRomanConverter.toRoman(i));
		// }
		showDocument(document);
	}

	private static void addNewLegion(Document document, String legioNumber)
			throws TransformerFactoryConfigurationError, DOMException {

		Node root = document.getDocumentElement();
		Element legion = document.createElement("Legion");
		Element name = document.createElement("Name");
		name.setTextContent("Legio " + legioNumber);
		Element founder = document.createElement("Founder");
		founder.setTextContent("unknown");
		Element foundationDate = document.createElement("FoundationDate");
		foundationDate.setTextContent("unknown");
		Element symbol = document.createElement("Symbol");
		symbol.setTextContent("unknown");
		Element province = document.createElement("Province");
		province.setTextContent("unknown");
		Element legioneersCount = document.createElement("LegioneersCount");
		legioneersCount.setTextContent("unknown");

		legion.appendChild(name);
		legion.appendChild(founder);
		legion.appendChild(foundationDate);
		legion.appendChild(symbol);
		legion.appendChild(province);
		legion.appendChild(legioneersCount);
		root.appendChild(legion);

		writeDocument(document);
	}

	// Write
	private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream fos = new FileOutputStream("src/main/java/com/andersen/XML/Roman Legions Updated.xml");
			StreamResult result = new StreamResult(fos);
			tr.transform(source, result);
		} catch (TransformerException | IOException e) {
			e.printStackTrace(System.out);
		}
	}

	private static void showDocument(Document document) {

		Node root = document.getDocumentElement();
		System.out.println("List of Legions:");
		System.out.println();
		// Check all primary element in root - i.e. legions
		NodeList legions = root.getChildNodes();
		for (int i = 0; i < legions.getLength(); i++) {
			Node legion = legions.item(i);
			// Check if our node is ELEMENT_NODE, print
			if (legion.getNodeType() != Node.TEXT_NODE) {
				NodeList legionProps = legion.getChildNodes();
				for (int j = 0; j < legionProps.getLength(); j++) {
					Node legionProp = legionProps.item(j);
					// Check if our node is ELEMENT_NODE, print
					if (legionProp.getNodeType() != Node.TEXT_NODE) {
						System.out.println(
								legionProp.getNodeName() + ":" + legionProp.getChildNodes().item(0).getTextContent());
					}
				}
				System.out.println("===========>>>>");
			}
		}
	}
}
