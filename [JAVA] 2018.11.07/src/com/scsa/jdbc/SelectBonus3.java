package com.scsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectBonus3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String DB_URL = "jdbc:oracle:thin:@70.12.60.53:1521:XE";
		final String DB_USER = "hr";
		final String DB_PASSWORD = "hr";
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		String sql = "select sum(round(salary*1.3,-2)) as bonus from employees";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println(rs.getInt("bonus"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
