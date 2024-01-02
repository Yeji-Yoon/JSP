<%@page import="com.board.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상세</h2>
BoardDto : 한건의 게시글에 정보
<p>jsp를 단독으로 실행할 경우, request영역에서 BoardDto를 저장하지 않으므로 게시글의 정보가 출력되지 않아요!</p>
num : <%=request.getParameter("num") %>번 게시글에 대한 정보
dto : <%=request.getAttribute("boardDto") %>
<p>게시글 상세정보</p>
<%
	if(request.getAttribute("boardDto") != null) {
	BoardDto dto = (BoardDto)request.getAttribute("boardDto");
%>
<br>번호 : <%=dto.getNum() %>
<br>제목 : <%=dto.getTitle() %>
<br>내용 : <%=dto.getContent() %>
<br>작성자 : <%=dto.getId() %>
<br>작성일 : <%=dto.getPostdate() %>
<br>조회수 : <%=dto.getVisitcount() %>
<% } %>
            
</body>
</html>