<%@page import="com.scsa.model.vo.BookInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	text-align: center;
	width: 50%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%
		BookInfo b = (BookInfo) request.getAttribute("book");
	%>
	<table border="1">
		<tr>
			<td colspan="2"><h1>도서정보 상세보기</h1></td>
		</tr>

		<tr>
			<td colspan="2">도서 정보</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td><%=b.getTitle()%></td>
		</tr>

		<tr>
			<td>도서번호</td>
			<td><%=b.getIsbn()%></td>
		</tr>

		<tr>
			<td>도서분류</td>
			<td><%=b.getKind()%></td>
		</tr>

		<tr>
			<td>도서국가</td>
			<td><%=b.getNation()%></td>
		</tr>

		<tr>
			<td>출판일</td>
			<td><%=b.getPublish_date()%></td>
		</tr>

		<tr>
			<td>출판사</td>
			<td><%=b.getPublisher()%></td>
		</tr>

		<tr>
			<td>저 자</td>
			<td><%=b.getAuthor()%></td>
		</tr>

		<tr>
			<td>도서가격</td>
			<td><%=b.getPrice()%>원</td>
		</tr>

		<tr>
			<td>도서설명</td>
			<td><%=b.getSummary()%></td>
		</tr>
		<tr>
			<td colspan="2"><a href="<%=request.getContextPath() %>/book/BookInput.jsp">도서등록</a>
			<a href="<%=request.getContextPath() %>/controller/delete.do?isbn=<%=b.getIsbn()%>">도서삭제</a>
			</td>
		
		</tr>

	</table>
</body>
</html>