package com.scsa.news;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NewsNetDAOImpl implements INewsDAO {

	ArrayList<News> list;

	public NewsNetDAOImpl() {

	}

	private class SAXHandler extends DefaultHandler {

		
		StringBuilder sb = new StringBuilder();
		News n = null;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("item")) {
				n = new News();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {

			if (n != null) {
				if (qName.equals("title")) {
					n.setTitle(sb.toString().trim());
				} else if (qName.equals("link")) {
					n.setLink(sb.toString().trim());
				} else if (qName.equals("description")) {
					n.setDesc(sb.toString().trim());
				}  else if (qName.equals("item")) {
					list.add(n);
				}
			}
			
			sb.setLength(0);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(String.valueOf(ch, start, length));
		}

	}

	@Override
	public List<News> getNewsList(String url) {
		// TODO Auto-generated method stub

		list = new ArrayList<News>();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(url, new SAXHandler());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String getDesc(String title) {
		// TODO Auto-generated method stub
		for (News n:list) {
			if(n.getTitle().equals(title)) {
				return n.getDesc();
			}
		}
		return null;
	}
	
/*	public static void main(String[] args) {
		NewsNetDAOImpl temp = new NewsNetDAOImpl();
		ArrayList<News> news = (ArrayList<News>) temp.getNewsList("http://rss.etnews.com/Section902.xml");
		for(News n:news) {
			System.out.println(n);
		}
	}*/

}
