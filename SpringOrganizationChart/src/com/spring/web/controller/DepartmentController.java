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

import com.spring.jdbc.model.Department;
import com.spring.web.service.DepartmentService;

@Controller
@RequestMapping(value="/department")
public class DepartmentController {
	private final static Logger logger=Logger.getLogger(DepartmentController.class);
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(value="/getall", method=RequestMethod.GET)
	public ModelAndView loadAllDepartmentPage() {
		logger.info("mapping => /department/getall  method => GET called for DepartmentController.loadAllDepartmentPage()");
		ModelAndView mav = new ModelAndView("department");
		mav.addObject("title", "All Departments Overview");
		mav.addObject("depObject", new Department());
		mav.addObject("depList",departmentService.getAll());
		mav.addObject("orgIdNameMap", departmentService.getOrgIdAndNameMap());
		return mav;
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public ModelAndView loadDepartmentPage(@PathVariable int id) {
		logger.info("mapping => /department/get/{id}  method => GET called for DepartmentController.loadDepartmentPage()");
		ModelAndView mav = new ModelAndView("department");
		mav.addObject("title", "Department Overview For <br>Organization :"+id);
		mav.addObject("OrgID", id);
		mav.addObject("depObject", new Department());
		mav.addObject("depList",departmentService.getAllByOrgId(id));
		mav.addObject("orgIdNameMap", departmentService.getOrgIdAndNameMap());
//		mav.addObject("deptIdNameMap", departmentService.getDeptIdAndNameMapByOrgId(id));
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Department addDepartment(@RequestBody Department depObject) {
		logger.info("mapping => /department/add  method => POST called for DepartmentController.addDepartment()");
		return departmentService.add(depObject);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Department deleteDepartment(@PathVariable int id) {
		logger.info("mapping => /department/delete/{id}  method => DELETE called for DepartmentController.deleteDepartment()");
		return departmentService.delete(id);
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Department editDepartment(@PathVariable int id, 
			@RequestBody Department depObject) {
		logger.info("mapping => /department/edit/{id}  method => PUT called for DepartmentController.editDepartment()");
		return departmentService.update(depObject);
	}
}
