<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>TEST</title>

<%@ include file="../common/include_static.jsp"%>
<link href="<c:url value="/test/css/login.css"/>" rel="stylesheet">

</head>
<script>
	function goRegister() {
		document.location.href = '<c:url value="/user/register.do"/>';
	}

	function doFindId() {
		if ($("#find_id_user_name").val() == '') {
			alert("이름을 입력하세요.");
			return;
		}

		if ($("#find_id_tel2").val() == '') {
			alert("휴대폰 번호를 입력하세요.");
			return;
		}

		if ($("#find_id_tel3").val() == '') {
			alert("휴대폰 번호를 입력하세요.");
			return;
		}

		var mobile_no = $("#find_id_tel1").val() + $("#find_id_tel2").val()
				+ $("#find_id_tel3").val();
		var sendData = "user_name=" + $("#find_id_user_name").val()
				+ "&mobile_no=" + mobile_no;

		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		$.ajax({
			url : '<c:url value="/user/findId.do"/>',
			type : "post",
			dataType : "json",
			data : sendData,
			cache : false,
			beforeSend : function(xhr) {
				// here it is
				xhr.setRequestHeader(header, token);
			},
			success : function(responseData) {
				var data = responseData;
				if (!data) {
					alert("통신 에러");
				}
				if (data.success) {
					var resultHtml = "<p>회원님의 아이디는 " + data.result_msg
							+ " 입니다.";
					$("#findIdModal").html(resultHtml);
				} else {
					alert("회원정보가 존재하지 않습니다.");
				}
			},
			error : function(request, status, error) {
				alert("오류가 발생되었습니다. code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}
		});

	}

	function doFindPwd() {
		if ($("#find_pwd_member_id").val() == '') {
			alert("이름을 입력하세요.");
			return;
		}

		if ($("#find_pwd_user_name").val() == '') {
			alert("이름을 입력하세요.");
			return;
		}

		var sendData = "member_id=" + $("#find_pwd_member_id").val()
				+ "&user_name=" + $("#find_pwd_user_name").val();

		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		$
				.ajax({
					url : '<c:url value="/user/findPwd.do"/>',
					type : "post",
					dataType : "json",
					data : sendData,
					cache : false,
					beforeSend : function(xhr) {
						// here it is
						xhr.setRequestHeader(header, token);
					},
					success : function(responseData) {
						var data = responseData;
						if (!data) {
							alert("통신 에러");
						}
						if (data.success) {
							var resultHtml = "<p>회원님의 이메일로 임시 비밀번호를 발송하였습니다. 이메일을 확인하세요.</p>";
							$("#findPwdModal").html(resultHtml);
						} else {
							alert("아이디 또는 이름이 일치하지 않습니다.")
						}
					},
					error : function(request, status, error) {
						alert("오류가 발생되었습니다. code:" + request.status + "\n"
								+ "message:" + request.responseText + "\n"
								+ "error:" + error);
					}
				});
	}
</script>
<body>
	<div class="container">


		<div class="omb_login">
			<h3 class="omb_authTitle">
			로그인 및 <a href="<c:url value='/user/register.do'/>">회원가입</a>
			</h3>

			<div class="row omb_row-sm-offset-3 omb_loginOr">
				<div class="col-xs-12 col-sm-6">
					<hr class="omb_hrOr">
					<span class="omb_spanOr">or</span>
				</div>
			</div>

			<div class="row omb_row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">
					<c:url value="/authLogin.do" var="actionUrl" />
					<form class="omb_loginForm" role="form" action="${actionUrl}"
						method="post">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" class="form-control" name="username"
								placeholder="아이디를 입력해주세요">
						</div>
						<span class="help-block"></span>

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input type="password" class="form-control" name="password"
								placeholder="비밀번호를 입력해주세요">
						</div>
						<%--<span class="help-block">Password error</span>--%>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button class="btn btn-lg btn-primary btn-block" type="submit"
							style="margin-top: 10px;">로그인</button>
					</form>
				</div>
			</div>

			<div class="row omb_row-sm-offset-3">
				<%--<div class="col-xs-12 col-sm-3">--%>
				<%--<label class="checkbox">--%>
				<%--<input type="checkbox" value="remember-me">Remember Me--%>
				<%--</label>--%>
				<%--</div>--%>
				<div class="col-xs-12 col-sm-3">
					<p class="omb_forgotPwd">
						<a class="pull-right" href="#" data-toggle="modal"
							data-target=".id_pw">아이디/비밀번호가 기억나지 않으세요?</a>
					</p>
				</div>
			</div>
		</div>


		<div class="modal fade id_pw" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<!-- header modal -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myLargeModalLabel">아이디/비밀번호 찾기</h4>
					</div>

					<!-- body modal -->
					<div class="modal-body row">
						<div id="findIdModal" class="col-md-6 col-xs-12 border-right">
							<p>회원가입 시 입력하셨던 이름과 휴대폰 번호를 입력해 주세요.</p>
							<div class="group">
								<label>이름</label><input name="find_id_user_name"
									id="find_id_user_name" required="" type="text" value=""
									class="form-control contact c01" style="ime-mode: active;">
							</div>
							<div class="group">
								<label>휴대폰 번호</label> <select name="find_id_tel1"
									id="find_id_tel1" class="form-control contact c02">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select> <span class="space">-</span> <input name="find_id_tel2"
									id="find_id_tel2" type="tel" class="form-control contact c02"
									maxlength="4"> <span class="space">-</span> <input
									name="find_id_tel3" id="find_id_tel3" type="tel"
									class="form-control contact c02" maxlength="4">
							</div>
							<div class="footer">
								<button type="button" class="btn btn-primary"
									onclick="doFindId();">
									<span aria-hidden="true">아이디 찾기</span>
								</button>
							</div>
						</div>


					</div>

				</div>
			</div>
		</div>
	</div>

	<form action="<c:url value="/auth/facebook"/>" name="facebook"
		method="get">
		<input type="hidden" name="scope" value="public_profile,email"></input>
	</form>

	<form action="<c:url value="/kakao/userinfo"/>" name="kakao"
		method="get"></form>

</body>



</html>
