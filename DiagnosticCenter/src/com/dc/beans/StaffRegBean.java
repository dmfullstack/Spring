package com.dc.beans;

import java.io.Serializable;
import java.util.Date;

public class StaffRegBean implements Serializable{
private static final long serialVersionUID = 1L;
	
	public String firstName;
	public String lastName;
	public Date date_t;
	public String sex;
	public int age;
	public long phoneNumber;
	public String test;
	public double sum;
	public String urgency;
	public int patientId;
	public int sample;
	public int result;
	public String comments;
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
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
