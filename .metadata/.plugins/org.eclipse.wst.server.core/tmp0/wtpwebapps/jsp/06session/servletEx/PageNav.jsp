<%@page import="com.momo.dto.PageDto"%>
<%@page import="com.momo.dto.Criteria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- 
페이지를 블럭을 출력하는 방법
	1. 요청 컨트롤러에서 pageDto를 request영역에 저장해주세요.
	2. pageNavi.jsp를 리스트 페이지의 페이지 블럭을 출력하고싶은 위치에 include해주세요.
	3. searchForm을 생성합니다.
		pageNo요소가 있어야해요
	-->
<script type="text/javascript">
	function goPage(pageNo){
		//value : 페이지에 갑을 지정하고 싶을때
		searchForm.pageNo.value = pageNo
		searchForm.submit();
	}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<%-- el표현식으로 쓰면서 없어짐.
<%	
	PageDto pageDto = null;
	//controller에서 request영역에 저장한pageDto를 화면에서 사용할 수 있도록 변수에 저장함.
	if(request.getAttribute("pageDto") != null 
			&& !"".equals(request.getAttribute("pageDto"))){
		 pageDto = (PageDto)request.getAttribute("pageDto");
	} else {
		//게시글의 총건수를 넣어 페이지 네비게이션을 생성함.
		 pageDto = new PageDto(150,new Criteria());
	}
	
	/*
	---------위의 P조건으로 대체
	int totalCnt = 160;
	Criteria cri = new Criteria(); //pageNo  = 1, amount = 10;
	cri.setPageNo(13);
	pageDto = new PageDto(totalCnt,cri);
	----------dto가 가지고 있음.
	int pageNo = 12;
	int startNo =11;
	int endNo = 15;
	
	boolean prev= (startNo == 1) ? false : true;
	boolean next=true;
	*/
%>
 --%>
</head>
<body>
<br>
<%-- 
pageDto : ${pageDto }
<br>startNo : ${pageDto.startNo }
<br>prev : ${pageDto.prev ? "": "disabled" }
--%>
<!-- 페이지 네이션 -->
<nav aria-label="...">
  <ul class="pagination">
  	<!-- 앞으로 가기 버튼 시작 disabled : 비활성화 -->
  	<!-- "가 겉과 속에 같이 있을경우 하나를 '로 바꾼다 -->
  	<!-- class는 띄어쓰기 하기 -->
    <li class='page-item ${pageDto.prev ?"":"disabled"}'>
      <a class="page-link" onclick="goPage(${pageDto.startNo-1})">Previous</a>
    </li>
    <!-- 앞으로 가기 버튼 끝 -->
<c:forEach begin="${pageDTo.startNo }" end="${pageDto.endNo }" var="i">
	<li class="page-item">
	    <!-- href = "..." 링크로 이동할 경우, 검색어가 유지가 되지 않습니다. -->
	    <!-- 검색어를 유지하기 위해 searchForm을 전송하는 gopage 함수를 생성했음. -->
	    <!-- 링크를 함수 호출로 변경 onClick이벤트가 발생하면 goPage()함수를 ㅎ출함.
	  			함수의 파라메터로 페이지 번호를 넣어주어야함 -->
	  		
	    	<a class='page-link ${pageDto.cri.pageNo eq i ? "active":"" }' 
	    	
	    		onclick = "goPage(${i})"
	    		>
	    		${i}</a>
	    </li>
</c:forEach>
<%-- 
    <%for(int i=pageDto.getStartNo(); i<=pageDto.getEndNo(); i++){%>
	    <li class="page-item">
	    <!-- href = "..." 링크로 이동할 경우, 검색어가 유지가 되지 않습니다. -->
	    <!-- 검색어를 유지하기 위해 searchForm을 전송하는 gopage 함수를 생성했음. -->
	    <!-- 링크를 함수 호출로 변경 onClick이벤트가 발생하면 goPage()함수를 ㅎ출함.
	  			함수의 파라메터로 페이지 번호를 넣어주어야함 -->
	    	<a class="page-link <%= pageDto.getCri().getPageNo() == i ? "active" : ""%>" 
	    	
	    		onclick = "goPage(<%=i %>)"
	    		>
	    		<%=i %></a>
	    </li>
    <%} %>
 --%>   
    <!-- 뒤로 가기 버튼 시작 -->
    <li class="page-item ${ pageDto.next ? '':'disabled'}">
      <a class="page-link" onclick="goPage({pageDto.endNo+1})">Next</a>
    </li>
    <!-- 뒤로가기 버튼 시작 -->
  </ul>
</nav>

<!-- 부트스트랩 JS -->
<!-- script의 위치는 위에 있는 것을 다 실행하고 마지막에 실행하라는 의미 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>