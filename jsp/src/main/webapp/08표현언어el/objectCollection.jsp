<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.momo.dto.Person"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	//리스트 생성
	List<Object> aList = new ArrayList<>();
	aList.add("문자열");
	aList.add(new Person("momo",25));
	
	//페이지 영역에 리스트 저장
	//el표현 언어를 사용하기 위해서 내장 객체에 값이 저장되어 있어야함
	pageContext.setAttribute("aList", aList);
%>
<h3>List컬랙션</h3>
<!-- 영역을 지정하지 않아도 작은 영역부터 탐색해서 있으면 출력. -->
<br>${aList}
<!-- 객체의 주소갑이 출력(toString()메서드의 호출결과
	->toString()을 재정의한 경우 해당 메서드의 실행결과가 출력 -->
<br>${aList[0] }
<br>${aList[1] }
<br>${aList[1].name }
<br>${aList[1].age }
<!-- 값이 없어도 오류가 발생하지 않아요 -->
<br>없어도 오루가 발생하지 않음 === ${aList[2].age}

<h3>Map 컬렉션</h3>
<%
	Map<String,String>map = new HashMap<>();
	//key, value
	map.put("한글","모모");
	map.put("영어","momo");
	
	pageContext.setAttribute("map",map);
%>
<ul>
	<li>
		한글
		<p>${map['한굴'] }</p>
		<p>${map["한글"] }</p>
		<!-- 한글은 .을 찍어서 접근할수 없음 
			\${} : 주석처리
		-->
		<p>\${map."한글" }</p>
		<P><%=map.get("한글") %></p>
	</li>
	<li>
		<p>${map['eng'] }</p>
		<p>${map["eng"] }</p>
		<p>${map.eng }</p>
		<p><%=map.get("eng") %></p>
	</li>
</ul>

</body>
</html>