package com.scsa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scsa.model.dao.UserDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO userDao = new UserDAO();

		// Ȥ�� �ѱ۷� ���� ���� ������ ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id != null && id.trim().length() !=0) {
			if (password != null && password.trim().length() != 0) {
				// ���̵�, �н����� �� �� �ִ� ���
				try {
					if ( userDao.checkPW(id, password)) {
						RequestDispatcher rd = request.getRequestDispatcher("/Result.jsp");
						rd.forward(request, response);
						return;
					} else {
						// ��й�ȣ�� ��ġ���� ���� ���
						System.out.println(id);
						request.setAttribute("errorMessage", "���̵� �Ǵ� �н����尡 �ٸ��ϴ�.");
					}
				} catch (SQLException e) {
					// SQL ����
					request.setAttribute("errorMessage", "�����ͺ��̽� ���� ���� ������ �߻��Ͽ����ϴ�");
				}
			} else {
				// �н����带 �Է����� ���� ���
				request.setAttribute("errorMessage", "��й�ȣ�� �Է��� �ּ���.");
			}
			
		} else {
			// ���̵� �Է����� ���� ���
			request.setAttribute("errorMessage", "���̵� �Է��� �ּ���.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		rd.forward(request, response);
		return;
	}

}
