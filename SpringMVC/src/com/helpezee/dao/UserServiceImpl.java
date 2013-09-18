package com.helpezee.dao;

import com.helpezee.beans.User1;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User1 user1) {
		//Persist the user object here. 
		System.out.println("User added successfully");

	}

}