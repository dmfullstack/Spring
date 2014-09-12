package com.employee.dao;

import java.util.List;

import com.employee.beans.EmployeeBean;

public interface SaveEmployeeDao {

	public abstract void saveEmployee(EmployeeBean eb);
	public List<EmployeeBean> listEmployees();

}