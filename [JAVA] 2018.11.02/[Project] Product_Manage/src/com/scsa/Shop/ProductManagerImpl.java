package com.scsa.Shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ProductManagerImpl implements IproductManager {
	
	private static ProductManagerImpl instance = new ProductManagerImpl();
	
	public ArrayList<Product> list = new ArrayList<Product>();
	
	public static ProductManagerImpl getInstance() {
		
		return instance;
	}
	
	public ArrayList<Product> getList(){
		return list;
	}
	
	public ProductManagerImpl() {
		
	}
	
	@Override
	public Product search(String code) {
		for (Product p : list) {
			if(p.getCode().equals(code)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void save(Product p) throws SameCode {
		for (Product temp : list) {
			if(temp.getCode().equals(p.getCode())) {
				throw new SameCode(p.getCode());
			}
		}
		list.add(p);
	}

	@Override
	public void modify(String code,int price) {
		// TODO Auto-generated method stub
		for (int i=0; i<list.size(); i++) {
			if ( list.get(i).getCode().equals(code)) {
				list.get(i).setPrice(price);
			}
		}
	}

	@Override
	public void delete(Product p) {
		list.remove(p);
	}
	
	@Override
	public void load() throws ClassNotFoundException, IOException {
		FileInputStream in = new FileInputStream(new File("Product.dat"));
		ObjectInputStream br = new ObjectInputStream(in);
		
		int size = br.readInt();
		for (int i=0; i<size; i++) {
			list.add((Product)br.readObject());
		}
		br.close();
	}

}
