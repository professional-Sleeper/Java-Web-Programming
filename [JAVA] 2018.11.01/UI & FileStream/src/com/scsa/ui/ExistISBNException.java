package com.scsa.ui;

public class ExistISBNException extends Exception {

	public ExistISBNException(String isbn) {
		super("중복된 Isbn 입니다. : "+isbn);
		
	}
}
