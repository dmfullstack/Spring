<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Hi, Welcome to MultiActionController Example</h1>
    <ul>
<!--        <li><a href="add.html">Add</a><br></li>-->
        <li><a href="remove.html">Remove</a>
        </li>
        <li><a href="listAll.html">ListALL</a>
        </li>
    </ul>
<pre>
Three ways for routing the request a)InternalPathMethodNameResolver b)PropertiesMethodNameResolver c)ParameterMethodNameResolver 	

 &lt;bean id="MultiProcessorController" class="com.helpezee.controller.MultiProcessorController"&gt;
          &lt;property name="methodNameResolver"&gt;
            &lt;bean class="org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver"/&gt;
   		&lt;/property&gt;
   		
   a)<b>InternalPathMethodNameResolver</b>
   
		&lt;property name="methodNameResolver"&gt;
            &lt;bean class="org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver"&gt;
    			&lt;property name="prefix" value="test" /&gt;
   		   		&lt;property name="prefix" value="Customer" /&gt;
	   		&lt;/bean&gt;
	   		&lt;/property&gt;
	   		
	   		
	    add.htm - testaddCustomer()
    	delete.htm - testdeleteCustomer()
    	update.htm - testupdateCustomer()
    	list.htm - testlistCustomer()		
	   		
	   		
	b) <b>PropertiesMethodNameResolver</b>  	
	
	&lt;property name="methodNameResolver"&gt;
    	&lt;bean class="org.springframework.web.servlet.mvc.multiaction.PropertiesMethodNameResolver"&gt;
     		 &lt;property name="mappings"&gt;
				&lt;props&gt;
				  &lt;prop key="/customer/a.htm"&gt;add&lt;/prop&gt;
				  &lt;prop key="/customer/b.htm"&gt;update&lt;/prop&gt;
				  &lt;prop key="/customer/c.htm"&gt;delete&lt;/prop&gt;
				  &lt;prop key="/customer/d.htm"&gt;list&lt;/prop&gt;
				  &lt;prop key="/customer/whatever.htm"&gt;add&lt;/prop&gt;
				&lt;/props&gt;
       		&lt;/property&gt;
     &lt;/bean&gt;
    &lt;/property&gt;
    
     a.htm - add() method
     b.htm - update() method
     c.htm - delete() method
     d.htm - list() method
     whatever.htm - add() method
    
    c) <b>ParameterMethodNameResolver</b>
    
    &lt;property name="methodNameResolver"&gt;
			&lt;bean class="org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver"&gt;
			   &lt;property name="paramName" value="action"/&gt;
			&lt;/bean&gt;
     &lt;/property&gt;
     
     
     *.htm?action=add - add() method
     whatever.htm?action=add - add() method
     *.htm?action=update - update() method
     *.htm?action=delete - delete() method
     *.htm?action=list - list() method
    	
    
        
    &lt;/bean&gt; 


</pre>
     
    
</body>
</html>