package com.scsa.sax;

import java.util.ArrayList;

public class personXMLSAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> persons 
		 = PersonParser.getPersons();
		for (Person p : persons) {
			System.out.println(p);
		}
	}

}
