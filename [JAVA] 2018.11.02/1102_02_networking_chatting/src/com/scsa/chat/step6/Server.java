package com.scsa.chat.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	ServerSocket ss;
	ArrayList<ServerThread> clients;

	public void go() {
		try {
			clients = new ArrayList<ServerThread>();
			ss = new ServerSocket(7777);
			while(true) {
			Socket s = ss.accept();
			System.out.println(s.getInetAddress()+"가 접속했습니다.");
			
			new ServerThread(this,s).start();
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ss != null) ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void broadcast(String message,Socket c) {
		for (ServerThread st:clients) {
			st.sendMessage(message, c);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.go();
	}
	
	public void addClient(ServerThread c) {
		clients.add(c);
	}
	
	public void removeClient(ServerThread c) {
		clients.remove(c);
	}

}

class ServerThread extends Thread {

	private Socket s;
	BufferedReader in;
	PrintWriter out;
	String str = null;
	Server server = null;

	public ServerThread(Server server,Socket s) throws IOException {
		this.server = server;
		this.s = s;
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);
		
		server.addClient(this);
	}

	@Override
	public void run() {
		try {
			while ((str = in.readLine()) != null && str.trim().length() != 0) {
				System.out.println(s.getInetAddress() + "의 메세지 : " + str);
				server.broadcast(str, s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			server.removeClient(this);
		}
	}
	
	public void sendMessage(String message,Socket s) {
		out.println(s.getInetAddress()+" : "+message);
	}
}
