package com.scsa.Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket s= null;
		String str;
		Socket s1 = null;
		BufferedReader in = null;
		
		try {
			s = new ServerSocket(7777);
			
			System.out.println("¥Î±‚¡ﬂ");
			s1 = s.accept();
			in = new BufferedReader(new InputStreamReader(s1.getInputStream()));

			while((str = in.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
