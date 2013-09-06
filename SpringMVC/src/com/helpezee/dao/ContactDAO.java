package com.helpezee.dao;

import java.util.List;

import com.helpezee.beans.*;
 
public interface ContactDAO {
     
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
