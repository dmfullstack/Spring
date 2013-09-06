package com.helpezee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.helpezee.beans.Contact;

@Repository
/*
 The @Repository annotation is yet another stereotype that was introduced in Spring 2.0. 
 This annotation is used to indicate that a class functions as a repository and
 needs to have exception translation applied transparently on it. 
 The benefit of exception translation is that the service layer only has to 
 deal with exceptions from Spring’s DataAccessException hierarchy, 
 even when using plain JPA in the DAO classes.
 */
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact")
				.list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	
}
