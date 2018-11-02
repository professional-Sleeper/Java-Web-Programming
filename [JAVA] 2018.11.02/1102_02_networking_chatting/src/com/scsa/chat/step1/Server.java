package com.scsa.chat.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket ss;
	Socket s;
	BufferedReader br;
	
	public void go() {
		try {
			ss = new ServerSocket(3337);
			System.out.println("접속 대기중");
			s = ss.accept();
			System.out.println(s.getInetAddress()+"가 접속했습니다.");
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = null;
			
			
			while((str=br.readLine()) != null && str.trim().length() != 0 ) {
				
				System.out.println(s.getInetAddress()+"의 메세지 : "+ str);
			
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
