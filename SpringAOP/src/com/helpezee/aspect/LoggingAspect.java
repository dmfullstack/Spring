package com.helpezee.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //to tell spring that this is aspect bean
public class LoggingAspect {


/*
 NOTES: 
 a)
 tells the spring to execute this loggerAdvice before getName method is executed,it will executed to all the classes
 that has this method --->@Before("execution( public String getName())")	
 
 b)if we want to restrict to particular class do the chnages, need to mention the classname 
 along with package before method name -->@Before("execution( public String com.helpezee.model.Circle.getName())")
 c)
 @Before("execution( public * get*())")-->applys to all the getters, get methods that has zero arguments but should be public
 d)
 @Before("execution(** get*())")-->applys to all the getters,get methods that has zero arguments and identifier
  can be public or private ot default or protected
 e)
 @Before("execution(** get*(*))")-->applys to all the getters,get methods that has one argument of anytype irrespective of identifier and return type
 f)
 @Before("execution(** get*(..))")-->-->applys to all the getters,get methods that has zero  or more  argumnets
 g)
 @Before("execution(** com.helpezee.model.*.get*(..))")--> applys to all the getters,get methods that has zero  or more  argumnets
 to all classes that are present in the package defined.
 h)
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

i)
suppose if i want to apply for all the members that are in Circle class
@Pointcut("execution(**com.helpezee.model.Circle.*(..))") or @Pointcut("within(com.helpezee.model.Circle)"

j)
suppose if i want to apply for all the members that are in package and sub package 
@Pointcut("within(com.helpezee.model..*)"

k)
for applying to all that has aurgument as circle--->@Pointcut("args(com.helpezee.model.Circle)")
l)
execution----only for method
within ---- for classes
args-- for argument that matching to passed args

m) clubing two conditions  for one advice

@Before("allGetters()&& allmethodsCircle()")

 */
@Before("allGetters()&& allmethodsCircle()")	 
public void loggerAdvice()
{
System.out.println("logger advice called before ");	
}

@Before("allGetters()")	 	 
public void secondAdvice()
{
System.out.println("second advice called before ");	
}

@Pointcut("execution(* *.get*())")
public void allGetters(){}

@Pointcut("within(com.helpezee.model.Circle)")
public void allmethodsCircle(){}

}
