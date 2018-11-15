package com.scsa.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	private static DataSource ds;
	static {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/OracleDB");

			// ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/OracleDB");
			// 하나만 하면 이렇게 해도됨 근데 env밑에 다른거도 있을 수 있으니 나눔
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // root directory임(naming service의 루트)
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();

	}

	public static void close(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void close(Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void close(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}