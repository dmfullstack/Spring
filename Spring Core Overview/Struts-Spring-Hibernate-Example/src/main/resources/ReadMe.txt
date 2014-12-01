In this tutorials, you will learn how to create a simple customer management (add and select) 
web application, Maven as project management tool,

*****Struts 1.x as web framework, 
	 Spring as dependency injection framework and 
	 Hibernate as database ORM framework.

The overall integration architecture is look like following :

Struts (Web page) <---> Spring DI <--> Hibernate (DAO) <---> Database

To integrate all those technologies together, you should..

 *****   Integrate Spring with Hibernate with Spring’s “LocalSessionFactoryBean” class.
 *****   Integrate Spring with Struts via Spring’s ready make Struts plug-in – “ContextLoaderPlugIn“.