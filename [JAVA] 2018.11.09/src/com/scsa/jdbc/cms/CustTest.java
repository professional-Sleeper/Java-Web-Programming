package com.scsa.jdbc.cms;

import java.sql.SQLException;

public class CustTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAO();
		
		try {
			dao.add(new Customer(1,"가","서울시"));
			dao.add(new Customer(2,"나","경기도"));
			dao.add(new Customer(3,"다","강원도"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer 데이터 추가 실패");
		}

		
		try {
			for(Customer c:dao.search()) {
				System.out.println(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer 데이터 검색 실패");
		}
	}
}
