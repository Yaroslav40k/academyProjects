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

body {
	background: url('static/images/metal.jpg') no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>
<body>
	<%@include file="navPanel.jsp"%>
	<div class="container" style="max-width: 400px;">

		<c:url var="loginUrl" value="/login" />
		<form class="form-signin" form action="${loginUrl}" method="post" style="color: white; padding-bottom: 20px">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Nick name</label> <input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" style="margin-bottom: 20px" required autofocus> 
			<label for="inputPassword" class="sr-only">Password</label> <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" id="rememberme" name="remember-me"> Remember me
				</label>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button class="btn btn-lg btn-primary btn-block  btn-outline-info my-2 my-sm-0" type="submit">Sign in</button>
		</form>
		<div style="padding-bottom: 20px">
			<a href="<c:url value='newuser'/>"> <input type="button" class="btn btn-lg btn-primary btn-block  btn-outline-info my-2 my-sm-0" value="Registration">
			</a>
		</div>
	</div>
</body>
</html>