<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h2>You have applied successfully</h2>
<table bgcolor="skyblue">
	<tr>
		<td>User Name :</td>
		<td>${modelDataToRender.userName}</td>
	</tr>
	<tr>
		<td>Address :</td>
		<td>${modelDataToRender.address}</td>
	</tr>
	<tr>
		<td>Sex :</td>
		<td>${modelDataToRender.sex}</td>
	</tr>
	<tr>
		<td>Selected Plan :</td>
		<td>${modelDataToRender.plan}</td>
	</tr>
	<tr>
		<td>Selected Options :</td>
		<td><c:forEach items="${modelDataToRender.options}" var="opt">                 { <c:out
				value="${opt}" /> }                 </c:forEach></td>
	</tr>
</table>
<a
	href="http://localhost:8080/Spring_SimpleFormController/fillFormProcess.dev">Click
here to apply again</a>
</body>
</html>