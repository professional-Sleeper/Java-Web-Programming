package com.scsa.Shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class saveThread implements Runnable,Serializable  {

	IproductManager dao = ProductManagerImpl.getInstance();
	
	@Override
	public void run() {
		
		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			out = new FileOutputStream(new File("Product.dat"));
			oos = new ObjectOutputStream(out);
			
			int size = dao.getList().size();
			oos.writeInt(size);
			for (Product p : dao.getList()) {
				oos.writeObject(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}

	}
}
