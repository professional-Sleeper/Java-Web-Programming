package com.scsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectJobsInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String DB_URL = "jdbc:oracle:thin:@70.12.60.53:1521:XE";
		final String DB_USER = "hr";
		final String DB_PASSWORD = "hr";
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		String sql = "select * from jobs order by job_id";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.printf("%s %s %d %d\n",rs.getString(1),rs.getString(2)
						,rs.getInt(3),rs.getInt(4));
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
