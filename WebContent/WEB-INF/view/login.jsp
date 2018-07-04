<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	</div>
</nav>
<body>
	<div class="container">
	<h1>Login Here</h1>
	<br />
	<form id="userForm" class="form-horizontal" action="LoginController" method="post">
		<div class="form-group ">
			<label class="col-sm-3 control-label">Name</label>
			<div class="col-sm-5">
				<input id="username" name="username" placeholder="UserName" type="text"
					class="form-control " value="" />
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-3 control-label">Password</label>
			<div class="col-sm-5">
				<input id="password" name="password" placeholder="password"
					class="form-control" type="password" value="" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-3">
				<button type="submit" class="btn-lg btn-primary pull-right">Login</button>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-6 control-label error">${msg}</label>
		</div>
	</form>
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