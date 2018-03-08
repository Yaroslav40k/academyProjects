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
		<table id="cart" class="table table-hover table-condensed">
			<tbody>
				<tr>
					<td data-th="Manufacturer">
						<div class="row">
							<div class="col-xs-12 col-md-4">
								<img alt="" style="border-radius: 20px" src="<%=request.getContextPath()%>/static/images/me.jpg">
							</div>
							<div class="col-xs-12 col-md-8">
								<p style="color: white;">
									Hello, my name is <strong>Yaroslav</strong> (aka Jarek or Ярослав) and I live in Minsk, Belarus.<strong> I'm professional miniature painter. </strong>My journey with miniatures start probably
									in childhood where I was building model kits, mostly planes and tanks. During long time of my life I worked as a professional graphic designer, web designer and also as a professional
									miniature painter.
								</p>
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

		<div class="row">
			<p style="color: white;">
				<strong>My "Best Army" awards (total of 32 in 2018)</strong> <br> 1.Call to Arms ( Moscow 2008) – Chaos Space Marines (Best Army)<br> 2.Generals 8 (Moscow 2009) – Black Templars (Best
				Army)<br> 3.Summer Blood ( Minsk 2009) - Chaos Space Marines (Best Army)<br> 4.Generals 9 (Moscow 2009) – Chaos Space Marines (Best Army)<br> 5.Flames of Independence (Kyiv 2010) –
				Sisters of Battle (Best Army)<br> 6.Russia Open (Moscow 2010) - Space Wolves (Best Army)<br> 7.Second Chance (Vitebsk 2010) – Chaos Space Marines (Best Army)<br> 8.Generals 11
				(Moscow 2010) – Necrons (Best Army)<br> 9.Burning Autumn (Voronezh 2010) – Space Wolves (Best Army)<br> 10.RoE mk 2 (Moscow 2010) – Eldar (Best Army)<br> 11.Vox Nova (Moscow 2011) -
				Space Wolves (Best Army)<br> 12.Iron Gears (Minsk 2011) –TrollBloods (Hordes) (Best Army)<br> 13.Winter Assault (Moscow 2011) - Space Wolves (Best Army)<br> 14.Armageddon Guardians
				(2011) Black Templars (Best Army)<br> 15.Summer Appeal 2011 (Minsk 2011) –Khador (Hordes) (Best Army)<br> 16.DMP (Warsaw 2012) - Imperial Guard
				(Best Army)<br> 17.Avalon Fogs (Zelenograd 2012) - Space Marines (Best Army)<br> 18.European Single Champinship (Gorzów Wielkopolski 2012) – Necrons (Best Army)<br> 19.Renaissance
				(Vladivostok 2012) - Grey Knights (Best Army)<br> 20.Minskая Autumn 2012 (Minsk 2012) - Chaos Space Marines Iron Warriors (Best Army)<br> 21.Minsk Winter 2013 (Minsk 2013) - Dark Eldar
				(Best Army)<br> 22.Marсh fields (Vitebsk 2013) Dark Angels (Best Army)<br> 23.Russia Team Championship (Moscow 2013) (Total BEST PAINT)<br> 24.ReUnion2 (Moscow 2013) Tyranids (Best
				Army)<br> 25.The Awakening Team Championship (Moscow 2014) (Total BEST PAINT)<br> 26.The Union Single Championship (Moscow 2014) High Elves (FB) (Best Army)<br> 27.The Union Team
				Championship (Moscow 2014) Empire (FB) (Best Army)<br> 28 Severe Tournament (St. Petersburg 2015) Empire (FB) (Best Army)<br> 29.Russia Open (Moscow 2017) Chaos Daemons (40к) (Best
				Army)<br>30.White Rabbit (Minsk 2017) Eldar (40к) (Best Army)<br> 31.Brothers in Arms (Moscow 2017) Eldar (40к) (Best Army)<br> 32.OldSchool (Moscow 2018) Chaos daemons (40к) (Best Army)<br>
				33.CoolDown (Moscow 2018) High Elves (FB) (Best Army)<br>
			</p>
		</div>
	</div>
</body>
</html>