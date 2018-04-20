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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.thumbnail:hover {
	position: relative;
	top: -25px;
	left: -35px;
	width: 100%;
	height: auto;
	display: block;
	z-index: 999;
}

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

.fa {
	font-size: 25px;
}

.checked {
	color: orange;
}
</style>
</head>
<body>

	<%@include file="navPanel.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">OUR PAINTERS</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="row ">
					<div class="col-md-12" style="border-color: RGB(23, 162, 184); border-style: solid; border-radius: 20px; padding: 10px;">
						<div class="row ">
							<div class="col-sm-12 col-centered text-center">
								<h4 style="color: white; font-family: Perpetua Titling MT;">YAROSLAV "JAREK" DMITRIEV</h4>
							</div>
						</div>

						<div class="row ">
							<div class=" col-md-12 col-centered text-center">

								<!--Carousel Wrapper-->
								<div id="carousel-yaroslav-1z" class="carousel slide carousel-fade" data-ride="carousel" data-interval="false">
									<!--Slides-->
									<div class="carousel-inner" role="listbox">
										<!--First slide-->
										<div class="carousel-item active">
											<div class="row ">
												<div class=" col-md-12 col-centered text-center">
													<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span
														class="fa fa-star checked"></span>
												</div>
											</div>
											<div class="row ">
												<div class="col-sm-12 col-md-6 col-centered text-center">
													<img src="<%=request.getContextPath()%>/static/images/avatars/JarekAvatar.png" class="media" alt="" />

												</div>
												<div class="col-sm-12 col-md-6 col-centered text-center">
													<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="1" class="btn btn-outline-info my-2 my-sm-0">Priority control</button>
													<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="2" class="btn btn-outline-info my-2 my-sm-0">Warnings</button>
													<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="3" class="btn btn-outline-info my-2 my-sm-0">Current activity</button>
													<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="4" class="btn btn-outline-info my-2 my-sm-0">About</button>
													<a style="width: 100%;" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Orders history</a>
												</div>
											</div>
											<div class="row ">
												<div class="col-sm-12"></div>
											</div>
										</div>
										<!--/First slide-->
										<!--Second slide-->
										<div class="carousel-item">

											<div class="row ">
												<div class=" col-md-12 col-centered text-center">
													<table id="cart" class="table table-hover table-condensed" style="color: white;">
														<thead>
															<tr>
																<th style="width: 10%">Order</th>
																<th style="width: 20%"></th>
																<th style="width: 40%">Customer</th>
																<th style="width: 20%">Priority</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${paintersOrders}" var="paintersOrder">
																<tr>
																	<td data-th="faction_image"><a href="<%=request.getContextPath()%>/orders/stage2-${paintersOrder.order_id}"><img border="0"
																			src="<%=request.getContextPath()%>/static/images/defaultImage.jpg" width="25" height="25" style="border-radius: 10px"></a></td>
																	<td>
																		<div class="row">
																			<div class="col-sm-12">
																				<h4 class="nomargin"># ${paintersOrder.order_id}</h4>

																			</div>
																		</div>
																	</td>
																	<td>
																		<div class="row">
																			<div class="col-sm-12">
																				<h4 class="nomargin">${loggedinuser.ssoId}</h4>
																			</div>
																		</div>
																	</td>
																	<td>
																		<div class="row">
																			<div class="col-sm-12">
																				<select id="prioritySelect" onChange="priorityCalculate()">
																					<option value="1">LOW</option>
																					<option value="2">MEDIUM</option>
																					<option value="3">HIGH</option>
																				</select>
																			</div>
																		</div>
																	</td>

																</tr>
															</c:forEach>
														</tbody>
														<tfoot>
															<tr>
																<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="0" class="btn btn-outline-info my-2 my-sm-0">Return</button>
																<td colspan="2" class="hidden-xs"></td>
															</tr>
														</tfoot>
													</table>
												</div>
											</div>




										</div>
										<!--/Second slide-->
										<!--Third slide-->
										<div class="carousel-item">
											<div class="row ">
												<div class=" col-md-12 col-centered text-center">
													<table id="cart" class="table table-hover table-condensed" style="color: white;">
														<thead>
															<tr>
																<th style="width: 10%">Order</th>
																<th style="width: 90%">Warnings</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${paintersOrders}" var="paintersOrder">
																<tr>
																	<td data-th="faction_image"><a href="<%=request.getContextPath()%>/orders/stage2-${paintersOrder.order_id}"><img border="0"
																			src="<%=request.getContextPath()%>/static/images/defaultImage.jpg" width="25" height="25" style="border-radius: 10px"></a></td>
																	<td>
																		<div class="row">
																			<div class="col-sm-12">
																				<h4 class="nomargin">
																					<p>Some strange warning here!</p>
																				</h4>

																			</div>
																		</div>
																	</td>


																</tr>
															</c:forEach>
														</tbody>
														<tfoot>
															<tr>
																<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="0" class="btn btn-outline-info my-2 my-sm-0">Return</button>
																<td colspan="2" class="hidden-xs"></td>
															</tr>
														</tfoot>
													</table>
												</div>
											</div>

										</div>
										<!--/Third slide-->
										<!--Fourth slide-->
										<div class="carousel-item">
											<div class="row ">
												<div class=" col-md-12 col-centered text-center">
													<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="0" class="btn btn-outline-info my-2 my-sm-0">Return</button>
													<td colspan="2" class="hidden-xs"></td>
													<iframe width="490" height="370" src="https://www.youtube.com/embed/mU8WlZgr-OQ" frameborder="0" allowfullscreen="allowfullscreen" data-link="https://www.youtube.com/watch?v=mU8WlZgr-OQ"></iframe>

												</div>
											</div>

										</div>
										<!--/Fourth slide-->
										<!--Fifth slide-->
										<div class="carousel-item">
											<div class="row ">
												<div class=" col-md-12 col-centered text-center">
													<table id="cart" class="table table-hover table-condensed" style="color: white;">
														<thead>
															<tr>
																<th style="width: 10%">Order</th>
																<th style="width: 90%">Warnings</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${paintersOrders}" var="paintersOrder">
																<tr>
																	<td data-th="faction_image"><a href="<%=request.getContextPath()%>/orders/stage2-${paintersOrder.order_id}"><img border="0"
																			src="<%=request.getContextPath()%>/static/images/defaultImage.jpg" width="25" height="25" style="border-radius: 10px"></a></td>
																	<td>
																		<div class="row">
																			<div class="col-sm-12">
																				<h4 class="nomargin">
																					<p>Some strange warning here!</p>
																				</h4>

																			</div>
																		</div>
																	</td>


																</tr>
															</c:forEach>
														</tbody>
														<tfoot>
															<tr>
																<button type="button" style="width: 100%" data-target="#carousel-yaroslav-1z" data-slide-to="0" class="btn btn-outline-info my-2 my-sm-0">Return</button>
																<td colspan="2" class="hidden-xs"></td>
															</tr>
														</tfoot>
													</table>
												</div>
											</div>

										</div>
										<!--/Fifth slide-->
									</div>
									<!--/.Slides-->
								</div>
								<!--/.Carousel Wrapper-->



							</div>
						</div>














						<div class="row ">
							<div class=" col-md-12 col-lg-3">
								<h4 style="color: white; font-family: Perpetua Titling MT;">Сapacity</h4>
							</div>
							<div class=" col-md-12 col-lg-9">
								<div class="progress" style="margin-top: 5px">
									<div id="jarekProgressbar" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%; color: black;">40%</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>


			<div class="col-md-6">
				<div class="row ">
					<div class="col-md-12" style="border-color: RGB(23, 162, 184); border-style: solid; border-radius: 20px; padding: 10px;">
						<div class="row ">
							<div class="col-sm-12 col-centered text-center">
								<h4 style="color: white; font-family: Perpetua Titling MT;">FRANKY "FOUR FINGERS"</h4>
							</div>
						</div>
						<div class="row ">
							<div class=" col-md-12 col-centered text-center">
								<span class="fa fa-star checked"></span>
							</div>
						</div>
						<div class="row ">
							<div class="col-sm-12 col-md-6 col-centered text-center">
								<img src="<%=request.getContextPath()%>/static/images/avatars/FrankyAvatar.png" class="media" alt="" />

							</div>
							<div class="col-sm-12 col-md-6 col-centered text-center">
								<a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Priority control</a> <a style="width: 100%"
									href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Warnings</a> <a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1"
									class="btn btn-outline-info my-2 my-sm-0">Current activity</a> <a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">About</a> <a
									style="width: 100%;" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Orders history</a>
							</div>
						</div>
						<div class="row ">
							<div class="col-sm-12"></div>
						</div>
						<div class="row ">
							<div class=" col-md-12 col-lg-3">
								<h4 style="color: white; font-family: Perpetua Titling MT;">Сapacity</h4>
							</div>
							<div class=" col-md-12 col-lg-9">
								<div class="progress" style="margin-top: 5px">
									<div id="frankyProgressbar" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%; color: black;">80%</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="row ">
					<div class="col-md-12" style="border-color: RGB(23, 162, 184); border-style: solid; border-radius: 20px; padding: 10px;">
						<div class="row ">
							<div class="col-sm-12 col-centered text-center">
								<h4 style="color: white; font-family: Perpetua Titling MT;">BORIS "THE BLADE"</h4>
							</div>
						</div>
						<div class="row ">
							<div class=" col-md-12 col-centered text-center">
								<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span>
							</div>
						</div>
						<div class="row ">
							<div class="col-sm-12 col-md-6 col-centered text-center">
								<img src="<%=request.getContextPath()%>/static/images/avatars/BorisAvatar.png" class="media" alt="" />
							</div>
							<div class="col-sm-12 col-md-6 col-centered text-center">
								<a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Priority control</a> <a style="width: 100%"
									href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Warnings</a> <a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1"
									class="btn btn-outline-info my-2 my-sm-0">Current activity</a> <a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">About</a> <a
									style="width: 100%;" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Orders history</a>
							</div>
						</div>
						<div class="row ">
							<div class="col-sm-12"></div>
						</div>
						<div class="row ">
							<div class=" col-md-12 col-lg-3">
								<h4 style="color: white; font-family: Perpetua Titling MT;">Сapacity</h4>
							</div>
							<div class=" col-md-12 col-lg-9">
								<div class="progress" style="margin-top: 5px">
									<div id="borisProgressbar" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%; color: black;">60%</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="row ">
					<div class="col-md-12" style="border-color: RGB(23, 162, 184); border-style: solid; border-radius: 20px; padding: 10px;">
						<div class="row ">
							<div class="col-sm-12 col-centered text-center">
								<h4 style="color: white; font-family: Perpetua Titling MT;">"BULLET TOOTH" TONY</h4>
							</div>
						</div>
						<div class="row ">
							<div class=" col-md-12 col-centered text-center">
								<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span>
							</div>
						</div>
						<div class="row ">
							<div class="col-sm-12 col-md-6 col-centered text-center">
								<img src="<%=request.getContextPath()%>/static/images/avatars/TonyAvatar.png" class="media" alt="" />
							</div>
							<div class="col-sm-12 col-md-6 col-centered text-center">
								<a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Priority control</a> <a style="width: 100%"
									href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Warnings</a> <a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1"
									class="btn btn-outline-info my-2 my-sm-0">Current activity</a> <a style="width: 100%" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">About</a> <a
									style="width: 100%;" href="<%=request.getContextPath()%>/orders/stage1" class="btn btn-outline-info my-2 my-sm-0">Orders history</a>
							</div>
						</div>
						<div class="row ">
							<div class="col-sm-12"></div>
						</div>
						<div class="row ">
							<div class=" col-md-12 col-lg-3">
								<h4 style="color: white; font-family: Perpetua Titling MT;">Сapacity</h4>
							</div>
							<div class=" col-md-12 col-lg-9">
								<div class="progress" style="margin-top: 5px">
									<div id="tonyProgressbar" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%; color: black;">20%</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>


		</div>
	</div>
	<script type="text/javascript">
		function priorityCalculate() {

			var ValueToCheck = document.getElementById("prioritySelect").value;
			var progressBar = document.getElementById("jarekProgressbar");
			var progressBarColor;

			if (ValueToCheck == "3") {
				progressBarColor = "#A52A2A";
				$("#jarekProgressbar").css('width', "80%");
				$('#jarekProgressbar').text("80%");
			} else if (ValueToCheck == "2") {
				progressBarColor = "#FFFF00";
				$("#jarekProgressbar").css('width', "50%");
				$('#jarekProgressbar').text("50%");
			} else {
				progressBarColor = "#32CD32";
				$("#jarekProgressbar").css('width', "40%");
				$('#jarekProgressbar').text("40%");
			}
			$("#jarekProgressbar").css('background-color', progressBarColor);

		}
	</script>
	<script type="text/javascript">
		var progressBarColor;

		var ValueToCheck = document.getElementById('jarekProgressbar')
				.getAttribute('aria-valuenow');
		;

		if (ValueToCheck >= 80) {
			progressBarColor = "#A52A2A";
		} else if (ValueToCheck >= 50) {
			progressBarColor = "#FFFF00";
		} else {
			progressBarColor = "#32CD32";
		}
		$("#jarekProgressbar").css('background-color', progressBarColor);

		var ValueToCheck2 = document.getElementById('frankyProgressbar')
				.getAttribute('aria-valuenow');
		;

		if (ValueToCheck2 >= 80) {
			progressBarColor = "#A52A2A";
		} else if (ValueToCheck2 >= 50) {
			progressBarColor = "#FFFF00";
		} else {
			progressBarColor = "#32CD32";
		}
		$("#frankyProgressbar").css('background-color', progressBarColor);

		var ValueToCheck3 = document.getElementById('borisProgressbar')
				.getAttribute('aria-valuenow');
		;

		if (ValueToCheck3 >= 80) {
			progressBarColor = "#A52A2A";
		} else if (ValueToCheck3 >= 50) {
			progressBarColor = "#FFFF00";
		} else {
			progressBarColor = "#32CD32";
		}
		$("#borisProgressbar").css('background-color', progressBarColor);

		var ValueToCheck3 = document.getElementById('tonyProgressbar')
				.getAttribute('aria-valuenow');
		;

		if (ValueToCheck3 >= 80) {
			progressBarColor = "#A52A2A";
		} else if (ValueToCheck3 >= 50) {
			progressBarColor = "#FFFF00";
		} else {
			progressBarColor = "#32CD32";
		}
		$("#tonyProgressbar").css('background-color', progressBarColor);
	</script>
</body>
</html>