package com.dc.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dc.beans.TestDetailsBean;
import com.dc.entities.Doctors;
import com.dc.entities.Patient;
import com.dc.entities.SubTest;
import com.dc.entities.Test;
import com.dc.entities.TestReports;

@Repository
public class LoadTestDaoImpl implements LoadTestDao {

	@Autowired
	private SessionFactory sessionFactory;
	Map<Integer, String> testNames;

	public List<Patient> getReports() {

		Session ses = sessionFactory.getCurrentSession();

		Query qry = ses.createQuery("select pb from Dio_Patient as pb");

		List<Patient> reports = qry.list();

		return reports;

	}

	// Save Test
	
	public void registerTest(TestDetailsBean tb) {

		Session ses = sessionFactory.getCurrentSession();

		Patient p = new Patient();

		TestReports tr = new TestReports();

		SubTest st = new SubTest();

		Test t = new Test();

		
		p.setFirstName(tb.getFirstName());
		p.setLastName(tb.getLastName());
		p.setGender(tb.getGender());
		p.setAge(tb.getAge());
		p.setAge(tb.getAge());
		p.setMobileNo(tb.getMobileNo());
		
		
		tr.setSampleDoctorId(tb.getSampleDoctorId());
		tr.setVerifiedDoctorId(tb.getVerifiedDoctorId());
		tr.setTestId(tb.getTestId());
		tr.setTestDate(new Date());

		for (Integer st1 : tb.getSubTestId()) {

			p.getSubTests().add((SubTest) ses.get(SubTest.class, st1));

		}

		// Doctors docs=(Doctors)ses.get(Doctors.class, tb.getD);

		tr.setReferredDoctor(tb.getReferredDoctor());
		tr.setStatus(tb.getStatus());
		tr.setComments(tb.getComments());

		tr.setPatient(p);

		// ses.save(p);

		ses.save(tr);

	}

	@Override
	public Map<Integer, String> listTests() {

		Session ses = sessionFactory.getCurrentSession();

		String q1 = "from Test";
		Query qry = ses.createQuery(q1);

		@SuppressWarnings("unchecked")
		List<Test> tests = qry.list();

		testNames = new HashMap<Integer, String>();

		for (Test t1 : tests) {

			testNames.put(t1.getTestId(), t1.getTestName());

		}

		return testNames;

	}

	public Map<Integer, String> listSubTests(Integer testId) {

		Session ses = sessionFactory.getCurrentSession();

		Test test = (Test) ses.get(Test.class, testId);

		List<SubTest> subtestNames = test.getSubTests();

		Map<Integer, String> subTestNames = new HashMap<Integer, String>();

		for (SubTest st : subtestNames) {

			subTestNames.put(st.getsId(), st.getSubTestName());

		}

		return subTestNames;
	}

	public Map<Integer, String> listDoctors() {

		Session ses = sessionFactory.getCurrentSession();
		Query qry = ses.createQuery("from Doctors");
		List<Doctors> docs = qry.list();

		Map<Integer, String> doctors = new HashMap<Integer, String>();
		for (Doctors d1 : docs) {

			doctors.put(d1.getDoctorId(), d1.getDoctorName());

		}

		return doctors;
	}

	public double getTotal(Integer[] testId) {

		Session ses = sessionFactory.getCurrentSession();

		double total = 0.0;

		for (int t1 : testId) {

			SubTest st = (SubTest) ses.get(SubTest.class, t1);
			total = total + st.getAmt();
		}

		// Test test = (Test) ses.get(Test.class, testId);

		// List<SubTest> sts = test.getSubTests();

		/*
		 * for (SubTest st : sts) {
		 * 
		 * total = total + st.getAmt();
		 * 
		 * }
		 */
		return total;
	}

	public double getTestCoste(int testId) {

		Session ses = sessionFactory.getCurrentSession();

		Test t1 = (Test) ses.get(Test.class, testId);

		return t1.getAmt();
	}

}
