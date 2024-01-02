<%@page import="com.board.BoardDto"%>
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
<h2>리스트 목록 조회</h2>
<p>jsp를 단독으로 실행할 경우,request 영역에 list를 저장하지 않으므로 null이 출력됨.</p>
<p>Contoller를 거쳐서 실행해보셍..<br>Controller에서 리스트를 조회후 request영역에 저장함.</p>

<%=request.getAttribute("list") %>
<%
	List<BoardDto>list = (List<BoardDto>)request.getAttribute("list");
%>

<table border="1">
	<tr>
		<th width="50">제목</th>
		<th>작성자</th>
		<th>등록일</th>
		
	</tr>
	<%
	//조회 결과가 존재한다면
	if(list != null && list.size()>0){
		//반복문을 돌면서 리스트 출력
		for(BoardDto dto : list) {
	%>
		<tr>.
			<!-- 제목을 클릭하면 view상세보기 화면으로 전환됩니다. -->
			<td><a href="/boardView?num=<%= dto.getNum()%>"> <%=dto.getTitle() %></td>
			<td><%=dto.getId() %></td>
			
			<td><%=dto.getPostdate() %></td>
		</tr>
	<%
		}
	} else {
		out.print("<tr><td colspan = '3'>조회 결과가 없습니다. </td></tr>");
		
	}
	%>
</table>

</form>
</body>
</html>