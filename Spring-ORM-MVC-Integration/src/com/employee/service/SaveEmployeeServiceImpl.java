package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.beans.EmployeeBean;
import com.employee.model.SaveEmployeeModel;

@Service
public class SaveEmployeeServiceImpl implements SaveEmployeeService {

	@Autowired
	private SaveEmployeeModel saveEmployeeModel;

	@Override
	@Transactional
	public void saveEmployee(EmployeeBean eb) {

		saveEmployeeModel.saveEmployee(eb);

	}

	@Transactional
	public List<EmployeeBean> listEmployees() {

		return saveEmployeeModel.listEmployees();
	}

}
