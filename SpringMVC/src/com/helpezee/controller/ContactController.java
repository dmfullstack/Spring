package com.helpezee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.helpezee.beans.Contact;
import com.helpezee.service.ContactService;
import com.helpezee.validators.ContactValidator;
 
@Controller

public class ContactController {
	
	
 
    @Autowired
    private ContactService contactService;
    
    @Autowired
    @Qualifier("contactValidator")
    private ContactValidator contactValidator;
    

    @RequestMapping("/index")
    public ModelAndView listContacts(ModelMap map) {
    	 map.put("contact", new Contact());
	     map.put("contactList", contactService.listContact());	
        return new ModelAndView("contact");
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact")Contact contact, BindingResult result,ModelMap map) {
    		
    		contactValidator.validate(contact, result);
    		if (result.hasErrors()) {
    			//map.put("contact", new Contact());
			    map.put("contactList", contactService.listContact());	
    			return new ModelAndView("contact");
    			
    			} else {
    				contactService.addContact(contact);
    		        //map.put("contact", new Contact());
    			    map.put("contactList", contactService.listContact());	
    	        return new ModelAndView("contact");
    			}
    		
    }
 
    @RequestMapping("/delete")
    public ModelAndView deleteContact(@RequestParam("contactId")Integer contactId,ModelMap map) {
    				contactService.removeContact(contactId);
	         map.put("contact", new Contact());
		     map.put("contactList", contactService.listContact());	
	        //return new ModelAndView("contact");
		    return new ModelAndView("contact");
		
         
    }
}