package com.dc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dc.beans.LoginBean;
import com.dc.dao.LoginCheckDao;


@Component
public class LoginCheckModelImpl implements LoginCheckModel{

	@Autowired
	LoginCheckDao loginCheckDao;
	
	@Override
	public boolean validateUser(LoginBean lb) {

		return loginCheckDao.validateUser(lb);
	}
}
