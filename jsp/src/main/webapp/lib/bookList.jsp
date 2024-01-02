<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- header 외부파일을 인클루드 -->
<%@ include file = "common/header.jsp" %>
<!-- 도서 목록을 출력합니다. -->
<br>${list }
<table border="1" class="table">
	<thead>
		<tr>
			<th>대여번호</th>
			<th>아이디</th>
			<th>도서번호</th>
			<th>대여여부</th>
			<th>대여일</th>
			<th>반납일</th>
			<th>반납가능일</th>
			<th>연체일</th>
		</tr>
	</thead>
</table>
<!-- footer 외부파일 인클루드 -->
<%@ include file="common/footer.jsp" %>
</body>
</html>