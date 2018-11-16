package com.scsa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scsa.model.dao.UserDAO;
import com.scsa.model.vo.User;

/**
 * Servlet implementation class UserListErvlet
 */
public class UserListErvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. process Business Logic(call Model)
		UserDAO userDao = new UserDAO();
		try {
			List<User> user = userDao.selectUserList();
			request.setAttribute("userList", user);
			
			request.getRequestDispatcher("/user/list.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", 
					"����� ��� ��ȸó�� �� ������ �߻��Ͽ����ϴ�. : "+e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
	}

}
