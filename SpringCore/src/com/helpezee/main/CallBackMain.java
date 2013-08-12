package com.helpezee.main;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.CallBackBean;

public class CallBackMain {

	public static void main(String args[]){
		
	AbstractApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
	context.registerShutdownHook();
	CallBackBean bean=(CallBackBean)context.getBean("callback");
	bean.draw();
		
	}
}

/*
We have used the init and destroy method from interfaces InitializingBean,DisposableBean
this is spring specific and bounded to code. we can do the same thing  by defining the
init-method and destroy method for that bean in spring xml as shown below

	<bean id="callback" class="com.helpezee.beans.CallBackBean" 
	init-method="initmethod" destroy-method="destroymethod">
		<property name="pointA" ref="pointA" />
		<property name="pointB" ref="pointB" />
		<property name="pointC" ref="pointC" />
	</bean>

we can define the init and destroy method globally, means they will be applied for all beans defined in
the spring.xml as shown below

<beans default-init-method="initmethod" default-destroy-method="destroymethod">
</beans>

if we used both global  and interface method parallelly, interfaces method will be executed first 
and then global method will execute.

*/