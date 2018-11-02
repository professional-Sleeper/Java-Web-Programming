package com.scsa.thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start..");
		
		MyThread [] thread = new MyThread[5];
		
		for (int i=0; i<3; i++) {
			thread[i] = new MyThread();
		}
		
		for (int i=0; i<3; i++) {
			thread[i].start();
		}
		
		System.out.println("main end...");
	}

}
