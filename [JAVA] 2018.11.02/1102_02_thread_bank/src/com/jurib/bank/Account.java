package com.jurib.bank;

// Account.java .... share data

public class Account {
	private int balance;// �ܾ�
	private int transactionNum; // �ŷ�Ƚ��

	public synchronized void deposit(int money) {

		if ( balance>0) {
			notify();
		}
		
		transactionNum++;
		balance += money;
		System.out.print("[" + transactionNum + "]���� : \t");
		System.out.println(money + " ���� �� �ܾ� > " + balance);

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
			System.out.print("[" + transactionNum + "]��� : \t");
			System.out.println(money + " ��� �� �ܾ� > " + balance);

		}
	}
}