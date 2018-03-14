<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
<title>Artist.Yaroslav Miniatures</title>
<meta charset="utf-8">
<meta name="author" content="pixelhint.com">
<meta name="description" content="Miniatures gallery and workshop of Yaroslav Dmitriev" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" type="text/css"></link>
<link href="<c:url value='/static/css/Custom.css' />" rel="stylesheet" type="text/css"></link>


<style>

.col-centered{
    float: none;
    margin: 0 auto;
}
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
	<div class="container" style="color: white;">

		<div class="well lead col-centered text-center">
			New User Registration Form
			<form:form method="POST" modelAttribute="user" class="form-horizontal">
				<form:input type="hidden" path="id" id="id" />
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable col-centered text-center" for="firstName">First Name</label>
						<div class="col-md-7 col-centered text-center">
							<form:input type="text" path="firstName" id="firstName" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="firstName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable col-centered text-center" for="lastName">Last Name</label>
						<div class="col-md-7 col-centered text-center">
							<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="lastName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable col-centered text-center" for="ssoId">Nick name</label>
						<div class="col-md-7 col-centered text-center">
							<c:choose>
								<c:when test="${edit}">
									<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true" />
								</c:when>
								<c:otherwise>
									<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="ssoId" class="help-inline" />
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable col-centered text-center" for="password">Password</label>
						<div class="col-md-7 col-centered text-center">
							<form:input type="password" path="password" id="password" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="password" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable col-centered text-center" for="email">Email</label>
						<div class="col-md-7 col-centered text-center">
							<form:input type="text" path="email" id="email" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="email" class="help-inline" />
							</div>
						</div>
					</div>
				</div>


				<sec:authorize access="hasRole('ADMIN')">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable col-centered text-center" for="userProfiles">Roles</label>
							<div class="col-md-7 col-centered text-center">
								<form:select path="userProfiles" items="${roles}" multiple="false" itemValue="id" itemLabel="type" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="userProfiles" class="help-inline" />
								</div>
							</div>
						</div>
					</div>
				</sec:authorize>

				<div class="row">
					<div class="form-actions floatLeft col-md-12">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Update" class="btn btn-outline-info my-2 my-sm-0" /> or <a href="<c:url value='/home' />">Cancel</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Register" class="btn btn-outline-info my-2 my-sm-0" /> or <a href="<c:url value='/home' />">Cancel</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>