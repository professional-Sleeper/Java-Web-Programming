package com.scsa.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonHandler extends DefaultHandler{

	ArrayList<Person> list;
	StringBuilder sb = new StringBuilder();
	Person p;
	
	public PersonHandler(ArrayList<Person> list) {
		this.list = list;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("person")) {
			p = new Person();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("name")) {
			p.name = sb.toString().trim();
		}
		else if (qName.equals("age")) {
			p.age = Integer.parseInt(sb.toString().trim());
		}
		else if (qName.equals("person")) {
			list.add(p);
		}
		sb.setLength(0);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		sb.append(String.valueOf(ch,start,length));
	}
	
}
