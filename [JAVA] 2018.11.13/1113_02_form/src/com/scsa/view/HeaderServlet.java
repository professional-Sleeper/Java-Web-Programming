package com.scsa.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userAgent = request.getHeader("User-Agent");
		
		Enumeration<String> names = request.getHeaderNames();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("세번째 서블릿");
		out.print("</title>");
		out.print("</head>");
		
		out.print("<body>");
		out.println("접속 브라우저 정보 "+userAgent);
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getHeader(name);
			out.println(name + " "+ value);
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
