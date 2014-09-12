package com.dc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubTest {
	@Id
	private int sId;
	@Column(length = 20)
	private String subTestName;
	private double amt;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getSubTestName() {
		return subTestName;
	}

	public void setSubTestName(String subTestName) {
		this.subTestName = subTestName;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

}
