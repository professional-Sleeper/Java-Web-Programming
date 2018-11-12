package com.scsa.jdbc.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scsa.jdbc.util.DBUtil;

public class CustomerDAO {
	
	public void add(Customer c) throws SQLException {
		
		String sql = "Insert into Customer values(?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// Ŀ�ؼ� ����
			con = DBUtil.getConnection();
			
			// Prepared ������Ʈ��Ʈ ����
			ps = con.prepareStatement(sql);
			
			// ����ǥ ä���
			ps.setInt(1, c.getCnum());
			ps.setString(2, c.getCname());
			ps.setString(3, c.getCaddress());
			
			// ����
			int Count = ps.executeUpdate();
			System.out.println("Customer�� "+Count+"���� �߰� �Ǿ����ϴ�.");
		}  finally {
			
			// ��� ���
			
			try {
				DBUtil.close(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBUtil.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Customer> search() throws SQLException{
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		String sql = "select * from Customer";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			// Ŀ�ؼ� ����
			con = DBUtil.getConnection();
			
			// Prepared ������Ʈ��Ʈ ����
			ps = con.prepareStatement(sql);
			
			// ����
			rs = ps.executeQuery();

			// �����ϴ� �����͸�ŭ
			
			while (rs.next()) {
				list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			
			System.out.println("Customer List �˻� ����");
			return list;
		} finally {
			
			// ��� ���
			
			try {
				DBUtil.close(rs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				DBUtil.close(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBUtil.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}