<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Artist.Yaroslav Miniatures</title>
<meta charset="utf-8">
<meta name="author" content="pixelhint.com">
<meta name="description" content="Miniatures gallery and workshop of Yaroslav Dmitriev" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" type="text/css"></link>
<link href="<c:url value='/static/css/Custom.css' />" rel="stylesheet" type="text/css"></link>


<style>
.media {
	width: 100%; /* ширина картинки */
	height: auto; /* высота картинки */
}

.navbar {
	margin-bottom: 300px;
}

.container {
	margin-top: 30px;
	background-color: rgba(0, 0, 0, 0.5);
}
</style>
</head>
<body>
	<%@include file="navPanel.jsp"%>

	<div class="container">
		<div class="row ">
			<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">"Monsters" Showcase</h2>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/monstersGallery/m1.JPG" class="media" alt="" />
					<div class="mask">
						<h2>Frosthearth Phoenix</h2>
						<p>Some miniature info here</p>
						<a href="#" class="info">Would you like to know more?</a> <a href="<c:url value='/orders/updateDetail-${46}'/>" class="info">Order it NOW!</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/monstersGallery/m2.JPG" class="media" alt="" />
					<div class="mask">
						<h2>Karl Franz on DeathClaw</h2>
						<p>Some miniature info here</p>
						<a href="#" class="info">Would you like to know more?</a> <a href="<c:url value='/orders/updateDetail-${46}'/>" class="info">Order it NOW!</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/monstersGallery/m3.JPG" class="media" alt="" />
					<div class="mask">
						<h2>Stormsurge</h2>
						<p>Some miniature info here</p>
						<a href="#" class="info">Would you like to know more?</a> <a href="<c:url value='/orders/updateDetail-${46}'/>" class="info">Order it NOW!</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/monstersGallery/m4.JPG" class="media" alt="" />
					<div class="mask">
						<h2>Maw-Crusha</h2>
						<p>Some miniature info here</p>
						<a href="#" class="info">Would you like to know more?</a> <a href="<c:url value='/orders/updateDetail-${46}'/>" class="info">Order it NOW!</a>
					</div>
				</div>
			</div>

			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/monstersGallery/m5.JPG" class="media" alt="" />
					<div class="mask">
						<h2>Nurgle Big Daddy</h2>
						<p>Some miniature info here</p>
						<a href="#" class="info">Would you like to know more?</a> <a href="<c:url value='/orders/updateDetail-${46}'/>" class="info">Order it NOW!</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/monstersGallery/m6.JPG" class="media" alt="" />
					<div class="mask">
						<h2>Eldar WraithKnight</h2>
						<p>Some miniature info here</p>
						<a href="#" class="info">Would you like to know more?</a> <a href="<c:url value='/orders/updateDetail-${46}'/>" class="info">Order it NOW!</a>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>