package com.scsa.WeatherDOM;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DOMTest {
	Frame f;
	Panel p;
	Button b;
	List li;
	WeatherDAO dao;

	
	public DOMTest(){
		dao=WeatherDAO.getInstance();
		createGUI();
		addEvent();
		showList();
	}
	public void createGUI(){
		f=new Frame("NewsList");
		p=new Panel();
		b=new Button("News List 요청");
		li=new List();
		
		p.setLayout(new BorderLayout());//동서남북센터
		p.add(b, "North");
		p.add(li);
		
		f.setLayout(new GridLayout(2,1,5,5));//2행 1열,수평여백 5,수직여백5
		f.add(p);
		
		f.setSize(400, 500);
		f.setVisible(true);
	}
	public void addEvent(){
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showList();				
			}			
		});
	}
	public void showList(){
		
		dao.connectXML();
		java.util.List<Weather> w = dao.getWeatherList();
		
		li.removeAll();
		for (Weather n : w) {
			li.add(n.toString());
		}
		
	}
	
	public static void main(String[] args) {
		new DOMTest();
	}
}
