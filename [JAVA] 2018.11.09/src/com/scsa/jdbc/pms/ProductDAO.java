package com.scsa.jdbc.pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scsa.jdbc.util.DBUtil;

public class ProductDAO {

	public void add(Product p) throws SQLException {

		String sql = "Insert into Product values(?,?,?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;

		try {

			// 커넥션 연결
			con = DBUtil.getConnection();

			// Prepared 스테이트먼트 연결
			ps = con.prepareStatement(sql);

			// 물음표 채우고
			ps.setInt(1, p.getPnum());
			ps.setString(2, p.getTitle());
			ps.setInt(3, p.getPrice());
			ps.setString(4, p.getBrand());

			// 실행
			int Count = ps.executeUpdate();
			System.out.println("Product에 " + Count + "행이 추가 되었습니다.");
		} finally {

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

	public ArrayList<Product> search() throws SQLException {

		ArrayList<Product> list = new ArrayList<Product>();

		String sql = "select * from Product";

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
				list.add(new Product(rs.getInt(1), rs.getString(2), 
						rs.getInt(3),rs.getString(4)));
			}

			System.out.println("Product List 검색 성공");
			return list;
		}  finally {

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
