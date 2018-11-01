package com.scsa.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
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
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaUI {

	static final int BCOUNT = 7;
	static final int MCOUNT = 9;
	static final String[] LABEL_LIST = { "Isbn", "Title", "Author", "Publisher", "Desc", "Price", "Quantity", "Year",
			"Month" };

	ListManagement lm = ListManagement.getInstance();

	Frame f;

	Panel up, center, centerBook, centerMagazine, down;
	Panel bookButton, magazineButton;

	Label[] labelB;
	Label[] labelM;

	TextField[] textB;
	TextField[] textM;

	Button saveB, cancelB, searchB, saveM, cancelM, searchM;
	Button enrollB, enrollM, exit;
	Button save,load;
	
	int flag = 0; // book

	private CardLayout cardLayout;

	List bookList;

	public void createUI() {
		up = new Panel();
		center = new Panel();
		centerMagazine = new Panel();
		centerBook = new Panel();
		down = new Panel();
		bookButton = new Panel();
		magazineButton = new Panel();
		bookList = new List();

		labelB = new Label[BCOUNT];
		labelM = new Label[MCOUNT];

		textB = new TextField[BCOUNT];
		textM = new TextField[MCOUNT];

		for (int i = 0; i < BCOUNT; i++) {
			labelB[i] = new Label(LABEL_LIST[i]);
			textB[i] = new TextField(20);
		}

		for (int i = 0; i < MCOUNT; i++) {
			labelM[i] = new Label(LABEL_LIST[i]);
			textM[i] = new TextField(20);
		}

		saveB = new Button("저장");
		cancelB = new Button("취소");
		searchB = new Button("검색");

		saveM = new Button("저장");
		cancelM = new Button("취소");
		searchM = new Button("검색");
		
		save = new Button("Save to File");
		load = new Button("Load to File");

		enrollB = new Button("책등록");
		enrollM = new Button("잡지등록");
		exit = new Button("종료");

		bookList = new List();

		up.setSize(300, 100);
		up.add(bookList);
		up.setLayout(new GridLayout(0, 1));

		cardLayout = new CardLayout();

		center.setLayout(cardLayout);
		center.add(centerBook, "book");
		center.add(centerMagazine, "magazine");
		cardLayout.show(center, "book");

		centerBook.setLayout(new GridLayout(0, 1));

		for (int i = 0; i < BCOUNT; i++) {
			centerBook.add(labelB[i]);
			centerBook.add(textB[i]);
		}

		bookButton.add(saveB);
		bookButton.add(cancelB);
		bookButton.add(searchB);
		centerBook.add(bookButton);

		centerMagazine.setLayout(new GridLayout(0, 1));
		for (int i = 0; i < MCOUNT; i++) {
			centerMagazine.add(labelM[i]);
			centerMagazine.add(textM[i]);
		}
		magazineButton.add(saveM);
		magazineButton.add(cancelM);
		magazineButton.add(searchM);
		centerMagazine.add(magazineButton);

		down.add(enrollB);
		down.add(enrollM);
		down.add(exit);
		down.setLayout(new GridLayout(2,3));
		
		down.add(save);
		down.add(load);

		f = new Frame("자바 UI TEST");
		f.setSize(400, 700);
		f.add(up, BorderLayout.NORTH);
		f.add(center, BorderLayout.CENTER);
		f.add(down, BorderLayout.SOUTH);
		
		f.setVisible(true);
	}

	public void addEvent() {

		
		enrollB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(center, "book");
				bookList.removeAll();

				for (Book b : lm.bList()) {
					bookList.add(b.getIsbn());
				}
				
				bookList.select(lm.bList().size() - 1);
				
				flag = 0;
			}
		});

		enrollM.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(center, "magazine");
				bookList.removeAll();
				for (Book b : lm.mList()) {
					bookList.add(b.getIsbn());
				}
				bookList.select(lm.mList().size() - 1);
				
				flag = 1;
			}
		});

		saveB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 등록
				String[] temp = new String[BCOUNT];
				for (int i = 0; i < BCOUNT; i++) {
					temp[i] = textB[i].getText();
				}

				try {
				lm.add(new Book(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]),
						Integer.parseInt(temp[6])));
				} catch ( ExistISBNException error) {
					System.out.println(error.getMessage());
					return;
				}
				// list 변경
				bookList.removeAll();
				for (Book b : lm.bList()) {
					bookList.add(b.getIsbn());
				}

				for (int i = 0; i < BCOUNT; i++) {
					textB[i].getText();
					textB[i].setText("");
				}
				bookList.select(lm.bList().size() - 1);

			}
		});

		searchB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String isbn = bookList.getSelectedItem();
				// 모든 북리스트 돌면서
				for (int i = 0; i < lm.bList.size(); i++) {
					// ISBN이 일치하는거 발견하면
					if (lm.bList.get(i).getIsbn().equals(isbn)) {
						textB[0].setText(lm.bList.get(i).getIsbn());
						textB[1].setText(lm.bList.get(i).getTitle());
						textB[2].setText(lm.bList.get(i).getAuthor());
						textB[3].setText(lm.bList.get(i).getPublisher());
						textB[4].setText(lm.bList.get(i).getDesc());
						textB[5].setText(Integer.toString(lm.bList.get(i).getPrice()));
						textB[6].setText(Integer.toString(lm.bList.get(i).getQuantity()));
						return;
					}
				}
			}
		});

		cancelB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < BCOUNT; i++) {
					textB[i].getText();
					textB[i].setText("");
				}
			}
		});

		// 매거진

		saveM.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 등록
				String[] temp = new String[MCOUNT];
				for (int i = 0; i < MCOUNT; i++) {
					temp[i] = textM[i].getText();
				}

				try {
					lm.add(new Magazine(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]),
							Integer.parseInt(temp[6]), Integer.parseInt(temp[7]), Integer.parseInt(temp[8])));
				} catch (ExistISBNException error) {
					System.out.println(error.getMessage());
					return;
				}
				// list 변경
				bookList.removeAll();
				for (Magazine m : lm.mList()) {
					bookList.add(m.getIsbn());
				}

				for (int i = 0; i < MCOUNT; i++) {
					textM[i].getText();
					textM[i].setText("");
				}
				bookList.select(lm.mList().size() - 1);

			}
		});

		searchM.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String isbn = bookList.getSelectedItem();
				// 모든 북리스트 돌면서
				for (int i = 0; i < lm.mList.size(); i++) {
					// ISBN이 일치하는거 발견하면
					if (lm.mList.get(i).getIsbn().equals(isbn)) {
						textM[0].setText(lm.mList.get(i).getIsbn());
						textM[1].setText(lm.mList.get(i).getTitle());
						textM[2].setText(lm.mList.get(i).getAuthor());
						textM[3].setText(lm.mList.get(i).getPublisher());
						textM[4].setText(lm.mList.get(i).getDesc());
						textM[5].setText(Integer.toString(lm.mList.get(i).getPrice()));
						textM[6].setText(Integer.toString(lm.mList.get(i).getQuantity()));
						textM[7].setText(Integer.toString(lm.mList.get(i).getYear()));
						textM[8].setText(Integer.toString(lm.mList.get(i).getMonth()));
						return;
					}
				}
			}
		});

		cancelM.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < MCOUNT; i++) {
					textM[i].getText();
					textM[i].setText("");
				}
			}
		});

		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		save.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lm.save("Book.data");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		load.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lm.bList.clear();
					lm.list.clear();
					lm.mList.clear();
					lm.load("Book.data");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				bookList.removeAll();

				if ( flag == 1) { // Magzine
					for (Book b : lm.mList()) {
						bookList.add(b.getIsbn());
					}
					bookList.select(lm.mList().size() - 1);
				} else {
					for (Book b : lm.bList()) {
						bookList.add(b.getIsbn());
					}	
					bookList.select(lm.bList().size() - 1);
				}
			}
		});

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
