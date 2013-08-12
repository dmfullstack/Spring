package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.helpezee.beans.Scope;


public class PrototypeScope {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		  Scope proto =(Scope)context.getBean("prototyp");
		  proto.setMessage("Message by custA");
		  proto.draw();

		  Scope proto1 =(Scope)context.getBean("prototyp");
		  proto1.draw();

	}

}
