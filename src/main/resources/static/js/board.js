
function boardStatus() {
	$.get(root + "/board/"
			, function(notices, status) {
				$("#boardResult").empty();
				let str=`<ul>`;
				$.each(notices, function(index, notice) {
					console.log(notice);
					str += `<li><a class="noticeTitle" data-value="${notice.boardNo}">${notice.boardName}</a></li>`;
				});
				str += `</ul>`;
				$("#boardResult").append(str);
		}, "json"
	);
}

function boardView(boardNo) {
	var user_data = 0;
	$.get(root + "/user/login-check"
			, function(data, status) {
		if (data == 1)
			user_data = 1;
	});
	$.get(root + "/board/" + boardNo
			,function(notice, status) {
			$("#boardModalResult").empty();
			$("#boardSubject").text(notice.boardName);
			
			let str = `
			<div>${notice.writeDate}</div>
			<div>${notice.total}</div>
			<div>${notice.user_id}</div>
			<div>${notice.content}</div>
			<ul>
			`;
			
			$.each(notice.replies, function(index, reply) {
				console.log(notice);
				str += `
				<li>${reply.writeDate}</li>
				<li>${reply.user_id}</li>
				<li>${reply.content}</li>
				`;
			});
			if (user_data == 1) {
				str += `</ul>
				<button id="boardUpdateBtn" class="button" data-value="${notice.boardNo}">수정</button>
				`;
			}
			$("#boardModalResult").append(str);
	}, "json")
}
$(document).ready(boardStatus);

$(document).on("click", ".noticeTitle", function() {
//	alert($(this).attr('data-value'));
	var boardNo = $(this).attr('data-value');
	$.post(root + "/board/" + boardNo
			,function(data, status) {
	});
	$("#boardModal").modal("show");
	boardView(boardNo);
});

$(document).on("click", "#boardUpdateBtn", function() {
	var boardNo = $(this).attr('data-value');
	$.get(root + "/board/" + boardNo
			,function(notice, status) {
		$("#boardSubject").empty();
    	let str = `
    		<form role="form" id="boardForm">
							<div class="form-group" style="text-align: left;">
								<label for="boardName">제목</label> <span
									class="text-danger small">*</span> <input type="text"
									class="form-control" id="boardName" name="boardName" value="${notice.boardName}">
							</div>
							<div class="form-group" style="text-align: left;">
								<label for="content">내용</label> <span
									class="text-danger small">*</span> <textarea
									class="form-control" id="content"  name="content" value="${notice.content}"></textarea>
							</div>
							<div class="form-group text-center">
								<button id="board-update" class="btn btn-primary" data-value="${notice.boardNo}">
									수정<i class="fa fa-check spaceLeft"></i>
								</button>
								<button id="board-delete" class="btn btn-primary" data-value="${notice.boardNo}">
									삭제<i class="fa fa-check spaceLeft"></i>
								</button>
							</div>
						</form>
`;
		$("#boardModalResult").empty();
		$("#boardModalResult").append(str);
	}, "json")
	return false;
});


$(document).on("click", "#board-update", function() {
	var boardNo = $(this).attr('data-value');
	$.ajax({
        url: "/board/" + boardNo,
        method: "PUT",
        data: $("#boardForm").serialize(),
        dataType: "json",
        success: function (notice) {
        	if(notice == 1)
        		alert("수정 완료되었습니다.");
        }
    });
	boardView();
	boardStatus();
    return false;
});
$(document).on("click", "#board-delete", function() {
	var boardNo = $(this).attr('data-value');
	$.ajax({
        url: "/board/" + boardNo,
        method: "DELETE",
        dataType: "json",
        success: function (notice) {
        	if(notice == 1)
        		alert("삭제 완료되었습니다.");
        	$("#boardModal").modal("hide");
        }
    });
	boardView(boardNo);
	boardStatus();
    return false;
});

$(document).on("click", "#AddNewBoard", function() {
	$("#boardModal").modal("show");
	$("#boardSubject").text("공지사항 작성하기");
	let str = `
		<form role="form" id="boardForm">
						<div class="form-group" style="text-align: left;">
							<label for="boardName">제목</label> <span
								class="text-danger small">*</span> <input type="text"
								class="form-control" id="boardName" name="boardName">
						</div>
						<div class="form-group" style="text-align: left;">
							<label for="content">내용</label> <span
								class="text-danger small">*</span> <textarea
								class="form-control" id="content"  name="content"></textarea>
						</div>
						<div class="form-group text-center">
							<button id="AddNewBoardBtn" class="btn btn-primary">
								등록<i class="fa fa-check spaceLeft"></i>
							</button>
						</div>
					</form>
`;
	$("#boardModalResult").empty();
	$("#boardModalResult").append(str);
});
$(document).on("click", "#AddNewBoardBtn", function() {
	$.post(root + "/board/"
			, $("#boardForm").serialize()
			,function(data, status) {
		if(data == 1) {
			alert("공지사항이 등록되었습니다.");
		} else {
			alert("로그인하세요.");
		}
		$("#boardModal").modal("hide");
	}, "json");
	
	boardStatus();
	
	return false;
});