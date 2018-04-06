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
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Account information</h2>
			</div>
		</div>
		<hr />
		<div class="col-xs-12 col-md-12 col-centered text-center">
			<a href="<%=request.getContextPath()%>/orders/stage5-${loggedinuser.firstName}"><img border="0" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg" width="50" height="50"
				style="border-radius: 10px"></a>
			<h4 class="nomargin" style="color: white; font-family: Perpetua Titling MT;">User: ${loggedinuser.firstName}</h4>
		</div>
		<hr />


		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			<div class="panel panel-primary">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="true" aria-controls="collapse1"> <img
							src="<%=request.getContextPath()%>/static/images/orderImages/currentOrdersBar.jpg" class="media" alt="" />
						</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
					<div class="panel-body">
						<table id="cart" class="table table-hover table-condensed">
							<tbody>
								<c:forEach items="${currentOrders}" var="entry">
									<tr>
										<td>
											<div class="row" style="width: 100%">
												<div class="col-xs-12 col-md-2">
													<h2 style="color: white; font-family: Times New Roman; font-size: 16px">ORDER №: ${entry.key.order_id}</h2>
													<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
												</div>
												<div class="col-xs-12 col-md-3">
													<h2 style="color: white; font-family: Times New Roman; font-size: 16px">RECIEVED:</h2>
													<h2 style="color: white; font-family: Times New Roman; font-size: 12px">${entry.key.orderDate}</h2>
												</div>
												<div class="col-xs-12 col-md-3">
													<h2 style="color: white; font-family: Times New Roman; font-size: 16px">RELEASE:</h2>
													<h2 style="color: white; font-family: Times New Roman; font-size: 12px">${entry.key.finishedDate}</h2>
												</div>
												<div class="col-xs-12 col-md-2">
													<h2 style="color: white; font-family: Times New Roman; font-size: 16px">STATUS:</h2>
													<h2 style="color: white; font-family: Times New Roman; font-size: 16px">${entry.key.orderStatus}</h2>
												</div>
												<div class="col-xs-12 col-md-2">
													<a href="<%=request.getContextPath()%>/orders/orderControl-${entry.key.order_id}" class="btn btn-outline-info my-2 my-sm-0">Choose <i class="fa fa-angle-right"></i></a>
												</div>


											</div>
										</td>
									</tr>
									<table id="cart" class="table table-hover table-condensed" style="color: white;">
										<tbody>
										<thead>
											<tr>
												<th style="width: 20%">Miniature name</th>
												<th style="width: 20%">Type</th>
												<th style="width: 20%">Quantity</th>
												<th style="width: 20%">Size</th>
												<th style="width: 20%">Price</th>

											</tr>
										</thead>
										<c:forEach items="${entry.value}" var="innerEntry">
											<tr>
												<td><h2 style="color: white; font-family: Times New Roman; font-size: 16px">${innerEntry.value.miniatureName}</h2></td>
												<td><h2 style="color: white; font-family: Times New Roman; font-size: 16px">${innerEntry.value.miniatureType}</h2></td>
												<td><h2 style="color: white; font-family: Times New Roman; font-size: 16px">${innerEntry.key.minisQuantity}</h2></td>
												<td><h2 style="color: white; font-family: Times New Roman; font-size: 16px">${innerEntry.value.miniatureSize}</h2></td>
												<td><h2 style="color: white; font-family: Times New Roman; font-size: 16px">${innerEntry.key.minisAvgPrice}$</h2></td>

											</tr>
										</c:forEach>
										</tbody>
									</table>
								</c:forEach>

							</tbody>
						</table>

					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2"> <img
							src="<%=request.getContextPath()%>/static/images/orderImages/finishedOrdersBar.jpg" class="media" alt="" />
						</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading2">
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingThree">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3"> <img
							src="<%=request.getContextPath()%>/static/images/orderImages/canceledOrdersBar.jpg" class="media" alt="" />
						</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading3">
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
