JavaConfig features are included in core Spring module, 
it allow developer to move bean definition and Spring configuration 
out of XML file into Java class.

Sample code
------------
@Configuration
public class AppConfig {
 
    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
 
}

<!-- JavaConfig need this library -->
	<dependency>
		<groupId>cglib</groupId>
		<artifactId>cglib</artifactId>
		<version>2.2.2</version>
	</dependency>
	
	
	
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
HelloWorld obj = (HelloWorld) context.getBean("helloBean");
obj.printHelloWorld("Spring3 Java Config");