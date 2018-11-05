package com.scsa.jadv.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EmpServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(7777);

			s = ss.accept();

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (true) {
				System.out.println(br.readLine());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ss != null)
				try {
					ss.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
