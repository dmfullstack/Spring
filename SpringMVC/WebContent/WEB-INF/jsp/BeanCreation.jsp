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
<b><font color="red" >Bean creation via static factory method</font></b>

When defining a bean which is to be created using a static factory method, along with the class attribute 
which specifies the class containing the static factory method, another attribute 
named factory-method is needed to specify the name of the factory method itself. 
Spring expects to be able to call this method (with an optional list of arguments as described later) and 
get back a live object, which from that point on is treated as if it had been created normally 
via a constructor. One use for such a bean definition is to call static factories in legacy code.

Following is an example of a bean definition which specifies that the bean is to be 
created by calling a factory-method. Note that the definition does not specify the type (class) 
of the returned object, only the class containing the factory method. 

In this example, createInstance must be a static method.

&lt;bean id="exampleBean"
      class="examples.ExampleBean2"
      factory-method="createInstance"/&gt;

The mechanism for supplying (optional) arguments to the factory method, or setting properties of the 
object instance after it has been returned from the factory, will be described shortly.

3.2.3.3. Bean creation via instance factory method

Quite similar to using a static factory method to create a bean, is the use of an instance (non-static) 
factory method, where a factory method of an existing bean from the factory is called to create the new bean.

To use this mechanism, the class attribute must be left empty, and the factory-bean attribute must 
specify the name of a bean in the current or an ancestor bean factory which contains the factory method.
 The factory method itself should still be set via the factory-method attribute.

Following is an example:

<!-- The factory bean, which contains a method called
     createInstance -->
&lt;bean id="myFactoryBean"
      class="..."&gt;
  ...
&lt;/bean&gt;
<!-- The bean to be created via the factory bean -->
&lt;bean id="exampleBean"
      factory-bean="myFactoryBean"
      factory-method="createInstance"/&gt;

Although the mechanisms for setting bean properties are still to be discussed,
 one implication of this approach is that the factory bean itself can be managed and 
 configured via Dependency Injection, by the container.


 package samples;

public abstract class Product {

	private String name;
	private double price;
	
	public Product(){
		
	}
	public Product(String name,double price){
		this.name=name;
		this.price=price;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString(){
		return (name+" "+price);
	}
}
   

  package samples;

public class Dvd extends Product {

	private int  capacity;
	
	public Dvd(){
		super();
	}
	public Dvd(String name,double price){
		super(name,price);
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
}
  
  
    package samples;

public class Battery extends Product {

	private boolean rechargeable;
	
	public Battery(){
		super();
	}
	public Battery(String name,double price){
		super(name,price);
	}
	/**
	 * @return the rechargeable
	 */
	public boolean isRechargeable() {
		return rechargeable;
	}
	/**
	 * @param rechargeable the rechargeable to set
	 */
	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}
	
	
	
}
  
  
  The factory method implementor class ProductCreator
  
package Creator;

import samples.*;

public class ProductCreator {
	
	public static Product createProduct(String productId) {
		
		if ("aaa".equals(productId)) {
			
			return new Battery("AAA", 2.5);
			
		} else if ("cdrw".equals(productId)) {
			
			return new Dvd("CD-RW", 1.5);
		}
		throw new IllegalArgumentException("Unknown product");
	}
} 


the beans.xml

   &lt;beans  xmlns="http://www.springframework.org/schema/beans" 
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans-2.5.xsd"&gt;

	&lt;bean id="aaa" class="Creator.ProductCreator" factory-method="createProduct"&gt;
		&lt;constructor-arg value="aaa" /&gt;
	&lt;/bean&gt;
	
	&lt;bean id="cdrw" class="Creator.ProductCreator" factory-method="createProduct"&gt;
		&lt;constructor-arg value="cdrw" /&gt;
	&lt;/bean&gt;
	
&lt;/beans&gt; 


the main class which creates the beans Main.java

   package Checker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Creator.ProductCreator;
import samples.Product;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		Product cr=(Product)context.getBean("aaa");
		Product aaa=ProductCreator.createProduct("aaa");
		System.out.println(aaa);;
	}

}
 
 Reason
 
 
 The reason why it works in your code when you comment out the App context stuff is because you aren't even using it in your last two lines. You are bypassing it by calling a static method in the Factory class directly.

So the code is to demonstrate that it works the same way.

factory-method states call this method instead of a constructor when requesting that bean.

so

view plainprint?
Note: Text content in the code blocks is automatically word-wrapped

       
    &lt;bean id="aaa" class="Creator.ProductCreator" factory-method="createProduct"&gt;    
         &lt;constructor-arg value="aaa" /&gt;    
    &lt;/bean&gt;  



In the creation of aaa bean, Spring will call the createProduct method of ProductCreator, passing in the constructor-arg of "aaa" to the createProduct method.
Spring will not create "aaa" via a constructor in ProductCreator.

Remember a bean tag means Spring is going to create an instance of your object for you. Either via a constructor method, or via some other means when a constructor isn't available, (in this case a static factory method).
 
</pre>
</body>
</html>