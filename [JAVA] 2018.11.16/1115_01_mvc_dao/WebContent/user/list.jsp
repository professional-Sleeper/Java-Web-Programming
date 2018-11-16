<%@page import="com.scsa.model.vo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table1.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<User> userList = (List<User>) request.getAttribute("userList");
				if (userList != null && userList.size() > 0) {
					for (User user : userList) {
			%>
			<tr>
				<th><%=user.getUserId() %></th>
				<th><%=user.getName() %></th>
			</tr>
			<%
				}
				} else { %>
					<tr>
						<td colspan = "2"> 조회된 데이터가 업습니다./>
					</tr>
				<% }
			%>
		</tbody>
	</table>
</body>
</html>