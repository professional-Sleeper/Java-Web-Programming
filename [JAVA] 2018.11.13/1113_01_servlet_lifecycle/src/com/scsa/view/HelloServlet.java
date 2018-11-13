package com.scsa.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloServlet() {
    	System.out.println("HelloServlet()....;");
       
    }
    
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy()....;");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()....;");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("doGet()....;");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter rout = response.getWriter();
		
		rout.print("<html>");
		rout.print("<head>");
		rout.print("<title>");
		rout.print("첫번째 서블릿");
		rout.print("</title>");
		rout.print("</head>");
		rout.print("<body>");
		rout.print("<h1>");
		rout.print("안녕 scsa");
		rout.print("</h1>");		
		rout.print("<h2>");
		rout.print(new Date());
		rout.print("</h2>");
		rout.print("</body>");
		rout.print("</html>");
		
		rout.close();
		
	}



}
