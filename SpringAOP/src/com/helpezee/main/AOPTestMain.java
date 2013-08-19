package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.service.Shape;

public class AOPTestMain {
public static void main(String args[])
{
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	Shape shape=ctx.getBean("shapeService",Shape.class);
	System.out.println(shape.getTriangle().getName());
	//System.out.println(shape.getTriangle().getName());
}
}


/* 
 Note: Comment the below code in the Spring.xml if using Annotations for AOP Programming
 
      <aop:config>
     <aop:aspect id="loggingAspect" ref="loggingAspect">
     <aop:pointcut expression="execution(* *.get*())" id="allGetters"/>
     <aop:pointcut expression="within(com.helpezee.model.Circle)" id="allmethodsCircle"/>
     <aop:before method="loggerAdvice"  pointcut-ref="allmethodsCircle"/>
     <aop:before method="loggerAdvice"  pointcut-ref="allGetters"/>
     <aop:before method="secondAdvice" pointcut-ref="allmethodsCircle"/>
    <aop:before method="argAdvice"   arg-names="name" pointcut="args(name)" />
    <aop:after method="argAdvice2" arg-names="name" pointcut="args(name)" xsi:type="aop:basicAdviceType"/>
	<aop:after-returning method="argAdvice5" arg-names="name,returnvalue" pointcut="args(name)"   returning="returnvalue"   />
	<aop:after-throwing method="argAdvice3" arg-names="name" pointcut="args(name)"/>
 	<aop:after-throwing method="argAdvice4" arg-names="name,ex" pointcut="args(name)" throwing="ex"/>  
		<aop:around method="aroundAdvice2" arg-names="proceedingjointpoint" pointcut-ref="allGetters" />
     </aop:aspect>
     </aop:config>

 */
  
 
 