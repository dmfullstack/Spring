<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h2>Application form for MTNL Broadband Connection</h2>
<form:form method="POST">
	<table>
		<tr>
			<td>User Name :</td>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:textarea path="address" /></td>
		</tr>
		<tr>
			<td>Sex :</td>
			<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton
				path="sex" value="F" />Female</td>
		</tr>
		<tr>
			<td>Select a Plan :</td>
			<td><form:select path="plan">
				<form:option value="NONE" label="-Select Plan-" />
				<form:options items="${availablePlans}" />
			</form:select></td>
		</tr>
		<tr>
			<td>Other Options :</td>
			<td><form:checkboxes items="${availableOptions}" path="options"
				delimiter="  " /></td>
		</tr>
		<tr>
			<td><input type="submit" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>