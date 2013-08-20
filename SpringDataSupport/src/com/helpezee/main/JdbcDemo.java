package com.helpezee.main;

import com.helpezee.dao.JdbcDaoImpl;
import com.helpezee.model.Circle;

public class JdbcDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	Circle circle=new JdbcDaoImpl().getCircle(1);
	System.out.println("id----"+circle.getId());
	System.out.println("name---"+circle.getName());

	}

}
