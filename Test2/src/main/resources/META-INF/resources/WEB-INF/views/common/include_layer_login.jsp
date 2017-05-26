<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>


<div id="login_window" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button>
                <h4 class="modal-title" id="myModalLabel">로그인</h4>
            </div>
            <!-- body modal -->
            <div class="modal-body">
                <div>
                    <c:url value="/authLogin.do" var="actionUrl"/>
                    <form id="layerLoginForm" name="f" role="form" action="${actionUrl}" method="post">

                        <div class="row" style="margin-bottom: 10px;">
                            <div class="col-md-6">
                                <a href="#" class="btn btn-block btn-social btn-facebook" onclick="document.facebook.submit();">
                                    <span class="fa fa-facebook"></span>
                                    페이스북
                                </a>
                            </div>
                            <div class="col-md-6">
                                <a href="#" class="btn btn-block btn-social btn-kakao" onclick="document.kakao.submit();">
                                    <span class="fa fa-kakao" style="color: #3C1E1E"></span>
                                    카카오
                                </a>
                            </div>
                            <%--<div class="col-xs-4 col-sm-2">--%>
                            <%--<a href="#" class="btn btn-lg btn-block omb_btn-google">--%>
                            <%--<i class="fa fa-google-plus visible-xs"></i>--%>
                            <%--<span class="hidden-xs">Google+</span>--%>
                            <%--</a>--%>
                            <%--</div>--%>
                        </div>

                        <div class="login_input_box">
                            <div class="lib_icon id"></div>
                            <input required="" name='username' type="text" value="" class="form-control name" placeholder="abc@zipdoc.co.kr" style="ime-mode: active;">
                        </div>
                        <div class="login_input_box">
                            <div class="lib_icon pw"></div>
                            <input required="" name='password' type="password" value="" class="form-control name" placeholder="8자리 이상 입력">
                        </div>
                        <div class="text-center">
                            <%--<span class="help-block">Password error</span>--%>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 10px;">로그인</button>
                        </div>


                        <div class="lib_text_box margin-top-10">
                            <span>아직 회원이 아니세요?</span>&nbsp;&nbsp; <a class="text-right"
                                                                     href="<c:url value='/user/register.do'/>">회원가입 &gt;</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<form action="<c:url value="/auth/facebook?targetUrl=/seminar/getList.do"/>" name="facebook" method="get">
    <input type="hidden" name="scope" value="public_profile,email"></input>
</form>

<form action="<c:url value="/kakao/userinfo?targetUrl=/seminar/getList.do"/>" name="kakao" method="get">
</form>