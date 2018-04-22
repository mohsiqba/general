package com.spring.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.model.Organization;
import com.spring.web.service.OrganizationService;

@Controller
@RequestMapping(value="/organization")
public class OrganizationController {
	private final static Logger logger = Logger.getLogger(OrganizationController.class);
	private OrganizationService organizationService;
	
	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView loadOrganizationPage() {
		logger.info("mapping => /organization  method => GET called for OrganizationController.loadOrganizationPage()");
		ModelAndView mav = new ModelAndView("organization");
		mav.addObject("title", "All Organizations Overview");
		mav.addObject("orgObject", new Organization());
		mav.addObject("orgList",organizationService.getAll());
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Organization addOrganization(@RequestBody Organization orgObject) {
		logger.info("mapping => /organization/add  method => POST called for OrganizationController.addOrganization()");
		return organizationService.add(orgObject);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Organization deleteOrganization(@PathVariable int id) {
		logger.info("mapping => /organization/delete/{id}  method => DELETE called for OrganizationController.deleteOrganization()");
		return organizationService.delete(id);
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Organization editOrganization(@PathVariable int id, 
			@RequestBody Organization orgObject) {
		logger.info("mapping => /organization/edit/{id}  method => PUT called for OrganizationController.editOrganization()");
		return organizationService.update(orgObject);
	}
}