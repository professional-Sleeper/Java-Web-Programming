package com.scsa.jdbc.cms;

import java.sql.SQLException;

public class CustTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAO();
		
		try {
			dao.add(new Customer(1,"��","�����"));
			dao.add(new Customer(2,"��","��⵵"));
			dao.add(new Customer(3,"��","������"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer ������ �߰� ����");
		}

		
		try {
			for(Customer c:dao.search()) {
				System.out.println(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer ������ �˻� ����");
		}
	}
}
