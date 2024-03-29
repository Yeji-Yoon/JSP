<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>액션 태그를 활용한 포워딩</h2>
<!-- 
	페이지 전환(이동)
	page영역은 공유되지 않고 
	request영역은 공유 됩니다.
	session영역도 공유됨.
 -->
 <%	
 	request.setCharacterEncoding("utf-8");
 
 	//내장 객체 영역에 속성(값)을 저장
 	pageContext.setAttribute("pageAttr", "페이지 영역");
 	request.setAttribute("requestAttr", "요청 역영");
 	
 	//forward방식 
 	//request.getRequestDispatcher("경로").forward(request,response);
 	
 %>
 <jsp:forward page = "forwardSub.jsp">
 	<jsp:param value = "액션태그 파라메터" name = "param"></jsp:param>
 </jsp:forward>
 
</body>
</html>