package com.jurib.bank;
// Bank.java

public class Bank{
	public static void main(String [] args){
		Account account = new Account();
		Thread t1 = new Ant(account);				//�����ϴ� Thread ��ü
		Thread t2 = new Drawing(account);		//����ϴ� Thread ��ü
		t1.start();
		t2.start();	
	}
}