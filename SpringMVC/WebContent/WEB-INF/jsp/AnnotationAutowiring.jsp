<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using autowiring with @Autowired annotations</title>
</head>
<body>
<pre>
<span class="headline">Using autowiring with @Autowired annotations</span>

Apart from the autowiring modes provided in bean configuration file, autowiring can be specified in bean 
classes also using @Autowired annotation. To use @Autowired annotation in bean classes, 
you must first enable the annotation in spring application using below configuration.

<span class="backgroundyellow">&lt;context:annotation-config /&gt;</span>

Same can be acheived using 'AutowiredAnnotationBeanPostProcessor' bean definition in configuration file.

&lt;bean class ="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/&gt;

Now, when annotation configuration has been enables, you are free to autowire bean dependencies using @Autowired,
 the way you like. This is done by three ways:

<span class="headline">1) @Autowired on properties</span>

<span class="backgroundyellow">When @Autowired is used on properties, it is equivalent to autowiring by 'byType' in configuration file.</span>

public class EmployeeBean
{
    @Autowired
    private DepartmentBean departmentBean;
      
    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }
    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }
    //More code
}

<span class="headline">2) @Autowired on property setters</span>

<span class="backgroundyellow">When @Autowired is used on setters, it is also equivalent to autowiring by 'byType' in configuration file.</span>

public class EmployeeBean
{
    private DepartmentBean departmentBean;
      
    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }
     
    @Autowired
    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }
    //More code
}

<span class="headline">3) @Autowired on constructors</span>

<span class="backgroundyellow">When @Autowired is used on bean's constructor, it is also equivalent to autowiring by 'constructor' in configuration file.</span>

	
package com.howtodoinjava.autowire.constructor;
  
public class EmployeeBean
{
    @Autowired
    public EmployeeBean(DepartmentBean departmentBean)
    {
        this.departmentBean = departmentBean;
    }
     
    private DepartmentBean departmentBean;
  
    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }
    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }
    //More code
}
<span class="headline">Using @Qualifier in case of conflict</span>

As we learned that if we are using autowiring in 'byType' mode and dependencies are looked for property class 
types. If no such type is found, an error is thrown. But, what if there are two or more beans for same class type.

In this case spring will not be able to choose correct bean to inject into property, and you will need to help
 the container using qualifiers.

To resolve a specific bean using qualifier, we need to use @Qualifier annotation along with @Autowired annotation and pass the bean name in annotation parameter. Take a look below for example:

	
public class EmployeeBean
{
    @Autowired
    @Qualifier("finance")
    private DepartmentBean departmentBean;
      
    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }
    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }
    //More code
}

where duplicate beans are as below:

	
&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;beans&gt;
    &lt;context:annotation-config /&gt;
      
    &lt;bean id="employee" class="com.howtodoinjava.autowire.constructor.EmployeeBean" autowire="constructor"&gt;
        &lt;property name="fullName" value="Lokesh Gupta"/&gt;
    &lt;/bean&gt;
    &lt;!--First bean of type DepartmentBean--&gt;
    &lt;bean id="humanResource" class="com.howtodoinjava.autowire.constructor.DepartmentBean" &gt;
        &lt;property name="name" value="Human Resource" /&gt;
    &lt;/bean&gt;
     
    &lt;!--Second bean of type DepartmentBean--&gt;
     &lt;bean id="finance"      class="com.howtodoinjava.autowire.constructor.DepartmentBean" &gt;
        &lt;property name="name" value="Finance" /&gt;
    &lt;/bean&gt;
&lt;/beans&gt;
<span class="headline">Making autowiring error safe using required=false</span>

Even if you have used utmost care in autowiring bean dependencies, still you may find strange lookup failures.
So, solve this issue, you will need to make autowiring optional so that if no dependency is found, application 
should not throw any exception and autowiring should simpy be ignored.

This can be done in two ways:

<span class="headline">1)If you want to make specific bean autowiring non-mandatory for a specific bean property, use required="false" attribute in @Autowired annotation</span>

<span class="backgroundyellow">
@Autowired (required=false)
@Qualifier ("finance")</span>
private DepartmentBean departmentBean;

<span class="headline">2) If you want to apply optional autowiring at global level</span> i.e. for all properties in all beans; use below configuration setting.

<span class="backgroundyellow">	
&lt;bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"&gt;
    &lt;property name="requiredParameterValue" value="false" /&gt;
&lt;/bean&gt;
</span>
Excluding a bean from being available for autowiring

By default, autowiring scan and matches all bean definitions in scope. If you want to exclude some bean 
definitions so that they can not be injected through autowiring mode, you can do this using 'autowire-candidate' set to false.

<span class="headline">1) Using 'autowire-candidate' as false totally exclude a bean from being an autowire 
candidate. </span>It totally exclude that specific bean definition from being available 
to the autowiring infrastructure.

	
&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;beans&gt;
    &lt;context:annotation-config /&gt;
      
    &lt;bean id="employee" class="com.howtodoinjava.autowire.constructor.EmployeeBean" autowire="constructor"&gt;
        &lt;property name="fullName" value="Lokesh Gupta"/&gt;
    &lt;/bean&gt;
    &lt;!--Will be available for autowiring--&gt;
    &lt;bean id="humanResource" class="com.howtodoinjava.autowire.constructor.DepartmentBean" &gt;
        &lt;property name="name" value="Human Resource" /&gt;
    &lt;/bean&gt;
     
    &lt;!--Will not participate in autowiring--&gt;
     &lt;bean id="finance"      class="com.howtodoinjava.autowire.constructor.DepartmentBean" <span class="backgroundyellow">autowire-candidate="false"</span>&gt;
        &lt;property name="name" value="Finance" /&gt;
    &lt;/bean&gt;
&lt;/beans&gt;

<span class="headline">2) Another option is to limit autowire candidates based on pattern-matching against 
bean names.</span> The top-level &lt;beans/&gt; element accepts one or more patterns within its 
'default-autowire-candidates' attribute. 

For example, to limit autowire candidate status to any bean whose name ends with 'Impl', 
provide a value of '*Impl'. To provide multiple patterns, define them in a comma-separated list.

	
&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;beans <span class="backgroundyellow">default-autowire-candidates="*Impl,*Dao"</span>&gt;
    &lt;context:annotation-config /&gt;
      
    &lt;bean id="employee" class="com.howtodoinjava.autowire.constructor.EmployeeBean" autowire="constructor"&gt;
        &lt;property name="fullName" value="Lokesh Gupta"/&gt;
    &lt;/bean&gt;
    &lt;!--Will be available for autowiring--&gt;
    &lt;bean id="humanResource" class="com.howtodoinjava.autowire.constructor.DepartmentBean" &gt;
        &lt;property name="name" value="Human Resource" /&gt;
    &lt;/bean&gt;
     
    &lt;!--Will not participate in autowiring--&gt;
     &lt;bean id="finance"      class="com.howtodoinjava.autowire.constructor.DepartmentBean" autowire-candidate="false"&gt;
        &lt;property name="name" value="Finance" /&gt;
    &lt;/bean&gt;
&lt;/beans&gt;

Note that an explicit value of 'true' or 'false' for a bean definition's 'autowire-candidate' attribute 
always takes precedence, and for such beans, the pattern matching rules will not apply.

That's all about autowiring feature available in spring framework. 
</pre>

</body>
</html>