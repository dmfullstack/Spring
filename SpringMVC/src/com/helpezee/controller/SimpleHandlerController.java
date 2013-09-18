package com.helpezee.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


import com.helpezee.beans.User1;
import com.helpezee.dao.UserService;


@SuppressWarnings("deprecation")
public class SimpleHandlerController extends SimpleFormController {

	private UserService userService;

	public SimpleHandlerController()	{
		setCommandClass(User1.class);
		setCommandName("user1");
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User1 user = (User1) command;
		userService.add(user);
		return new ModelAndView("userSuccess","user",user);
	}
	
}