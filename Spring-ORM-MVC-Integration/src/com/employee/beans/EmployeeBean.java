package com.employee.beans;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int empId;
	private String empName;
	private double salary;

	private String addr;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
