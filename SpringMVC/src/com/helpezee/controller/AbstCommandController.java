package com.helpezee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.helpezee.beans.User1;

public class AbstCommandController  extends AbstractCommandController{

	public AbstCommandController(){
		setCommandClass(User1.class);
		setCommandName("User1");
	}
	
	private User1 user;
	
	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errrors)
			throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("ABSCommandController","User1",user);
	}

}
