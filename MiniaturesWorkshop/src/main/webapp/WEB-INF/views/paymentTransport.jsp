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

body {
	background: url('static/images/metal.jpg') no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>
<body>

	<%@include file="navPanel.jsp"%>
	<div class="container">
		<div class="row">
			<table id="cart" class="table table-hover table-condensed">
				<tbody>
					<tr>
						<td data-th="Manufacturer">
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<img alt="" width="300" height="200" style="border-radius: 20px" src="<%=request.getContextPath()%>/static/images/shippingImage.jpg">
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">I would like to mention that items sent uninsured are entirely at your own risk and we cannot be held responsible for loss or damage during transit. Insurance
										would be extra so therefore please e-mail for a quote. I pack minis very carefully with bubblewrap and hardcarton - so they are really safe. *For faster shipping like UPS or other courier
										services please send me an e-mail with quote about costs, prices in table are estimated.</p>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" class="hidden-xs"></td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="row">
			<table id="cart" class="table table-hover table-condensed">
				<tbody>
					<tr>
						<td data-th="Manufacturer">
							<div class="row">
								<div class="col-xs-12 col-md-6">
									<img alt="" width="300" height="200" style="border-radius: 20px" src="<%=request.getContextPath()%>/static/images/depositImage.jpg">
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">To start work I'll need 25% commission value prepayment and money to buy miniatures (cost of miniatures + shipping to my location). You can supply your own
										miniatures or buy it yourself and place an order to my location.</p>
		
								</div>
							</div>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" class="hidden-xs"></td>
						
					</tr>
				</tfoot>
			</table>

			
		</div>

	</div>
	
</body>
</html>