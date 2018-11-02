package com.scsa.Shop;

public class SameCode extends Exception{
	
	public SameCode(String code) {
		super("상품코드가 겹칩니다 : "+code);
		
	}
}
