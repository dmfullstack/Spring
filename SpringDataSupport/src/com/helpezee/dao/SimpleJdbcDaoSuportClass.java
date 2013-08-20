package com.helpezee.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.helpezee.model.Circle;

public class SimpleJdbcDaoSuportClass extends SimpleJdbcDaoSupport {

	public void insertCircle(Circle circle){
	  String sql="insert into circle values(?,?)";
	  getSimpleJdbcTemplate().update(sql, new Object[]{circle.getId(),circle.getName()});
	}
}
