<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일목록</h2>
list : ${list }

<table border = "1">
	<tr>
		<th>파일명</th>
		<th>제목</th>
		
		<th>아이디</th>
		<th>카테고리</th>
		<th>원본 파일명</th>
		<th>저장 파일명</th>
		<th>등록일</th>
	</tr>
	<c:forEach items="${list }" var="fileDto">
	<tr>
		<td>${fileDto.file_no }</td>
		<td>${fileDto.title }</td>
		<td>${fileDto.name }</td>
		<td>${fileDto.cate }</td>
		<td>${fileDto.ofile }</td>
		<td>${fileDto.sfile }</td>
		<td>${fileDto.postdate }</td>
	</tr>
	
	</c:forEach>
</table>
<!-- ofile : 원본파일명
	sfile : 저장된 파일명 
	저장된 파일로만 반지 않고 
-->
<a href="/10upload/filedownload.jsp?ofile=1.png&sfile=1.png">
				10_정규식.js
			</a>
			
</body>
</html>