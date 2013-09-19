package com.helpezee.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity 
//@Entity which tells Hibernate that this class represents an object that we can persist.
@Table(name="CONTACTS")
//@Table(name = "CONTACTS") annotation tells Hibernate which table to map properties in this class to. 
public class Contact {
     
    @Id
   //ID which will be unique for all events persisted.This is why we’ve annotated it with @Id.
    @Column(name="ID")
    @GeneratedValue 
    //@GeneratedValue annotation says that this value will be determined by the datasource, not by the code.
    private Integer id;
     
    @Column(name="FIRSTNAME")
    //@Column(name = "FIRSTNAME") annotation is used to map this property to the FIRSTNAME column in the CONTACTS table.
    private String firstname;
 
    @Column(name="LASTNAME")
    private String lastname;
 
    @Column(name="EMAIL")
    private String email;
     
    @Column(name="TELEPHONE")
    private String telephone;
     
     
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}