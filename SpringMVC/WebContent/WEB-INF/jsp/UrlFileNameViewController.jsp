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
<span class="headline">UrlFilenameViewController.</span> 

It transforms the virtual path of a URL into a view name and returns the view, 
that's it. It is useful when you don't need any logical operation on request and 
simply wants to redirect to some resource. 
For example, each site has 'Contact Us', 'About Us' pages.
To map those pages UrlFilenameViewController is a good choice


&lt;beans&gt;
	&lt;!--BELOW BEAN CLASS MAPS URL TO PROPER CONTROLLER. CONTROLLER CAN BE UrlFilenameView/MultiAction/SimpleForm etc.		
	 --&gt;
	&lt;bean id="urlHandler" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"&gt;
		&lt;property name="mappings"&gt;
			&lt;map&gt;
				&lt;entry key="/index.do" value="urlFilenameViewController"/&gt;
				&lt;entry key="/About_Us.do" value="urlFilenameViewController"/&gt;
				&lt;entry key="/Contact_Us.do" value="urlFilenameViewController"/&gt;				
			&lt;/map&gt;
		&lt;/property&gt;
	&lt;/bean&gt;	

	&lt;!-- BELOW UrlFileNameViewController maps request to static resource
		e.g. In our case,
			 index.do -&gt; index.jsp
			 About_Us.do -&gt; About_Us.jsp
			 Contact_Us.do -&gt; Contact_Us.jsp
	--&gt;
	<span class="backgroundyellow">
	&lt;bean id="urlFilenameViewController" class="org.springframework.web.servlet.mvc.UrlFilenameViewController"&gt;
		&lt;property name="suffix" value=".jsp" /&gt;
	&lt;/bean> </span>
&lt;/beans>

</pre>
</body>
</html>