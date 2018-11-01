package com.scsa.sax;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PersonParser {
	
	public static ArrayList<Person> getPersons() {
		ArrayList<Person> list = new ArrayList<Person>();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse("addr.xml", new PersonHandler(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
		
	}
}
