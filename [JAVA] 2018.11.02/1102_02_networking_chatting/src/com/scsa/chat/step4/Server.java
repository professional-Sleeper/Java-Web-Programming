package com.scsa.chat.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket ss;
	Socket s;
	BufferedReader in;
	PrintWriter out;
	String str = null;
	
	public void go() {
		try {
			ss = new ServerSocket(3337);
			System.out.println("접속 대기중");
			
			s = ss.accept();
			System.out.println(s.getInetAddress()+"가 접속했습니다.");
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(),true);
			

			while((str=in.readLine()) != null && str.trim().length() != 0 ) {
				System.out.println(s.getInetAddress()+"의 메세지 : "+ str);
				out.println("from Server ... " + str);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(s != null) s.close();
				if(ss != null) ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.go();
	}

}
