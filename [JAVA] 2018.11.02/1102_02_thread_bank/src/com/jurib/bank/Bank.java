package com.jurib.bank;
// Bank.java

public class Bank{
	public static void main(String [] args){
		Account account = new Account();
		Thread t1 = new Ant(account);				//예금하는 Thread 객체
		Thread t2 = new Drawing(account);		//출금하는 Thread 객체
		t1.start();
		t2.start();	
	}
}