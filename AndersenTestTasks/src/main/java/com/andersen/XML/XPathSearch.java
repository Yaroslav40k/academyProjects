package com.andersen.XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/*
 * Works with "Roman Legions Updated.xml", uses XPath to find the information
 * 
 * 	@method  findAllLegions , prints All  Legions,that was found in current XML
 * 	@method  findLegionByFounder, prints All Legions,that belong to selected founder
 * 	@method  findLastLegion, print last  Legion in the XML
 * 	@method  findUnderstrengthLegions, print  all legion with LegioneersCount<3500
 * 	@method  printLegion, show legion information in console
 */
public class XPathSearch {

	private static final String FILE_NAME = "src/main/java/com/andersen/XML/Roman Legions Updated.xml";

	public static void main(String[] args) {
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(FILE_NAME);

			findLegionByFounder(document, "Julius Caesar");
			findAllLegions(document);
			findLastLegion(document);
			findUnderstrengthLegions(document);
	

		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException ex) {
			ex.printStackTrace(System.out);
		}
	}

	// prints All  Legions,that was found in current XML
	private static void findAllLegions(Document document) throws DOMException, XPathExpressionException {
		System.out.println("/----------------------/Find All legions/----------------------/");
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile("//RomanLegionsCatalogue/Legion");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		printLegion(nodes);
	}

	// prints All Legions,that belong to selected founder
	private static void findLegionByFounder(Document document, String leadername)
			throws DOMException, XPathExpressionException {
		System.out.println("/----------------------/Find " + leadername + " legions/----------------------/");
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile("RomanLegionsCatalogue/Legion[Founder=\"" + leadername + "\"]");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		printLegion(nodes);
	}

	// print last  Legion
	private static void findLastLegion(Document document) throws DOMException, XPathExpressionException {
		System.out.println("/----------------------/Find Last legion/----------------------/");
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile("RomanLegionsCatalogue/Legion[last()]");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		printLegion(nodes);
	}

	// print understrength legions
	private static void findUnderstrengthLegions(Document document) throws DOMException, XPathExpressionException {
		System.out.println("/----------------------/Find understrength legions/----------------------/");
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile("RomanLegionsCatalogue/Legion[LegioneersCount<3500]");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		printLegion(nodes);
	}

	private static void printLegion(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			System.out.println("===========>>>>");
			if (node.getNodeType() != Node.TEXT_NODE) {
				NodeList legionProps = node.getChildNodes();
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
