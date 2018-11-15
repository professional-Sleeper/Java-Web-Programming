package com.scsa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scsa.model.dao.BookDAO;
import com.scsa.model.vo.BookInfo;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		BookInfo bookinfo = null;
		BookDAO b = new BookDAO();
		
		try {
			bookinfo = b.returnBook(isbn);
			request.setAttribute("book", bookinfo);
			RequestDispatcher rd = request.getRequestDispatcher("/book/BookView.jsp");
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
