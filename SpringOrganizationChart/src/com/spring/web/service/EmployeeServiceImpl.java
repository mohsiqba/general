package com.spring.web.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.spring.jdbc.dao.EmployeeDAO;
import com.spring.jdbc.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger logger=Logger.getLogger(EmployeeServiceImpl.class);
	private EmployeeDAO empDao;

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public Employee add(Employee employee) {
		logger.info("class=> EmployeeServiceImpl method => add()  : adding Employee :"+employee);
		return empDao.add(employee);
	}

	@Override
	public Employee get(Integer id) {
		logger.info("class=> EmployeeServiceImpl method => get()  : getting Employee by Id :"+id);
		return empDao.get(id);
	}

	@Override
	public List<Employee> getAll() {
		logger.info("class=> EmployeeServiceImpl method => getAll()  : getting all Employee");
		return empDao.getAll();
	}

	@Override
	public Employee update(Employee employee) {
		logger.info("class=> EmployeeServiceImpl method => update()  : updating Employee :"+employee);
		return empDao.update(employee);
	}

	@Override
	public Employee delete(Integer id) {
		logger.info("class=> EmployeeServiceImpl method => delete()  : deleting Employee :"+id);
		return empDao.delete(id);
	}
	
	@Override
	public Map<Integer,	String> getOrgIdAndNameMap() {
		logger.info("class=> EmployeeServiceImpl method => getOrgIdAndNameMap()");
		return empDao.getOrgIdAndNameMap();
	}

	@Override
	public Map<Integer,	String> getDeptIdAndNameMapByOrgId(Integer id) {
		logger.info("class=> EmployeeServiceImpl method => getDeptIdAndNameMapByOrgId()  id :"+id);
		return empDao.getDeptIdAndNameMapByOrgId(id);
	}

	@Override
	public List<Employee> getAllByOrgAndDeptId(Integer orgId,Integer deptId) {
		logger.info("class=> EmployeeServiceImpl method => getAllByOrgAndDeptId()  orgId:"+orgId+" deptId:"+deptId);
		return empDao.getAllByOrgAndDeptId(orgId, deptId);
	}
	
}
