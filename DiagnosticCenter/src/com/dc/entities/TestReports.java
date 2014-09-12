package com.dc.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class TestReports {

	@Id
	@GeneratedValue
	private int reportId;
	private Integer testId;
	@Transient
	private Integer[] subtestId;
	private String referredDoctor;
	private int sampleDoctorId;
	private String verifiedDoctor;
	private String status;
	private String comments;

	@Temporal(TemporalType.TIMESTAMP)
	private Date testDate;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	private int verifiedDoctorId;
	

	
	
	public int getVerifiedDoctorId() {
		return verifiedDoctorId;
	}

	public void setVerifiedDoctorId(int verifiedDoctorId) {
		this.verifiedDoctorId = verifiedDoctorId;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Integer[] getSubtestId() {
		return subtestId;
	}

	public void setSubtestId(Integer[] subtestId) {
		this.subtestId = subtestId;
	}

	public String getReferredDoctor() {
		return referredDoctor;
	}

	public void setReferredDoctor(String referredDoctor) {
		this.referredDoctor = referredDoctor;
	}

	

	public int getSampleDoctorId() {
		return sampleDoctorId;
	}

	public void setSampleDoctorId(int sampleDoctorId) {
		this.sampleDoctorId = sampleDoctorId;
	}

	public String getVerifiedDoctor() {
		return verifiedDoctor;
	}

	public void setVerifiedDoctor(String verifiedDoctor) {
		this.verifiedDoctor = verifiedDoctor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
