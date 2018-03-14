<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</style>
</head>
<body>
	<%@include file="navPanel.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Stage 1 of 5: Choose the Manufacturer</h2>
			</div>
		</div>
		<table id="cart" class="table table-hover table-condensed" style="color: white;">
			<thead>
				<tr>
					<th style="width: 10%"></th>
					<th style="width: 40%">Manufacturer</th>
					<th style="width: 30%">Website</th>
					<th style="width: 10%">Country</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${manufacturers}" var="manufacturer">
					<tr>
						<td data-th="faction_image"><a href="<%=request.getContextPath()%>/orders/stage2-${manufacturer.manuf_id}"><img border="0"
								src="<%=request.getContextPath()%>/static/images/defaultImage.jpg" width="50" height="50" style="border-radius: 10px"></a></td>
						<td data-th="Manufacturer">
							<div class="row">
								<div class="col-sm-10">
									<h4 class="nomargin">${manufacturer.manufName}</h4>
									<p>${manufacturer.manufDescr}</p>
								</div>
							</div>
						</td>
						<td data-th="Website">${manufacturer.manufWebsite}</td>
						<td data-th="Country">${manufacturer.manufCountry}</td>
						<td><a href="<%=request.getContextPath()%>/orders/stage2-${manufacturer.manuf_id}" class="btn btn-outline-info my-2 my-sm-0">Choose <i class="fa fa-angle-right"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td><button onclick="window.history.go(-1); return false;" class="btn btn-outline-info my-2 my-sm-0">Return</button></td>
					<td colspan="2" class="hidden-xs"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>
