package com.scsa.WeatherDOM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherDAO {

	ArrayList<Weather> list = new ArrayList<Weather>();

	private static WeatherDAO instance = new WeatherDAO();

	private WeatherDAO() {

	}

	public static WeatherDAO getInstance() {
		return instance;
	}

	public List<Weather> getWeatherList() {
		return list;
	}

	public void connectXML() {
		Document document;
		NodeList weatherList;
		
		DocumentBuilderFactory factory
		= DocumentBuilderFactory.newInstance();
		
		DocumentBuilder parser;
		try {
			parser = factory.newDocumentBuilder();
			document = parser.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");
			
			weatherList = document.getElementsByTagName("data");
			for (int i=0; i<weatherList.getLength(); i++)
			{
				Element n = (Element)weatherList.item(i);
				Weather ns = new Weather();
				
				Node ch = n.getElementsByTagName("hour").item(0);
				ns.setHour(Integer.parseInt(ch.getFirstChild().getNodeValue()));
				
				ch = n.getElementsByTagName("temp").item(0);
				ns.setTemp(Double.parseDouble(ch.getFirstChild().getNodeValue()));
				
				ch = n.getElementsByTagName("wfKor").item(0);
				ns.setWfKor(ch.getFirstChild().getNodeValue());
				
				ch = n.getElementsByTagName("reh").item(0);
				ns.setReh(Integer.parseInt(ch.getFirstChild().getNodeValue()));
				
				list.add(ns);
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
