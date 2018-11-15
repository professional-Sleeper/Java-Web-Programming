package com.scsa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scsa.model.vo.BookInfo;
import com.scsa.util.DBUtil;

public class BookDAO {

	public List<BookInfo> returnList() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BookInfo> list = new ArrayList<BookInfo>();

		String sql = "Select isbn,title,Author,price from BookInfo";

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BookInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return list;
	}

	public BookInfo returnBook(String isbn) throws SQLException {
		BookInfo b = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "Select * from BookInfo where isbn = ?";

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);

			rs = ps.executeQuery();
			if (rs.next()) {
				b = new BookInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}

		return b;
	}

	public void enrollBook(BookInfo b) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "Insert into Bookinfo values(?,?,?,?,?,?,?,?,?)";

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, b.getIsbn());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getKind());
			ps.setString(4, b.getNation());
			ps.setString(5, b.getPublish_date());
			ps.setString(6, b.getPublisher());
			ps.setString(7, b.getAuthor());
			ps.setString(8, b.getPrice());
			ps.setString(9, b.getSummary());

			ps.executeQuery();

		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);

		}

	}

	public void deleteBook(String isbn) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "delete from BookInfo where isbn = ?";

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			ps.executeQuery();

		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);

		}

	}

}
