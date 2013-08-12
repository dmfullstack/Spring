package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.Scope;


public class SingletonScope {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		  Scope proto =(Scope)context.getBean("singleton");
		  proto.setMessage("Message by custA");
		  proto.draw();

		  Scope proto1 =(Scope)context.getBean("singleton");
		  proto1.draw();

	}

}
/*
 5 types of bean scopes supported :

    singleton – Return a single bean instance per Spring IoC container
    prototype – Return a new bean instance each time when requested
    request – Return a single bean instance per HTTP request. *
    session – Return a single bean instance per HTTP session. *
    globalSession – Return a single bean instance per global HTTP session. *

In most cases, you may only deal with the Spring’s core scope – singleton and prototype,
 and the default scope is singleton.
*/