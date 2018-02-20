<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>

		<div class="well lead">Phone Registration Form</div>
		<form:form method="POST" modelAttribute="phone"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />
			<c:choose>
				<c:when test="${edit}">
					<form:input type="hidden" path="ownerID" id="ownerID" />
				</c:when>

			</c:choose>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phoneNumber">Phone
						Number</label>
					<div class="col-md-7">
						<form:input required='INPUT_PHONE!' type="text" path="phoneNumber" id="phoneNumber"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="phoneNumber" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="areaCode">Area
						Code</label>
					<div class="col-md-7">
						<form:input required='INPUT_CODE!' type="text" path="areaCode" id="areaCode"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="areaCode" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="type">Type</label>
					<div class="col-md-7">
						<form:input required='INPUT_TYPE!' type="text" path="type" id="type"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="type" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/phones/show-phones' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Save" class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/phones/show-phones' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>