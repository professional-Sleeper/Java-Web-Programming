package com.scsa.ui;

public class ExistISBNException extends Exception {

	public ExistISBNException(String isbn) {
		super("�ߺ��� Isbn �Դϴ�. : "+isbn);
		
	}
}
