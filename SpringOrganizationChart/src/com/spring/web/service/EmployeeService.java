package com.spring.web.service;

import java.util.List;
import java.util.Map;

import com.spring.jdbc.model.Employee;

public interface EmployeeService extends Service<Employee, Integer>{
	public Employee add(Employee sp);
	public Employee get(Integer id);
	public List<Employee> getAll();
	public Employee update(Employee sp);
	public Employee delete(Integer id);
	
	public Map<Integer,	String> getOrgIdAndNameMap();
	public Map<Integer,	String> getDeptIdAndNameMapByOrgId(Integer id);
	public List<Employee> getAllByOrgAndDeptId(Integer orgId,Integer deptId);
}
