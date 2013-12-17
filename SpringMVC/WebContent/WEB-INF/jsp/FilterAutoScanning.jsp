<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>

<span class="headline">1. Filter component - include</span>

&lt;context:component-scan base-package="com.mkyong" &gt;
 
		&lt;context:include-filter type="regex" 
                       expression="com.mkyong.customer.dao.*DAO.*" /&gt;
 
		&lt;context:include-filter type="regex" 
                       expression="com.mkyong.customer.services.*Service.*" /&gt;
 
	&lt;/context:component-scan&gt;
	
	

<span class="headline">2. Filter component - exclude</span>


	&lt;context:component-scan base-package="com.mkyong.customer" &gt;
	
		&lt;context:exclude-filter type="annotation" 
			expression="org.springframework.stereotype.Service" /&gt;		
			
			&lt;context:exclude-filter type="regex" 
			expression="com.mkyong.customer.dao.*DAO.*" /&gt;	
			
			&lt;context:exclude-filter type="aspectj" expression="com.test.ws.client.*" /&gt;
	
	&lt;/context:component-scan&gt;
	
	
<span class="headline">Filter Types</span>

<table border="1">
<tr>
<th>Filter Type</th>
<th>Example Expression</th>
<th>Description</th>
</tr>
<tr>
<td>annotation</td>
<td>org.example.SomeAnnotation</td>
<td>An annotation to be present at the type level in target components.</td>
</tr>

<tr>
<td>assignable</td>
<td>org.example.SomeClass</td>
<td>A class (or interface) that the target components are assignable to (extend/implement).</td>

</tr>

<tr>
<td>aspectj</td>
<td>org.example..*Service+</td>
<td>An AspectJ type expression to be matched by the target components.</td>

</tr>

<tr>
<td>regex</td>
<td>org\.example\.Default.*</td>
<td>A regex expression to be matched by the target components' class names.</td>

</tr>

<tr>
<td>custom</td>
<td>org.example.MyCustomTypeFilter</td>
<td> nA custom implementation of the org.springframework.core.type.TypeFilter interface.</td>

</tr>

</table>
	 	
</pre>
</body>
</html>