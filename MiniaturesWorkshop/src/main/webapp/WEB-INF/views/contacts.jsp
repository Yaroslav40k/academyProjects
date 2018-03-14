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
			<div id="map" style="width: 100%; height: 400px; border-radius: 20px; padding-bottom: 50px;"></div>
		</div>


		<div class="row">
		<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Find me also at</h2>
			</div>
			<p style="color: white;">
				<br> Facebook: /artist.yaroslav <br> Instagram: /artist.yaroslav<br> VK: /yar_soldat<br> e-mail: 1dmitriev.yaroslav1@gmail.com<br>
			</p>
		</div>

		<div class="row">
		<div class="col-xs-12 col-md-12 col-centered text-center">
				<h2 class="form-signin-heading" style="color: white; font-family: Perpetua Titling MT;">Contact me via this form</h2>
			</div>
			<form action="MailSender" method="get" style="width: 100%">
				<div class="row" style="width: 100%">
					<fieldset class="form-group col-sm-6">
						<input required='required_field' id="name" type="text" name="name" placeholder="Name" style="width: 100%; margin-left: 0em; margin-right: auto;">
					</fieldset>
					<fieldset class="form-group col-sm-6">
						<input required='required_field' type="email" name="email" id="email" placeholder="Email" style="width: 100%; margin-left: auto; margin-right: 0em;">
					</fieldset>
				</div>
				<div class="row">
					<fieldset class="form-group col-sm-12">
						<input required='required_field' type="text" name="subject" id="subject" placeholder="Subject" style="width: 100%">
					</fieldset>
				</div>
				<div class="row">
					<fieldset class="form-group col-sm-12">
						<textarea required='required_field' name="message" id="message" placeholder="Message" style="width: 100%"></textarea>
					</fieldset>
				</div>
				<fieldset class="col-md-12">
					<input type="submit" name="send" value="Send Message" id="submit" class="btn btn-outline-info my-2 my-sm-0">
				</fieldset>
			</form>
		</div>
		<!-- /.row -->
	</div>




	<script>
		function myMap() {
			var location = new google.maps.LatLng(53.914354, 27.583466);
			var mapCanvas = document.getElementById("map");
			var mapOptions = {
				center : location,
				zoom : 5
			};
			var map = new google.maps.Map(mapCanvas, mapOptions);
			var marker = new google.maps.Marker({
				position : location,
				map : map
			});

			var styles = [ {
				"featureType" : "landscape",
				"stylers" : [ {
					"saturation" : -100
				}, {
					"lightness" : 65
				}, {
					"visibility" : "on"
				} ]
			}, {
				"featureType" : "poi",
				"stylers" : [ {
					"saturation" : -100
				}, {
					"lightness" : 51
				}, {
					"visibility" : "simplified"
				} ]
			}, {
				"featureType" : "road.highway",
				"stylers" : [ {
					"saturation" : -100
				}, {
					"visibility" : "simplified"
				} ]
			}, {
				"featureType" : "road.arterial",
				"stylers" : [ {
					"saturation" : -100
				}, {
					"lightness" : 30
				}, {
					"visibility" : "on"
				} ]
			}, {
				"featureType" : "road.local",
				"stylers" : [ {
					"saturation" : -100
				}, {
					"lightness" : 40
				}, {
					"visibility" : "on"
				} ]
			}, {
				"featureType" : "transit",
				"stylers" : [ {
					"saturation" : -100
				}, {
					"visibility" : "simplified"
				} ]
			}, {
				"featureType" : "administrative.province",
				"stylers" : [ {
					"visibility" : "off"
				} ]
			}, {
				"featureType" : "water",
				"elementType" : "labels",
				"stylers" : [ {
					"visibility" : "on"
				}, {
					"lightness" : -25
				}, {
					"saturation" : -100
				} ]
			}, {
				"featureType" : "water",
				"elementType" : "geometry",
				"stylers" : [ {
					"hue" : "#ffff00"
				}, {
					"lightness" : -25
				}, {
					"saturation" : -97
				} ]
			} ];

			map.set('styles', styles);

		}
	</script>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDcuOVWVdBPyFjAGRG2Ane1cSCuquZgc_w&callback=myMap"></script>
</body>
</html>