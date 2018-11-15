package com.scsa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.scsa.util.DBUtil;

public class UserDAO {

	public boolean checkPW(String id,String password) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean re = false;
		String sql = "Select password from USERINFO where userid = ?";

		try {
			conn = DBUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				if( rs.getString(1).equals(password)) {
					re = true;
				}
			}
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		
		return re;
	}
}
