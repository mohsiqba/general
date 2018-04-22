package com.spring.jdbc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Employee;

public class EmployeeDAO {
	private static final Logger logger=Logger.getLogger(EmployeeDAO.class);
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	public Employee add(Employee employee) {
		logger.info("Class => EmployeeDAO  Method => add() ");
		int empGenId=getJdbcTemplate().queryForObject(QueryString.EMP_ID_GET_QRY, Integer.class);
		employee.setEmpId(empGenId);
		Object[] args = new Object[] {employee.getEmpId(), employee.getEmpName(), employee.getEmpDoj(),employee.getEmpPosition(),employee.getOrgId(),employee.getDeptId()};
		int out = getJdbcTemplate().update(QueryString.EMP_INSERT_QRY, args);
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getEmpId());
		}else System.out.println("Employee save failed with id="+employee.getEmpId());
		return get(employee.getEmpId());
	}

	public Employee get(Integer id) {
		logger.info("Class => EmployeeDAO  Method => get() ");
		Employee emp = getJdbcTemplate().queryForObject(QueryString.EMP_SELECT_BY_ID_QRY, new Object[]{id}, new RowMapper<Employee>(){
		public Employee mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Employee emp = new Employee();
			emp.setEmpId(rs.getInt(QueryString.EMP_ID));
			emp.setEmpName(rs.getString(QueryString.EMP_NAME));
			emp.setEmpPosition(rs.getString(QueryString.EMP_POSITION));
			emp.setEmpDoj(rs.getDate(QueryString.EMP_DOJ));
			emp.setOrgId(rs.getInt(QueryString.EMP_ORG_ID));
			emp.setDeptId(rs.getInt(QueryString.EMP_DEPT_ID));
			return emp;
		}});
		logger.info("for Id : "+id+" returning : "+emp);
		return emp;
	}

	public List<Employee> getAll() {
		logger.info("Class => EmployeeDAO  Method => getAll() ");
		List<Employee> empList = new ArrayList<Employee>();
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss'.0'");
			List<Map<String,Object>> empRows = getJdbcTemplate().queryForList(QueryString.EMP_GET_ALL_QRY);
			for(Map<String,Object> empRow : empRows){
				Employee emp = new Employee();
				emp.setEmpId(Integer.parseInt(String.valueOf(empRow.get(QueryString.EMP_ID))));
				emp.setEmpName(String.valueOf(empRow.get(QueryString.EMP_NAME)));
				emp.setEmpPosition(String.valueOf(empRow.get(QueryString.EMP_POSITION)));
				emp.setEmpDoj(new Date((sdf.parse(String.valueOf(empRow.get(QueryString.EMP_DOJ)))).getTime()));
				emp.setOrgId(Integer.parseInt((String.valueOf(empRow.get(QueryString.EMP_ORG_ID)))));
				emp.setDeptId(Integer.parseInt((String.valueOf(empRow.get(QueryString.EMP_DEPT_ID)))));
				empList.add(emp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("returning all Employees :"+empList);
		return empList;
	}

	public Employee update(Employee employee) {
		logger.info("Class => EmployeeDAO  Method => update() ");
		Object[] args = new Object[] {employee.getEmpName(), employee.getEmpPosition(), employee.getEmpDoj(), employee.getOrgId(), employee.getDeptId(),employee.getEmpId()};
		int out = getJdbcTemplate().update(QueryString.EMP_UPDATE_BY_ID_QRY, args);
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getEmpId());
		}else System.out.println("No Employee found with id="+employee.getEmpId());
		return get(employee.getEmpId());
	}

	public Employee delete(Integer id) {
		logger.info("Class => EmployeeDAO  Method => delete() ");
		Employee emp=get(id);
		int out = getJdbcTemplate().update(QueryString.EMP_DELETE_BY_ID_QRY, id);
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
		}else System.out.println("No Employee found with id="+id);
		return emp;
	}
	
	
	public Map<Integer,	String> getOrgIdAndNameMap() {
		logger.info("Class => EmployeeDAO  Method => getOrgIdAndNameMap() ");
		HashMap<Integer,String> orgIdMap=new HashMap<Integer, String>();
		List<Map<String,Object>> objRows = getJdbcTemplate().queryForList(QueryString.GET_ORG_ID_AND_NAME_FOR_SELECT_QRY);
		for(Map<String,Object> objRow : objRows){
			orgIdMap.put(Integer.parseInt(String.valueOf(objRow.get(QueryString.ORG_ID))), (String)objRow.get(QueryString.ORG_NAME));
		}
		return orgIdMap;
	}

	public Map<Integer,	String> getDeptIdAndNameMapByOrgId(Integer id) {
		logger.info("Class => EmployeeDAO  Method => getDeptIdAndNameMapByOrgId() ");
		HashMap<Integer,String> deptIdMap=new HashMap<Integer, String>();
		List<Map<String,Object>> objRows = getJdbcTemplate().queryForList(QueryString.GET_DEPT_ID_AND_NAME_FOR_SELECT_BY_ORG_ID_QRY, new Object[]{id});
		for(Map<String,Object> objRow : objRows){
			deptIdMap.put(Integer.parseInt(String.valueOf(objRow.get(QueryString.DEPT_ID))), (String)objRow.get(QueryString.DEPT_NAME));
		}
		return deptIdMap;
	}

	public List<Employee> getAllByOrgAndDeptId(Integer orgId,Integer deptId) {
		logger.info("Class => EmployeeDAO  Method => getAllByOrgAndDeptId() ");
		List<Employee> empList = new ArrayList<Employee>();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss'.0'");
			List<Map<String,Object>> empRows = getJdbcTemplate().queryForList(QueryString.EMP_GET_ALL_BY_ORG_DEPT_ID_QRY, new Object[]{orgId,deptId});
			for(Map<String,Object> empRow : empRows){
				Employee emp = new Employee();
				emp.setEmpId(Integer.parseInt(String.valueOf(empRow.get(QueryString.EMP_ID))));
				emp.setEmpName(String.valueOf(empRow.get(QueryString.EMP_NAME)));
				emp.setEmpPosition(String.valueOf(empRow.get(QueryString.EMP_POSITION)));
				emp.setEmpDoj(new Date((sdf.parse(String.valueOf(empRow.get(QueryString.EMP_DOJ)))).getTime()));
				emp.setOrgId(Integer.parseInt((String.valueOf(empRow.get(QueryString.EMP_ORG_ID)))));
				emp.setDeptId(Integer.parseInt((String.valueOf(empRow.get(QueryString.EMP_DEPT_ID)))));
				empList.add(emp);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
