package com.scsa.WeatherSAX;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
		SAXHandler handler = new SAXHandler();

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;

		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			parser.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000", handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
