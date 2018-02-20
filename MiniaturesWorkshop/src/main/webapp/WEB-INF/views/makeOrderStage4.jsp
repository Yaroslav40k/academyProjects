<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Form Stage 2</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>


<style>
.layer {
	overflow: scroll; /* Добавляем полосы прокрутки */
	width: 400px; /* Ширина блока */
	height: 400px; /* Высота блока */
	padding: 5px; /* Поля вокруг текста */
	border: solid 1px black; /* Параметры рамки */
}
</style>
</head>

<body>


	<div class="generic-container">


		<%@include file="authheader.jsp"%>
		<div class="chart"></div>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Customer </span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Nickname</th>
						<th>Lastname</th>
						<th>Adress</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${loggedinuser.firstName}</td>
						<td></td>
						<td>${loggedinuser.lastName}</td>
						<td></td>
						<td>${loggedinuser.email}</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="well lead">Choose Miniature</div>
		
		
		

		<div class="layer" >
			<table>
				<tr>
					<c:forEach items="${miniatures}" var="miniature">
						<tr>
							<td><a type="chosenMiniature"
								href="<c:url value='/orders/stage5-${miniature.miniature_id}' />"
								value="${miniature.miniature_id}" class="btn btn-success ">${miniature.miniatureName}</a></td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>

		<div padding: 20px">

			<button onclick="goBack()" class="btn btn-success">Return to
				Factions List</button>

		</div>

	</div>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>

	<script type="text/javascript">
		
	<%@include file="/static/js/vendor/jquery-1.10.1.min.js"%>
		
	</script>
	<script src="<c:url value='/static/js/jquery.jquery.js'/>"></script>
	<script src="<c:url value='/static/js/myScripts.js'/>"></script>
	<script src="<c:url value='/static/js/jquery.backstretch.js'/>"></script>
	<script type="text/javascript">
		
	<%@include file="/static/js/main.js"%>
		
	</script>
	<script type="text/javascript">
		$.backstretch([ "<c:url value='/static/images/b1.JPG'/>",
				"<c:url value='/static/images/b2.JPG'/>",
				"<c:url value='/static/images/b3.JPG'/>",
				"<c:url value='/static/images/b4.JPG'/>",
				"<c:url value='/static/images/b5.JPG'/>",
				"<c:url value='/static/images/b6.JPG'/>",
				"<c:url value='/static/images/b7.JPG'/>" ], {
			fade : 750,
			duration : 4000
		});
	</script>
</body>
</html>