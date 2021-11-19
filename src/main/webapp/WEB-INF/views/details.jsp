<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<script>
$(document).ready(function(){
	$("#dong").change(function() {
	
	$.get("${pageContext.request.contextPath}/map"
			,{act:"apt", dong:$("#dong").val()}
			,function(data, status){
				$(".details-text").empty();
				$.each(data, function(index, vo) {
					var a = document.createElement("a");
					
					let a_str =  vo.apt_name;
					a.append(a_str);
					a.addEventListener("click", function(){
						callHouseDealInfo(a_str);
					});
					$(".details-text").append(a);
					let str = "<ul class="+colorArr[index%3]+">"
					+ "<li class='important'>" 
					+ "<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-calendar-date' viewBox='0 0 16 16'> "+
                    + "<path d='M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z' />"
                    + "<path d='M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z' /> "
                	+ "</svg>" + vo.build_year + "</li>";
					//+ "<li class='important'>" + vo.dong_code + "</li>"
					//+ "<li id='lat_"+index+"'></li><li id='lng_"+index+"'></li></ul><hr>"
					$(".details-text").append(str);
					//$("#searchResult").append(vo.dong_name+" "+vo.apt_name+" "+vo.jibun+"<br>");
				});//each
				geocode(data);
			}//function
			, "json"
	);//get
});//change

});//ready
</script>


<div class="p-3" style="text-align: center">
	<div class="btn-group">
		시도 : <select id="sido">
			<option value="0">선택</option>
		</select>

		구군 : <select id="gugun">
			<option value="0">선택</option>
		</select> 

		
		읍면동 : <select id="dong">
			<option value="0">선택</option>
		</select>

	</div>
</div>


<div class="container">
	<div class="row">
		<div class="col-4">
			<div class="mb-3">
				<h3 style="display: inline;">거래 정보</h3>
				<select class="form-select" aria-label="Default select example"
					style="display: inline;">
					<option selected>아파트</option>
					<option value="1">경남아너스빌</option>
					<option value="2">경남</option>
					<option value="3">e편한세상</option>
					<option value="4">광화문풍문스페이스본</option>
					<option value="5">래미안</option>
					<option value="6">마곡승윤노블리안아파트</option>
					<option value="7">개포래미안포레스트</option>
				</select>
			</div>
			<div class="details-text" id="details-text">
				<a style="margin: 2px;" href="detailsApt.html">e편한세상</a>
				<p class="important" style="margin: 0;">거래금액: 52,200만원</p>
				<p class="important" style="margin: 0;">면적: 84,965</p>
				<p style="margin: 0;">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-calendar-date"
						viewBox="0 0 16 16">
                            <path
							d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z" />
                            <path
							d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
                        </svg>
					2019. 12. 16
				</p>
				<hr>
			</div>

		</div>
		<div class="col-8">
			<!-- <img src="https://lh3.googleusercontent.com/proxy/3Ug3H8dZp9VonicHk7LbUuK7AlD-bplSZ8UHaJRV7eVwTGVJxsL9OBE-LNcIKo5qjrbhbEpiJcS4lC0GaCKTwKVNsQIYEKm7OAFOOAxJ"
                    style="width:100%"> -->
			<div id="map" style="width: 80%; height: 500px; margin: auto;"></div>

		</div>
	</div>
</div>
<!-- Footer -->
<footer class="pt-4">
	<div class="container">
		<div
			class="row justify-content-lg-between circle-blend-right circle-danger">
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