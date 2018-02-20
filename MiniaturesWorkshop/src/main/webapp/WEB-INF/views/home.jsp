<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<title>Artist.Yaroslav Miniatures</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet">
<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/normalize.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/animate.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/templatemo_misc.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/templatemo_style.css' />" rel="stylesheet"></link>
<script type="text/javascript"> <%@include file="/static/js/vendor/modernizr-2.6.2.min.js"%></script>

<body>
	<!--[if lt IE 7]>
    <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
    <![endif]-->

	<div class="bg-overlay"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-sm-12">
				<div class="sidebar-menu">
					<div class="logo-wrapper">
						<h1 class="logo">
							<a rel="homePage" href="<c:url value='/home' />"> <img src="<c:url value='/static/images/logo.png'/>" alt="Circle Template"> 
								<span>artist.yaroslav</span></a>
						</h1>
					</div>
					<div class="menu-wrapper">
						<ul class="menu">
							<li><a class="show-1" href="#">About me</a></li>
							<li><a  href="<c:url value='/makeOrder' />">Commisions</a></li>
							<li><a class="show-2" href="#">Tutorials</a></li>
							<li><a class="show-3" href="#">Gallery</a></li>
							<li><a class="show-4" href="#" onclick="runGoogleMap();">Contacts</a></li>
							<li><a rel="instagram" href="https://www.instagram.com/artist.yaroslav/">My Instagram</a></li>
						</ul>
						<!-- /.menu -->
						<a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
					</div>
					<!-- /.menu-wrapper -->
				</div>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-8 col-sm-12">
				<div id="menu-container">
					<div id="menu-1" class="about content">
						<div class="row">
							<ul class="tabs">
								<li class="col-md-4 col-sm-4"><a href="#tab1"
									class="icon-item"> <i class="fa fa-umbrella"></i>
								</a> <!-- /.icon-item --></li>
								<li class="col-md-4 col-sm-4"><a href="#tab2"
									class="icon-item"> <i class="fa fa-camera"></i>
								</a> <!-- /.icon-item --></li>
								<li class="col-md-4 col-sm-4"><a href="#tab3"
									class="icon-item"> <i class="fa fa-coffee"></i>
								</a> <!-- /.icon-item --></li>
							</ul>
							<!-- /.tabs -->
							<div class="col-md-12 col-sm-12">
								<div class="toggle-content text-center" id="tab1">
									<h3>About me</h3>
									<p>
										text here
									</p>
								</div>

								<div class="toggle-content text-center" id="tab2">
									<h3>What I Do</h3>
									<p>
										text here
									</p>
								</div>

								<div class="toggle-content text-center" id="tab3">
									<h3>My Team</h3>
									<p>
										text here
									</p>
								</div>
							</div>
							<!-- /.col-md-12 -->
						</div>
						<!-- /.row -->

						<div class="row">
							<div class="col-md-4 col-sm-4">
								<div class="member-item">
									<div class="thumb">
										<img src="<c:url value='/static/images/team/member-1.JPG'/>" alt="Workplace">
									</div>
									<h4>Workplace</h4>
									<span>sometext</span>
								</div>
								<!-- /.member-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-sm-4">
								<div class="member-item">
									<div class="thumb">
										<img src="<c:url value='/static/images/team/member-2.JPG'/>" alt="Workplace">
									</div>
									<h4>Workplace</h4>
									<span>sometext</span>
								</div>
								<!-- /.member-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-sm-4">
								<div class="member-item">
									<div class="thumb">
										<img src="<c:url value='/static/images/team/member-3.JPG'/>" alt="Workplace">
									</div>
									<h4>Workplace</h4>
									<span>sometext</span>
								</div>
								<!-- /.member-item -->
							</div>
							<!-- /.col-md-4 -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.about -->

					<div id="menu-2" class="services content">
						<div class="row">
							<ul class="tabs">
								<li class="col-md-4 col-sm-4"><a href="#tab4"
									class="icon-item"> <i class="fa fa-cogs"></i>
								</a> <!-- /.icon-item --></li>
								<li class="col-md-4 col-sm-4"><a href="#tab5"
									class="icon-item"> <i class="fa fa-leaf"></i>
								</a> <!-- /.icon-item --></li>
								<li class="col-md-4 col-sm-4"><a href="#tab6"
									class="icon-item"> <i class="fa fa-users"></i>
								</a> <!-- /.icon-item --></li>
							</ul>
							<!-- /.tabs -->
							<div class="col-md-12 col-sm-12">
								<div class="toggle-content text-center" id="tab4">
									<h3>text here</h3>
									<p>
										text here
									</p>
								</div>

								<div class="toggle-content text-center" id="tab5">
									<h3>text here</h3>
									<p>
										text here
									</p>
								</div>

								<div class="toggle-content text-center" id="tab6">
									<h3>text here</h3>
									<p>
										text here
									</p>
								</div>
							</div>
							<!-- /.col-md-12 -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.services -->

					<div id="menu-3" class="gallery content">
						<div class="row">

							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g1.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g1.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g2.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g2.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g3.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g3.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g4.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g4.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g5.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g5.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g6.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g6.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g7.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g7.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g8.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g8.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->
							<div class="col-md-4 col-ms-6">
								<div class="g-item">
									<img src="<c:url value='/static/images/gallery/g9.jpg'/>" alt=""> <a
										data-rel="lightbox" class="overlay"
										href="<c:url value='/static/images/gallery/g9.jpg'/>"> <span>+</span>
									</a>
								</div>
								<!-- /.g-item -->
							</div>
							<!-- /.col-md-4 -->

						</div>
						<!-- /.row -->
					</div>
					<!-- /.gallery -->

					<div id="menu-4" class="contact content">
						<div class="row">

							<div class="col-md-12">
								<div class="toggle-content text-center spacing">
									<h3>Contact me</h3>
									<p>
										text here
									</p>
								</div>
							</div>
							<!-- /.col-md-12 -->

							<div class="col-md-12">
								<div class="google-map" id="map"></div>
								<!-- /.google-map -->
							</div>
							<!-- /.col-md-12 -->

							<div class="col-md-12">
								<div class="contact-form">
									<div class="row">
										<form action="MailSender" method="get">
											<fieldset class="col-md-4">
												<input required='required_field' id="name" type="text" name="name" placeholder="Name">
											</fieldset>
											<fieldset class="col-md-4">
												<input required='required_field' type="email" name="email" id="email"
													placeholder="Email">
											</fieldset>
											<fieldset class="col-md-4">
												<input required='required_field' type="text" name="subject" id="subject"
													placeholder="Subject">
											</fieldset>
											<fieldset class="col-md-12">
												<textarea required='required_field' name="message" id="message" placeholder="Message"></textarea>
											</fieldset>
											<fieldset class="col-md-12">
												<input type="submit" name="send" value="Send Message"
													id="submit" class="button">
											</fieldset>
										</form>
									</div>
									<!-- /.row -->
								</div>
								<!-- /.contact-form -->
							</div>
							<!-- /.col-md-12 -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.contact -->

				</div>
				<!-- /#menu-container -->

			</div>
			<!-- /.col-md-8 -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 footer">
				<p id="footer-text">
					Copyright artist.yaroslav <a href="#"></a> | Photos by <a
						rel="nofollow" href="http://unsplash.com">Yaroslav Dmitriev</a>
				</p>
			</div>
			<!-- /.footer -->
		</div>
	</div>
	<!-- /.container-fluid -->

	<script type="text/javascript"> <%@include file="/static/js/vendor/jquery-1.10.1.min.js"%> </script>
	<script>window.jQuery|| document.write('<script src="/static/js/vendor/jquery-1.10.1.min.js"><\/script>')</script> 
	<script type="text/javascript"> <%@include file="/static/js/jquery.easing-1.3.js"%> </script>
	<script type="text/javascript"> <%@include file="/static/js/bootstrap.js"%></script> 
	<script type="text/javascript"> <%@include file="/static/js/plugins.js"%> </script>
	<script type="text/javascript"> <%@include file="/static/js/main.js"%> </script>
	<script src="<c:url value='/static/js/jquery.jquery.js'/>"></script>
	<script src="<c:url value='/static/js/jquery.backstretch.js'/>"></script>
    <script type="text/javascript">
            
    $.backstretch([
    	  "<c:url value='/static/images/b1.JPG'/>",
    	  "<c:url value='/static/images/b2.JPG'/>",
    	  "<c:url value='/static/images/b3.JPG'/>",
    	  "<c:url value='/static/images/b4.JPG'/>",
    	  "<c:url value='/static/images/b5.JPG'/>",
    	  "<c:url value='/static/images/b6.JPG'/>",
    	  "<c:url value='/static/images/b7.JPG'/>"
    	], {
    	    fade: 750,
    	    duration: 4000
    	});
            
    </script>
    
    	<!-- Google Map -->

    <script>
    function initMap() {
        var myLoc = {lat: 53.914354, lng:  27.583466};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: myLoc
        });
        var marker = new google.maps.Marker({
          position: myLoc,
          map: map
          
        });
      }
    	function runGoogleMap(){
		  var script = document.createElement('script');
		  script.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDcuOVWVdBPyFjAGRG2Ane1cSCuquZgc_w&callback=initMap";
		  script.async = false; 
		  document.head.appendChild(script);
			}
	</script>
</head>

</body>
</html>