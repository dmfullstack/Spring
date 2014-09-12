package com.dc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dc.beans.StaffRegBean;
import com.dc.entities.StaffRegEntity;


@Repository
public class StaffRegDaoImpl implements StaffRegDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void registerStaff(StaffRegBean ab) {
		Session ses = sessionFactory.getCurrentSession();
		StaffRegEntity are = new StaffRegEntity();

	
		are.setFirstName(ab.getFirstName());
		are.setLastName(ab.getLastName());
		are.setDate_t(ab.getDate_t());
		are.setSex(ab.getSex());
		are.setAge(ab.getAge());
		are.setPhoneNumber(ab.getPhoneNumber());
		are.setTest(ab.getTest());
		are.setSum(ab.getSum());
		are.setUrgency(ab.getUrgency());
		are.setSample(ab.getSample());
		are.setResult(ab.getResult());
		are.setComments(ab.getComments());
		

		ses.save(are);
	
	}
}
