package com.scsa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.scsa.exception.ExistedIDException;
import com.scsa.model.vo.User;
import com.scsa.util.DBUtil;

public class UserDAO {
	
	public boolean insertUser(User user) throws SQLException, ExistedIDException {
		
		return insertUser2(user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
		
	}

	public boolean insertUser(String userId, String password, String name, String email) throws SQLException, ExistedIDException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
	
		String sql = "INSERT INTO USERINFO (USERID, PASSWORD, NAME, EMAIL) "
				+ "VALUES (?, ?, ?, ?) ";
		try {
			
			if(selectUser(userId) != null) {
				throw new ExistedIDException(userId);
			}
			
			// 2. CREATE CONNECTION
			conn = DBUtil.getConnection();
			
			// 3. CREATE STATEMENT
			stmt = conn.prepareStatement(sql);
			
			// 4. EXECUTE SQL
			stmt.setString(1, userId);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, email);
			
			int rowCount = stmt.executeUpdate();
			System.out.println(rowCount + "행이 처리되었습니다.");
			return rowCount > 0;
		} finally {
			// 6. RELEASE RESOURCE
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
	}
	
	public boolean insertUser2(String userId, String password, String name, String email) throws SQLException, ExistedIDException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
	
		String sql = "INSERT INTO USERINFO (USERID, PASSWORD, NAME, EMAIL) "
				+ "VALUES (?, ?, ?, ?) ";
		try {
			
			// 2. CREATE CONNECTION
			conn = DBUtil.getConnection();
			
			// 3. CREATE STATEMENT
			stmt = conn.prepareStatement(sql);
			
			// 4. EXECUTE SQL
			stmt.setString(1, userId);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, email);
			
			int rowCount = stmt.executeUpdate();
			System.out.println(rowCount + "행이 처리되었습니다.");
			return rowCount > 0;
		} catch(SQLException e){
			e.printStackTrace();
			if(e instanceof SQLIntegrityConstraintViolationException) throw new ExistedIDException(userId);
			else throw e;
		} finally {
			// 6. RELEASE RESOURCE
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
	}
	
	public void deleteUser(String userId) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM USERINFO "
				+ "WHERE USERID = ?";
		try {
			
			// 2. CREATE CONNECTION
			conn = DBUtil.getConnection();
			
			// 3. CREATE STATEMENT
			stmt = conn.prepareStatement(sql);
			
			// 4. EXECUTE SQL
			stmt.setString(1, userId);
			int rowCount = stmt.executeUpdate();
			System.out.println(rowCount + "행이 처리되었습니다.");
		} finally {
			// 6. RELEASE RESOURCE
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
	}
	
	public void updateUser(User user) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "UPDATE USERINFO SET PASSWORD = ?, EMAIL = ? "
				+ "WHERE USERID = ?";
		try {
			
			// 2. CREATE CONNECTION
			conn = DBUtil.getConnection();
			
			// 3. CREATE STATEMENT
			stmt = conn.prepareStatement(sql);
			
			// 4. EXECUTE SQL
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getUserId());
			int rowCount = stmt.executeUpdate();
			System.out.println(rowCount + "행이 처리되었습니다.");
		} finally {
			// 6. RELEASE RESOURCE
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
	}
	
	public User selectUser(String userId) throws SQLException {
		
		User user = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT USERID, PASSWORD, NAME, EMAIL FROM USERINFO "
				+ "WHERE USERID = ?";
		try {
			
			// 2. CREATE CONNECTION
			conn = DBUtil.getConnection();
			
			// 3. CREATE STATEMENT
			stmt = conn.prepareStatement(sql);
			
			// 4. EXECUTE SQL
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
			}
		} finally {
			// 6. RELEASE RESOURCE
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return user;
		
	}
	
	public List<User> selectUserList() throws SQLException {
		
		List<User> list = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT USERID, PASSWORD, NAME, EMAIL FROM USERINFO ";

		try {
			
			// 2. CREATE CONNECTION
			conn = DBUtil.getConnection();
			
			// 3. CREATE STATEMENT
			stmt = conn.prepareStatement(sql);
			
			// 4. EXECUTE SQL
			rs = stmt.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(user);
			}
		} finally {
			// 6. RELEASE RESOURCE
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return list;
		
	}

	
	
}





















