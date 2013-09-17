package com.helpezee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HandlerMappingController {

@RequestMapping("beanNamehandlermapping.html")
public ModelAndView BeanNameUrlHandlerMapping(){
	return new ModelAndView("beanNameUrl");
}
@RequestMapping("ControllerClassNameHandlerMapping.html")
public ModelAndView ControllerClassNameHandlerMapping(){
	return new ModelAndView("className");
}

@RequestMapping("SimpleUrlHandlerMapping.html")
public ModelAndView SimpleUrlHandlerMapping(){
	return new ModelAndView("simpleUrl");
}
}
