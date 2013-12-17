<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" style="text/css" href="./css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>

<span class="headline">ParameterizableViewController : </span>

ParameterizableViewController is one of the concrete Spring's Controller. 
This controller returns a view name specified in Spring configuration xml file 
thus eliminates the need of hard coding view name in the controller class 
as in case of AbstractController. 

ParameterizableViewController is used when you don't need to implement any logic in 
controller and just want to redirect to another view.

Consider the following configuration. 
Spring returns a view name by looking the value of property 'viewName' 
of ParameterizableViewController bean. In this case when testController is called, 
this testController (which is ParameterizableViewController) will return view name 
as 'Test'.

<span class="backgroundyellow">	
&lt;bean name="testController"
            class="org.springframework.web.servlet.mvc.ParameterizableViewController"&gt;
        &lt;property name="viewName" value="Test" /&gt;
&lt;/bean&gt;
</span>
</pre>
</body>
</html>