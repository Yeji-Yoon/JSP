<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿을 통한 로그인</h2>  
<!-- 
경로 확인
loginProcess 또는 ./loginProcess : 현재 페이지의 위치를기준으로 경로를 호출
				/06%20session/ex/loginForm.jsp
/loginProcess : 루트 경로를 기준으로
				/loginProcess
../loginProcess :상위 경로로 이동
/06%20session/loginForm.jsp
 -->
  <form action="loginProcess" method="post" name="loginFrm">
        아이디 : <input type="text" name="user_id" required="required"/><br />
        패스워드 : <input type="password" name="user_pw" required="required"/><br />
        <input type="submit" value="로그인하기" />
   </form> 
</body>
</html>