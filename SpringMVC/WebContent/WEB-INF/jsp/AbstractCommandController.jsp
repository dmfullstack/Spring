<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="./css/style.css">
</head>
<body>
<pre>
<span class="headline">AbstractCommandController</span>

If you want to process request parameters in the controller, then instead of 
using servlet classes to get request parameters in Abstract controller
based controller, you can use AbstractCommandController which has the ability 
to auto populate request parameters to the data object which is also termed as 
command object in spring. This controller also offers feature to validate the 
request parameters.

<span class="backgroundyellow">public class AbstCommandController  extends AbstractCommandController{</span>

	<span class="backgroundyellow">public AbstCommandController(){
		setCommandClass(User1.class);
		setCommandName("User1");
	}</span>
	
	private User1 user;
	
	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	@Override
	<span class="backgroundyellow">protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errrors)
			throws Exception {</span>
		// TODO Auto-generated method stub
		return new ModelAndView("ABSCommandController","User1",user);
	}

}
</pre>
</body>
</html>