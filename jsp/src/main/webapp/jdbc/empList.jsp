<%@page import="com.momo.dto.EmpDto"%>
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

<h2>사원 목록을 출력해봅시다</h2>

<%
	//request.getAttribute()의 반환타입 Object타입이므로 현변환후에 사용이 가능합니다.
	List<EmpDto> list = (List<EmpDto>)request.getAttribute("list");
%>
<%=list %>
<talbe>
	<tr>
		<td>사원</td>
		<td>사원명</td>
		<td>주민등록 번호</td>
	</tr>
	<%for(EmpDto dto : list) {%>
		<td><%=dto.getEmp_id() %></td>
		<td><%=dto.getEmp_name() %></td>
		<td><%=dto.getEmp_no() %></td>
	<% } %>
	<tr>
	
	</tr>
</talbe>
</body>
</html>