<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>회원가입 축하페이지</title>

    <%@ include file="../common/include_static.jsp"%>

</head>

<body>

<div id="wrapper">

    <section>

        <div class="container">

            <div class="row">

                <!-- 가입완료 -->
                <div class="register_done col-md-10 col-sm-12 col-md-offset-1">

                    <h4 class="margin-top-10 margin-bottom-0 text-orange"><i class="fa fa-check-circle-o" aria-hidden="true"></i> IT 꾸자갤 회원가입이 완료되었습니다.</h4>
                    <p class="text-gray">회원가입이 되었습니다.</p>

                </div>


                <div class="">
                    <a href="<c:url value='/index.do'/>" class="btn btn-orange">
                        <i class="fa fa-home" aria-hidden="true"></i> <span>홈페이지 가기</span>
                    </a>
                    <a href="<c:url value='/common/login.do'/>" class="btn btn-orange">
                        <i class="fa fa-user" aria-hidden="true"></i> <span>로그인 하기</span>
                    </a>
                </div>

            </div>

        </div>

    </section>

</div>


</body>
</html>