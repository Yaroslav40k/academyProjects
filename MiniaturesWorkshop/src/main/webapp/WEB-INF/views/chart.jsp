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
</style>
</head>
<body>

	<%@include file="navPanel.jsp"%>
	<div class="container">
		<table id="cart" class="table table-hover table-condensed" style="color: white;">
			<thead>
				<tr>
					<th style="width: 30%">Miniature</th>
					<th style="width: 15%">Quantity</th>
					<th style="width: 15%" class="text-center">Subtotal</th>
					<th style="width: 40%"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${orderedMiniatures}" var="entry">
					<tr>
						<td data-th="Miniature">
							<div class="row">
								<div class="col-sm-10">
									<h4 class="nomargin">${entry.value.miniatureName}</h4>
								</div>
							</div>
						</td>
						<td data-th="Quantity">${entry.key.minisQuantity}</td>
						<td data-th="Price Each">${entry.key.minisAvgPrice} $</td>
						<td class="actions" data-th="">
							<a class="navbar-brand" href="<c:url value='/orders/deleteDetail-${entry.key.order_detail_id}'/>"><img border="0"
		src="<%=request.getContextPath()%>/static/images/deleteButton.png" width="50" height="50" style="border-radius: 10px"></a>
							<a class="navbar-brand" href="<c:url value='/orders/updateDetail-${entry.key.order_detail_id}'/>"><img border="0"
		src="<%=request.getContextPath()%>/static/images/updateButton.png" width="50" height="50" style="border-radius: 10px"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td><a href="<c:url value='/orders/stage1'/>" class="btn btn-outline-info my-2 my-sm-0"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>TOTAL: ${totalSum} $</strong></td>
					<td><a href="<c:url value='/orders/completeOrder-${orderNumber}'/>" class="btn btn-outline-info my-2 my-sm-0">Confirm the Order <i class="fa fa-angle-right"></i></a></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>