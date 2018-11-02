package com.scsa.thread2;

public class MyThread extends Thread {

	public void run() {
		for (int i=1; i<=7; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +" : " + i);
		}
	}
}
