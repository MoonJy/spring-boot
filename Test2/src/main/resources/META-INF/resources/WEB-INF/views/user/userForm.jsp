<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>test 회원 가입</title>

    <%@ include file="../common/include_static.jsp"%>

</head>
<script>

    function doRegister(){
        if(!validationForm()) return;

        //include_static.jsp 파일에 정의되어있음.
//        if(grecaptchaUseded && !grecaptchaVerified2){
//            alert("로봇이 아닙니다를 선택하세요.(자동글 등록 방지)");
//            return;
//        }

        var form = document.getElementById("userForm");
        form.action = "<c:url value="/user/register.do"/>";
        form.method = "post";
        form.submit();
    }


    function validationForm(){
        var form = document.getElementById("userForm");
        if($("#cmd").val()=='create'){
            if(form.member_agree.checked == false){
                alert("회원가입약관 내용에 동의하세요.");
                form.member_agree.focus();
                return false;
            }
            if(form.privacy_agree.checked == false){
                alert("개인정보처리방침에 동의하세요.");
                form.privacy_agree.focus();
                return false;
            }
        }

        return true;
    }


</script>

<body>

<div id="wrapper">

    <section>
        <div class="container register">


            <h4>
                <c:choose>
                    <c:when test="${userForm.cmd eq 'create'}">
                        test 회원가입
                    </c:when>
                    <c:otherwise>
                        IT 꾸자갤 회원정보수정
                    </c:otherwise>
                </c:choose>
            </h4>


            <c:if test="${userForm.cmd eq 'create'}">
                <fieldset class="register_sns_box">
                    <span class="text-small text-gray">SNS 계정으로 회원가입 : </span>

                    <a href="#" class="btn btn-social-icon btn-lg btn-kakao" onclick="document.kakao.submit();">
                        <span class="fa fa-kakao"></span>
                    </a>

                    <a href="#" class="btn btn-social-icon btn-lg btn-facebook" onclick="document.facebook.submit();">
                        <span class="fa fa-facebook"></span>
                    </a>

                </fieldset>
            </c:if>

            <!-- register form -->
            <form:form modelAttribute="userForm" method="post" id="userForm" class="nomargin">
                <form:hidden path="cmd" />
                <form:hidden path="user.member_type" id="member_type" />
                <fieldset class="nomargin">
                    <div class="group id">
                        <c:choose>
                            <c:when test="${userForm.cmd eq 'update'}">
                                <form:hidden path="user.member_id" />
                            </c:when>
                            <c:otherwise>
                                <form:input path="user.member_id" id="member_id" class="regi_id form-control" minlength="8" maxlength="40" placeholder="아이디(이메일)"/>
                                <form:errors path="user.member_id" element="div" cssClass="alert alert-mini alert-danger margin-bottom-30" />
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <c:if test="${hasRole eq true || userForm.cmd eq 'create'}">
                        <div class="group pw">
                            <form:password path="user.plain_password" class="form-control" placeholder="비밀번호(영문,숫자 조합 8~16자 입력)" maxlength="16" />
                            <form:errors path="user.plain_password" element="div" cssClass="alert alert-mini alert-danger margin-bottom-30" />
                            <form:password path="user.validate_password" class="form-control" placeholder="비밀번호확인" maxlength="16" />
                            <form:errors path="user.validate_password" element="div" cssClass="alert alert-mini alert-danger margin-bottom-30" />
                        </div>
                    </c:if>
                    <div class="group option">
                        <form:input path="user.name" maxlength="8" class="form-control" placeholder="이름" />
                        <form:errors path="user.name" element="div" cssClass="alert alert-mini alert-danger margin-bottom-30" />
                        <form:input path="user.nickname" maxlength="30" class="form-control" placeholder="닉네임" />
                        <form:errors path="user.nickname" element="div" cssClass="alert alert-mini alert-danger margin-bottom-30" />
                        <form:input path="user.mobile_no" maxlength="11" class="form-control" placeholder="휴대전화번호(- 없이 숫자만)"/>
                        <form:errors path="user.mobile_no" element="div" cssClass="alert alert-mini alert-danger margin-bottom-30" />
                    </div>

                    <c:if test="${userForm.cmd eq 'create'}">
                        <div class="group agreement">
                            <div class="member_box">
                                <input type="checkbox" name="member_agree" id="member_agree" value="3" style="width:17px;height:17px;"> <span>회원가입 약관 동의</span>
                                <a href="#" onclick="window.open('<c:url value="/html/agreement_info.jsp"/>','name', 'top=10,left=10,width=500,height=400,resizable=1,status=0,scrollbars=1,menubar=0').focus()">자세히보기 <i class="fa fa-angle-down"></i></a>
                            </div>
                            <div class="privacy_box">
                                <input type="checkbox" name="privacy_agree" id="privacy_agree" value="3" style="width:17px;height:17px;"> <span>개인정보처리방침 동의</span>
                                <a href="#" onclick="window.open('<c:url value="/partner/getSupplyList.do"/>','name', 'top=10,left=10,width=500,height=400,resizable=1,status=0,scrollbars=1,menubar=0').focus()">자세히보기 <i class="fa fa-angle-down"></i></a>
                            </div>
                        </div>
                        <div class="group margin-top-20 captcha">
                            <div class="col-md-12">
                                <div id="grecaptcha2"></div>
                            </div>
                        </div>
                    </c:if>
                </fieldset>
                <c:choose>
                    <c:when test="${userForm.cmd eq 'create'}">
                        <button type="button" onclick="doRegister();" class="btn btn-default">회원가입</button>
                    </c:when>
                    <c:otherwise>
                        <div class="btn_wrap">
                            <button type="button" onclick="document.location.href=<c:url value='/'/>" class="btn btn-primary cancel">
                                홈
                            </button>
                            <button type="button" onclick="doUpdate();" class="btn btn-primary">
                                <i class="fa fa-check"></i> 정보수정
                            </button>
                        </div>
                    </c:otherwise>
                </c:choose>

            </form:form>

        </div>


    </section>


</div>

<form action="<c:url value="/auth/facebook"/>" name="facebook" method="get">
    <input type="hidden" name="scope" value="public_profile,email"></input>
</form>

<form action="<c:url value="/kakao/userinfo"/>" name="kakao" method="get">
</form>

</body>

</html>