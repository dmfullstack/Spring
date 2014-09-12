package com.dc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer testId;
	private Integer sid;
	private String testName;
	private String subTestName;
	private double ttot;
	private double sttot;
	private Integer[] subTestId;

	private String firstName;
	private String lastName;
	private String gender;
	private double amount;
	private Long mobileNo;
	private String sampleDoctor;
	private String varifiedDoctor;
	private String ReferredDoctor;
	private String status;
	private String comments;
	private String urgencyReason;
	private int sampleDoctorId;
	private int verifiedDoctorId;
	
	public int getVerifiedDoctorId() {
		return verifiedDoctorId;
	}

	public void setVerifiedDoctorId(int verifiedDoctorId) {
		this.verifiedDoctorId = verifiedDoctorId;
	}

	public int getSampleDoctorId() {
		return sampleDoctorId;
	}

	public void setSampleDoctorId(int sampleDoctorId) {
		this.sampleDoctorId = sampleDoctorId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUrgencyReason() {
		return urgencyReason;
	}

	public void setUrgencyReason(String urgencyReason) {
		this.urgencyReason = urgencyReason;
	}

	private int sampleDocId;

	public int getSampleDocId() {
		return sampleDocId;
	}

	public void setSampleDocId(int sampleDocId) {
		this.sampleDocId = sampleDocId;
	}

	public Integer[] getSubTestId() {
		return subTestId;
	}

	public void setSubTestId(Integer[] subTestId) {
		this.subTestId = subTestId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSampleDoctor() {
		return sampleDoctor;
	}

	public void setSampleDoctor(String sampleDoctor) {
		this.sampleDoctor = sampleDoctor;
	}

	public String getVarifiedDoctor() {
		return varifiedDoctor;
	}

	public void setVarifiedDoctor(String varifiedDoctor) {
		this.varifiedDoctor = varifiedDoctor;
	}

	public String getReferredDoctor() {
		return ReferredDoctor;
	}

	public void setReferredDoctor(String referredDoctor) {
		ReferredDoctor = referredDoctor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	private Map<Integer, String> testNames = new HashMap<Integer, String>();
	private Map<Integer, String> subTestNames = new HashMap<Integer, String>();
	private Map<Integer, String> doctors = new HashMap<Integer, String>();

	private List<Integer> ageRange = new ArrayList<Integer>();

	/*
	 * public String getAge() { return age; }
	 * 
	 * public void setAge(String age) { this.age = age; }
	 */

	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public List<Integer> getAgeRange() {

		for (Integer i = 0; i <= 100; i++) {

			ageRange.add(i);
		}

		return ageRange;
	}

	public void setAgeRange(List<Integer> ageRange) {

		System.out.println("--------------- setter ---------------");

		this.ageRange = ageRange;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Map<Integer, String> getDoctors() {
		return doctors;
	}

	public void setDoctors(Map<Integer, String> doctors) {
		this.doctors = doctors;
	}

	public Map<Integer, String> getSubTestNames() {
		return subTestNames;
	}

	public void setSubTestNames(Map<Integer, String> subTestNames) {
		this.subTestNames = subTestNames;
	}

	public Map<Integer, String> getTestNames() {
		return testNames;
	}

	public void setTestNames(Map<Integer, String> testNames) {
		this.testNames = testNames;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getSubTestName() {
		return subTestName;
	}

	public void setSubTestName(String subTestName) {
		this.subTestName = subTestName;
	}

	public double getTtot() {
		return ttot;
	}

	public void setTtot(double ttot) {
		this.ttot = ttot;
	}

	public double getSttot() {
		return sttot;
	}

	public void setSttot(double sttot) {
		this.sttot = sttot;
	}

}
