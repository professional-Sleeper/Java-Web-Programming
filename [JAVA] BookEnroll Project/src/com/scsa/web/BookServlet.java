package com.scsa.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String bno = request.getParameter("bno");
		String btitle = request.getParameter("btitle");
		String btype = request.getParameter("btype");
		String babroad = request.getParameter("babroad");
		String bdate = request.getParameter("bdate");
		String bpublisher = request.getParameter("bpublisher");
		String bwriter = request.getParameter("bwriter");
		String bprice = request.getParameter("bprice");
		String bmoney = request.getParameter("bmoney");
		String barea = request.getParameter("barea");
		
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				".title {\r\n" + 
				"	background-color: gray;\r\n" + 
				"	text-align: center;\r\n" + 
				"	height: 150px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".right {\r\n" + 
				"	text-align: right;\r\n" + 
				"	height: 40px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".left {\r\n" + 
				"	text-align: left;\r\n" + 
				"	height: 40px;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<table width=\"100%\" border=\"1\">\r\n" + 
				"		<thead class=title>\r\n" + 
				"			<tr>\r\n" + 
				"				<th colspan=\"2\"><h1>입력된 도서 정보</h1></th>\r\n" + 
				"			</tr>\r\n" + 
				"		</thead>\r\n" + 
				"		<tbody height=\"500px\">\r\n" + 
				"\r\n" + 
				"			<tr>\r\n" + 
				"				<th colspan=\"2\"><h1>도서 정보</h1></th>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;도서명</td>\r\n" + 
				"				<td>&nbsp;"+btitle+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;도서번호</td>\r\n" + 
				"				<td>&nbsp;"+bno+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;도서분류</td>\r\n" + 
				"				<td>&nbsp;"+btype+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;도서국가</td>\r\n" + 
				"				<td>&nbsp;"+babroad+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;출판일</td>\r\n" + 
				"				<td>&nbsp;"+bdate+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;출판사</td>\r\n" + 
				"				<td>&nbsp;"+bpublisher+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;저 자</td>\r\n" + 
				"				<td>&nbsp;"+bwriter+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;도서가격</td>\r\n" + 
				"				<td>&nbsp;"+bprice+bmoney+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr class=left>\r\n" + 
				"				<td width=\"150px\">&nbsp;도서설명</td>\r\n" + 
				"				<td>&nbsp;"+barea+"</td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tbody>\r\n" + 
				"		<tfoot class=title>\r\n" + 
				"			<tr height=\"50px\">\r\n" + 
				"				<td colspan=\"2\">\r\n" + 
				"					<a href=\"./BookInput.html\">도서 등록</a>\r\n" + 
				"				</td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tfoot>\r\n" + 
				"	</table>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
	}

}
