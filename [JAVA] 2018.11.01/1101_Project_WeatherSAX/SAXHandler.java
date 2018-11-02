package com.scsa.WeatherSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler{

	WeatherDAO dao = WeatherDAO.getInstance();
	StringBuilder sb = new StringBuilder();
	Weather w = null;
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if (w != null) {
			if ( qName.equals("hour"))
			{
				w.setHour(Integer.parseInt(sb.toString().trim()));
			} else if ( qName.equals("temp"))
			{
				w.setTemp(Double.parseDouble(sb.toString().trim()));
			} else if ( qName.equals("wfKor"))
			{
				w.setWfKor((sb.toString().trim()));
			} else if ( qName.equals("reh"))
			{
				w.setReh(Integer.parseInt(sb.toString().trim()));
			}
			
		}
		if (qName.equals("data")) {
			dao.list.add(w);
			w = null;
		}
		
		sb.setLength(0);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (qName.equals("data")) {
			w = new Weather();
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		sb.append(String.valueOf(ch,start,length));
	}
	
}
