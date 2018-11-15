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
}


</style>
</head>
<body>
	<table width = "700px">
	<tr>
		<td> <h1> 도서 정보 관리 ERROR</h1> </td>
	</tr>
	<tr>
		<td> <%=request.getAttribute("errorMessage") %> </td>
	</tr>
		
	</table>
</body>
</html>