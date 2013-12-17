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
In Spring framework, you can wire beans automatically with auto-wiring feature.
 To enable it, just define the "autowire" attribute in <bean>.

	&lt;bean id="customer" class="com.mkyong.common.Customer" autowire="byName" />

In Spring, 5 Auto-wiring modes are supported.

    no - Default, no auto wiring, set it manually via "ref" attribute
    byName - Auto wiring by property name. If the name of a bean is same as the name of other bean property, auto wire it.
    byType - Auto wiring by property data type. If data type of a bean is compatible with the data type of other bean property, auto wire it.
    constructor - byType mode in constructor argument.
    autodetect - If a default constructor is found, use "autowired by constructor"; Otherwise, use "autowire byType".

Examples

A Customer and Person object for auto wiring demonstration.

package com.mkyong.common;
 
public class Customer 
{
	private Person person;
 
	public Customer(Person person) {
		this.person = person;
	}
 
	public void setPerson(Person person) {
		this.person = person;
	}
	//...
}

package com.mkyong.common;
 
public class Person 
{
	//...
}

<span class="headline">1. Auto-Wiring 'no'</span>

This is the default mode, you need to wire your bean via 'ref' attribute.

	&lt;bean id="customer" class="com.mkyong.common.Customer"&gt;
                  &lt;property name="person" ref="person" /&gt;
	&lt;/bean&gt;
 
	&lt;bean id="person" class="com.mkyong.common.Person" /&gt;

<span class="headline">2. Auto-Wiring 'byName'</span>

Auto-wire a bean by property name. In this case, since the name of "person" bean is same with the name of 
the "customer" bean's property ("person"), so, Spring will auto wired it via 
setter method - "setPerson(Person person)".

	&lt;bean id="customer" class="com.mkyong.common.Customer" autowire="byName" /&gt;
 
	&lt;bean id="person" class="com.mkyong.common.Person" /&gt;



<span class="headline">3. Auto-Wiring 'byType'</span>

Auto-wire a bean by property data type. In this case, since the data type of "person" bean is same as the 
data type of the "customer" bean's property (Person object), so, Spring will auto wired it via 
setter method - "setPerson(Person person)".

	&lt;bean id="customer" class="com.mkyong.common.Customer" autowire="byType" /&gt;
 
	&lt;bean id="person" class="com.mkyong.common.Person" /&gt;



<span class="headline">4. Auto-Wiring 'constructor'</span>

Auto-wire a bean by property data type in constructor argument. In this case, since the data 
type of "person" bean is same as the constructor argument data type in "customer" bean's property
 (Person object), so, Spring auto wired it via constructor method - "public Customer(Person person)".

	&lt;bean id="customer" class="com.mkyong.common.Customer" autowire="constructor" /&gt;
 
	&lt;bean id="person" class="com.mkyong.common.Person" /&gt;


<span class="headline"> 5. Auto-Wiring 'autodetect'</span>

If a default constructor is found, uses "constructor"; Otherwise, uses "byType". 
In this case, since there is a default constructor in "Customer" class, so, Spring auto wired it 
via constructor method - "public Customer(Person person)".

	&lt;bean id="customer" class="com.mkyong.common.Customer" autowire="autodetect" /&gt;
 
	&lt;bean id="person" class="com.mkyong.common.Person" /&gt;


<span class="headline">Note</span>

It's always good to combine both 'auto-wire' and 'dependency-check' together, to make sure the property 
is always auto-wire successfully.

	&lt;bean id="customer" class="com.mkyong.common.Customer" 
			autowire="autodetect" dependency-check="objects /&gt;
 
	&lt;bean id="person" class="com.mkyong.common.Person" /&gt;

<span class="headline">Conclusion</span>

In my view, Spring 'auto-wiring' make development faster with great costs - 
it added complexity for the entire bean configuration file, and you don't even know which bean will 
auto wired in which bean.

In practice, i rather wire it manually, it is always clean and work perfectly, 
or better uses @Autowired annotation, which is more flexible and recommended.


</pre>
</body>
</html>