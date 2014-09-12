package com.dc.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dc.beans.TestDetailsBean;
import com.dc.dao.LoadTestDao;
import com.dc.entities.Patient;

@Component
public class LoadTestModelImpl implements LoadTestModel {

	@Autowired
	LoadTestDao loadTestDao;

	@Override
	public Map<Integer, String> listTests() {
		return loadTestDao.listTests();

	}

	@Override
	public Map<Integer, String> listSubTests(Integer testId) {
		// TODO Auto-generated method stub
		return loadTestDao.listSubTests(testId);
	}
	
	public Map<Integer, String> listDoctors(){
		
		return loadTestDao.listDoctors();
		
	}
	
	public double getTotal(Integer[] testId){
		
		return loadTestDao.getTotal(testId);
	}
	
	public void registerTest(TestDetailsBean tb){
		
		loadTestDao.registerTest(tb);
	}
	
	public List<Patient> getReports(){
		
		return loadTestDao.getReports();
	}
	
	public double getTestCoste(int testId){
		
	 return loadTestDao.getTestCoste(testId);
	}

}
