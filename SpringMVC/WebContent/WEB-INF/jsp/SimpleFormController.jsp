<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration Page</title>
<link  rel="stylesheet" style="text/css"  href="./css/style.css">
</head>
<body>

<form:form method="POST" commandName="user1">
<table>
    <tr>
        <td>User Name :</td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td>Gender :</td>
        <td>
        	<form:radiobutton path="gender" value="M" label="M" /> 
            <form:radiobutton path="gender" value="F" label="F" />
        </td>
    </tr>
    <tr>
        <td>Country :</td>
        <td>
        <form:select path="country">
            <form:option value="0" label="Select" />
            <form:option value="1" label="India" />
            <form:option value="2" label="USA" />
            <form:option value="3" label="UK" />
        </form:select></td>
    </tr>
    <tr>
        <td>About you :</td>
        <td><form:textarea path="aboutYou" /></td>
    </tr>
    <tr>
        <td>Community :</td>
        <td>
        	<form:checkbox path="community" value="Spring" label="Spring" /> 
        	<form:checkbox path="community" value="Hibernate" abel="Hibernate" /> 
            <form:checkbox path="community" value="Struts" label="Struts" />
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
        <form:checkbox path="mailingList" label="Would you like to join our mailinglist?" /></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit"></td>
    </tr>
    <tr><td colspan="2">
    <pre>
    
   <span class="headline"> Controller Example</span>
    
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.vaannila.domain.User;
import com.vaannila.service.UserService;

@SuppressWarnings("deprecation")
public class UserController extends SimpleFormController {

	private UserService userService;

	<span class="backgroundyellow">public UserController()	{
		setCommandClass(User.class);
		setCommandName("user");
	}</span>
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	<span class="backgroundyellow">protected ModelAndView onSubmit(Object command) throws Exception {</span>
	
	or 
	
      <span class="backgroundyellow">protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response,Object command,BindException errors)
	{
	</span>
	
		User user = (User) command;
		userService.add(user);
		return new ModelAndView("userSuccess","user",user);
	}
	
}

<b>Bean Entry</b>

&lt;bean id="userService" class="com.helpezee.dao.UserServiceImpl" /&gt;
&lt;bean  class="com.helpezee.controller.SimpleHandlerController" &gt;
&lt;property name="userService" ref="userService"/&gt;
<span class="backgroundyellow">&lt;property name="formView" value="userForm1"/&gt;
&lt;property name="successView" value="userSuccess"/&gt;</span>
&lt;/bean&gt;

    </pre>
    
    </td></tr>
</table>
</form:form>

</body>
</html>