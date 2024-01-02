<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
<%
      
      //변수 선언
      int age = Integer.parseInt(request.getParameter("age"));
      
      out.print("나이 : " + age);
%>
<hr>
<%= "나이 : " + age %>
</body>
</html>