package com.helpezee.service;

import java.util.List;

import com.helpezee.beans.Contact;
 
public interface ContactService {
     
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
