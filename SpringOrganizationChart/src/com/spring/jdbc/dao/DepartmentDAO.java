package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Department;

public class DepartmentDAO {
	private static final Logger logger=Logger.getLogger(DepartmentDAO.class);
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	public Department add(Department department) {
		logger.info("Class => DepartmentDAO  Method => add() ");
		int deptGenId=getJdbcTemplate().queryForObject(QueryString.DEPT_ID_GET_QRY, Integer.class);
		department.setDeptId(deptGenId);
		Object[] args = new Object[] {department.getDeptName(), department.getDeptMgrName(), department.getOrgId(),department.getDeptId()};
		int out = getJdbcTemplate().update(QueryString.DEPT_INSERT_QRY, args);
		if(out !=0){
			logger.info("Department saved with id="+department.getDeptId());
		}else logger.info("Department save failed with id="+department.getDeptId());
	
		return get(department.getDeptId());
	}

	public Department get(Integer id) {
		logger.info("Class => DepartmentDAO  Method => get() ");
		Department dep = getJdbcTemplate().queryForObject(QueryString.DEPT_SELECT_BY_ID_QRY, new Object[]{id}, new RowMapper<Department>(){
		public Department mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Department dep = new Department();
			dep.setDeptId(rs.getInt(QueryString.DEPT_ID));
			dep.setDeptName(rs.getString(QueryString.DEPT_NAME));
			dep.setDeptMgrName(rs.getString(QueryString.DEPT_MGR_NAME));
			dep.setOrgId(rs.getInt(QueryString.DEPT_ORG_ID));
			return dep;
		}});
		logger.info("for Id : "+id+" returning : "+dep);
		return dep;
	}

	public List<Department> getAll() {
		logger.info("Class => DepartmentDAO  Method => getAll() ");
		List<Department> deptList = new ArrayList<Department>();
		List<Map<String,Object>> depRows = getJdbcTemplate().queryForList(QueryString.DEPT_GET_ALL_QRY);
		for(Map<String,Object> depRow : depRows){
			Department dep = new Department();
			dep.setDeptName(String.valueOf(depRow.get(QueryString.DEPT_NAME)));
			dep.setDeptMgrName(String.valueOf(depRow.get(QueryString.DEPT_MGR_NAME)));
			dep.setOrgId(Integer.parseInt((String.valueOf(depRow.get(QueryString.DEPT_ORG_ID)))));
			dep.setDeptId(Integer.parseInt((String.valueOf(depRow.get(QueryString.DEPT_ID)))));
			deptList.add(dep);
		}
		logger.info("Returning All Departments : "+deptList);
		return deptList;
	}

	public Department update(Department department) {
		logger.info("Class => DepartmentDAO  Method => update() ");
		Object[] args = new Object[] {department.getDeptName(), department.getDeptMgrName(), department.getOrgId(), department.getDeptId()};
		int out = getJdbcTemplate().update(QueryString.DEPT_UPDATE_BY_ID_QRY, args);
		if(out !=0){
			logger.info("Department updated with id="+department.getDeptId());
		}else logger.info("No Department found with id="+department.getDeptId());
		return get(department.getDeptId());
	}

	public Department delete(Integer id) {
		logger.info("Class => DepartmentDAO  Method => delete() ");
		Department dep=get(id);
		int out = getJdbcTemplate().update(QueryString.DEPT_DELETE_BY_ID_QRY, id);
		if(out !=0){
			logger.info("Department deleted with id="+id);
		}else logger.info("No Department found with id="+id);
		return dep;
	}

	public Map<Integer,	String> getOrgIdAndNameMap() {
		logger.info("Class => DepartmentDAO  Method => getOrgIdAndNameMap() ");
		HashMap<Integer,String> orgIdMap=new HashMap<Integer, String>();
		List<Map<String,Object>> objRows = getJdbcTemplate().queryForList(QueryString.GET_ORG_ID_AND_NAME_FOR_SELECT_QRY);
		for(Map<String,Object> objRow : objRows){
			orgIdMap.put(Integer.parseInt(String.valueOf(objRow.get(QueryString.ORG_ID))), objRow.get(QueryString.ORG_NAME).toString());
		}
		return orgIdMap;
	}
	
	/*
	public Map<Integer,	String> getDeptIdAndNameMapByOrgId(Integer id) {
		logger.info("Class => DepartmentDAO  Method => getDeptIdAndNameMapByOrgId() ");
		HashMap<Integer,String> deptIdMap=new HashMap<Integer, String>();
		
		List<Map<String,Object>> objRows = getJdbcTemplate().queryForList(QueryString.GET_DEPT_ID_AND_NAME_FOR_SELECT_BY_ORG_ID_QRY, new Object[]{id});
		for(Map<String,Object> objRow : objRows){
			deptIdMap.put(Integer.parseInt(String.valueOf(objRow.get(QueryString.DEPT_ID))), objRow.get(QueryString.DEPT_NAME).toString());
		}
		return deptIdMap;
	}*/
	
	public List<Department> getAllByOrgId(Integer id) {
		logger.info("Class => DepartmentDAO  Method => getAllByOrgId() ");
		List<Department> deptList = new ArrayList<Department>();
		List<Map<String,Object>> depRows = getJdbcTemplate().queryForList(QueryString.DEPT_GET_ALL_BY_ORG_ID_QRY, new Object[]{id});
		for(Map<String,Object> depRow : depRows){
			Department dep = new Department();
			dep.setDeptName(String.valueOf(depRow.get(QueryString.DEPT_NAME)));
			dep.setDeptMgrName(String.valueOf(depRow.get(QueryString.DEPT_MGR_NAME)));
			dep.setOrgId(Integer.parseInt((String.valueOf(depRow.get(QueryString.DEPT_ORG_ID)))));
			dep.setDeptId(Integer.parseInt((String.valueOf(depRow.get(QueryString.DEPT_ID)))));
			deptList.add(dep);
		}
		return deptList;
	}
}
