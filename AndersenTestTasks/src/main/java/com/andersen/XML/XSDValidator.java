package com.andersen.XML;

import java.io.File;

import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/*
 * Works with "Roman Legions Updated.xml" and "RomanLegionsXMLSchema.xsd"( as Schema)
 *			
 *	compares presented XML with the Schema		
 */

public class XSDValidator {
	
	private static final String XML_PATH = "src/main/java/com/andersen/XML/Roman Legions Updated.xml";
	private static final String XSD_PATH = "src/main/java/com/andersen/XML/RomanLegionsXMLSchema.xsd";

	public static void main(String[] args) {
		boolean answer = validateXMLSchema(XSD_PATH, XML_PATH);
		System.out.println("XML Validation Result:" + answer);
	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}
}
