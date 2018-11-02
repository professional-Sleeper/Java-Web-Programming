package com.scsa.ui;

public class Magazine extends Book {

	private int year;
	private int month;

	public Magazine(String isbn,String title, String author, String publisher,
			String desc,int price, int quantity,int year,int month)
	{
		super(isbn,title,author,publisher,desc,price,quantity);
		this.year = year;
		this.month = month;
	}
	
	public Magazine() {
		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
