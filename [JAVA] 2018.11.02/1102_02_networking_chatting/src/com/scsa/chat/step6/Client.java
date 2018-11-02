package com.scsa.chat.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	Socket me;
	PrintWriter out1 = null;

	Scanner sc = new Scanner(System.in);
	StringBuilder sb = new StringBuilder();

	public void chatToServer() {

		try {
			System.out.println("Client................");
			me = new Socket("70.12.60.50", 7777);
			out1 = new PrintWriter(me.getOutputStream(), true);
			
			new ClientThread(me).start();
			
			while (true) {

				sb.append(sc.nextLine());
				out1.println(sb);
				if (sb.toString().trim().length() == 0) {
					break;
				}

				sb.setLength(0);

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (me != null)
				try {
					me.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.chatToServer();
	}
}

class ClientThread extends Thread {

	BufferedReader in = null;
	Socket s;

	public ClientThread(Socket s) throws IOException {
		this.s = s;
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));

	}

	@Override
	public void run() {
		String str = null;
		try {
			while ((str = in.readLine()) != null && str.trim().length() != 0) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( s!= null)
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}