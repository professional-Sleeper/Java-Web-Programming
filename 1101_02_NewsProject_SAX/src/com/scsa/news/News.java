package com.scsa.news;

public class News {
	
	private String title;
	private String link;
	private String desc;

	public News() {
		super();
	}

	

	@Override
	public String toString() {
		return "News [title=" + title + ", link=" + link + ", desc=" + desc + "]";
	}



	public News(String title, String link, String desc) {
		super();
		this.title = title;
		this.link = link;
		this.desc = desc;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	
	
}
