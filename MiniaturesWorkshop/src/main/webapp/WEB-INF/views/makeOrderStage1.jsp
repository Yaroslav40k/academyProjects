<%@ page language="java" contentType="text/html;charset=utf-8"%>
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

</style>
</head>
<body>
	<%@include file="navPanel.jsp"%>
	<div class="container">
		<table id="cart" class="table table-hover table-condensed" style="color: white;">
			<thead>
				<tr>
					<th style="width: 50%">Manufacturer</th>
					<th style="width: 30%">Website</th>
					<th style="width: 10%">Country</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${manufacturers}" var="manufacturer">
					<tr>
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
					<td><a href="#" class="btn btn-outline-info my-2 my-sm-0"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>
