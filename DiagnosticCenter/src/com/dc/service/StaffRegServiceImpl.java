package com.dc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.beans.StaffRegBean;
import com.dc.model.StaffRegModel;

@Service
public class StaffRegServiceImpl implements StaffRegService{

	@Autowired
	private StaffRegModel staffRegModel;
	@Override
	@Transactional
	public void registerStaff(StaffRegBean ab) {
		staffRegModel.registerStaff(ab);

	}
}
