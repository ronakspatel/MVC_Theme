<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	<%@ include file="../css/bootstrap.min.css" %>
	<%@ include file="../css/hello.css" %>
</style>
</head>
<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="IndexController">Home</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="EmployeeController">Add Employee</a></li>
			</ul>
		</div>
	</div>
</nav>
<body>
	<div class="container">
		<h1>All Employee</h1>
		<table class="table table-hover">
			<tr>
				<td>ID</td>
				<td>${e.id}</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${e.name}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${e.email}</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>${e.phone}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${e.address}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${e.gender}</td>
			</tr>
			<tr>
				<td>MS</td>
				<td>${e.ms}</td>
			</tr>
			<tr>
				<td>DOJ</td>
				<td>${e.doj}</td>
			</tr>
			<tr>
				<td>Hobbies</td>
				<td>
					${e.sports}
					<c:if test="${e.sports == 'Sports'}">,</c:if>
					<c:if test="${e.music == 'Music'}">${e.music}</c:if>
					<c:if test="${e.music == 'Music' && e.traveling =='Traveling'}">,</c:if>
					<c:if test="${e.traveling == 'Traveling'}">${e.traveling}</c:if>
				</td>
			</tr>
			<tr>
				<td>Skills</td>
				<td>${e.skills}</td>
			</tr>
			<tr>
				<td>Image</td>
				<td><img src='<c:url value="/images/${e.image}"></c:url>' /></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		<%@ include file="../js/jquery.min.js" %>	
		<%@ include file="../js/hello.js" %>	
		<%@ include file="../js/bootstrap.min.js" %>	
	</script>
</body>
</html>