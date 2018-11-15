package com.scsa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scsa.model.dao.BookDAO;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookdao = new BookDAO();
		try {
			bookdao.deleteBook(request.getParameter("isbn"));
			System.out.println(request.getParameter("isbn")+" 도서 삭제 되었습니다.");
			response.sendRedirect(request.getContextPath()+"/Result.jsp");
			return;
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "데이터베이스 접근 도중 오류가 발생하였습니다");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		rd.forward(request, response);
		return;
	}

}
