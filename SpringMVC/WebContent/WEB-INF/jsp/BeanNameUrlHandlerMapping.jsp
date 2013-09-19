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
In Spring MVC, BeanNameUrlHandlerMapping is the default handler mapping mechanism, which maps URL requests to the name of the beans. For example,

&lt;beans ...&gt;
 
   &lt;bean 
	class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/&gt;
 
   &lt;bean name="/welcome.htm" 
        class="com.mkyong.common.controller.WelcomeController" /&gt;
 
   &lt;bean name="/streetName.htm" 
        class="com.mkyong.common.controller.StreetNameController" /&gt;
 
   &lt;bean name="/process*.htm" 
        class="com.mkyong.common.controller.ProcessController" /&gt;
 
&lt;/beans&gt;

In above example, If URI pattern

    /welcome.htm is requested, DispatcherServlet will forward the request to the “WelcomeController“.
    /streetName.htm is requested, DispatcherServlet will forward the request to the “StreetNameController“.
    /processCreditCard.htm or /process{any thing}.htm is requested, DispatcherServlet will forward the request to the “ProcessController“.

Note
Additionally, this mapping is support Ant style regex pattern match, see this AntPathMatcher javadoc for details.

Actually, declare BeanNameUrlHandlerMapping is optional, by default, if Spring can’t found handler mapping, the DispatcherServlet will creates a BeanNameUrlHandlerMapping automatically.

So, the above web.xml file is equivalence to the following web.xml:

&lt;beans ...&gt;
 
   &lt;bean name="/welcome.htm" 
            class="com.mkyong.common.controller.WelcomeController" /&gt;
 
   &lt;bean name="/streetName.htm" 
            class="com.mkyong.common.controller.StreetNameController" /&gt;
 
   &lt;bean name="/process*.htm" 
            class="com.mkyong.common.controller.ProcessController" /&gt;
 
&lt;/beans&gt;
</pre>
</body>
</html>