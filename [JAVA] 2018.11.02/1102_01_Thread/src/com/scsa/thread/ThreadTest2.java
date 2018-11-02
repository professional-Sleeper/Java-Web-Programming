package com.scsa.thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start..");
		
		Thread [] thread = new Thread[5];
		
		for (int i=0; i<3; i++) {
			thread[i] = new Thread(new MyRunaable());
		}
		
		for (int i=0; i<3; i++) {
			thread[i].start();
		}
		
		System.out.println("main end...");
	}

}
