package com.scsa.jdbc.pms;

import java.sql.SQLException;

public class ProdcutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductDAO dao = new ProductDAO();
		
		try {
			dao.add(new Product(1,"이불",40000,"우리집"));
			dao.add(new Product(2,"수면안대",2000,"다이소"));
			dao.add(new Product(3,"침대",600000,"에이스"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product 데이터 추가 실패");
		}

		
		try {
			for(Product p:dao.search()) {
				System.out.println(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product 데이터 검색 실패");
		}
	}

}
