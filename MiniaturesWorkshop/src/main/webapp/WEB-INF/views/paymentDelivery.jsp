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
			<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Here is your plan</h2>
				<div class="view">
					<img src="<%=request.getContextPath()%>/static/images/Payment&Delivery_explain.jpg" class="media" alt="" />
				</div>
			</div>

			<table id="cart" class="table table-hover table-condensed">
				<tbody>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">1. Choose miniatures to paint</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">Quite simple step. Just choose what painted miniature will make you happy!</p>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">2. Make an order</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">Go through order steps and fulfill your chart with miniature. Each miniature pack with the same name, should have description of what you want to see - main
										colors, details colors, base style, weapon options and so on.</p>

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">3. Receive confirmation</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">Recive confirmation email from my workshop. Inside you will find your detailed order with fixed price based on your wishes, that you have already written in
										order. Remember, that it may vary a bit from the average price due to the details</p>

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">4. Send/Buy the miniatures</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">To start work I'll need 25% commission value prepayment and money to buy miniatures (cost of miniatures + shipping to my location). You can supply your own
										miniatures or buy it yourself and place an order to my location. I would like to mention that items sent uninsured are entirely at your own risk and we cannot be held responsible for loss or
										damage during transit. Insurance would be extra so therefore please e-mail for a quote. I pack minis very carefully with bubblewrap and hardcarton - so they are really safe. *For faster
										shipping like UPS or other courier services please send me an e-mail with quote about costs, prices in table are estimated</p>

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">5. Track the Progress</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">Immediately after receiving the box with miniatures, your painter will inform you that the work is begun . In your account you can track the progress status for
										each position, questions, problems and some other useful information. The most urgent questions will be also duplicated via email.</p>

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">6. Receive Photos</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">When the work will finally over, your painter will send you high resolution photos of your miniatures, hope you`ll be happy with the result.</p>

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">7. Make  payment</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">If everything is all right, you will receive information to make payment via different ways: PayPal, Visa/Mastercard or Western Union. Just choose the best
										variant for you.</p>

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-xs-1 col-md-1">
									<img width="50" height="50" style="border-radius: 10px" src="<%=request.getContextPath()%>/static/images/defaultImage.jpg">
								</div>
								<div class="col-xs-10 col-md-5">
									<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">8. Receive miniatures</h2>
								</div>
								<div class="col-xs-12 col-md-6">
									<p style="color: white;">After payment confirmation, your miniatures will be send to you. Choose the best variant: express post, UPS/DHL or other transport company. Sometimes i will be
										able to deliver order myself.</p>

								</div>
							</div>
						</td>
					</tr>

				</tbody>
			</table>


		</div>

	</div>

</body>
</html>