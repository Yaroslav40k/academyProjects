package com.andersen.XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


/*
 * Works with "Roman Legions Updated.xml" via STAX way
 * 
 * 		prints the content of "Roman Legions Updated.xml"
 */
public class STAXparser {
	
	private static final String FILE_NAME = "src/main/java/com/andersen/XML/Roman Legions Updated.xml";

	public static void main(String[] args) {

		try {
			XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(FILE_NAME,
					new FileInputStream(FILE_NAME));

			while (xmlr.hasNext()) {
				xmlr.next();
				if (xmlr.isStartElement()) {
					System.out.println(xmlr.getLocalName());
				} else if (xmlr.isEndElement()) {
					System.out.println("/" + xmlr.getLocalName());
				} else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
					System.out.println("   " + xmlr.getText());
				}
			}
		} catch (FileNotFoundException | XMLStreamException ex) {
			ex.printStackTrace();
		}
	}

}
