package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.Collections;

public class UsingCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		Collections coll=(Collections)context.getBean("collections");
		coll.displayList();
		coll.displaySet();
		coll.displayMap();
		coll.displayProp();

	}

}
