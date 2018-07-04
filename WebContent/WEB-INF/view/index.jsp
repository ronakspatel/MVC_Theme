<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>MVC Form Handling Example</title>
<style type="text/css">
	<%@ include file="../css/bootstrap.min.css" %>
	<%@ include file="../css/hello.css" %>
</style>
</head>
<nav class="navbar navbar-inverse ">
	<div class="container">
		<!-- <div class="navbar-header">
			<a class="navbar-brand" href="index.html">MVC Form</a>
		</div> -->
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${ls}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.name}</td>
					<td>${e.email}</td>
					<td>${e.phone}</td>
					<td>
						<form action="ActionController" method="post">
							<input type="hidden" name="hid" value="${e.id}"/>
							<input type="submit" name="btn" class="btn btn-info" value="View"/>
							<input type="submit" name="btn" class="btn btn-primary" value="Edit"/>
							<input type="submit" name="btn" class="btn btn-danger" value="Delete"/>					
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<hr>
		<footer>
			<p>&copy; abc.com 2016</p>
		</footer>
	</div>
	<script type="text/javascript">
		<%@ include file="../js/jquery.min.js" %>	
		<%@ include file="../js/hello.js" %>	
		<%@ include file="../js/bootstrap.min.js" %>	
	</script>
</body>
</html>