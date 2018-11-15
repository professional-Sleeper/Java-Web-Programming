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
	height: 150px;
	background-color: gray;
}

.right {
	text-align: right;
	height: 40px;
}

.left {
	text-align: left;
	height: 40px;
}
</style>
</head>
<body>
	<form action="<%=request.getContextPath() %>/controller/book.do" METHOD=POST>
		<table width="100%" border="1">
			<thead class=title>
				<tr>
					<th colspan="2"><h1>도서 등록 화면</h1></th>
				</tr>
			</thead>
			<tbody height="500px">
				<tr class=right>
					<td colspan="2">* 표시가 된 항목은 필수 입력 항목입니다.&nbsp;</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;* 도서번호</td>
					<td>&nbsp; <input type="text" name ="isbn" required>
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;* 도서제목</td>
					<td>&nbsp; <input type="text" name = "title" required>
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;* 도서종류</td>
					<td>&nbsp; <select name = "kind" required>
							<option value ="">해당 항목을 선택하세요</option>
							<option value="프로그래밍">프로그래밍</option>
							<option value="운영체제">운영체제</option>
							<option value="데이터베이스">데이터베이스</option>
							<option value="네트워크">네트워크</option>
					</select>
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp; 출판국가</td>
					<td>&nbsp;
				     	  <input type="radio" value="국내도서" name = "nation"> 국내도서 
						  <input type="radio" value="외국도서" name = "nation" > 외국도서
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp; 출 판 일</td>
					<td>&nbsp; <input type="text" name = "publish_date">
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;출 판 사</td>
					<td>&nbsp; <select name = "publisher">
							<option value="">해당 항목을 선택하세요</option>
							<option value="영진출판사">영진출판사</option>
							<option value="한빛미디어">한빛미디어</option>
							<option value="프리렉출판사">프리렉출판사</option>
							<option value="네오솔루션">네오솔루션</option>
							<option value="사이버출판사">사이버출판사</option>
					</select>
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;* 저 자</td>
					<td>&nbsp; <input type="text" name="author" required>
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;* 도서가격</td>
					<td>&nbsp; <input type="text" name="price"> 
							<select name = "bmoney">
							<option value="원">원</option>
							<option value="달러">달러</option>
					</select>
					</td>
				</tr>

				<tr class=left>
					<td width="150px">&nbsp;요약내용</td>
					<td>&nbsp; <textarea rows="4" cols="80" name = "summary">
						</textarea>
					</td>
				</tr>
			</tbody>
			<tfoot class=title>
				<tr height="50px">
					<td colspan="2"><input type="submit" value="도서등록" /> <input
						type="reset" value="취소" /></td>
				</tr>
			</tfoot>
		</table>
	</form>


</body>
</html>