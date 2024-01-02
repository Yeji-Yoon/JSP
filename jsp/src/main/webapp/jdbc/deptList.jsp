<%@page import="java.util.List"%>
<%@page import="com.momo.dao.DeptDao"%>
<%@page import="com.momo.dto.DeptDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
DeptDto dao = new DepartmentDao(application);
	List<DeptDto> list = dao.getList();
	
	
	for(DeptDto dto: list) {
		out.print(dto.getDept_title());
		out.print(dto.getLocal_code());
		out.print(dto.getLocation_id());
		out.print(dto.getLocal_name());
		
	}
 -->
 
<h2>부서 목록</h2>
<%
	//jsp를 단독으로 실행할 경우 null이 출력될수 있다.
	//ruquest받는 것이 없어서 null 출력
	List<DeptDto> list = (List<DeptDto>)request.getAttribute("list");
	out.print(list);
%>	
</body>
</html>