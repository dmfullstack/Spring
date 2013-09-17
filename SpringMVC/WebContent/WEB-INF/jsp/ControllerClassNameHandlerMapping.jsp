<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
In Spring MVC, ControllerClassNameHandlerMapping use convention to map requested URL to Controller (convention over configuration). It takes the Class name, remove the ‘Controller’ suffix if exists and return the remaining text, lower-cased and with a leading “/”.

See following few examples to demonstrate the use of this ControllerClassNameHandlerMapping class.
1. Before and After

By default, Spring MVC is using the BeanNameUrlHandlerMapping handler mapping.

&lt;beans ...&gt;
 
  &lt;bean name="/welcome.htm" 
        class="com.mkyong.common.controller.WelcomeController" /&gt;
 
  &lt;bean name="/helloGuest.htm" 
        class="com.mkyong.common.controller.HelloGuestController" /&gt;
 
&lt;/beans&gt;

To enable the ControllerClassNameHandlerMapping, declared it in the bean configuration file, and now the controller’s bean’s name is no longer required.

&lt;beans ...&gt;
 
  &lt;bean 
   class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping" /&gt;
 
  &lt;bean class="com.mkyong.common.controller.WelcomeController" /&gt;
 
  &lt;bean class="com.mkyong.common.controller.HelloGuestController" /&gt;
 
&lt;/beans&gt;

Now, Spring MVC is mapping the requested URL by following conventions :

WelcomeController -&gt; /welcome*
HelloGuestController -&gt; /helloguest*

    /welcome.htm –&gt; WelcomeController.
    /welcomeHome.htm –&gt; WelcomeController.
    /helloguest.htm –&gt; HelloGuestController.
    /helloguest12345.htm –&gt; HelloGuestController.
    /helloGuest.htm, failed to map /helloguest*, the “g” case is not match.

2. Case sensitive

To solve the case sensitive issue stated above, declared the “caseSensitive” property and set it to true.

&lt;beans ...&gt;
 
  &lt;bean class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping" &gt;
       &lt;property name="caseSensitive" value="true" /&gt;
  &lt;/bean&gt;
 
  &lt;bean class="com.mkyong.common.controller.WelcomeController" /&gt;
 
  &lt;bean class="com.mkyong.common.controller.HelloGuestController" /&gt;
 
&lt;/beans&gt;

Now, Spring MVC is mapping the requested URL by the following conventions :

WelcomeController -&gt; /welcome*
HelloGuestController -&gt; /helloGuest*

    /helloGuest.htm –&gt; HelloGuestController.
    /helloguest.htm, failed to map “/helloGuest*”, the “G” case is not match.

3. pathPrefix

Additionally, you can specify a prefix to maps the requested URL, declared a “pathPrefix” property.

&lt;beans ...&gt;
 
  &lt;bean class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping" &gt;
	 &lt;property name="caseSensitive" value="true" /&gt;
	 &lt;property name="pathPrefix" value="/customer" /&gt;
  &lt;/bean&gt;
 
  &lt;bean class="com.mkyong.common.controller.WelcomeController" /&gt;
 
  &lt;bean class="com.mkyong.common.controller.HelloGuestController" /&gt;
 
&lt;/beans&gt;

Now, Spring MVC is mapping the requested URL by the following conventions :

WelcomeController -&gt; /customer/welcome*
HelloGuestController -&gt; /customer/helloGuest*

    /customer/welcome.htm –&gt; WelcomeController.
    /customer/helloGuest.htm –&gt; HelloGuestController.
    /welcome.htm, failed.
    /helloGuest.htm, failed.
    </pre>
</body>
</html>