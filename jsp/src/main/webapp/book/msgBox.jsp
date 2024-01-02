<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 메세지 출력후 다른페이지를 요청하거나 뒤로가기 함. -->
<script type="text/javascript">
	//1. 서버로부터 전달받은 메세지를 출력합니다.
	let msg = '${msg}';
	//alert('${msg}');
	
	//2. 서버로 부터 전달받은 url로 이동함
	//만약 url에 값이 있다면 url요청 (location.href = null)
	//단, url이 없다면 뒤로가기를 시행함.
	let url = '${url}';
	if(msg !='') {
		alert(msg);
	}
	if(url != '') {
		
		//웹브라우저 객체 BOM - location
		//href - 페이지 요청
		//location.href ='/book/list';
		location.href = url;
	}else{
		//뒤로가기
    	history.go(-1);
		//history.go(-1);
    }
</script>
</body>
</html>