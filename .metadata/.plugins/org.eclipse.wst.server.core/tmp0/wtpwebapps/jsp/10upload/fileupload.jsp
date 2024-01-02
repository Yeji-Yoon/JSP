<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일 업로드</h2>
<!-- 
	1. cos.jar 라이브러리 추가
	2. form 태그의 속성 설정
		- method : post
		- enctype : multipart/form-data
 -->
<form method="post" enctype="multipart/form-data" action="/upload/uploadProcess">
	<p>작성자 : <input type="text" name="name" value="momo"></p>
	<p>제목 : <input type="text" name="title" value="title"></p>
	<p>카테고리 : 
				<input type="checkbox" name="cate" value="picture">사진
				<input type="checkbox" name="cate" value="subject">과제
				<input type="checkbox" name="cate" value="word">워드
				<input type="checkbox" name="cate" value="umwon">음원
	
	</p>
	<p>첨부파일 : <input type="file" name="attachedFile"></p>
	<input type="submit" value="submit">
</form>
</body>
</html>