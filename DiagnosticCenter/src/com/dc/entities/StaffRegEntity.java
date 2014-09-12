package com.dc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="patientDetails")
public class StaffRegEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int patientId;
	@Column(length=15)
	private String firstName;
	@Column(length=15)
	private String lastName;
	@Column(length=15)
	@Temporal(TemporalType.DATE)
	private Date date_t;
	@Column(length=15)
	private String sex;
	@Column(length=3)
	private int age;
	@Column(length=10)
	private long phoneNumber;
	@Column(length=15)
	private String test;
	@Column(length=15)
	private double sum;
	@Column(length=15)
	private String urgency;
	@Column(length=15)
	private int sample;
	@Column(length=15)
	private int result;
	@Column(length=15)
	private String comments;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate_t() {
		return date_t;
	}
	public void setDate_t(Date date_t) {
		this.date_t = date_t;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public int getSample() {
		return sample;
	}
	public void setSample(int sample) {
		this.sample = sample;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
