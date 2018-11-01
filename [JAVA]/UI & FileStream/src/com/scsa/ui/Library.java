package com.scsa.ui;

import java.io.IOException;
import java.util.List;

public interface Library {
	void add(Book b) throws ExistISBNException;
	List<Book> allList();
	int size();
	Book search(String isbn);
	List<Book> searchTitle(String title);
	List<Book> searchPrice(int price);
	void sell(String isbn,int quantity);
	void buy(String isbn,int quantity);
	long getTotalPrice();
	void save(String filename) throws IOException;
	void load(String filename) throws IOException;
}
