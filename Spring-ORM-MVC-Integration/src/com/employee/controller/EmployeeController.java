package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.employee.beans.EmployeeBean;
import com.employee.service.SaveEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private SaveEmployeeService saveEmployeeService;

	@RequestMapping(value = "/saveEmployee")
	public String saveEmployee(
			@ModelAttribute(value = "employeeBean") EmployeeBean employeeBean) {

		saveEmployeeService.saveEmployee(employeeBean);

		return "success";

	}

	@RequestMapping(value="/displayEmployees")
	public ModelAndView listEmployees() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("display");
		EmployeeBean employeeBean = new EmployeeBean();

		List<EmployeeBean> emps = saveEmployeeService.listEmployees();
		mav.addObject("emps", emps);
		mav.addObject("emp", employeeBean);

		return mav;
	}

}
