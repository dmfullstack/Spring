package com.helpezee.dao;

import com.helpezee.beans.Employee;

public interface EmployeeDAO {

	public int insert(Employee employee);
    public Employee findById(int id);
}
