<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.momo.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Core태그
    변수 선언, 조건문, 반복문등을 대체하는 태그를 제공 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- set : 변수 선언(setAttribute())
	var : 변수명
	vlaue : 값
	scope : 저장영역 - 기본값은 page
 -->
<c:set var="directVar" value="100" scope="request"/>
<c:set var="elVar" value="${directVar mod 5 }"/>
<c:set var="dateVar" value="<%=new Date() %>"/>
<c:set var="betweenVar">값</c:set>

<h2>el을 이용해서 변수를 출력해봅시다.</h2>
<ul>
	<li>${directVar }</li>
	<li>${elVar }</li>
	<li>${dateVar }</li>
	<li>${betweenVar }</li>
</ul>
	
<h2>자바빈즈 생성1 = 생성자를 이용</h2>
<c:set var="person" value='<%=new Person("GD",25) %>' scope="request"></c:set>
<ul>
	<li>${person.name }</li>
	<li>${person.age }</li>
</ul>

<h2>자바빈즈 생성2 - 생성후 값을 변경하기</h2>
<c:set var="person2" value='<%=new Person("대성",30) %>'></c:set>
<p>변경전</p>
리스트 : ${person2 }
<ul>
	<li>${person2 }</li>
	<li>${person2.name }</li>
	<li>${person2.age }</li>
</ul>
<!-- 자바 빈즈 생성후 값을 변경해봅시다.
	target : 자바빈즈 변수명
	property : 자바빈즈 속성명(멤버 변수명)
	value : 값 지정 
 -->
 <c:set target="${person2 }" property="name" value="빅뱅"></c:set>
 <c:set target="${person2 }" property="age" value="20"></c:set>
 <p>변경후</p>
 <ul>
 	<li>${person2 }</li>
 	<li>${person2.name }</li>
 	<li>${person2.age }</li>
 </ul>
<h2>List 컬렉션 이용하기</h2>
<%
	//리스트 생성
	List<Person> list = new ArrayList<>();
	list.add(new Person("세븐틴",17));
	list.add(new Person("청하",28));
%>
<c:set var = "list" value = "<%=list %>"></c:set>
<ul>
	<li>${list[0].name}</li>
	<li>${list[0].age}</li>
</ul>
<ul>
	<li>${list[1].name}</li>
	<li>${list[1].age}</li>
</ul>
<hr>
<!-- 리스트를 출력하기 위해서 반복문을 사용해봅시다.
	for(Person p:list){...} 비슷 -->
<p>foreach를 사용해서 반복문을 만들어 봅시다</p>
<c:forEach var="list" items="<%=list %>">
	이름 : ${person.name }
	나이 : ${person.age }
</c:forEach>
<hr>

<h2>Map 컬렉션 이용하기</h2>
<%
	//map : 다른 타입의 여러가지 값을 저장하기가 용이
	//리스트,pageDto
	//ajax,petch 를 이용할 경우 -> 데이터만 전달 ->스크립트에서 화면을 다시 그려주어야해요!
	//list : 인덱스를 이용해서 한가지 타입만 넘김
	Map<String, Person> map = new HashMap<>();
	map.put("person1",new Person("사람1",27));
	map.put("person2", new Person("사람2",27));
%>
<!-- map은 변수로 선언만 하고 영역에 저장하지 않았기ㄸ문에 사용할수 없어요 -->
<c:set var="pMap" value="<%=map %>"></c:set>
<ul>
	<li>${pMap.person1.name }</li>
	<li>${pMap.person1.age }</li>
</ul>
<ul>
	<li>${pMap.person2.name }</li>
	<li>${pMap.person2.age }</li>
</ul>

</body>
</html>