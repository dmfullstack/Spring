package com.employee.model;

import java.util.List;

import com.employee.beans.EmployeeBean;

public interface SaveEmployeeModel {

	public abstract void saveEmployee(EmployeeBean eb);
	public List<EmployeeBean> listEmployees();

}