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
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="view view-help">
					<img src="<%=request.getContextPath()%>/static/images/testMainPageImage1.jpg" class="media" alt="" />
					<div class="mask">
						<h2>Infantry gallery</h2>
						<p>Words and such, a whole lot more of muh flippin' words.</p>
						<a href="#" class="info">Would you like to know more?</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-4">
				<div class="view">
					<a  href="<c:url value='/aboutMe'/>"><img src="<%=request.getContextPath()%>/static/images/AboutMe.jpg" class="media" alt="" /> 
					</a>
				</div>
			</div>
			<div class="col-xs-12 col-md-4">
				<div class="view">
					<a  href="<c:url value='/orders/stage1'/>"><img src="<%=request.getContextPath()%>/static/images/StartArmyLogo.jpg" class="media" alt="" /> 
					</a>
				</div>
			</div>
			<div class="col-xs-12 col-md-4">
				<div class="view">
					<a  href="<c:url value='/galleryMain'/>"><img src="<%=request.getContextPath()%>/static/images/GalleryLogo.jpg" class="media" alt="" /> 
					</a>
				</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>