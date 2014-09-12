<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	<h1>Welcome to Login.jsp</h1>

	<form action="validateUser.htm" method="post">

		User Name: <input type="text" name="userName" /> <br> Password: <input
			type="password" name="password" /> <br> Login As<select
			name="role">

			<option>Admin</option>
			<!--  <option>client</option>-->
		</select> <input type="submit" value="Login" />

	</form>
	 ${requestScope.msg}

</body>
</html>