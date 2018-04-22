package com.spring.web.service;

import java.util.List;
import java.util.Map;

import com.spring.jdbc.model.Department;

public interface DepartmentService extends Service<Department, Integer>{
	public Department add(Department sp);
	public Department get(Integer id);
	public List<Department> getAll();
	public Department update(Department sp);
	public Department delete(Integer id);
	
	public Map<Integer,String> getOrgIdAndNameMap();
//	public Map<Integer,	String> getDeptIdAndNameMapByOrgId(Integer id);
	public List<Department> getAllByOrgId(Integer id);
}

