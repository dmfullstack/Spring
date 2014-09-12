package com.employee.service;

import java.util.List;

import com.employee.beans.EmployeeBean;

public interface SaveEmployeeService {

	public abstract void saveEmployee(EmployeeBean eb);

	public List<EmployeeBean> listEmployees();

}