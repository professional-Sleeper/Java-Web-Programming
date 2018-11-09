package com.scsa.jdbc.pms;

import java.sql.SQLException;

public class ProdcutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductDAO dao = new ProductDAO();
		
		try {
			dao.add(new Product(1,"�̺�",40000,"�츮��"));
			dao.add(new Product(2,"����ȴ�",2000,"���̼�"));
			dao.add(new Product(3,"ħ��",600000,"���̽�"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product ������ �߰� ����");
		}

		
		try {
			for(Product p:dao.search()) {
				System.out.println(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product ������ �˻� ����");
		}
	}

}
