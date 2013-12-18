package com.helpezee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractFormController;

public class AbstractFormControllerExample extends AbstractFormController{

	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest arg0,
			HttpServletResponse arg1, BindException arg2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
