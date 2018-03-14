<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<title>Artist.Yaroslav Miniatures</title>
<meta name="author" content="pixelhint.com">
<meta name="description" content="Miniatures gallery and workshop of Yaroslav Dmitriev" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" type="text/css"></link>
<link href="<c:url value='/static/css/Custom.css' />" rel="stylesheet" type="text/css"></link>
<script type="text/javascript">
	function calculate() {
		var low_pt_h = '${miniature.miniatureLowPH}';
		var mid_pt_h = '${miniature.miniatureMidPH}';
		var high_pt_h = '${miniature.miniatureHighPH}';
		var low_price= '${miniature.miniatureLowPrice}';
		var mid_price = '${miniature.miniatureMidPrice}';
		var high_price = '${miniature.miniatureHighPrice}';
		var quality = document.getElementById('qualitySelect').value;
		var miniaturesCount = document.getElementById('minisQuantity').value;
		document.getElementById('minisAvgPrice').value = parseInt(quality)
				* parseInt(miniaturesCount);
		
		document.getElementById('estTime').value = (quality>mid_price? miniaturesCount*high_pt_h : quality==mid_price? miniaturesCount*mid_pt_h : miniaturesCount*low_pt_h );
	}
</script>

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

hr {
	height: 5px;
	background-color: white;
	margin-top: 10px;
	margin-bottom: 10px;
	width: 100%;
}
</style>
</head>
<body>

	<%@include file="navPanel.jsp"%>
	<div class="container" style="color: white;">
	<div class="row">
			<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Stage 5 of 5: Describe your wishes</h2>
			</div>
		</div>

		<table id="cart" class="table table-hover table-condensed" style="color: white;">
			<thead>
			<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-3">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-12 col-md-9">
									<p style="color: white;">Estimate time: <input  id="estTime"  />  working hours</p>

								</div>
							</div>
						</td>
					</tr>
			</thead>
		</table>
		<hr />
		<form:form method="POST" modelAttribute="orderDetails" class="form-horizontal" acceptCharset="utf-8">
			<form:input type="hidden" path="order_detail_id" id="order_detail_id" />
			<form:input type="hidden" path="orderId" id="orderId" value="${orderDetails.orderId}" />
			<form:input type="hidden" path="miniatureId" id="miniatureId" value="${miniature.miniature_id}" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="minisQuantity">Miniatures count</label>
					<form:input type="number" path="minisQuantity" id="minisQuantity" onkeyup="calculate()" />
					<div class="has-error">
						<form:errors path="minisQuantity" class="help-inline" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Quality</label> <select id="qualitySelect" name="qualitySelect"  onChange="calculate()">
						<option value="${miniature.miniatureLowPrice}" onChange="calculate()">Low</option>
						<option value="${miniature.miniatureMidPrice}" onChange="calculate()">Medium</option>
						<option value="${miniature.miniatureHighPrice}" onChange="calculate()">High</option>
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
					<form:input path="minisAvgPrice" id="minisAvgPrice" name="minisAvgPrice" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">

					<c:choose>
						<c:when test="${edit}">
							<input style="margin-left: auto; margin-right: 0em;" type="submit" value="Update" class="btn btn-outline-info my-2 my-sm-0" />
						</c:when>
						<c:otherwise>
							<input style="margin-left: auto; margin-right: 0em;" type="submit" value="Add To Chart" class="btn btn-outline-info my-2 my-sm-0" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>

		<div class="row">
			<hr />
			<br>
			<button style="margin-left: 0em; margin-right: auto;" onclick="window.history.go(-1); return false;" class="btn btn-outline-info my-2 my-sm-0">Return</button>
			<a style="margin-left: auto; margin-right: 0em;" href="<%=request.getContextPath()%>/orders/chart" class="btn btn-outline-info my-2 my-sm-0">Check Chart <i class="fa fa-angle-right"></i></a>
		</div>
	</div>




</body>
</html>
