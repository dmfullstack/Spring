package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.SetLine;

public class UsingCollectionsSet4ref {

	public static void main(String args[]){
		
	ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	SetLine set=(SetLine)context.getBean("Set");
	set.draw();
	
	}
}
