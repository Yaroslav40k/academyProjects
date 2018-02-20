<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Form Stage 2</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>


<style>


.layer2 {
	overflow: auto;
	width: 890px; /* Ширина блока */
	height: 600px; /* Высота блока */
	padding: 5px; /* Поля вокруг текста */
	border: solid 1px black; /* Параметры рамки */
}
</style>
</head>

<body>


	<div class="generic-container" >


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

		<div class="well lead">Choose final options for ${miniature.miniatureName}</div>


		<div class="layer2" name="options">



			<form:form method="POST" modelAttribute="orderDetails" class="form-horizontal" oninput="amount.value = (minisQuantity.value * qualitySelect.value)">
				<form:input type="hidden" path="order_detail_id" id="order_detail_id"/>
				<form:input type="hidden" path="orderId" id="orderId" value="1"/>
				<form:input type="hidden" path="chartId" id="chartId" value="1"/>
				<form:input type="hidden" path="miniatureId" id="miniatureId" value="${miniature.miniature_id}" />

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minisQuantity">Miniatures count</label> 
						<form:input type="number" path="minisQuantity" id="minisQuantity" />
						<div class="has-error">
							<form:errors path="minisQuantity" class="help-inline"/>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable">Quality</label> <select id="qualitySelect" name="qualitySelect">
							<option value="${miniature.miniatureLowPrice}">Low</option>
							<option value="${miniature.miniatureMidPrice}">Medium</option>
							<option value="${miniature.miniatureHighPrice}">High</option>
						</select>
					</div>
				</div>



				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minisColorScheme">Color Scheme</label>
						<form:textarea name="textarea" path="minisColorScheme" id="minisColorScheme" style="width: 550px; height: 50px;"></form:textarea>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minisBaseScheme">Base details</label>
						<form:textarea name="textarea" path="minisBaseScheme" id="minisBaseScheme" style="width: 550px; height: 50px;"></form:textarea>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minisInventory">Weapons/Inventory</label>
						<form:textarea name="textarea" path="minisInventory" id="minisInventory" style="width: 550px; height: 50px;"></form:textarea>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minisInventoryOp">Weapons/Inventory magnetized options</label>
						<form:textarea name="textarea" path="minisInventoryOp" id="minisInventoryOp" style="width: 550px; height: 50px;"></form:textarea>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="minisAddDetails">Additional details</label>
						<form:textarea name="textarea" path="minisAddDetails" id="minisAddDetails" style="width: 550px; height: 50px;"></form:textarea>
					</div>
				</div>



				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="userProfiles">Average price ($)</label> 
						<form:input path="minisAvgPrice" id="minisAvgPrice" name="minisAvgPrice" value="5" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-success"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Add To Chart" class="btn btn-success"/>
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			</form:form>

			<div class="row">
				<div style="float: left; padding: 20px">

					<button onclick="goBack()" class="btn btn-success">Return to Miniatures List</button>

				</div>
				<div style="float: right; padding: 20px">
					<input type="submit" value="Complete Order" class="btn btn-success" />

				</div>
			</div>
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