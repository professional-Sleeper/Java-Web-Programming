package com.scsa.ui;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String desc;
	private int price;
	private int quantity;

	public Book(String isbn, String title, String author, 
			String publisher, String desc, int price, int quantity) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;

	}	
	
	public Book() {
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}



	public void setPublihser(String publihser) {
		this.publisher = publihser;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
