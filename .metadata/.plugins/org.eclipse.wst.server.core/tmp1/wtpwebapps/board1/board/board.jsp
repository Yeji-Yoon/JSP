<%@page import="com.login.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	window.onload = function() {
		let logoutBtn = document.querySelector("#logoutBtn");
		if(logoutBtn != null){
			logoutBtn.onclick = function() {
				//로그아웃 처리 -> 로그인 페이지로 이동
				location.href = "/logoutAction";
			}
		}
		//로그인 버튼 처리
		let loginBtn = document.querySelector("#loginBtn")
			if(loginBtn != null) {
			loginBtn.addEventListener('click',function(){
				//로그인 페이지로 이동
			location.href = "/login.jsp";
			//alert('loginBtn 클릭');
			});
		}
			
		
	}
</script>
<%	
	if(session.getAttribute("userId") != null && 
		!"".equals(session.getAttribute("userId").toString())) {
		//로그인 사용자
		out.print(session.getAttribute("userId").toString() + "님 환영합니다.");
		out.print("<button id = 'logoutBtn'>로그아웃</button>");
	}else {
		//로그인 전
		out.print("<button id = 'loginBtn'>로그인</button>");
	}

%>

<h2>게시글 목록 조회</h2>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
    </tr>
  </thead>
  <tbody>
	<%
	if(request.getAttribute("list") == null){
		out.print("<td colspan='4'> 게시글이 존재하지 않습니다.</td>");
	}else {
		List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
		for(BoardDto dto : list) {
	%>
  
    <tr>
      <th scope="row"><%=dto.getNum() %></th>
      <td><a href = "/view1?num=<%=dto.getNum()%>"><%=dto.getTitle() %></a></td>
      <td><%=dto.getId() %></td>
      <td><%=dto.getPostdate() %></td>
    </tr>
    <!-- 반복 종료 -->
 <%  }
	}
	
%>   
  </tbody>
</table>

	<!-- 게시글의 수만큼 반복 시작 -->
	

	<!-- 반복 종료 -->

<%@include file = "PageNavi.jsp" %>
</body>
</html>