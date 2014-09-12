<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table cellpadding="5" cellspacing="3">
	<tr bgcolor="skyblue">
		<th>Employee Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Address</th>
	
	</tr>


  <c:forEach var="emp" items="${emps}">
  
  	<tr bgcolor="silver">
  		<td>${emp.empId}</td>
  		<td>${emp.empName}</td>
  		<td>${emp.salary}</td>
  		<td>${emp.addr}</td>
  	</tr>
  </c:forEach>

</table>

</body>
</html>