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
/* ENLARGE PHOTO STYLES*/
#myImg {
	border-radius: 5px;
	cursor: pointer;
	transition: 0.3s;
}

#myImg:hover {
	opacity: 0.7;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
	margin: auto;
	display: block;
	width: 100%;
	max-width: 1200px;
}

/* Caption of Modal Image */
#caption {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
	text-align: center;
	color: #ccc;
	padding: 10px 0;
	height: 150px;
}

/* Add Animation */
.modal-content, #caption {
	-webkit-animation-name: zoom;
	-webkit-animation-duration: 0.6s;
	animation-name: zoom;
	animation-duration: 0.6s;
}

@
-webkit-keyframes zoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* The Close Button */
.close {
	position: absolute;
	top: 15px;
	right: 35px;
	color: #fff;
	font-size: 100px;
	font-weight: bold;
	transition: 0.3s;
}

.close:hover, .close:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px) {
	.modal-content {
		width: 100%;
	}
}
</style>
</head>
<body>

	<%@include file="navPanel.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">ORDER № ${orderedMiniatures.key.orderId}</h2>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${orderedMiniatures}" var="entry">
				<div class="col-md-6">
					<div class="row ">
						<div class="col-md-12" style="border-color: RGB(23, 162, 184); border-style: solid; border-radius: 20px; padding: 10px;">
							<div class="row ">
								<div class="col-sm-12 col-centered text-center">
									<h4 style="color: white; font-family: Perpetua Titling MT;"" >${entry.key.minisQuantity}
										${entry.value.miniatureName}
										<c:if test="${entry.key.minisQuantity > 1}">s</c:if>
									</h4>
								</div>
							</div>
							<div class="row ">
								<div class="col-sm-12 col-md-6 col-centered text-center">
									<button style="width: 100%" onclick="window.history.go(-1); return false;" class="btn btn-outline-info my-2 my-sm-0">Changes log</button>
								</div>
								<div class="col-sm-12 col-md-6 col-centered text-center">
									<button style="width: 100%" onclick="window.history.go(-1); return false;" class="btn btn-outline-info my-2 my-sm-0">Details</button>
								</div>
							</div>
							<div class="row ">
								<div class="col-sm-12">
									<!--Carousel Wrapper-->
									<div id="carousel-${entry.value.miniatureName}-1z" class="carousel slide carousel-fade" data-ride="carousel" data-interval="false">
										<!--Indicators-->
										<ol class="carousel-indicators">
											<li data-target="#carousel-${entry.value.miniatureName}-1z" data-slide-to="0" class="active"></li>
											<li data-target="#carousel-${entry.value.miniatureName}-1z" data-slide-to="1"></li>
											<li data-target="#carousel-${entry.value.miniatureName}-1z" data-slide-to="2"></li>
										</ol>
										<!--/.Indicators-->
										<!--Slides-->
										<div class="carousel-inner" role="listbox">
											<!--First slide-->
											<div class="carousel-item active">
												<img class="d-block w-100" style="border-radius: 20px;" src="<%=request.getContextPath()%>/static/images/workFlowImages/${entry.value.miniatureName}1.JPG" alt="First slide">
											</div>
											<!--/First slide-->
											<!--Second slide-->
											<div class="carousel-item">
												<img class="d-block w-100" style="border-radius: 20px;" src="<%=request.getContextPath()%>/static/images/workFlowImages/${entry.value.miniatureName}2.JPG" alt="Second slide">
											</div>
											<!--/Second slide-->
											<!--Third slide-->
											<div class="carousel-item">
												<img class="d-block w-100" style="border-radius: 20px;" src="<%=request.getContextPath()%>/static/images/workFlowImages/${entry.value.miniatureName}3.JPG" alt="Third slide">
											</div>
											<!--/Third slide-->
										</div>
										<!--/.Slides-->
										<!--Controls-->
										<a class="carousel-control-prev" href="#carousel-${entry.value.miniatureName}-1z" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
											class="sr-only">Previous</span>
										</a> <a class="carousel-control-next" href="#carousel-${entry.value.miniatureName}-1z" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span
											class="sr-only">Next</span>
										</a>
										<!--/.Controls-->
									</div>
									<!--/.Carousel Wrapper-->

									<hr />
								</div>
							</div>
							<div class="row ">
								<div class=" col-md-12 col-lg-3">
									<h4 style="color: white; font-family: Perpetua Titling MT;">PROGRESS:</h4>
								</div>
								<div class=" col-md-12 col-lg-9">
									<div class="progress" style="margin-top: 5px">
										<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">80%</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>



	</div>
	<!-- The Modal -->
	<div id="myModal" class="modal">
		<span class="close">&times;</span> <img class="modal-content" id="img01">
		<div id="caption"></div>
	</div>
	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the image and insert it inside the modal - use its "alt" text as a caption
		var img = document.getElementById('myImg');
		var modalImg = document.getElementById("img01");
		var captionText = document.getElementById("caption");
		img.onclick = function() {
			modal.style.display = "block";
			modalImg.src = this.src;
			captionText.innerHTML = this.alt;
		}

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}
	</script>
</body>
</html>