<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Painting Service SUCCESS</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/chartStyle.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
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
	background: url('images/metal.jpg') no-repeat center center fixed;
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
			<div class="col-xs-12 col-md-4">
				<img alt="" style="border-radius: 40px; padding: 20px; max-height: 300; max-width: 300px" src="images/Success.png">
			</div>
			<div class="col-xs-12 col-md-8 centered text-center" style="padding-top: 30px">
				<h1 style="color: white;">You made successful click!</h1>
			</div>
		</div>
	</div>
</body>
</html>