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
String id = request.getParameter("id");
String pw = request.getParameter("pw");

//체크 박스는 값이 선택된 경우에만 넘어옴.
//save_check값이 null이 아니라면 체크 박스는 값이 선택된 경우에만 넘어옴.
//체크박스의 값을 수집
String save_check = request.getParameter("save_check");
out.print("save_check"+ save_check);
//save_check값이 null이 아니라면
if(save_check != null) {
	//쿠키에 아이디를 저장함.
	CookieManager.makeCookie(response, "userId", id, 3600);
	/*이창에서 설정한 후 실행
	Cookie cookie = new Cookie("userId",id);
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
	*/
	out.print("아이디를 쿠키에 저장했습니다.");
}

if(true) {
//if("momo".equals(id) && "1234".equals(pw)) {
	out.print("<h2>로그인 성공</h2>");
}else {
	//java를 이용하는 방법
	String script=
	"<String script ='text/javascript'>"
			+"alert('id/pw를 확인해주세요.');"
			+"history.go(-1);"
			+"</script>";
		out.print(script);
%>
<!-- script를 이용하는 방법 
<script type = "text/javascript">
	alert('id.pw를 확인해주세요');
	//뒤로 가기 back : 뒤로 가기 go : 앞으로 가거나 뒤로 가기
	history.go(-1)
</script>
-->
<%
}
%>

</body>
</html>