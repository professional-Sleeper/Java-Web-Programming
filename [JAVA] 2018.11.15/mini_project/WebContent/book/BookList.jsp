<%@page import="com.scsa.model.vo.BookInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	text-align: center;
}

.title {
	height: 100px;
	background-color: gray;
}

</style>
</head>
<body>
<% 
	List<BookInfo> list = (List<BookInfo>)request.getAttribute("list"); 
%>
	<table width ="100%"  border="1">
		<tr>
			<td class = "title" colspan="4">
				<h1> 도서 목록 화면 </h1>
			</td>
		</tr>
		<tr>
			<td width="25%">도서번호</td>
			<td width="40%">도서제목</td>
			<td width="15%">저자</td>
			<td width="20%">가격</td>
		</tr>
		<% for(BookInfo b : list){%>
			<tr>
				<td><%=b.getIsbn() %></td>
				<td><a href="<%=request.getContextPath()%>/controller/view.do?
						isbn=<%=b.getIsbn()%>">
				<%=b.getTitle() %></a></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getPrice() %>원</td>
			</tr>
		<% } %>
		<tr>
			<td colspan="4"><a href="<%=request.getContextPath() %>/book/BookInput.jsp">도서등록</a></td>
		</tr>
	</table>
</body>
</html>