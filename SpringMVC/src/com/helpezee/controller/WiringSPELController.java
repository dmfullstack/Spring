package com.helpezee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.helpezee.beans.Product;

public class WiringSPELController extends AbstractController {

	private Product products; 
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		  for(String part : products.getParts()) 
			System.out.println(part);

		return new ModelAndView("wireusingSpEl","products",products);
	}


}