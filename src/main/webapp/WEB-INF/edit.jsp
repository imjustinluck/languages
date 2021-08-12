<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

		<h1>Edit Book</h1>
		<form:form action="/languages/edit/${language.id}" method="POST"
			modelAttribute="language">
			<input type="hidden" name="_method" value="PUT">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator" />
				<form:textarea path="creator" />
			</p>
			<p>
				<form:label path="currentVersion">Current Version</form:label>
				<form:errors path="currentVersion" />
				<form:input path="currentVersion" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>

		<form action="/languages/${language.id}" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="Delete">
		</form>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>