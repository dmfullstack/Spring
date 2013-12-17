<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
<html>
<head>
<link rel="stylesheet"  href="./css/style.css" style="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<span class="headline">AbstractController</span>

<pre>
public class ABSController extends AbstractController {
	
	<span class="backgroundyellow">protected ModelAndView handleRequestInternal(HttpServletRequest request,</span>
			HttpServletResponse response) throws Exception {
			return new ModelAndView("EmployeeRegistration");
		
		
	}

}

If you want to process request parameters in the controller, then instead of 
using servlet classes to get request parameters in Abstract controller
based controller, you can use AbstractCommandController which has the ability 
to auto populate request parameters to the data object which is also termed as 
command object in spring. This controller also offers feature to validate the 
request parameters
 
</pre>
</body>
</html>