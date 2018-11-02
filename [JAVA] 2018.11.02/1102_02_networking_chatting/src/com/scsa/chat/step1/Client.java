package com.scsa.chat.step1;

import java.io.IOException;
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
			me = new Socket("70.12.60.54", 3337);
			out1 = new PrintWriter(me.getOutputStream(), true);

			
			// nanKisu = new Socket("70.12.60.53", 3337);
			// out2 = new PrintWriter(nanKisu.getOutputStream(),true);

			while (true) {

				sb.append(sc.nextLine());
				out1.println(sb);
				// out2.println(sb);
				if (sb.equals("exit")) {
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
