package com.scsa.Shop;

import java.io.Serializable;

public class Product implements Serializable {
	private String code;
	private String pName;
	public Product(String code, String pName, int price) {
		super();
		this.code = code;
		this.pName = pName;
		this.price = price;
	}
	private int price;
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", pName=" + pName + ", price=" + price + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
