<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<%
String isError = request.getParameter("isError");
String id = "momo";
if(request.getParameter("id") != null){
	id = request.getParameter("id");
}
%>
<%= "1".equals(isError)? "아이디 밀번호를 확인해 주세요" : "" %>
<!-- ./ 현재 나의 경로 -->
<form action = "./login.jsp" method = "post">
	아이디 : <input type="text" name="id" value = "momo"><br/>
	비밀 번호 : <input type = "password" name = "pw" value = "1234"><br/>
	<button>로그인</button>
</form>
</body>
</html>