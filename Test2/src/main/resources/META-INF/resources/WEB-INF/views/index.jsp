<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/include.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>test</title>
<%@ include file="common/include_static.jsp"%>
<style>
.swiper-container {
	width: 100%;
	height: 100%;
	margin-left: auto;
	margin-right: auto;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}

.swiper-seminar {
	height: 300px;
	border: 1px solid #e5e5e5;
	margin: 0 0 20px;
	padding: 0;
}

.card-columns {
	padding: 10px;
}

.card {
	margin-bottom: 10px;
}

.jumbotron-billboard .img {
	margin-bottom: 0px;
	opacity: 0.2;
	color: #fff;
	background: #000
		url("https://dppgjjx7k7m5m.cloudfront.net/assets/intro/9-b69744e47c11215211787ae325586dea9c7a63e7f2331bce3f60d9e8f47bdcf0.jpg")
		center center;
	width: 100%;
	height: 100%;
	background-size: cover;
	overflow: hidden;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 1;
}

.jumbotron {
	position: relative;
	padding: 50px;
}

.jumbotron .container {
	z-index: 2;
	position: relative;
	z-index: 2;
}
</style>

</head>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<body cz-shortcut-listen="true">

	<%@ include file="common/include_top.jsp"%>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-12">

				<div class="row swiper-seminar">
					<!-- Swiper -->
					<div class="swiper-container">

					</div>
				</div>
			</div>
			<!--/span-->

		</div>
		<!--/row-->

		<hr>

		<footer>
			<p></p>
		</footer>

	</div>
	<!--/.container-->
</body>
</html>