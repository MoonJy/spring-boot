<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title><spring:message code="TITLE"/></title>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<%@ include file="include_static.jsp" %>
</head>
<body cz-shortcut-listen="true">
	<!-- wrapper -->
	<div id="wrapper">
		<div class="error_wrap">
			<div class="error_content">
				<h3 class="hide_ment">알려지지 않은 에러</h3>
				<i class="error_icon fa fa-times-circle-o" aria-hidden="true"></i>
				<h4 class="text-orange">
					죄송합니다.<br/>
					요청하신 페이지를 바르게 표시할 수 없습니다.
				</h4>
				<p class="title">아래와 같은 사유로 해당 페이지에 접속할 수 없습니다.</p>
				<p class="errorText">
					<c:if test="${not empty failMessages}">
						<div class="message" id="failMessages">
							<c:forEach var="msg" items="${failMessages}">
								<c:out value="${msg}"/><br />
							</c:forEach>
						</div>
						<c:remove var="failMessages" scope="session"/>
					</c:if>
				</p>
				<p class="error_btn">
					<a class="btn btn-default" href="<c:url value='/'/>">메인으로 이동 ▶</a>
					<a class="btn btn-default" href="javascript:history.back();">이전페이지 이동 ▶</a>
				</p>
			</div>
			<div class="errorCopy">
				<span><spring:message code="TITLE"/></span>
			</div>
		</div>
	</div>
</body>
</html>
