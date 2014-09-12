package com.employee.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.beans.EmployeeBean;
import com.employee.dao.SaveEmployeeDao;

@Component
public class SaveEmployeeModelImpl implements SaveEmployeeModel {

	@Autowired
	private SaveEmployeeDao saveEmployeeDao;

	@Override
	public void saveEmployee(EmployeeBean eb) {

		saveEmployeeDao.saveEmployee(eb);

	}
	
	public List<EmployeeBean> listEmployees(){
		
		return saveEmployeeDao.listEmployees();
	}

}
