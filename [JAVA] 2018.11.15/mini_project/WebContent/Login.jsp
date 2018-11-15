<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.title {
	text-align: center;
	height: 40px;
	background-color: gray;
}

.label {
	padding-right : 10px;
	text-align: right;
	height: 40px;
}

.content{
	padding-left : 10px;
}

.button{
	text-align: center;
}


</style>
</head>
<body>
	<form action="<%=request.getContextPath() %>/controller/login.do" method = post>
		<table width = "400px" border="1">
			<tr>
				<td colspan="2" class="title">로 그 인</td>
			</tr>
			<tr>
				<td class="label">아이디</td>
				<td class = "content"><input type="text" name="id" ></td>
			</tr>

			<tr>
				<td class="label">비밀번호</td>
				<td class = "content"><input type="password" name="password"></td>
			</tr>

			<tr>
				<td class = "button" colspan="2" ><input type="submit" value="로그인"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>