package com.helpezee.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.ListLine;

public class UsingCollectionsList4ref {

	public static void main(String args[]){
		
	ApplicationContext context= new ClassPathXmlApplicationContext("Spring.xml");
	ListLine list=(ListLine)context.getBean("List");
	list.draw();
	
	}
}
