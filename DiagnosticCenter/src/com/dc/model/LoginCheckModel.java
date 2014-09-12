package com.dc.model;

import com.dc.beans.LoginBean;

public interface LoginCheckModel {

	public abstract boolean validateUser(LoginBean lb);
}
