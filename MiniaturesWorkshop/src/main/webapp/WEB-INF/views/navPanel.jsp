<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	margin-top: 100px;
	background-color: rgba(0, 0, 0, 0.5);
}

body {
	background: url('<%=request.getContextPath()%>/static/images/metal.jpg')
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>


</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top "> <!-- Chart, "YD" Symbol and Menu icons --> <a class="navbar-brand" href="<c:url value='/orders/chart'/>"><img border="0"
		src="<%=request.getContextPath()%>/static/images/myChart.jpg" width="50" height="50" style="border-radius: 10px"></a> <a class="navbar-brand" href="<c:url value='/home'/>"><img border="0"
		src="<%=request.getContextPath()%>/static/images/logo.png" width="50" height="50" style="border-radius: 20px"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar1" aria-controls="navbar1" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!--  Menu options -->
	<div class="collapse navbar-collapse" id="navbar1">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="<c:url value='/orders/stage1'/>">Make Order<span class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/paymentTransport'/>">Payment and Transport</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/aboutMe'/>">About me</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/contacts'/>">Contacts</a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Account control</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown1">

					<c:if test="${empty loggedinuser.firstName}">
						<a class="dropdown-item" href="<c:url value='/login'/>">Login</a>
					</c:if>
					<c:if test="${not empty loggedinuser.firstName}">
						<h6 style="padding-left: 20px">
							<strong>Hello ${loggedinuser.firstName}</strong>!
						</h6>
						<a class="dropdown-item" href="#">Account info</a>
						
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="<c:url value='/logout'/>">Logout</a>
						<a class="dropdown-item" href="SuccessWindow.jsp">Success Window</a>
						<a class="dropdown-item" href="registration.jsp">Registration</a>
					</c:if>
				</div></li>
		</ul>

	</div>
	</nav>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->

	<script type="text/javascript"><%@include file="/static/js/jquery-3.2.1.slim.min.js"%></script>
	<script type="text/javascript">
		
	<%@include file="/static/js/popper.min.js"%></script>
	<script type="text/javascript">
		
	<%@include file="/static/js/bootstrap.min.js"%></script>
</body>
</html>