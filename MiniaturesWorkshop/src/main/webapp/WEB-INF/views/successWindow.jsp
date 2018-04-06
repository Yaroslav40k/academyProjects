<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Artist.Yaroslav Miniatures</title>
<meta charset="utf-8">
<meta name="author" content="pixelhint.com">
<meta name="description" content="Miniatures gallery and workshop of Yaroslav Dmitriev" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="refresh" content="3;url=<%=request.getContextPath()%>${redirectPath}" />
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" type="text/css"></link>
<link href="<c:url value='/static/css/Custom.css' />" rel="stylesheet" type="text/css"></link>


<style>
.row {
	padding: 10px;
}

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
			<div class="col-xs-12 col-md-4">
				<img alt="" style="border-radius: 40px; padding: 20px; max-height: 300; max-width: 300px" src="<%=request.getContextPath()%>/static/images/Success.png">
			</div>
			<div class="col-xs-12 col-md-8 centered text-center" style="padding-top: 30px">
				<h1 style="color: white;">${success}</h1>
			</div>
		</div>
	</div>
</body>
</html>