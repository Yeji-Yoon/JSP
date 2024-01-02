<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jst1의 core 태그를 사용하기 위해 태그 라이브러리 지시자를 추가합니다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!-- 커서 손모양으로 바꾸기 -->
<style type="text/css">
	.pointer {
		cursor : pointer;
	}
	
</style>

<script type="text/javascript">
/*
 	스크립트에서 함수를 정의하는 방법
	function 함수명(파람0,파람1,....){
		
	}
	함수의 호출
	함수명(파람0,파람1,...);
	
*/

//파라메터로 받은 것을 메세지 창으로 출력
function msg(str) {
	alert(str);
}

function view(no) {
	//화면 요청
	location.href = "/book/view?no=" + no; 
}


</script>
</head>
<body>
<%@ include file="../header.jsp" %>

<h2>도서목록</h2>
<!--  
<form action="/book/list" name = "searchForm">
	<input name = "pageNo">
	<input name="amount" value = "2">
</form>
-->

<form name="searchForm" action="/book/list">
pageNo : <input type="text" name="pageNo" value="${pageDto.cri.pageNo }">
num : <input type="text" name="num" value="">
amount : <input name="amount" value="1">
<div class="input-group">
  <select class="form-select" name="searchField" id="inputGroupSelect04" aria-label="Example select with button addon">
    <!-- 선택된 요소의 value값이 서버로 넘어감 -->
    <option value="title"
    		${pageDto.cri.searchField eq 'title' ? 'selected' : ''}
    		>도서명 </option>
	<option value="author" 
			${pageDto.cri.searchField eq 'author' ? 'selected' : ''}
			>작가</option>
  </select>
  <input type="text" name="searchWord" value="${pageDto.cri.searchWord }" class="form-control" aria-label="Text input with dropdown button">
  <button class="btn btn-outline-secondary" type="submit">검색</button>
</div>
</form>

<table class="table">
  <thead>
    <tr>
      <th scope="col">도서번호</th>
      <th scope="col">도서명</th>
      <th scope="col">작가</th>
      <th scope="col">대여여부</th>
    </tr>
  </thead>
  <tbody>
<c:if test="${empty list}" var="res">
<!-- 리스트가 비어있다면 메세지 출력 -->
	<tr>
	<!-- 4개의 colmn을 붙임. -->
	  <td colspan="4">도서목록이 존재하지 않습니다.</td>
	</tr>
</c:if> 
<!-- 리스트가 비어있지 않다면 도서 목록을 출력 -->
<c:if test="${not res }">
	<c:forEach items="${list }" var="dto">
	    <tr>
	      <th scope="row">${dto.no }</th>
	      <td class = "pointer" 
	      onclick="view(${dto.no})" >
      		${dto.title }
      </td>
	     
	     <%-- <td><a href ="/book/view?no=${dto.no }""></a>${dto.title }</td>--%>
	      <td>${dto.author }</td>
	      <!-- Y/N 대여중 -->
	      <td>${dto.rentYnStr }</td>
	    </tr>
	 </c:forEach>  
</c:if>	  
</tbody>
</table>

<!-- page Navi -->
<!-- pageDto가 request영역에 저장되어 있으면 페이지 블럭을 출력함 -->
<%@ include file="/06session/servletEx/PageNav.jsp" %>
 
  
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<%@ include file="../footer.jsp" %>
</body>
</html>