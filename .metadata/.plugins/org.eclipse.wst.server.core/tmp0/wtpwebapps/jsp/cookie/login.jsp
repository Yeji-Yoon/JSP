<%@page import="com.momo.utils.CookieManager"%>
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
	//userId 쿠키에서 찾아요!!
	//요청 객체로부터 쿠키 정보를꺼내서 userId값을 변수에 저장함.
	String userId = "";
	String checked = "";
	
	userId = CookieManager.readCookie(request, "userId");
	//userId가 빈문자 열이 아니면 checked를 넣음
	checked = !"".equals(userId) ? "checked" : "";
	
	/*위와 동일한 역할 
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
	for(Cookie cookie : cookies) 
		if("userId".equals(cookie.getName())){
			out.print("userId를 찾았어요");
			userId = cookie.getValue();
			checked = "checked";
			break;
		}
	}
	*/
	out.print("checked 값 : " + checked);
	
%>
<form action="loginAction.jsp" method="post">
<div class='loginbox'>
        <div id='login'>
            <input type="text" name="id" id="userid" placeholder='ID를 입력해주세요.' required="required" value="<%= userId%>"><br>
            				
            <input type="password" name="pw" id="userpw" placeholder='PW를 입력해주세요.' required="required" value="1234"><br>
            <input type="checkbox" <%=checked %>name="save_check" value="Y">아이디 저장하기<br>
        </div>
        <div id='button'>
        <input type="submit" value="로그인">
        </div>
    </div>
    <div id='info'>
        <a href="">회원가입</a>
        <a href="">ID찾기</a>
        <a href="">PW찾기</a>
    </div> 
</form>

</body>
</html>