<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import ="java.util.*,java.text.*"    
%>
<%!
	public static final int SIZE = 10;
	public int sum(int i,int j){
		return i+j;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp 예제</h1>
	<%
		// loog reeting
		//for(int i=0; i<SIZE; ++i){%>
		<h2>Hello Scsa</h2>
	<%	//}
	%>
	<HR/>
	<%=2+3 %> <BR/>
	<%=sum(20,30) %>
</body>
</html>