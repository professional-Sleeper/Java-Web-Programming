package com.scsa.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if ( id.equals("scsa") && password.equals("1111")) {
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("�α��� ����");
			out.print("</title>");
			out.print("</head>");
			
			out.println("<body>");
			out.println("<h1> &nbsp;&nbsp;&nbsp; scsa�� �α��� �Ǿ����ϴ�.!!!</h1>");
			out.println("<a href=\"./BookInput.html\""+"</a>");
			out.println("&nbsp;&nbsp;&nbsp;���� ���");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			out.println("<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"<style type=\"text/css\">\r\n" + 
					".title {\r\n" + 
					"	text-align: center;\r\n" + 
					"	height: 50px;\r\n" + 
					"	background-color: grey;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".label {\r\n" + 
					"	text-align: right;\r\n" + 
					"	height: 50px;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form action = \"./login.do\" method=get>\r\n" + 
					"		<table border=\"1\" width=\"600px\">\r\n" + 
					"			<tr>\r\n" + 
					"				<td colspan=\"2\" class=title>�� �� ��</td>\r\n" + 
					"			</tr>\r\n" + 
					"			<tr>\r\n" + 
					"				<td class = label>���̵� &nbsp;</td>\r\n" + 
					"				<td> &nbsp; <input type=\"text\" name = \"id\"/></td>\r\n" + 
					"			</tr>\r\n" + 
					"			<tr>\r\n" + 
					"				<td class = label>��й�ȣ  &nbsp;</td>\r\n" + 
					"				<td> &nbsp; <input type=\"password\" name=\"password\" /></td>\r\n" + 
					"			</tr>\r\n" + 
					"			<tr>\r\n" + 
					"				<td colspan=\"2\" class = title> \r\n" + 
					"					<input type = \"submit\" value=\"�α���\"/>\r\n" + 
					"					<input type = \"reset\" value=\"���\"/>\r\n" + 
					"				</td>\r\n" + 
					"			</tr>\r\n" + 
					"		</table>\r\n" + 
					"	</form>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		}
	}

}
