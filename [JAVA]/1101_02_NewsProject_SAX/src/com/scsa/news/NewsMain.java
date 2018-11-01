package com.scsa.news;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewsMain {
	Frame f;
	Panel p;
	Button b;
	List li;
	TextArea ta;
	INewsDAO dao;

	
	public NewsMain(){
		dao=new NewsNetDAOImpl();
		createGUI();
		addEvent();
		showList();
	}
	public void createGUI(){
		f=new Frame("NewsList");
		p=new Panel();
		b=new Button("News List 요청");
		li=new List();
		ta=new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
		
		p.setLayout(new BorderLayout());//동서남북센터
		p.add(b, "North");
		p.add(li);
		
		f.setLayout(new GridLayout(2,1,5,5));//2행 1열,수평여백 5,수직여백5
		f.add(p);
		f.add(ta);
		
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
		li.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ta.setText(dao.getDesc(li.getSelectedItem()));
			}
		});
	}
	public void showList(){
		
		java.util.List<News> news 
			= dao.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		for (News n : news) {
			li.add(n.getTitle());
		}
		
	}

	public static void main(String[] args) {
		new NewsMain();
	}

}
