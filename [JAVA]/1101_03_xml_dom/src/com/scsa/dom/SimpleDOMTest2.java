package com.scsa.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SimpleDOMTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory
		= DocumentBuilderFactory.newInstance();
		
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse("addr.xml");
		
		getNode(document.getElementsByTagName("person").item(0));
	}

	public static void getNode(Node n) {
	for (Node ch = n.getFirstChild(); ch!= null; ch=ch.getNextSibling()){
		System.out.println(ch.getNodeName()+":"+ch.getNodeValue());
	}
}
	
}
