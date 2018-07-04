<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Spring MVC Form Handling Example</title>
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
	</div>
</nav>
<div class="container">
	<h1>Add Employee</h1>
	<br/>
	<form id="userForm" class="form-horizontal" action="EmployeeController" method="post" enctype="multipart/form-data">
		<div class="form-group ">
			<label class="col-sm-2 control-label">ID</label>
			<div class="col-sm-10">
			<c:choose>
				<c:when test="${e.id>0}">
					<input id="id" name="id" type="hidden" value="${e.id}"/>
					<input type="text" class="form-control" value="${e.id}" disabled />
				</c:when>
				<c:otherwise>
					<input id="id" name="id" type="hidden" value="${id}"/>
					<input type="text" class="form-control" value="${id}" disabled />
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<input id="name" name="name" placeholder="Name" type="text"
					class="form-control " value="${e.name}" />
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input id="email" name="email" placeholder="Email"
					class="form-control" type="text" value="${e.email}" />
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Phone</label>
			<div class="col-sm-10">
				<input id="phone" name="phone" placeholder="phone"
					class="form-control" type="text" value="${e.phone}" />
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Address</label>
			<div class="col-sm-10">
				<textarea id="address" name="address" placeholder="address"
					class="form-control" rows="5">${e.address}</textarea>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Gender</label>
			<div class="col-sm-10">
				<label class="radio-inline"> <input id="gender" name="gender"
					type="radio" value="Male" ${e.gender=='Male'?'checked':'' }/> Male
				</label> <label class="radio-inline"> <input id="gender" name="gender"
					type="radio" value="Female" ${e.gender=='Female'?'checked':'' }/> Female
				</label> <br />
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">MS</label>
			<div class="col-sm-5">
				<select id="ms" name="ms" class="form-control">
					<option value="" >--- Select ---</option>
					<option value="Single" ${e.ms=='Single'?'selected':'' }>Single</option>
					<option value="Married" ${e.ms=='Married'?'selected':'' }>Married</option>
				</select>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">DOJ</label>
			<div class="col-sm-10">
				<input id="doj" name="doj"
					class="form-control" type="date" value="${e.doj}" />
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Hobbies</label>
			<div class="col-sm-10">
				<label class='checkbox-inline'><input id="sports"
					name="sports" type="checkbox" value="Sports" ${e.sports=='Sports'?'checked':'' }/>
					<label for="sports">Sports</label>
				</label><br>
				<label class='checkbox-inline'><input id="music"
					name="music" type="checkbox" value="Music" ${e.music=='Music'?'checked':'' } />
					<label for="music">Music</label>
				</label><br>
				<label class='checkbox-inline'><input id="traveling"
					name="traveling" type="checkbox" value="Traveling" ${e.traveling=='Traveling'?'checked':'' } />
					<label for="traveling">Traveling</label>
				</label><br>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Java Skills</label>
			<div class="col-sm-5">
				<select id="skills" name="skills" class="form-control"
					multiple="multiple" size="4">
					<c:forTokens items="${e.skills}" delims="," var="s">
						<c:if test="${s=='Hibernate'}">
							<c:set var="hib" value="${s}"></c:set>
						</c:if>
						<c:if test="${s=='Spring'}">
							<c:set var="spr" value="${s}"></c:set>
						</c:if>
						<c:if test="${s=='Struts'}">
							<c:set var="str" value="${s}"></c:set>
						</c:if>
						<c:if test="${s=='JSF'}">
							<c:set var="jsf" value="${s}"></c:set>
						</c:if>
						<c:if test="${s=='Wicket'}">
							<c:set var="wic" value="${s}"></c:set>
						</c:if>
					</c:forTokens>
					<option value="Hibernate" ${hib=='Hibernate'?'selected':''}>Hibernate</option>
					<option value="Spring" ${spr=='Spring'?'selected':''}>Spring</option>
					<option value="Struts" ${str=='Struts'?'selected':''}>Struts</option>
					<option value="JSF" ${jsf=='JSF'?'selected':''}>JSF</option>
					<option value="Wicket" ${wic=='Wicket'?'selected':''}>Wicket</option>
				</select>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-2 control-label">Image</label>
			<div class="col-sm-10">
				<c:if test="${e.image!=null}">
					<img alt="no image found" src='<c:url value="/images/${e.image}"></c:url>' height="75px" width="100px"/>
				</c:if>
				<input type="hidden" name="himg" value="${e.image}" />
				<input id="img" name="img"
					class="form-control" type="file" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" name="btn" class="btn-lg btn-primary pull-right" value="${e.id>0?'Update':'Add'}"/>
			</div>
		</div>
	</form>
</div>
<div class="container">
	<hr>
	<footer>
		<p>&copy; abc.com 2015</p>
	</footer>
</div>
	<script type="text/javascript">
		<%@ include file="../js/jquery.min.js" %>	
		<%@ include file="../js/hello.js" %>	
		<%@ include file="../js/bootstrap.min.js" %>	
	</script>
</body>
</html>