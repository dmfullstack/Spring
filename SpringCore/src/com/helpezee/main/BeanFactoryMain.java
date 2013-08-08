package com.helpezee.main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.helpezee.beans.Traingle;

public class BeanFactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

  //Note In order to test this, creaste a java project and check
   BeanFactory myBean = new XmlBeanFactory(new FileSystemResource("spring.xml"));
   Traingle triangle=(Traingle) myBean.getBean("traingle");
   triangle.draw();
   
   
   

	}

}
