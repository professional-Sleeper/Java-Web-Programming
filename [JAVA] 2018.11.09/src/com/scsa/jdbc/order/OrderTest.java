package com.scsa.jdbc.order;

import java.sql.SQLException;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDAO dao = new OrderDAO();
		try {
			// �տ� 0�� �� ������ ��¥�� �������� ��� �� ���� ������ �ƹ��� ��� x
			dao.add(new OrderInfo(0,1,1,5));
			dao.add(new OrderInfo(0,1,2,2));
			dao.add(new OrderInfo(0,1,3,1));
			
			dao.add(new OrderInfo(0,2,1,5));
			dao.add(new OrderInfo(0,2,2,2));
			dao.add(new OrderInfo(0,2,3,1));
			
			dao.add(new OrderInfo(0,3,1,5));
			dao.add(new OrderInfo(0,3,2,2));
			dao.add(new OrderInfo(0,3,3,1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("OrderInfo ������ �߰� ����");
		}
		
		try {
			System.out.println("======== ������ ��� �׽�Ʈ ==============");
			System.out.println();
			for (DeliveryInfo d:dao.deliverysearch()) {
				System.out.println(d);
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("======== ������ �˻� �׽�Ʈ ==============");
			System.out.println();
			System.out.println(dao.deliverySearch(1));
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("======== ���� �˻� �׽�Ʈ ==============");
			System.out.println();
			System.out.println(dao.getOrderPrice(2));
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}