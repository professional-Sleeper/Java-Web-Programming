package com.scsa.Shop;

import java.io.IOException;
import java.util.ArrayList;

public interface IproductManager {

	Product search(String code);
	void save(Product p) throws SameCode;
	void modify(String code,int price);
	void delete(Product p);
	ArrayList<Product> getList();
	void load() throws ClassNotFoundException, IOException;
}
