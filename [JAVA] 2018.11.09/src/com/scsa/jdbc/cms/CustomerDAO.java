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
			
			// 커넥션 연결
			con = DBUtil.getConnection();
			
			// Prepared 스테이트먼트 연결
			ps = con.prepareStatement(sql);
			
			// 물음표 채우고
			ps.setInt(1, c.getCnum());
			ps.setString(2, c.getCname());
			ps.setString(3, c.getCaddress());
			
			// 실행
			int Count = ps.executeUpdate();
			System.out.println("Customer에 "+Count+"행이 추가 되었습니다.");
		}  finally {
			
			// 통로 폐쇄
			
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
			
			// 커넥션 연결
			con = DBUtil.getConnection();
			
			// Prepared 스테이트먼트 연결
			ps = con.prepareStatement(sql);
			
			// 실행
			rs = ps.executeQuery();

			// 존재하는 데이터만큼
			
			while (rs.next()) {
				list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			
			System.out.println("Customer List 검색 성공");
			return list;
		} finally {
			
			// 통로 폐쇄
			
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
