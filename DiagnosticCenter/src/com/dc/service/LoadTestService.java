package com.dc.service;

import java.util.List;
import java.util.Map;

import com.dc.beans.TestDetailsBean;
import com.dc.entities.Patient;
import com.dc.entities.Test;

public interface LoadTestService {

	public  Map<Integer, String> listTests();
	public Map<Integer, String> listSubTests(Integer testId);
	public Map<Integer, String> listDoctors();
	public double getTotal(Integer[] testId);
	public void registerTest(TestDetailsBean tb);
	public List<Patient> getReports();
	public double getTestCoste(int testId);

}