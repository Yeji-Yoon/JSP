<!-- 페이지 지시어
JSP 페이지를 자바(서블릿) 코드로 변환하는 데 필요한 정보를 JSP 엔진에 알려주며, 주로 스크립트 언어나 인코딩 방식 등을 설정
*페이ㅣ 지시어가 없는 경우 오류가 발생.
속성 = 값
language = "java"
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
jsp파일 호출 방법
localhost:포트/path/파일 이름
*웰컴 페이지 확인하기!!!
servlet 호출 방법
localhost:포트/path
 -->
     <h1>hello jsp</h1>
<%
     //자바 코드를 입력하기 위해 스크립트를 열어줌.
     
     //외부 클래스를 사용하기 위해서 page 지시어 import속성을 이용!!!
     Date today = new Date();

     //웹 브라우저에 출력하기 위핸 내장 객체
     //내장 객체 : 생성하지 않았지만 자동으로 클래스로 변환시 자동으로 생성해주는 객체. out이 내장 객체
     out.print("오늘 날짜 : " + today);
%>
<hr>
오늘 날짜 : <%= today  %>
</body>
</html>