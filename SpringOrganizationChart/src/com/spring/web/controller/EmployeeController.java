package com.spring.web.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.model.Employee;
import com.spring.web.service.EmployeeService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
	private final static Logger logger=Logger.getLogger(EmployeeController.class);
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value="getall", method=RequestMethod.GET)
	public ModelAndView loadAllEmployeePage() {
		logger.info("mapping => /employee/getall method => GET called for EmployeeController.loadAllEmployeePage()");
		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("title", "Employee Overview");
		mav.addObject("empObject", new Employee());
		mav.addObject("empList",employeeService.getAll());
		mav.addObject("orgIdNameMap",employeeService.getOrgIdAndNameMap());
		//mav.addObject("depIdNameMap",employeeService.getDeptIdAndNameMapByOrgId(orgid));
		return mav;
	}
	
	@RequestMapping(value="/get/{orgid}/{deptid}", method=RequestMethod.GET)
	public ModelAndView loadEmployeePage(@PathVariable int orgid, @PathVariable int deptid) {
		logger.info("mapping => /employee/get/{orgid}/{deptid}  method => GET called for EmployeeController.loadEmployeePage()");
		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("title", "Employee Overview For <br>Organization :"+orgid+"<br>Employee :"+deptid);
		mav.addObject("empObject", new Employee());
		mav.addObject("OrgID", orgid);
		mav.addObject("DeptID", deptid);
		mav.addObject("empList",employeeService.getAllByOrgAndDeptId(orgid, deptid));
		mav.addObject("orgIdNameMap",employeeService.getOrgIdAndNameMap());
		mav.addObject("depIdNameMap",employeeService.getDeptIdAndNameMapByOrgId(orgid));
		return mav;
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<Integer,String> populateSelectDept(@PathVariable int id) {
		logger.info("mapping => /employee/get/{id}  method => POST called for EmployeeController.populateSelectDept()");
		return employeeService.getDeptIdAndNameMapByOrgId(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee empObject) {
		logger.info("mapping => /employee/add  method => POST called for EmployeeController.addEmployee()");
		return employeeService.add(empObject);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee deleteEmployee(@PathVariable int id) {
		logger.info("mapping => /employee/delete/{id}  method => PUT called for EmployeeController.deleteEmployee()");
		return employeeService.delete(id);
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee editEmployee(@PathVariable int id, 
			@RequestBody Employee empObject) {
		logger.info("mapping => /employee/edit/{id}  method => PUT called for EmployeeController.editEmployee()");
		return employeeService.update(empObject);
	}
}
