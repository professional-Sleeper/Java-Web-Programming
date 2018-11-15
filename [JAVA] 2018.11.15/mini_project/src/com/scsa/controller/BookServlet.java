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
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		BookDAO bookDao = new BookDAO();
		BookInfo b = new BookInfo();
		b.setIsbn(request.getParameter("isbn"));
		b.setTitle(request.getParameter("title"));
		b.setKind(request.getParameter("kind"));
		b.setNation(request.getParameter("nation"));
		b.setPublish_date(request.getParameter("publish_date"));
		b.setPublisher(request.getParameter("publisher"));
		b.setAuthor(request.getParameter("author"));
		b.setPrice(request.getParameter("price"));
		b.setSummary(request.getParameter("summary"));
		
		try {
			bookDao.enrollBook(b);
			request.setAttribute("book", b);
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
