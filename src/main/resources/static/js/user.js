var root = '';
var loginText = `
	<li class="nav-item"><a
	class="nav-link px-lg-3 py-3 py-lg-4 fs-6" id="Login">로그인</a>
<div class="btn-group show" style="display: block;" id="login_div">
	<ul
		class="dropdown-menu dropdown-menu-right dropdown-animation show"
		aria-labelledby="header-top-drop-2">
		<li>
			<form class="login-form margin-clear" id="LoginForm">
				<div class="form-group has-feedback">
					<i class="fa fa-user form-control-feedback"></i> <label
						class="control-label">아 이 디</label> <input type="text"
						class="form-control" placeholder="" name="userId" id="userId">
				</div>
				<div class="form-group has-feedback">
					<i class="fa fa-lock form-control-feedback"></i> <label
						class="control-label">비밀번호</label> <input type="password"
						class="form-control" placeholder="" name="password" id="password">
				</div>
				<button type="submit" class="btn btn-gray btn-sm"
					id="loginbutton">로 그 인</button>

				<ul class="pagination">
					<li><a class="btn btn-default btn-sm"
						data-bs-toggle="modal" data-bs-target="#sign_up_Modal">
							회원가입</a></li>
					<li><a class="btn btn-default btn-sm"
						id="findPasswordBtn">비밀번호 찾기</a></li>
				</ul>

			</form>
		</li>
	</ul>
</div>
</li>
`;
var logoutText = `<li class="nav-item"><a
	class="nav-link px-lg-3 py-3 py-lg-4 fs-6"
	id="logout">로그아웃</a></li>
<li class="nav-item"><a
	class="nav-link px-lg-3 py-3 py-lg-4 fs-6" id="InfoModal"data-bs-toggle="modal"
	data-bs-target="#profile_Modal">회원정보 조회</a></li>
<li class="nav-item"><a
	class="nav-link px-lg-3 py-3 py-lg-4 fs-6" href="userlike.html">관심지역
		설정</a></li>
<li class="nav-item"><a
	class="nav-link px-lg-3 py-3 py-lg-4 fs-6"
	href="userlikelist.html">관심지역 둘러보기</a></li>`;

var findPasswordText = `<div class="form-group" style="text-align: left;">
<label for="userId">아이디</label> <span
	class="text-danger small">*</span> <input type="text"
	class="form-control" name="userId" id="userId" placeholder="아이디를 입력해 주세요">
</div>

<div class="form-group" style="text-align: left;">
<label for="email">이메일</label> <span
	class="text-danger small">*</span> <input type="email"
	class="form-control" id="email" name="email"
	placeholder="이메일을 입력해 주세요">
</div>

<div class="form-group text-center">
<button type="button" id="password-submit" class="btn btn-primary">
	비밀번호 찾기<i class="fa fa-check spaceLeft"></i>
</button>

</div>`;

function login_check() {
	$.get(root + "/user/login-check"
			,function(data, status){
				$("#navbarNotLogon").empty();
				if (data == 0) {
					$("#navbarNotLogon").append(loginText);
				} else {
					$("#navbarNotLogon").append(logoutText);
				}
			}
			, "json"
	)
}

$(document).ready(login_check);

// 회원가입
$(document).on("click", "#join-submit", function() {
	// 아이디 중복 체크
	$.post(root + "/user/join"
			,$("#registerForm").serialize()
			,function(data, status){
				if(data == 1)
					alert("회원가입 되었습니다!");
				else
					alert("회원가입에 실패했습니다!");
				$("#sign_up_Modal").modal('hide');
			}
			, "json"
	);
	return false;
});

// 로그인
$(document).on("click", "#loginbutton", function() {
	var formData = $("#LoginForm").serialize(); 
	
	$.post(root + "/user/login"
			,formData
			,function(data, status){
				if (data == 0) {
					alert("로그인이 실패했습니다!");
				} else {
					$("#navbarNotLogon").empty();
					$("#navbarNotLogon").append(logoutText);
					alert("로그인이 되었습니다!");
				}
			}
			, "json"
	);
	return false;
});

// 로그아웃
$(document).on("click", "#logout", function() {
	$.get(root + "/user/logout"
			,function(data, status){
				$("#navbarNotLogon").empty();
				$("#navbarNotLogon").append(loginText);
			}
			, "json"
	);
});

$(document).on("click", "#findPasswordBtn", function () {
	$("#search_password_Modal").modal("show");
	$("#findPasswordForm").empty();
	$("#findPasswordForm").append(findPasswordText);
})

// 비밀번호찾기 전 아이디, 이메일 확인 부분
$(document).on("click", "#password-submit", function() {
	var findPasswordForm = new FormData($("#findPasswordForm")[0]);
	var userId = findPasswordForm.get("userId");
	$.get(root + "/user/check-info"
			,$("#findPasswordForm").serialize()
		, function (data, status) {
		alert(userId);
			if (data == 0) {
				alert("일치하는 정보가 없습니다.");
			} else {
				$("#findPasswordForm").empty();
				let changePasswordText =  `<div class="form-group" style="text-align: left;">
				<label for="inputID">아이디</label> <div
				style="border: 1px solid black; height: 30px; width: auto;"
				id="userIdFind" name="userIdFind">${userId}</div>
				</div>
				
				<div class="form-group" style="text-align: left;">
				<label for="password">비밀번호</label> <span
					class="text-danger small">*</span> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="비밀번호를 입력해 주세요">
				</div>
				
				<div class="form-group" style="text-align: left;">
				<label for="passwordCheck">비밀번호 확인</label> <span
					class="text-danger small">*</span> <input type="password"
					class="form-control" id="passwordCheck" name="passwordCheck"
					placeholder="비밀번호를 입력해 주세요">
				</div>
				
				<div class="form-group text-center">
				<button type="submit" id="password-change" class="btn btn-primary">
					비밀번호 변경<i class="fa fa-check spaceLeft"></i>
				</button>
				
				</div>`;
				$("#findPasswordForm").append(changePasswordText);
			}
		}
		, "json"
	);
	return false;
});

$(document).on("click", "#password-change", function () {
	var userId = $("#userIdFind").text();
	$.post(root + "/user/change-password"
			,"userId=" + userId + "&" + $("#findPasswordForm").serialize()
		, function (data, status) {
			if (data == 0) {
				alert("비밀번호 맞게 입력했는지 확인하세요.");
			} else {
				alert("비밀번호가 변경되었습니다.");
				$("#search_password_Modal").modal("hide");
			}
		}
		, "json"
	);
	return false;
})

$(document).on("click", "#InfoModal", function() {
	$.get(root + "/user/info"
			,function(userInfo, status){
			$("#infoSubject").text("회원정보");
			$("#infoForm").empty();
				let str = `<div class="form-group p-1" style="text-align: left;">
					<label for="inputID">아이디</label>
					<div
						style="border: 1px solid black; height: 30px; width: auto;"
						id="userID">${userInfo.user_id}</div>

				</div>
				<div class="form-group p-1" style="text-align: left;">
					<label for="inputPassword">비밀번호</label>
					<div
						style="border: 1px solid black; height: 30px; width: auto;"
						>*******</div>
				</div>
				<div class="form-group p-1" style="text-align: left;">
					<label for="inputName">이름</label>
					<div
						style="border: 1px solid black; height: 30px; width: auto;"
						id="userID">${userInfo.name}</div>
				</div>
				<div class="form-group p-1" style="text-align: left;">
					<label for="InputEmail">주소</label>
					<div
						style="border: 1px solid black; height: 30px; width: auto;"
						id="userID">${userInfo.address}</div>
				</div>

				<div class="form-group p-1" style="text-align: left;">
					<label for="inputMobile">이메일</label>
					<div
						style="border: 1px solid black; height: 30px; width: auto;"
						id="userEmail">${userInfo.email}</div>
				</div>

				<div class="form-group text-center">
					<button class="btn btn-primary" id="profileModalCloseBtn">
						확인<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="button" id="InfoUpdateModalBtn" class="btn btn-warning">
						회원정보 수정<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>`
				$("#infoForm").append(str);
			}
			, "json"
	);
});

$(document).on("click", "#profileModalCloseBtn", function() {
	$("#profile_Modal").modal('hide');
})
$(document).on("click", "#InfoUpdateModalBtn", function() {
	$.get(root + "/user/info"
			,function(userInfo, status){
		$("#infoSubject").text("회원정보 수정");
		$("#infoForm").empty();
		let str =`<div class="form-group" style="text-align: left;">
			<label for="user_id">아이디</label> <div
			style="border: 1px solid black; height: 30px; width: auto;"
			id="user_id" name="user_id">${userInfo.user_id}</div>
	</div>
	<div class="form-group" style="text-align: left;">
		<label for="password">비밀번호</label> <input type="password"
			class="form-control" id="password" name="password"
			placeholder="비밀번호를 입력해주세요" value="${userInfo.password}">
	</div>
	<div class="form-group" style="text-align: left;">
		<label for="name">이름</label> <input type="text"
			class="form-control" id="name" name="name" placeholder="이름을 입력해 주세요" 
			value="${userInfo.name}">
	</div>
	<div class="form-group" style="text-align: left;">
		<label for="address">주소</label> <input type="text"
			class="form-control" id="address" name="address" placeholder="주소를 입력해주세요"
			value="${userInfo.address}">
	</div>

	<div class="form-group" style="text-align: left;">
		<label for="email">이메일</label> <input type="email"
			class="form-control" id="email" name="email"
			placeholder="이메일을 입력해 주세요" value="${userInfo.email}">
	</div>

	<div class="form-group text-center">
		<button type="submit" id="InfoUpdateBtn" class="btn btn-primary">
			회원정보 수정 완료<i class="fa fa-check spaceLeft"></i>
		</button>
		<button type="button" class="btn btn-warning" id="InfoDeleteModalBtn">
			회원 탈퇴<i class="fa fa-times spaceLeft"></i>
		</button>
	</div>`;
		$("#infoForm").append(str);
	})
	return false;
});

// 수정 완료
$(document).on("click", "#InfoUpdateBtn", function() {
	$.post(root + "/user/update"
			, $("#infoForm").serialize()
			, function(data, status){
		if (data != 0) {
			alert("회원정보가 수정되었습니다.");
			$("#profile_Modal").modal("hide");
		}
	})
	return false;
});

// 수정 화면에서 탈퇴 버튼을 눌렀을 때
$(document).on("click", "#InfoDeleteModalBtn", function() {
	$("#infoSubject").text("회원정보 탈퇴");
	$("#infoForm").empty();
	let str =`
								<div class="col=12 mt-md-5 text-center">탈퇴후에는 모든 정보가 사라집니다</div>
	                            <div class="col=12 mt-md-1 text-center">탈퇴를 원하시면 해당 문구와 비밀번호를 확인해주세요</div>
<hr>
								<div class="col=12">
	                            	모든 정보를 삭제하고 탈퇴하겠습니다.<br>
	                                <input type="text" class="form-control mt-md-3" id="confirmText" name="confirmText"
	                                    placeholder="모든 정보를 삭제하고 탈퇴하겠습니다.">
	                            </div>
	                            <div class="col-4 mt-md-5 text-center">
	                                <label for="InputPassword">비밀번호 확인</label>
	                            </div>
	                            <div class="col-8  mt-md-5">
	                                <input type="password" class="form-control" id="password"
	                                    placeholder="비밀번호를 입력하세요." name = "password">
	                            </div>
	                            <div class="form-group text-center">
									<button id="InfoDeleteBtn2" class="btn btn-primary">
										회원 탈퇴<i class="fa fa-check spaceLeft"></i>
									</button>

								</div>
`;
	$("#infoForm").append(str);
});
// 탈퇴 화면에서 탈퇴 완료 버튼을 눌렀을 때
$(document).on("click", "#InfoDeleteBtn2", function() {
	$.post(root + "/user/delete"
			, $("#infoForm").serialize()
			, function(data, status){
		if (data == -1) {
			$("#status").text("문구와 비밀번호를 확인하세요!")
		} else {
			alert("회원 탈퇴되었습니다.");
			$("#profile_Modal").modal("hide");
			login_check();
		}
	})
	return false;
});
