package com.dc.service;

import com.dc.beans.LoginBean;

public interface LoginCheckService {
	
	public abstract boolean validateUser(LoginBean lb);

}
