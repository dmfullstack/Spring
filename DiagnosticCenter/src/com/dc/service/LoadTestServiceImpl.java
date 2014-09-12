package com.dc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.beans.TestDetailsBean;
import com.dc.entities.Patient;
import com.dc.model.LoadTestModel;

@Service
public class LoadTestServiceImpl implements LoadTestService {

	@Autowired
	private LoadTestModel loadTestModel;

	@Override
	@Transactional
	public Map<Integer, String> listTests() {

		return loadTestModel.listTests();

	}

	@Override
	@Transactional
	public Map<Integer, String> listSubTests(Integer testId) {
		// TODO Auto-generated method stub
		return loadTestModel.listSubTests(testId);
	}

	@Transactional
	public Map<Integer, String> listDoctors() {

		return loadTestModel.listDoctors();
	}
	
	@Transactional
	public double getTotal(Integer[] testId){
		
		return loadTestModel.getTotal(testId);
	}
	
	@Transactional
	public void registerTest(TestDetailsBean tb){
		
		loadTestModel.registerTest(tb);
	}
	
	@Transactional
	public List<Patient> getReports(){
		
		return loadTestModel.getReports();
	}
	
	@Transactional
	public double getTestCoste(int testId){
		
		return loadTestModel.getTestCoste(testId);
	}

}
