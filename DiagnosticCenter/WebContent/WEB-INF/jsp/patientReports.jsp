<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Patient Report</h1>

<table>
<tr>
	<th>Patient Name</th>
	<th>Age</th>
	<th>Gender</th>
</tr>




<c:forEach var="pat" items="${reports}">

<tr>
<td>${pat.firstName }</td>
<td>${pat.age}</td>
<td>${pat.gender}</td>
</tr>

</c:forEach>

</table>
</body>
</html>