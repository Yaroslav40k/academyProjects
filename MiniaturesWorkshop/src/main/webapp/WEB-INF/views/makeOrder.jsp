<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
			<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Customer </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Nickname</th>
				        <th>Lastname</th>
				        <th>Adress</th>
				        <th>Email</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
					<tr>
						<td>${loggedinuser.firstName}</td>
						<td></td>
						<td>${loggedinuser.lastName}</td>
						<td></td>
						<td>${loggedinuser.email}</td>
					</tr>
	    		</tbody>
	    		
	    		<tbody>
				<c:forEach items="${spaceMarines}" var="spaceMarine">
					<tr>
						<td>${spaceMarine.miniatureName}</td>
						<td></td>
						<td>${spaceMarine.miniatureType}</td>
						<td></td>
						<td>${spaceMarine.miniatureSize}</td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>

		<div class="well lead">Order Form</div>
		
	
	 	<form:form method="POST" modelAttribute="user" class="form-horizontal" oninput="amount.value = (miniaturesCount.value * qualitySelect.value)">
	 
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Miniatures count</label>
					<input id="miniaturesCount" type="number">
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Quality</label>
					 <select id="qualitySelect" name="miniatureType">
					  <option value="5">Low</option>
					  <option value="10">Medium</option>
					  <option value="20">High</option>
					</select> 
				</div>
			</div>
	

			<div class="row">
				<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userProfiles">Average price ($)</label>
					<strong><output name="amount" for="miniaturesCount qualitySelect">0</output></strong>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update Order" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/home' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Make Order" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/home' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
		
		 <a href="<c:url value='/orders/stage1' />">Stage1</a>
	</div>

	
	<script type="text/javascript"> <%@include file="/static/js/vendor/jquery-1.10.1.min.js"%> </script>
	<script src="<c:url value='/static/js/jquery.jquery.js'/>"></script>
	<script src="<c:url value='/static/js/jquery.backstretch.js'/>"></script>
	<script type="text/javascript"> <%@include file="/static/js/main.js"%> </script>
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
</body>
</html>