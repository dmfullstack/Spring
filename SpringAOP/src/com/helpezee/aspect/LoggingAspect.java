package com.helpezee.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

import com.helpezee.model.Circle;


@Aspect //to tell spring that this is aspect bean
public class LoggingAspect  {


/*
 NOTES: 
 A)
 tells the spring to execute this loggerAdvice before getName method is executed,it will executed to all the classes
 that has this method --->@Before("execution( public String getName())")	
 
 B)if we want to restrict to particular class do the chnages, need to mention the classname 
 along with package before method name -->@Before("execution( public String com.helpezee.model.Circle.getName())")
 
 C)
 @Before("execution( public * get*())")-->applys to all the getters, get methods that has zero arguments but should be public

 D)
 @Before("execution(** get*())")-->applys to all the getters,get methods that has zero arguments and identifier
  can be public or private ot default or protected
 
 E)
 @Before("execution(** get*(*))")-->applys to all the getters,get methods that has one argument of anytype irrespective of identifier and return type

 F)
 @Before("execution(** get*(..))")-->-->applys to all the getters,get methods that has zero  or more  argumnets

 G)
 @Before("execution(** com.helpezee.model.*.get*(..))")--> applys to all the getters,get methods that has zero  or more  argumnets
 to all classes that are present in the package defined.
 
 H)
 suppose two advices should be applied to same criteria like as shown below
 
 @Before("execution(**.get*())")	 
public void loggerAdvice()
{
System.out.println("logger advice called before ");	
}

@Before("execution(*.get*())")	 	 
public void secondAdvice()
{
System.out.println("second advice called before ");	
}

In this case, the suggestion is to use pointcuts for defining the criteria

@Before("allGetters()")	 
public void loggerAdvice()
{
System.out.println("logger advice called before ");	
}

@Before("allGetters()")	 	 
public void secondAdvice()
{
System.out.println("second advice called before ");	
}

@Pointcut("execution(**.get*())")
public void allGetters(){}

I)
suppose if i want to apply for all the members that are in Circle class
@Pointcut("execution(**com.helpezee.model.Circle.*(..))") or @Pointcut("within(com.helpezee.model.Circle)"

J)
suppose if i want to apply for all the members that are in package and sub package 
@Pointcut("within(com.helpezee.model..*)"

K)
for applying to all that has arugument as circle--->@Pointcut("args(com.helpezee.model.Circle)")

L)
execution----only for method
within ---- for classes
args-- for argument that matching to passed args,takes classes or interfaces
target --

M) clubing two conditions  for one advice

@Before("allGetters()&& allmethodsCircle()")

N)In the below code even  if the setter is called it is printing that get method is called.
To print which method is called, we can use JoinPoint that AOP provides
public void secondAdvice(JoinPoint joinPoint)
{
System.out.println("second advice called and "+joinPoint.toString()+"is called");	
Circle cir=(Circle) joinPoint.getTarget();
System.out.println("Circle Object::"+cir);

}

O)Using the JoinPoints, we can get the Object of class and use them internally in the loggerAdvice
Circle cir=(Circle) joinPoint.getTarget();

P)args(String) is fired when any set method is called 
that is having only one argument and that is of type String

@Before("args(String)")
public void argAdvice(){
	System.out.println("using Args point type-----");
}

Q)we can get the value that is set to variable using below

@Before("args(name)")
public void argAdvice(String name){
	System.out.println("using Args point type-----"+name);
}

R) below code is used to trigger the advice once after the value is set,
it will trigger irrespective of the exception occurred during setting the value

@After("args(name)")
public void argAdvice1(String name){
	System.out.println("using Args point type @After-----"+name);
}
 */

	
@Before("allGetters()&& allmethodsCircle()")	 
public void loggerAdvice()
{
System.out.println("logger advice called before and print get method ");	
}


@Before("allmethodsCircle()")	 	 
public void secondAdvice(JoinPoint joinPoint)
{
System.out.println("second advice called and "+joinPoint.toString()+"is called");	
Circle cir=(Circle) joinPoint.getTarget();
System.out.println("Circle Object::"+cir);

}

@Before("args(name)")
public void argAdvice(String name){
	System.out.println("using Args point type @Before-----"+name);
}

@After("args(name)")
public void argAdvice1(String name){
	System.out.println("using Args point type @After,won't care of exception occurred during setting value,it will be get trigered-----"+name);
}

@AfterReturning("args(name)")
public void argAdvice2(String name){
	System.out.println("using Args point type @AfterReturning,will be triggered only when successfully setted the value-----"+name);
}

@AfterReturning(pointcut="args(name)",returning="returnvalue")
public void argAdvice5(String name,Object returnvalue){
	System.out.println("using Args point type @AfterReturning with retuen value,will be triggered only when successfully setted the value-----"+name+"-----returnvalue is---+"+returnvalue);
	
}
@AfterThrowing("args(name)")
public void argAdvice3(String name){
	System.out.println("using Args point type @AfterThrowing ,will be triggered only when exception is thrown-----"+name);
}

@AfterThrowing(pointcut="args(name)",throwing="ex")
public void argAdvice4(String name,Exception ex){
	System.out.println("using Args point type @AfterThrowing and catching Exception,will be triggered only when exception is thrown-----"+name+"Returned Exception is---"+ex);
}

@Around("execution(* *.get*())")
public Object aroundAdvice(ProceedingJoinPoint proceedingjointpoint){
	Object ret=null;
	
	try {
		System.out.println("Before Advice");
		ret= proceedingjointpoint.proceed(); //method processing done when this statement is called
		System.out.println("After advice");
	} catch (Throwable e) {
		System.out.println("Throwing Advice");
	}
	System.out.println("finally Advice");
	
	return ret;
}

@Around("@annotation(com.helpezee.aspect.Loggable)")
public Object aroundAdvice2(ProceedingJoinPoint proceedingjointpoint){
	Object ret=null;
	
	try {
		System.out.println("Before Advice");
		ret= proceedingjointpoint.proceed(); //method processing done when this statement is called
		System.out.println("After advice");
	} catch (Throwable e) {
		System.out.println("Throwing Advice");
	}
	System.out.println("finally Advice");
	
	return ret;
}


@Pointcut("execution(* *.get*())")
public void allGetters(){}

@Pointcut("within(com.helpezee.model.Circle)")
public void allmethodsCircle(){}

}
