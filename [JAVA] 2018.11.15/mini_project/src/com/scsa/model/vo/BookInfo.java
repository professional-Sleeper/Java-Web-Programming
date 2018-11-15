package com.scsa.model.vo;

public class BookInfo {
	private String isbn;
	private String title;
	private String kind;
	private String nation;
	private String publish_date;
	private String publisher;
	private String author;
	private String price;
	private String summary;
	
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public BookInfo() {}
	
	public BookInfo(String isbn, String title, String kind, String nation, String publish_date, String publisher,
			String author, String price, String summary) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.kind = kind;
		this.nation = nation;
		this.publish_date = publish_date;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.summary = summary;
	}
	
	public BookInfo(String isbn, String title, String Author, String price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = Author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookInfo [isbn=" + isbn + ", title=" + title + ", kind=" + kind + ", nation=" + nation
				+ ", publish_date=" + publish_date + ", publisher=" + publisher + ", author=" + author + ", price="
				+ price + ", summary=" + summary + "]";
	}
}
