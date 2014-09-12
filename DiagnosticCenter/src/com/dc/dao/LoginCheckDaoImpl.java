package com.dc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dc.beans.LoginBean;
import com.dc.entities.StaffLogin;

@Repository
public class LoginCheckDaoImpl implements LoginCheckDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean validateUser(LoginBean lb) {
		System.out.println("Login1");
		Session ses = sessionFactory.getCurrentSession();
		String query = "from StaffLogin where (user_name=? AND password=?) AND role=?";
		Query qry = ses.createQuery(query);

		qry.setString(0, lb.getUserName());
		qry.setString(1, lb.getPassword());
		qry.setString(2, lb.getRole());
		System.out.println("Login2");
		List<StaffLogin> users = qry.list();
		System.out.println("Login67");
		System.out.println(users);

		if (users.size() != 0) {
			return true;
		}

		return false;

	}
}
