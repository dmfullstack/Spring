<html>
<head>
<link rel="stylesheet" style="text/css" href="./css/style.css">
</head>
<body>
	<h2>ResultForm.jsp</h2>
 
	<table>
		<tr>
			<td>UserName :</td>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>Remark :</td>
			<td>${user.remark}</td>
		</tr>
	</table>
 <pre>
 <span class="headline"> AbstractWizardFormController</span>
 
<span class="backgroundyellow"> public class UserController extends AbstractWizardFormController{</span>
	 
	<span class="backgroundyellow">public UserController(){
		setCommandName("userForm");
	}</span>
 
	@Override
	<span class="backgroundyellow">protected Object formBackingObject(HttpServletRequest request)
		throws Exception {</span>
 
		return new User();
	}
	@Override
	<span class="backgroundyellow">protected ModelAndView processFinish(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {</span>
 
		//Get the data from command object
		User user = (User)command;
		System.out.println(user);
 
		//where is the finish page?
		return new ModelAndView("ResultForm", "user", user);
	}
 
	@Override
	<span class="backgroundyellow">protected ModelAndView processCancel(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {</span>
 
		//where is the cancel page?
		return new ModelAndView("WelcomePage");
	}
	
	<span class="backgroundyellow">protected void validatePage(Object command, Errors errors, int page) {</span>
		 
		UserValidator validator = (UserValidator) getValidator();
 
		//page is 0-indexed
		switch (page) {
		   case 0: //if page 1 , go validate with validatePage1Form
			validator.validatePage1Form(command, errors);
			break;
		   case 1: //if page 2 , go validate with validatePage2Form
			validator.validatePage2Form(command, errors);
			break;
		   case 2: //if page 3 , go validate with validatePage3Form
			validator.validatePage3Form(command, errors);
			break;
		}
	}
}
 
 &lt;bean class="com.helpezee.controller.UserController" &gt;
    	   &lt;property name="pages"&gt;
		&lt;list&gt;
		&lt;!-- follow sequence --&gt;
		&lt;value&gt;Page1Form&lt;/value&gt; &lt;!-- page1, _target0 --&gt;
		&lt;value&gt;Page2Form&lt;/value&gt; &lt;!-- page2, _target1 --&gt;
		&lt;value&gt;Page3Form&lt;/value&gt; &lt;!-- page3, _target2 --&gt;
		&lt;/list&gt;
	   &lt;/property&gt;
	   &lt;property name="validator"&gt;
		&lt;bean class="com.helpezee.validators.UserValidator" /&gt;
	   &lt;/property&gt;
       &lt;/bean&gt;
 
 
 </pre>
</body>
</html>