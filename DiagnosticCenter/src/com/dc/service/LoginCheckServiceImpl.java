package com.dc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.beans.LoginBean;
import com.dc.model.LoginCheckModel;
//import com.dc.service.Transactional;


@Service
public class LoginCheckServiceImpl implements LoginCheckService{

	@Autowired
	LoginCheckModel loginCheckModel;

	@Override
	@Transactional
	public boolean validateUser(LoginBean lb) {

		return loginCheckModel.validateUser(lb);
	}
}
