package com.jurib.bank;
// Drawing.java  출금만 하는 Thread class

public class Drawing extends Thread{
	Account account;
	int money = 10000;
	public Drawing(Account a){
		account = a;
	}
	public void run(){
		try{
			for(int i = 1; i<=20; i++){
				account.withdraw(money);
				Thread.sleep((int)(Math.random() * 20));
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
