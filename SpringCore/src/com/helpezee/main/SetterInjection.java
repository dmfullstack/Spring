package com.helpezee.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.Traingle;


public class SetterInjection {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Traingle traingle=(Traingle) context.getBean("traingle");
		traingle.draw();

	}
}
