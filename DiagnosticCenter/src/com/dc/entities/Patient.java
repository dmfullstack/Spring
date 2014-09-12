package com.dc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Dio_Patient")
public class Patient {

	@Id
	@GeneratedValue
	private int patientId;
	private String firstName;
	private String lastName;
	private Integer age;
	// private String age;
	private String gender;
	private long mobileNo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "patient_details", joinColumns = { @JoinColumn(name = "patientId") }, inverseJoinColumns = { @JoinColumn(name = "sId") })
	List<SubTest> subTests = new ArrayList<SubTest>();

	public List<SubTest> getSubTests() {
		return subTests;
	}

	public void setSubTests(List<SubTest> subTests) {
		this.subTests = subTests;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

}
