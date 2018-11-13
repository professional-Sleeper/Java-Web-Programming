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
		out.print("�ι�° ����");
		out.print("</title>");
		out.print("</head>");
		
		out.print("<body>");
		out.println("<h2> �Է��Ͻ� ������ ������ �����ϴ�.</h2>");
		out.println("<h3> ���̵�: "+id+"</h3>");
		out.println("<h3> �н�����: "+password+"</h3>");
		out.println("<h3> ����: "+gender+"</h3>");
		if (request.getParameter("age") != null &&
				request.getParameter("age").trim().length() != 0) {
			age = Integer.parseInt(request.getParameter("age"));
		}
		out.println("<h3> ����: "+age+"</h3>");
		if(hobby != null) {
			for (String string : hobby) {
				out.println("<h3> ���: "+string+"</h3>");
			}
		}
		
		out.print("</body>");
		out.print("</html>");
	}

	

}
