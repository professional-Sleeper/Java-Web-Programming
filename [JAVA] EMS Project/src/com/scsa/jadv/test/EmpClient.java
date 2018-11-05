package com.scsa.jadv.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class EmpClient extends Thread {
	Socket s = null;
	ArrayList<Employee> emps = EmpMgrImpl.getInstance().getList();

	public EmpClient(Socket temp) {
		s = temp;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			for (Employee e : emps) {
				out.println(e.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
