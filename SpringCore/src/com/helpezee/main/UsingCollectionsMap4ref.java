package com.helpezee.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.ListLine;
import com.helpezee.beans.MapLine;

public class UsingCollectionsMap4ref {

	public static void main(String args[]){
		
	ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	MapLine map=(MapLine)context.getBean("Map");
	map.draw();
	
	}
}
