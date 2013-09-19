<pre>
 Spring MVC SimpleUrlHandlerMapping example

In Spring MVC application, the SimpleUrlHandlerMapping is the most flexible handler mapping class, 
which allow developer to specify the mapping of URL pattern and handlers explicitly.

The SimpleUrlHandlerMapping can be declared in two ways.
1. Method 1 – prop key

The property keys are the URL patterns while the property values are the handler IDs or names.

&lt;beans ...&gt;
 
	&lt;bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"&gt;
	   &lt;property name="mappings"&gt;
		&lt;props&gt;
		   &lt;prop key="/welcome.htm"&gt;welcomeController&lt;/prop&gt;
		   &lt;prop key="/*/welcome.htm"&gt;welcomeController&lt;/prop&gt;
		   &lt;prop key="/helloGuest.htm"&gt;helloGuestController&lt;/prop&gt;
		 &lt;/props&gt;
	   &lt;/property&gt;
	&lt;/bean&gt;
 
	&lt;bean id="welcomeController" 
		class="com.mkyong.common.controller.WelcomeController" /&gt;
 
	&lt;bean id="helloGuestController" 
		class="com.mkyong.common.controller.HelloGuestController" /&gt;
 
&lt;/beans&gt;

2. Method 1 – value

The left side are the URL patterns while the right side are the handler IDs or names, separate by a equal symbol “=”.

&lt;beans ...&gt;
 
	&lt;bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"&gt;
	   &lt;property name="mappings"&gt;
		&lt;value&gt;
		   /welcome.htm=welcomeController
		   /*/welcome.htm=welcomeController
		   /helloGuest.htm=helloGuestController
		&lt;/value&gt;
	   &lt;/property&gt;
	&lt;/bean&gt;
 
	&lt;bean id="welcomeController" 
		class="com.mkyong.common.controller.WelcomeController" /&gt;
 
	&lt;bean id="helloGuestController" 
		class="com.mkyong.common.controller.HelloGuestController" /&gt;
 
&lt;/beans&gt;

3. Demo

Both are defined the same handler mappings.

    /welcome.htm –> welcomeController.
    /{anything}/welcome.htm –> w&gt;lcomeController.
    /helloGuest.htm –> helloGuestController.
    </pre>