<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h4>
			<c:out value="${language.name }"></c:out>
		</h4>
		<h4>
			<c:out value="${language.creator }"></c:out>
		</h4>
		<h4>
			<c:out value="${language.currentVersion }"></c:out>
		</h4>
		<div>
			<a href="/languages/edit/${language.id}">Edit</a>
			<form action="/languages/${language.id}" method="POST">
				<input type="hidden" name="_method" value="DELETE">
				<input type="submit" value="Delete">
			</form>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>