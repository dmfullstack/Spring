package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.Circle;


public class ConstructorInjection {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Circle circle=(Circle) context.getBean("circle");
		circle.draw();

	}
}

/* 
 When we are using constructor injection we need to define the bean like this
 
<bean id="circle" class="com.helpezee.beans.Circle">
<constructor-arg value="Equilateral"/>
<constructor-arg value="20"/>
</bean>

a) Actually type is String and value  passing is Equilateral
         height is int and the value passing is 20;
we are passing both the parameters in same style,Spring will internal takes care of conversions
b)Suppose we two constructor like this 

public Circle(String type)
{
	System.out.println("construction0");
	this.type=type;
	
}
public Circle(int height)
{
	System.out.println("construction1");
	this.height=height;
	
}

Even if we pass the type(String) or height(int) it will call the first constructor as it cant identify 
what we are passing int or String as it follows same style,this will create a problem

solution 1) specify the the type of parameter you are pasing using type attribute

<bean id="circle" class="com.helpezee.beans.Circle">
<constructor-arg value="Equilateral" type="java.lang.String"/>
</bean>

similarily

<bean id="circle" class="com.helpezee.beans.Circle">
<constructor-arg value="20" type="int"/>
</bean>

c) In case if  have construction more than two parameters then we  need to use index attribute
 for differenciating the parameter what we are passing 

public Circle(int height,String type)
{
	System.out.println("construction2");
	this.type=type;
	this.height=height;
}

<bean id="circle" class="com.helpezee.beans.Circle">
<!--  using index attribute -->
<constructor-arg value="Equilateral" index="1"/>
<constructor-arg value="20" index="0"/>
</bean>


 */



