package com.helpezee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.helpezee.beans.MtnlModel;

public class ProcessApplicationFormController extends SimpleFormController {
	public ProcessApplicationFormController() {
		setCommandClass(MtnlModel.class);
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		MtnlModel mtnlModel = (MtnlModel) command;
		return new ModelAndView(getSuccessView(), "modelDataToRender",mtnlModel);
	}

	@Override
	protected Map<String, List<String>> referenceData(HttpServletRequest request)
			throws Exception {
		List<String> listOfOptions = new ArrayList<String>();
		listOfOptions.add("Modem");
		listOfOptions.add("Extra cable");
		listOfOptions.add("Landline set");
		List<String> listOfPlans = new ArrayList<String>();
		listOfPlans.add("Rs:399");
		listOfPlans.add("Rs:599");
		listOfPlans.add("Rs:799");
		listOfPlans.add("Rs:999");
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("availablePlans", listOfPlans);
		map.put("availableOptions", listOfOptions);
		return map;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String[] options = { "Modem", "Landline set" };
		MtnlModel mtnlModel = new MtnlModel();
		mtnlModel.setOptions(options);
		return mtnlModel;
	}
}