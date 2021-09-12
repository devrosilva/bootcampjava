<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Authors List</title>
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
			crossorigin="anonymous">
	</head>
	<h1 class="text-center">Register Author</h1>
	<body class="container">
		<!-- Name attribute is used at java classes to capture values sent through the form. -->
		<form action="<c:url value="library"/>" method="POST">
			<div class="form-group">
				<label for="name">Name</label>
				<input class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input type="email" class="form-control" id="email" name="email" placeholder="email@company.com">
			</div>
			<div class="form-group">
				<label for="birthday">Birthday</label>
				<input type="date" id="birthday" class="form-control" name="birthday">
			</div>
			<div class="form-group">
				<label for="resume">Resume</label>
				<input id="resume" class="form-control" name="resume">
			</div>
			<input type="submit" value="save" class="mt-2 btn-primary">
		</form>
	
		<h1 class="text-center">Authors List</h1>
		<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Birthday</th>
					<th scope="col">Resume</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${authors}" var="author">
				<tr>
					<td>${author.name}</td>
					<td>${author.email}</td>
					<td>${author.birthday}</td>
					<td>${author.resume}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>