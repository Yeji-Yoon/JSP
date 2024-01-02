<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
	.w-15{width:15%}
	.w-20{width:20%}
</style>
</head>
<body>
<script type="text/javascript">
	window.onload = function() {
		
		//regBtn요소에 이벤트를 추가함.(아이디로 접근하는 방법)
		regBtn.addEventListener('click',function(){
			//form요소의 이름으로 접근하여 폼을 전송함.(새로운 페이지 요청)
			//등록처리를 하고 결과페이지를 출력함.
			regForm.submit();
		});
	}

</script>
<!-- 도서 등록 화면 -->

<%@ include file = "/header.jsp" %>

<!-- 메인 컨텐츠 영역 시작-->
	<div class="container-fluid">
	<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">도서등록</h6>
			</div>
			<div class="card-body">
			<!-- 등록폼 --> 파일 업로드를 위해 컨트롤러를 변경
				<form action="/book/bookRegUploadProcess" enctype = "multipart/form-data" name = "regForm" method="post">
				<div class="input-group mb-3">
				
					  <span class="w-15 input-group-text" id="basic-addon1">도서명</span>
					  <!-- 서버에 값을 넘길 요소 -->
					  <input type="text" class="form-control" placeholder="도서명을 입력해주세요" name = "title"
					   aria-label="Username" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
					  <span class="w-20 input-group-text" id="basic-addon1">작가명</span>
					  <input type="text" class="form-control" placeholder="작가명을 입력해주세요" name = "author"
					  aria-label="Username" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="basic-addon1">도서소개</span>
					  <input type="text" class="form-control" placeholder="도서 소개룰 입력해주세요" name = "content"
					  aria-label="Username" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="basic-addon1">표지 이미지</span>
					  <input type="file" class="form-control" id="inputGroupFile01" name = "imgFile">
					</div>
					
					<p><button type="button" class="btn btn-dark" id="regBtn">도서목록</button>
				</form>
		</div>
	</div>
<!-- 메인컨텐츠 영역 끝 -->

<%@ include file = "/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>