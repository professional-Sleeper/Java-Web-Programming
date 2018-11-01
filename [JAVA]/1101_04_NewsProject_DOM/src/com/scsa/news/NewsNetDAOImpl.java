package com.scsa.news;

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


public class NewsNetDAOImpl implements INewsDAO {

	ArrayList<News> list;

	public NewsNetDAOImpl() {

	}

	@Override
	public List<News> getNewsList(String url) {
		// TODO Auto-generated method stub

		list = new ArrayList<News>();
		Document document;
		NodeList newsList;
		
		DocumentBuilderFactory factory
		= DocumentBuilderFactory.newInstance();
		
		DocumentBuilder parser;
		try {
			parser = factory.newDocumentBuilder();
			document = parser.parse(url);
			
			newsList = document.getElementsByTagName("item");
			for (int i=0; i<newsList.getLength(); i++)
			{
				Element n = (Element)newsList.item(i);
				News ns = new News();
				
				Node ch = n.getElementsByTagName("title").item(0);
				ns.setTitle(ch.getFirstChild().getNodeValue());
				
				ch = n.getElementsByTagName("link").item(0);
				ns.setLink(ch.getFirstChild().getNodeValue());
				
				ch = n.getElementsByTagName("description").item(0);
				ns.setDesc(ch.getFirstChild().getNodeValue());
				
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
