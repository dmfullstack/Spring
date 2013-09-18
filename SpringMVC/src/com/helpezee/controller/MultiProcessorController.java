package com.helpezee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
public class MultiProcessorController extends MultiActionController {
	
	
	public ModelAndView show(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("showForm", "message", "Show method called");
    }
	public ModelAndView add(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "message", "Add method called");
    }
    public ModelAndView remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "message", "Remove method called");
    }
    public ModelAndView listAll(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "message", "ListAll method called");
    }
}