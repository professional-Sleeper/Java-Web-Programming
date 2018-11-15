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
			<td height = "100px"><h1><%=request.getParameter("id") %>님 로그인 되었습니다.!!!</h1></td>
		</tr>
		<tr>
			<td><a href="<%=request.getContextPath()%>/controller/list.do">도서목록보기</a></td>
		</tr>
		<tr>
			<td><a href="">로그아웃</a></td>
		</tr>
	</table>
</body>
</html>