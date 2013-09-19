<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<form:form name="login" commandName="Login"  method="POST" action="validateUser.html">
<table  border="0" align="center">
<tr><td>Themes :</td><td><span style="float: left"><a href="?theme=default">def</a>|<a href="?theme=black">blk</a>|<a href="?theme=blue">blu</a>
</span></td></tr>
<tr> <td>Lang :</td><td>  <span style="float: left"><a href="?lang=en">en</a>|<a href="?lang=de">de</a></span></td></tr>
<tr><td><form:label path="username"><spring:message code="label.username"/></form:label></td><td><form:input path="username"/></td></tr>
<tr><td><form:label path="password"><spring:message code="label.password"/></form:label></td><td><form:input path="password"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="<spring:message code="label.login"/>"/></td></tr>
</table>
</form:form>

</body>
</html>