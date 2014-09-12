package com.dc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StaffLogin {
	
	@Id
	private int login_Id;
	private String user_name;
	private String password;
	private String role;
	/*public int getLogin_Id() {
		return login_Id;
	}
	public void setLogin_Id(int login_Id) {
		this.login_Id = login_Id;
	}*/
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
