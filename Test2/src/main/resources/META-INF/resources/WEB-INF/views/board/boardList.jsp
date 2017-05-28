<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>TSET BOARD</title>

    <%@ include file="../common/include_static.jsp"%>

</head>

<script>


</script>

<body cz-shortcut-listen="true">

<!-- 2017-05-13 navbar 공통 추가 -->
<%@ include file="../common/include_top.jsp"%>

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-12">

            <div class="jumbotron jumbotron-billboard">
                <div class="img"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>누구나 세미나 정보를</h1>
                            <p>
                                등록할수 있습니다~!
                            </p>

                            <h2>
                                <span class="badge badge-default">개발관련</span>
                                <span class="badge badge-primary">IT 트렌드</span>
                                <span class="badge badge-success">서비스 기획</span>
                                <span class="badge badge-info">유익한 세미나 등</span>
                            </h2>

                            <%--<a href="<c:url value="/seminar/createForm.do"/>" class="btn btn-success btn-lg">세미나 등록하기</a>--%>
                            <sec:authorize access="isAuthenticated()">
                                <a href="<c:url value="/board/createForm.do"/>" class="btn btn-success btn-lg">세미나 등록하기</a>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                                <a href="#" class="btn btn-success btn-lg" data-toggle="modal"
                                        data-target="#login_window">세미나 등록하기</a>
                            </sec:authorize>
                        </div>


                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-xs-12">
                    <div style="margin-bottom: 20px !important; margin-top: 20px !important; margin-left: 16px;">
                        <h3>
                            <strong>세미나</strong>
                        </h3>
                    </div>
                </div>
            </div>

            <div class="row">

                <c:forEach items="${searchForm.pagingObject.resultList}" var="item" varStatus="status">
                    <div class="col-sm-4">
                            <a href="<c:url value="/seminar/detail.do?cno=${item.cno}"/>">
                                <div class="card" style="width: 20rem;">
                                    <img class="card-img-top img-fluid" data-src="holder.js/100px160/" alt="100%x160" src="${item.file_path}" data-holder-rendered="true" style="height: 160px; width: 100%; display: block;">
                                    <div class="card-block">
                                        <h4 class="card-title">
                                            <c:choose>
                                                <c:when test="${fn:length(item.subject) > 10}">
                                                    ${fn:substring(item.subject,0,8)}
                                                </c:when>

                                                <c:otherwise>
                                                    ${item.subject}
                                                </c:otherwise>
                                            </c:choose>
                                        </h4>
                                        <p class="card-text">${item.short_desc}</p>
                                        <p>

                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <i class="fa fa-users" aria-hidden="true"></i>
                                        22
                                        <i class="fa fa-heart" aria-hidden="true"></i>
                                        22
                                        <i class="fa fa-commenting" aria-hidden="true"></i>
                                    </div>
                                </div>
                            </a>




                    </div>
                </c:forEach>
            </div><!--/row-->
        </div><!--/span-->

    </div><!--/row-->

    <hr>


    <%@ include file="../common/include_layer_login.jsp"%>


</div><!--/.container-->
</body>
</html>