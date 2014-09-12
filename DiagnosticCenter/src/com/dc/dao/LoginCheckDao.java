package com.dc.dao;

import com.dc.beans.LoginBean;

public interface LoginCheckDao {
	public boolean validateUser(LoginBean lb);

}
