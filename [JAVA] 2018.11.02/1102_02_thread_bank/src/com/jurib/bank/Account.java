package com.jurib.bank;

// Account.java .... share data

public class Account {
	private int balance;// ÀÜ¾×
	private int transactionNum; // °Å·¡È½¼ö

	public synchronized void deposit(int money) {

		if ( balance>0) {
			notify();
		}
		
		transactionNum++;
		balance += money;
		System.out.print("[" + transactionNum + "]¿¹±Ý : \t");
		System.out.println(money + " ¿¹±Ý ÈÄ ÀÜ¾× > " + balance);

	}

	public void withdraw(int money) {

		synchronized (this) {

			while(balance <= 0){ 
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			 
			
			transactionNum++;
			balance -= money;
			System.out.print("[" + transactionNum + "]Ãâ±Ý : \t");
			System.out.println(money + " Ãâ±Ý ÈÄ ÀÜ¾× > " + balance);

		}
	}
}