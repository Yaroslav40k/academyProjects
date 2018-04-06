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
		var low_price = '${miniature.miniatureLowPrice}';
		var mid_price = '${miniature.miniatureMidPrice}';
		var high_price = '${miniature.miniatureHighPrice}';
		var quality = document.getElementById('qualitySelect').value;
		var miniaturesCount = document.getElementById('minisQuantity').value;
		document.getElementById('minisAvgPrice').value = parseInt(quality)
				* parseInt(miniaturesCount);

		document.getElementById('estTime').value = (quality > mid_price ? miniaturesCount
				* high_pt_h
				: quality == mid_price ? miniaturesCount * mid_pt_h
						: miniaturesCount * low_pt_h);
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
		<hr />
		<div class="col-xs-12 col-md-12 col-centered text-center">
			<a href="<%=request.getContextPath()%>/orders/stage5-${miniature.miniature_id}"><img border="0" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg" width="50" height="50"
				style="border-radius: 10px"></a>
			<h4 class="nomargin" style="color: white; font-family: Perpetua Titling MT;">MINIATURE: ${miniature.miniatureName}</h4>
		</div>
		<hr />
		<form:form method="POST" modelAttribute="orderDetails" class="form-horizontal" acceptCharset="utf-8">
			<form:input type="hidden" path="order_detail_id" id="order_detail_id" />
			<form:input type="hidden" path="orderId" id="orderId" value="${orderDetails.orderId}" />
			<form:input type="hidden" path="miniatureId" id="miniatureId" value="${miniature.miniature_id}" />

			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="true" aria-controls="collapse1"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/howManyMiniaturesBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">How many miniatures?</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/quanMiniatures.jpg" class="media" alt="" />
										</div>
										<form:input type="number" path="minisQuantity" id="minisQuantity" onkeyup="calculate()" />
										<div class="has-error">
											<form:errors path="minisQuantity" class="help-inline" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/whatAboutQualityBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading2">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">What about quality?</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/qualityMiniatures.jpg" class="media" alt="" />
										</div>
										<select id="qualitySelect" name="qualitySelect" onChange="calculate()">
											<option value="${miniature.miniatureLowPrice}" onChange="calculate()">BASE</option>
											<option value="${miniature.miniatureMidPrice}" onChange="calculate()">MEDIUM</option>
											<option value="${miniature.miniatureHighPrice}" onChange="calculate()">HIGH</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-success">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/colorsOfEverythingBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading3">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Colors of everything</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/colorMiniatures.jpg" class="media" alt="" />
										</div>
										<form:textarea name="textarea" path="minisColorScheme" id="minisColorScheme" style="width: 100%; height: 50px;"></form:textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-warning">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/basesStyleBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Bases style</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/basesMiniatures.jpg" class="media" alt="" />
										</div>
										<form:textarea name="textarea" path="minisBaseScheme" id="minisBaseScheme" style="width: 100%; height: 50px;"></form:textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse5" aria-expanded="false" aria-controls="collapse5"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/assembleVariantBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading5">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Assemble variant</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/variantsMiniatures.jpg" class="media" alt="" />
										</div>
										<form:textarea name="textarea" path="minisInventory" id="minisInventory" style="width: 100%; height: 50px;"></form:textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-danger">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse6" aria-expanded="false" aria-controls="collapse6"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/whatShouldBeMagnetizedBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse6" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading6">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">What should be magnetized?</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/magnetizingMiniatures.jpg" class="media" alt="" />
										</div>
										<form:textarea name="textarea" path="minisInventoryOp" id="minisInventoryOp" style="width: 100%; height: 50px;"></form:textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-danger">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse7" aria-expanded="false" aria-controls="collapse7"> <img
								src="<%=request.getContextPath()%>/static/images/orderImages/additionalInformationAndWishesBar.jpg" class="media" alt="" />
							</a>
						</h4>
					</div>
					<div id="collapse7" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading7">
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-12">
									<div class="col-xs-12 col-md-12 col-centered text-center">
										<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Additional information and wishes</h2>
										<div class="view">
											<img src="<%=request.getContextPath()%>/static/images/orderImages/additionalWishes.jpg" class="media" alt="" />
										</div>
										<form:textarea name="textarea" path="minisAddDetails" id="minisAddDetails" style="width: 100%; height: 50px;"></form:textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label class="col-xs-12 col-md-3 control-lable" for="userProfiles">Average price ($):</label>
					<form:input path="minisAvgPrice" id="minisAvgPrice" name="minisAvgPrice" />
				</div>
				<div class="col-xs-12 col-md-6">
					<label class="col-xs-12 col-md-3 control-lable">Estimate time (hours):</label> <input id="estTime" />
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
