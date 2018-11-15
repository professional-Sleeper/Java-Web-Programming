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

		// 혹시 한글로 들어올 수도 있으니 셋팅
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id != null && id.trim().length() !=0) {
			if (password != null && password.trim().length() != 0) {
				// 아이디, 패스워드 둘 다 있는 경우
				try {
					if ( userDao.checkPW(id, password)) {
						RequestDispatcher rd = request.getRequestDispatcher("/Result.jsp");
						rd.forward(request, response);
						return;
					} else {
						// 비밀번호가 일치하지 않을 경우
						System.out.println(id);
						request.setAttribute("errorMessage", "아이디 또는 패스워드가 다릅니다.");
					}
				} catch (SQLException e) {
					// SQL 오류
					request.setAttribute("errorMessage", "데이터베이스 접근 도중 오류가 발생하였습니다");
				}
			} else {
				// 패스워드를 입력하지 않은 경우
				request.setAttribute("errorMessage", "비밀번호를 입력해 주세요.");
			}
			
		} else {
			// 아이디를 입력하지 않은 경우
			request.setAttribute("errorMessage", "아이디를 입력해 주세요.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		rd.forward(request, response);
		return;
	}

}
