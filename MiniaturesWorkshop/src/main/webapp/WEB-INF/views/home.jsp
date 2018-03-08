<%@ page language="java" contentType="text/html;charset=utf-8"%>
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
		<div class="row">
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/work1.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Infantry gallery</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/work2.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Mounted gallery</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/work3.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Vehicles gallery</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/work4.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Monsters gallery</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>

			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/work5.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Very big miniatures gallary</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/work6.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Armies gallery</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>