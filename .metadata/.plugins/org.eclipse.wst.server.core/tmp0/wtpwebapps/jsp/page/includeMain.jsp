<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 다른 JSP파일을 포함. -->
<%@ include file = "includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>include 지시어</h1>
오늘 날짜 : <%=today %>
<hr>
선언부(클래스 내부에 생성)<br>
    - 메서드 작성이 가능<br>
    - <%! %>
    
스크립틀릿 (메서드 내부에 생성)<br>
    - 메서드 작성이 불가능<br>
    - 자바코드 <br>
    - <%  %><br>
표현식 
    - 실행 결과 하나의 값을 출력하는 방법<br>
    - 상수, 변수, 연산자, 수식<br>
    - 값이 있는 메서드<br>
    - <%= 10+20 %><br>
    - <%= "오늘 날짜는"+today %><br>
<%@ include file =  "includeFooter.jsp"%>
</body>
</html>