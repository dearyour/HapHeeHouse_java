<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>


<div class="p-3" style="text-align: center">

	<form id="form "class="btn-group" method="post" action="${root}/map">
		<input type="hidden" name="act" id="act" value="to_details">
		시도 : <select id="sido" name="sido">
			<option value="0">선택</option>
			<option value="1">이거</option>
		</select> 구군 : <select id="gugun" name="gugun">
			<option value="0">선택</option>
		</select> 읍면동 : <select onchange="this.form.submit()" id="dong" name="dong">
			<option value="0">선택</option>
		</select>
	</form>
	
</div>
<div>
		<div id="map" style="width: 80%; height: 500px; margin: auto;"></div>
	</div>
<!-- Main Content -->
<div class="container px-4 px-lg-5">
	<div class="row p-3">
		<div class="col-6 border-top">
			<h6 class="fw-bold mt-4 fs-4">공지사항</h6>
			<ul>
				<li><a href="#!" class="small margin-clear" title="공지사항 1">공지사항
						1</a></li>
				<li><a href="#!" class="small margin-clear" title="공지사항 2">공지사항
						2</a></li>
				<li><a href="#!" class="small margin-clear" title="공지사항 3">공지사항
						3</a></li>
				<li><a href="#!" class="small margin-clear" title="공지사항 4">공지사항
						4</a></li>
				<li><a href="#!" class="small margin-clear" title="공지사항 5">공지사항
						5</a></li>
			</ul>
		</div>
		<div class="col-6 border-top">
			<h6 class="fw-bold mt-4 fs-4">주택 관련 기사</h6>
			<ul>
				<li><a href="#!" class="small margin-clear" title="기사 제목 1">기사
						제목 1</a></li>
				<li><a href="#!" class="small margin-clear" title="기사 제목 2">기사
						제목 2</a></li>
				<li><a href="#!" class="small margin-clear" title="기사 제목 3">기사
						제목 3</a></li>
				<li><a href="#!" class="small margin-clear" title="기사 제목 4">기사
						제목 4</a></li>
				<li><a href="#!" class="small margin-clear" title="기사 제목 5">기사
						제목 5</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- Footer -->
<footer class="border-top pt-4">
	<div class="container">
		<div
			class="row justify-content-lg-between circle-blend-right circle-danger">
			<!-- Site Maps -->
			<div class="col-6">
				<h6 class="fw-bold fs-4 mb-4">기본 메뉴</h6>
				<ul class="list-unstyled mb-md-4 mb-lg-0">
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="accountLogin.html">로그인</a></li>
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="accountLogout.html">로그아웃</a></li>
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="accountInfo.html">회원정보 조회</a></li>
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="userlike.html">관심지역 설정</a></li>
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="userlikelist.html">관심지역 둘러보기</a></li>
				</ul>
			</div>
			<div class="col-6">
				<h6 class="fw-bold fs-4 mb-4">마이페이지</h6>
				<ul class="list-unstyled mb-md-4 mb-lg-0">
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="accountIDSearch.html">아이디 찾기</a></li>
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="accountPWSearch.html">비밀번호 찾기</a></li>
					<li class="mb-2"><a class="text-1100 text-decoration-none"
						href="accountModify.html">회원정보 수정</a></li>
				</ul>
			</div>
		</div>
		<hr class="text-200 mb-0" />
		<div
			class="row justify-content-md-between justify-content-evenly py-3">
			<div
				class="col-12 col-sm-8 col-md-6 col-lg-auto text-center text-md-start">
				<p class="fs-0 my-2 text-400">
					All rights Reserved <span class="fw-bold text-500">&copy;
						Happy House, 2021</span>
				</p>
			</div>
		</div>
	</div>
</footer>
</body>

</html>