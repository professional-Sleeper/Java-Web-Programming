package com.scsa.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		int age = 0;
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("두번째 서블릿");
		out.print("</title>");
		out.print("</head>");
		
		out.print("<body>");
		out.println("<h2> 입력하신 정보는 다음과 같습니다.</h2>");
		out.println("<h3> 아이디: "+id+"</h3>");
		out.println("<h3> 패스워드: "+password+"</h3>");
		out.println("<h3> 성별: "+gender+"</h3>");
		if (request.getParameter("age") != null &&
				request.getParameter("age").trim().length() != 0) {
			age = Integer.parseInt(request.getParameter("age"));
		}
		out.println("<h3> 나이: "+age+"</h3>");
		if(hobby != null) {
			for (String string : hobby) {
				out.println("<h3> 취미: "+string+"</h3>");
			}
		}
		
		out.print("</body>");
		out.print("</html>");
	}

	

}
