<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="./css/style.css" style="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello I  a Test Page for Abstract controller

<pre>
public class ABSController extends AbstractController {
	
		
	<span class="backgroundyellow">protected ModelAndView handleRequestInternal(HttpServletRequest request,</span>
			HttpServletResponse response) throws Exception {
			return new ModelAndView("EmployeeRegistration");
		
		
	}

}
</pre>
</body>
</html>