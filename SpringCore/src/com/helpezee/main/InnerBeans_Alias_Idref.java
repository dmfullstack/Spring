package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.helpezee.beans.Line;

public class InnerBeans_Alias_Idref {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		 Line line=(Line) context.getBean("line.new");
		 line.draw();
		
	}

}
