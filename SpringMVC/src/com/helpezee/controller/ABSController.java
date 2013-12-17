package com.helpezee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class ABSController extends AbstractController {//implements EmployeeDAO{"
	
	public ABSController(){
	//Not allows setting the pojo class	
		
	}
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			return new ModelAndView("AbstractController12");
		
		
	}

}

