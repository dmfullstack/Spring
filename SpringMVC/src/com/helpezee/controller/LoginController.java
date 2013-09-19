package com.helpezee.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.i18n.*;
import javax.servlet.*;

import com.helpezee.beans.Login;


@Controller
@SessionAttributes
public class LoginController {

@Autowired
public LocaleChangeInterceptor local;
public HttpRequestHandlerServlet request;

@ModelAttribute("Login")
private Login populateForm()
{
Login login= new Login();
	return login;
}
	
@RequestMapping("/login") // The @RequestMapping annotation tells Spring that this Controller should process all requests beginning with /login in the URL path. That includes /login/* and /login.html.
public ModelAndView LoadLoginPage()
{
String welcome="Namasthe";
return new ModelAndView("login","welcome",welcome);
}

@RequestMapping(method= RequestMethod.POST,value="/validateUser")
public ModelAndView validateUser(@ModelAttribute("Login")Login login,BindingResult error){ //This will binds the data from request to the object
	System.out.println("username---"+login.getUsername());
	System.out.println("password---"+login.getPassword());
	if(login.getUsername()!=null && !login.getUsername().equals("")&& login.getPassword()!=null && !login.getPassword().equals(""))
	{
	return new ModelAndView("home");
	}
	return new ModelAndView("login");
	
	
}


}

/*
Note that we have annotated the HelloWorldController class with @Controller and @RequestMapping("/hello") 
on line 7 and 10. When Spring scans our package, it will recognize this bean as being a Controller bean 
for processing requests. The @RequestMapping annotation tells Spring that this Controller should process 
all requests beginning with /hello in the URL path. That includes /hello/* and /hello.html.

The helloWorld() method returns ModelAndView object. The ModelAndView object tries to resolve to a 
view named “hello” and the data model is being passed back to the browser so we can access the data within 
the JSP. The logical view name will resolve to "/WEB-INF/jsp/hello.jsp". 
We will discuss this shortly how the logical name “hello” which is return in ModelAndView object is mapped 
to path /WEB-INF/jsp/hello.jsp.

The ModelAndView object also contains a message with key “message” and value “Hello World, Spring 3.0!”.
 This is the data that we are passing to our view. Normally this will be a value object in form of java bean 
 that will contain the data to be displayed on our view. Here we are simply passing a string.
 
 We will use class org.springframework.context.support.ReloadableResourceBundleMessageSource to define the 
 message resources.

Also, note that we will provide a feature where user will be able to select language for the application.
 This is implemented by using org.springframework.web.servlet.i18n.LocaleChangeInterceptor class. 
 The LocaleChangeInterceptor class will intercept any changes in the locale. 
 These changes are then saved in cookies for future request. 
 org.springframework.web.servlet.i18n.CookieLocaleResolver class will be used to store the locale changes 
 in cookies.
*/