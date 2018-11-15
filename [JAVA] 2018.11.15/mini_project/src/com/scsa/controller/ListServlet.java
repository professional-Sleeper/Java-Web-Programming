package com.scsa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scsa.model.dao.BookDAO;
import com.scsa.model.vo.BookInfo;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BookDAO bookDao = new BookDAO();
		try {
			List<BookInfo> list = bookDao.returnList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/book/BookList.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "데이터베이스 접근 도중 오류가 발생하였습니다");
		} 
		RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		rd.forward(request, response);
		return;
	}

}
