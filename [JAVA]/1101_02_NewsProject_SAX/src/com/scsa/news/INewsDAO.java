package com.scsa.news;


import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url);
	String getDesc(String title);
}
