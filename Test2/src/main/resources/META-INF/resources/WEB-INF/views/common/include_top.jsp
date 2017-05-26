<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<nav class="navbar navbar-toggleable-md fixed-top navbar-inverse bg-inverse">
	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="<c:url value="/index.do"/>">test</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    	<ul class="navbar-nav mr-auto">
    		<li class="nav-item">
                <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="javascript:devReady();">회원정보</a>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <a class="nav-link" href="<c:url value="/user/register.do"/>">회원가입</a>
                </sec:authorize>
            </li>
    	</ul>
    </div>

</nav>
