package com.andersen.XML;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

/*
 * Works with "Roman Legions Updated.xml" via SAX way
 * 
 * 		uses SAXDefaultHandler as DefaultHandler to show all legion names from "Roman Legions Updated.xml"
 */
public class SAXparser {
	
	private static final String FILE_NAME = "src/main/java/com/andersen/XML/Roman Legions Updated.xml";

	public static void main(String args[]) {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new SAXDefaultHandler();
			saxParser.parse(FILE_NAME, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
