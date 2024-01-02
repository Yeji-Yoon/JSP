<%@page import="java.util.Set"%>
<%@page import="com.momo.dto.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(application.getAttribute("map") != null ) {
		
		//브라우져를 닫았다가 다시 열어도 값이 유지가 됨.
		//서버를 종료후 다시 실행시 제거되는 것을 확인 할 수 있음.
		Map<String,Person> map = (Map<String,Person>)application.getAttribute("map");
		
		//맵에 담겨진 데이터의 키값을 조회함.
		//keySet() : 키의 지밥을 set타입으로 반환함.
		Set<String> keys = map.keySet();
		
		//map는 key, value가 쌍으로 저장되는 컬렉션 타입임.
		//get(key) : 키값을 이용하여 value값을 반환 받음.
		for(String key : keys) {
			//toString가 미리 재정의됨.
			Person p = map.get(key);
			out.print(p+"<br>");
		}
		
	}else { 
		out.print("map이 존재하지 않음.");
	}
	
	
%>
</body>
</html>