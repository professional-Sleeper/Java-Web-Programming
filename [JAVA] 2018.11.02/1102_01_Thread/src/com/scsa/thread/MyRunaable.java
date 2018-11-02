package com.scsa.thread;

public class MyRunaable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
		
	}

}
