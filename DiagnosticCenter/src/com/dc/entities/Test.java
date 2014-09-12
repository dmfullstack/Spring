package com.dc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Test {
	@Id
	@GeneratedValue
	private int testId;
	@Column(length = 20)
	private String testName;
	private double amt;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "test_details", joinColumns = { @JoinColumn(name = "testId") }, inverseJoinColumns = { @JoinColumn(name = "sId") })
	List<SubTest> subTests = new ArrayList<SubTest>();

	public List<SubTest> getSubTests() {
		return subTests;
	}

	public void setSubTests(List<SubTest> subTests) {
		this.subTests = subTests;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

}
