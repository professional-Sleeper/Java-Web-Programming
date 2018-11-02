package com.scsa.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListManagement implements Library {

	private static ListManagement instance = new ListManagement();

	private ListManagement() {
		
	}
	
	@Override
	public void save(String filename) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream out = new FileOutputStream(new File(filename));
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeInt(size());
		for (int i=0; i<size(); i++)
		{
			os.writeObject(list.get(i));
		}
		
	}

	@Override
	public void load(String filename)  throws IOException {
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream(new File(filename));
		ObjectInputStream ins = new ObjectInputStream(in);
		
		int len = ins.readInt();
		for (int i=0; i<len; i++) {
			try {
				Object o = ins.readObject();
				if (o instanceof Magazine)
					try {
						instance.add((Magazine) o);
					} catch (ExistISBNException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else
					try {
						instance.add((Book) o);
					} catch (ExistISBNException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static ListManagement getInstance() {
		return instance;
	}
	
	ArrayList<Book> list = new ArrayList<Book>();
	ArrayList<Book> bList = new ArrayList<Book>();
	ArrayList<Magazine> mList = new ArrayList<Magazine>();
	
	@Override
	public void add(Book b) throws ExistISBNException {
		// TODO Auto-generated method stub
		for (Book temp : list) {
			if(temp.getIsbn().equals(b.getIsbn()))
				throw new ExistISBNException("ISBN("+b.getIsbn()+") 중복입니다. ");
		}
		list.add(b);
		bList.add(b);
	}
	
	public void add(Magazine m) throws ExistISBNException
	{
		for (Book temp : list) {
			if(temp.getIsbn().equals(m.getIsbn()))
				throw new ExistISBNException("ISBN("+m.getIsbn()+") 중복입니다. ");
		}
		list.add(m);
		mList.add(m);
	}

	@Override
	public List<Book> allList() {
		return list;
		// TODO Auto-generated method stub
	}
	
	public List<Book> bList(){
		return bList;
	}
	
	public List<Magazine> mList(){
		return mList;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Book search(String isbn) {
		for (int i=0; i<list.size(); i++)
		{
			Book b = list.get(i);
			if (b.getIsbn().equals(isbn))
			{
				return b;
			}
		}
		// TODO Auto-generated method stub
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Book> searchTitle(String title) {
		ArrayList<Book> temp = new ArrayList<Book>();
		for (int i=0; i<list.size(); i++)
		{
			Book b = list.get(i);
			if (b.getTitle().contains(title))
			{
				temp.add(b);
			}
		}
		// TODO Auto-generated method stub
		return temp;
	}

	@Override
	public List<Book> searchPrice(int price) {
		ArrayList<Book> temp = new ArrayList<Book>();
		for (int i=0; i<list.size(); i++)
		{
			Book b = list.get(i);
			if (b.getPrice() == price)
			{
				temp.add(b);
			}
		}
		// TODO Auto-generated method stub
		return temp;
	}
	
	

	@Override
	public void sell(String isbn, int quantity) {
		Book b = search(isbn);
		if ( b.getQuantity() > quantity )
			b.setQuantity(b.getQuantity()-quantity);
		else b.setQuantity(0);
		// TODO Auto-generated method stub

	}

	@Override
	public void buy(String isbn, int quantity) {
		// TODO Auto-generated method stub
		Book b = search(isbn);
		if (b.getIsbn().equals(isbn))
		{
			b.setQuantity(b.getQuantity()+quantity);
		}
	}

	@Override
	public long getTotalPrice() {
		long sum = 0;
		for (int i=0; i<list.size(); i++)
		{
			Book b = list.get(i);
			sum += b.getPrice() * b.getQuantity();
		}
		// TODO Auto-generated method stub
		return sum;
	}

}
