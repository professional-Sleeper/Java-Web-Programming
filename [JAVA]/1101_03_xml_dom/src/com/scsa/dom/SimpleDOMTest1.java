package com.scsa.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SimpleDOMTest1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory
		= DocumentBuilderFactory.newInstance();
		
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse("addr.xml");
		Element root = document.getDocumentElement();
		
		getNode(root);
	}

	public static void getNode(Node n) {
		NodeList list = n.getChildNodes();
		for (int i=0; i<list.getLength(); i++) {
			Node ch = list.item(i);
			System.out.println(ch.getNodeName()+":"+ch.getNodeValue());
		}
	}
	

}
