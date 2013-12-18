package com.helpezee.ws.service;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

public class SpringWSEndPoint extends ServletEndpointSupport implements ISpringWS {

	public ISpringWS springWS;

	public SpringWSEndPoint() {
	}

	public SpringWSEndPoint(ISpringWS springWS) {
		this.springWS = springWS;
	}

	public void onInit() {
		this.springWS = (ISpringWS) getWebApplicationContext().getBean("springWS");
	}

	 public String sayHello(String message) {
		return springWS.sayHello(message);
	}
	 
	 public int add(int a,int b){
		 return springWS.add(a, b);
	 }

}
