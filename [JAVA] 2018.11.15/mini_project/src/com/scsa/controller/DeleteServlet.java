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
			System.out.println(request.getParameter("isbn")+" ���� ���� �Ǿ����ϴ�.");
			response.sendRedirect(request.getContextPath()+"/Result.jsp");
			return;
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "�����ͺ��̽� ���� ���� ������ �߻��Ͽ����ϴ�");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		rd.forward(request, response);
		return;
	}

}
