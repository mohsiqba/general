package com.spring.web.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.spring.jdbc.dao.DepartmentDAO;
import com.spring.jdbc.model.Department;

public class DepartmentServiceImpl implements DepartmentService{
	private static final Logger logger=Logger.getLogger(DepartmentServiceImpl.class);
	private DepartmentDAO deptDao;

	public void setDeptDao(DepartmentDAO deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public Department add(Department department) {
		logger.info("class=> DepartmentServiceImpl method => add()  : adding Department :"+department);
		return deptDao.add(department);
	}

	@Override
	public Department get(Integer id) {
		logger.info("class=> DepartmentServiceImpl method => get()  : getting Department by Id :"+id);
		return deptDao.get(id);
	}

	@Override
	public List<Department> getAll() {
		logger.info("class=> DepartmentServiceImpl method => getAll()  : getting all Department");
		return deptDao.getAll();
	}

	@Override
	public Department update(Department department) {
		logger.info("class=> DepartmentServiceImpl method => update()  : updating Department :"+department);
		return deptDao.update(department);
	}

	@Override
	public Department delete(Integer id) {
		logger.info("class=> DepartmentServiceImpl method => delete()  : deleting Department :"+id);
		return deptDao.delete(id);
	}

	@Override
	public Map<Integer,	String> getOrgIdAndNameMap() {
		logger.info("class=> DepartmentServiceImpl method => getOrgIdAndNameMap()");
		return deptDao.getOrgIdAndNameMap();
	}
	
	/*@Override
	public Map<Integer,	String> getDeptIdAndNameMapByOrgId(Integer id) {
		logger.info("class=> DepartmentServiceImpl method => getDeptIdAndNameMapByOrgId() Id :"+id);
		return dao.getDeptIdAndNameMapByOrgId(id);
	}*/
	
	@Override
	public List<Department> getAllByOrgId(Integer id) {
		logger.info("class=> DepartmentServiceImpl method => getAllByOrgId() Id :"+id);
		return deptDao.getAllByOrgId(id);
	}

}
