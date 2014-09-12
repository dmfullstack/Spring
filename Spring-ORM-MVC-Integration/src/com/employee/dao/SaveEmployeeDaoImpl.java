package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.beans.EmployeeBean;
import com.employee.entities.Employee;

@Repository
public class SaveEmployeeDaoImpl implements SaveEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmployee(EmployeeBean eb) {

		Session ses = sessionFactory.getCurrentSession();

		// Create Entity class Object
		Employee emp = new Employee();

		// Set Data to the Entity class Object
		emp.setEmpName(eb.getEmpName());
		emp.setSalary(eb.getSalary());
		emp.setAddr(eb.getAddr());

		// Save the Entity class Object in Session

		ses.save(emp);

	}

	public List<EmployeeBean> listEmployees() {

		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		Session ses = sessionFactory.getCurrentSession();

		Query qry = ses.createQuery("from Employee");

		List<Employee> emps = qry.list();

		for (Employee emp : emps) {

			EmployeeBean eb = new EmployeeBean();

			eb.setEmpId(emp.getEmpId());
			eb.setEmpName(emp.getEmpName());
			eb.setSalary(emp.getSalary());
			eb.setAddr(emp.getAddr());

			employees.add(eb);

		}
		return employees;
	}

}
