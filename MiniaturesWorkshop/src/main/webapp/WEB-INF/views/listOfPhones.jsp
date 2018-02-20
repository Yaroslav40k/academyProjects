<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>OWNER_ID</th>
				        <th>AREA CODE</th>
				        <th>PHONE NUMBER</th>
				        <th>TYPE</th>
				        <sec:authorize access="hasRole('MANAGER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('MANAGER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${phones}" var="phone">
					<tr>
						<td>${phone.ownerID}</td>
						<td>${phone.areaCode}</td>
						<td>${phone.phoneNumber}</td>
						<td>${phone.type}</td>
					    <sec:authorize access="hasRole('MANAGER') or hasRole('ADMIN')">
							<td><a href="<c:url value='/phones/edit-phone-${phone.id}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('MANAGER')">
							<td><a href="<c:url value='/phones/delete-phone-${phone.id}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
        				
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
		 	<div class="well">
		 		<a href="<c:url value='/phones/newphone-${ownerID}' />">Add New Phone</a>
		 	</div>
	 	</sec:authorize>
   	</div>
</body>
</html>