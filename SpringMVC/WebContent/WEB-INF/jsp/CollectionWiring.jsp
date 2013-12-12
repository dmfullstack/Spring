<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="left">
<tr>
<td valign="top">
<table border="1" >
<tr><td>LIST: ${collectionsPojo.enrolledCourses}</td></tr>
<tr><td>SET: ${collectionsPojo.enrolledActivities}</td></tr>
<tr><td>MAP: ${collectionsPojo.studentInfoMap}</td></tr>
<tr><td>PROPERTIES: ${collectionsPojo.emailProps}</td></tr>
<tr><td>LIST Objects: ${collectionsPojo.objectList}</td></tr>
</table>
</td>
</tr>
</table>
</body>
</html>