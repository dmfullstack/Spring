package com.dc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dc.beans.StaffRegBean;
import com.dc.dao.StaffRegDao;


@Component
public class StaffRegModelImpl implements StaffRegModel{

	@Autowired
	StaffRegDao staffRegDao;

	@Override
	public void registerStaff(StaffRegBean ab) {

		staffRegDao.registerStaff(ab);
	}
}
