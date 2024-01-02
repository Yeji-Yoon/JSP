<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>영역을 통해 전된된 객체 읽기</h3>
<% 
//표현언어 (el)를 이용하면 형변환이 필요없어 파라메터를 읽어올수 있음
//별도의 null처리를 하지 않아도 오류가 발생하지 않ㅅ음
//객체를 사용하기 위해서 임포트만 해주면 됨
%>
<ul>
	<li>Person객체(personObj)
		<p>${personObj.name} / ${personObj.age }</p>	
	</li>
	<li>문자열
		<p>${requestScope.str }</p>
	</li>
	<li>숫자
		<p>${integer }</p>
	</li>
	
</ul>
</body>
</html>