package com.helpezee.beans;

import java.beans.EventHandler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.helpezee.event.publisher.MyEvent;
import com.helpezee.interfaces.Shape;

//@Component or @Service or Repository
@Controller
public class Circle2 implements Shape,ApplicationEventPublisherAware{

	
	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public Point getCenter() {
		return center;
	}
	@Resource(name="Point")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init method");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Destroy method");	
	}
	
	

	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Message1", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(),center.getY()}, "Default Message2", null));
		MyEvent hand=new MyEvent(this);
		System.out.println("Printed User Created Event Handler----------"+hand.toString());
		
		
	}
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}

}
