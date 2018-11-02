package com.scsa.Shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class transferThread extends Thread {
	
	Socket s = null;
	PrintWriter out = null;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			s = new Socket("70.12.60.54",7777);
			out = new PrintWriter(s.getOutputStream(),true);
			for (Product p : ProductManagerImpl.getInstance().getList()) {
				out.println(p.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( s!=null)
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
