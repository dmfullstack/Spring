package com.dc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dc.beans.LoginBean;
import com.dc.beans.StaffRegBean;
import com.dc.beans.TestDetailsBean;
import com.dc.entities.Patient;
import com.dc.service.LoadTestService;
import com.dc.service.LoginCheckService;
import com.dc.service.StaffRegService;

@Controller
public class LoginController {

	@Autowired
	LoginCheckService loginCheckService;

	@Autowired
	StaffRegService staffRegService;

	@Autowired
	private LoadTestService loadTestService;

	@RequestMapping(value = "/validateUser")
	public ModelAndView validateUser(
			@ModelAttribute("LoginController") LoginBean lb,
			HttpServletRequest request) {

		boolean status = loginCheckService.validateUser(lb);

		ModelAndView mav = new ModelAndView();
		System.out.println("Check1");

		if (status) {

			HttpSession session = request.getSession(true);

			session.setAttribute("user", lb.getUserName());
			System.out.println("DC1");
			if (lb.getRole().equals("Admin")) {
				mav.setViewName("adminwelcome");
			}

			/*
			 * else { mav.setViewName("clientwelcome"); }
			 */
			else {
				mav.addObject("msg", "Invalid User Name/Password");
				mav.setViewName("fail");
			}

			if (lb.getUserName() == null) {
				mav.addObject("msg", "You Must Login First");
			}
			System.out.println("Check2");

		}
		return mav;
	}

	@RequestMapping(value = "logout")
	public ModelAndView logOut(HttpServletRequest request) {

		// HttpSession session = request.getSession(true);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("fail");
		mav.addObject("msg", "Logout Success");
		System.out.println("Check3");

		return mav;
	}

	@RequestMapping(value = "/savePatient")
	public String savePatient(
			@ModelAttribute(value = "staffRegBean") StaffRegBean ab) {

		staffRegService.registerStaff(ab);

		return "adminwelcome";

	}

	@RequestMapping(value = "loadTest")
	public ModelAndView loadTest(
			@ModelAttribute("testDetailsbean") TestDetailsBean detailsBean) {

		Map<Integer, String> testNames = loadTestService.listTests();
		Map<Integer, String> doctors = loadTestService.listDoctors();
		TestDetailsBean testDetailsBean = new TestDetailsBean();
		// System.out.println("-------------------- Age: "+testDetailsBean.getAgeRange());

		testDetailsBean.setTestNames(testNames);

		System.out.println("----tests: " + testNames);

		ModelAndView mav = new ModelAndView();

		Map<Integer, String> subs = new HashMap<Integer, String>();

		mav.addObject("test", testDetailsBean);
		mav.addObject("ageRange", testDetailsBean.getAgeRange());
		mav.addObject("tests", testNames);
		mav.addObject("subTests", subs);
		mav.setViewName("testReg1");
		mav.addObject("doctors", doctors);

		testDetailsBean.setAmount(1000);

		return mav;

	}

	@RequestMapping(value = "loadSubTests")
	public ModelAndView loadSubTests(@RequestParam("testId") Integer testId,
			@RequestParam("msg") String subTest,
			@ModelAttribute("testDetailsbean") TestDetailsBean detailsBean) {

		ModelAndView mav = new ModelAndView();

		double subTot = 0.0;
		double tot = loadTestService.getTestCoste(testId);

		if (subTest.equals("abc") || detailsBean.getSubTestId().length == 0) {
			detailsBean.setAmount(tot);
		}
		if (subTest.equals("subTest") && detailsBean.getSubTestId().length != 0) {

			System.out.println("--------- Test------------");
			subTot = loadTestService.getTotal(detailsBean.getSubTestId());
			detailsBean.setAmount(subTot);
		}

		Map<Integer, String> subTestNames = loadTestService
				.listSubTests(testId);

		Map<Integer, String> doctors = loadTestService.listDoctors();
		Map<Integer, String> testNames = loadTestService.listTests();

		double subTestAmount = loadTestService.getTotal(detailsBean
				.getSubTestId());

		detailsBean.setSubTestNames(subTestNames);

		mav.addObject("doctors", doctors);
		mav.addObject("ageRange", detailsBean.getAgeRange());
		mav.addObject("tests", testNames);
		System.out.println("------ Sub test----- " + subTestNames);
		mav.addObject("test", detailsBean);
		mav.addObject("subTests", subTestNames);
		mav.setViewName("testReg1");

		return mav;
	}

	@RequestMapping(value = "registerTest")
	public ModelAndView registerTest(
			@ModelAttribute("detailsBean") TestDetailsBean testDetailsBean) {
		// System.out.println("----------- SID: "+sid);
		// double total = loadTestService.getTotal(testDetailsBean.getTestId());

		ModelAndView mav = new ModelAndView();

		double total = loadTestService.getTotal(testDetailsBean.getSubTestId());

		loadTestService.registerTest(testDetailsBean);

		mav.setViewName("testReport");
		mav.addObject("testReport", testDetailsBean);
		mav.addObject("total", total);

		return mav;

	}

	@RequestMapping(value = "patientReports")
	public ModelAndView getReports() {

		List<Patient> reports = loadTestService.getReports();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("patientReports");
		mav.addObject("reports", reports);
		return mav;
	}

}
