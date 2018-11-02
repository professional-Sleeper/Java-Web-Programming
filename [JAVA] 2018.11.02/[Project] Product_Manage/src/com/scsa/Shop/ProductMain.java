package com.scsa.Shop;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class ProductMain {

	Frame f;

	Button save;
	Button search;
	Button delete;
	Button clear;
	Button stf;
	Button upload;
	Button modify;

	List productList;

	Panel pList;
	Panel button;
	Panel info;

	TextField[] ta = new TextField[3];
	Label[] label = new Label[3];

	IproductManager dao;

	static String labelList[] = { "상품번호", "성명", "상품 가격" };

	public ProductMain() {
		createUI();
		addEvent();
		dao = ProductManagerImpl.getInstance();
		try {
			dao.load();
			for (Product p : dao.getList()) {
				productList.add(p.getCode());
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createUI() {
		f = new Frame("SCSA 대리점");

		save = new Button("저장");
		search = new Button("검색");
		delete = new Button("삭제");
		modify = new Button("수정");
		clear = new Button("Clear");
		stf = new Button("SaveToFile");
		upload = new Button("Upload");
		

		productList = new List();
		pList = new Panel();
		pList.add(productList);

		info = new Panel();
		for (int i = 0; i < 3; i++) {
			label[i] = new Label(labelList[i]);
			ta[i] = new TextField();
			info.add(label[i]);
			info.add(ta[i]);
		}
		info.setLayout(new GridLayout(0, 1));

		button = new Panel();
		button.setLayout(new GridLayout(3, 2));
		button.add(save);
		button.add(search);
		button.add(modify);
		button.add(delete);
		button.add(clear);
		button.add(stf);
		button.add(upload);

		f.setSize(500, 800);

		f.add(pList, BorderLayout.NORTH);
		f.add(info, BorderLayout.CENTER);
		f.add(button, BorderLayout.SOUTH);

		f.setVisible(true);
	}

	private void addEvent() {

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		save.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String[] str = new String[4];

				for (int i = 0; i < 3; i++) {
					str[i] = ta[i].getText();
				}

				try {
					dao.save(new Product(str[0], str[1], Integer.parseInt(str[2])));
					productList.removeAll();
					for (Product p : dao.getList()) {
						productList.add(p.getCode());
					}

					for (int i = 0; i < 3; i++) {
						ta[i].getText();
						ta[i].setText("");
					}

					productList.select(dao.getList().size() - 1);
				} catch (NumberFormatException e1) {
					System.out.println("가격은 숫자를 입력해주세요");
				} catch (SameCode e1) {
					// TODO Auto-generated catch block
				}

			}

		});

		productList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Product p = dao.search(productList.getSelectedItem());
				if (p != null) {
					ta[0].setText(p.getCode());
					ta[1].setText(p.getpName());
					ta[2].setText(Integer.toString(p.getPrice()));
				}
			}

		});

		clear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 3; i++) {
					ta[i].getText();
					ta[i].setText("");
				}
			}
		});

		search.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (ta[0].getText() == "") {
					System.out.println("상품 코드를 입력해 주세요");
					return;
				}
				Product p = dao.search(ta[0].getText());
				if (p != null) {
					ta[0].setText(p.getCode());
					ta[1].setText(p.getpName());
					ta[2].setText(Integer.toString(p.getPrice()));
					for (int i = 0; i < dao.getList().size(); i++) {
						if (productList.getItem(i).equals(p.getCode())) {
							productList.select(i);
							break;
						}

					}
				}

			}
		});

		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Product p = dao.search(ta[0].getText());
				if (p != null) {
					dao.delete(p);
				}
				productList.removeAll();
				for (Product temp : dao.getList()) {
					productList.add(temp.getCode());
				}
				for (int i = 0; i < 3; i++) {
					ta[i].getText();
					ta[i].setText("");
				}
			}
		});

		stf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Thread t = new Thread(new saveThread());
				t.start();
			}
		});
		
		modify.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if ( ta[0].getText() != "" ) {
					dao.modify(ta[0].getText(),Integer.parseInt(ta[2].getText()));
				}
				for (int i = 0; i < 3; i++) {
					ta[i].getText();
					ta[i].setText("");
				}
			}
		});
		
		upload.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new transferThread().start();
			}
		});
	}

	public static void main(String[] args) {
		ProductMain temp = new ProductMain();

	}
}
