package com.andersen.XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Works with "Roman Legions Updated.xml" via SAX way
 * 
 *		Shows all legion names from "Roman Legions Updated.xml"
 */
public class SAXDefaultHandler extends DefaultHandler {

	//flag to start reading legion name
	boolean name = false;

	// Invoke when the parser meets tag <Name>
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Name")) {
			name = true;
		}
	}

	// Invoke when the parser reads the text between tags
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (name) {
			System.out.println("Name: " + new String(ch, start, length));
			name = false;
		}
	}
}
