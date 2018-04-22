package com.spring.jdbc.dao;

public class QueryString {
	
	public static String ORG_TABLE_NAME="test_organization";
	public static String ORG_ID="org_id";
	public static String ORG_NAME="org_name";
	public static String ORG_DESC="org_description";
	public static String ORG_ID_GET_QRY="select test_organization_seq.nextval from dual";
	public static String ORG_INSERT_QRY= "insert into test_organization (org_id,org_name,org_description) values (?,?,?)";
	public static String ORG_SELECT_BY_ID_QRY = "select org_id,org_name,org_description from test_organization where org_id = ?";
	public static String ORG_GET_ALL_QRY= "select org_id, org_name, org_description from test_organization";
	public static String ORG_UPDATE_BY_ID_QRY = "update test_organization set org_name=?, org_description=? where org_id=?";
	public static String ORG_DELETE_BY_ID_QRY = "delete from test_organization where org_id=?";
	
	public static String DEPT_TABLE_NAME="test_department";
	public static String DEPT_ID="dept_id";
	public static String DEPT_NAME="dept_name";
	public static String DEPT_MGR_NAME="dept_mgr_name";
	public static String DEPT_ORG_ID="org_id";
	public static String DEPT_ID_GET_QRY="select test_department_seq.nextval from dual";
	public static String DEPT_INSERT_QRY= "insert into test_department (dept_name,dept_mgr_name,org_id,dept_id) values (?,?,?,?)";
	public static String DEPT_SELECT_BY_ID_QRY = "select dept_name,org_id,dept_id,dept_mgr_name,dept_name from test_Department where dept_id = ?";
	public static String DEPT_GET_ALL_QRY= "select dept_name,dept_mgr_name,org_id, dept_id from test_department";
	public static String DEPT_UPDATE_BY_ID_QRY = "update test_department set dept_name=?, dept_mgr_name=?, org_id=? where dept_id=?";
	public static String DEPT_DELETE_BY_ID_QRY = "delete from test_department where dept_id=?";
	public static String DEPT_GET_ALL_BY_ORG_ID_QRY= "select dept_name,dept_mgr_name,org_id, dept_id from test_department where org_id=?";
	
	public static String EMP_TABLE_NAME = "test_employee";
	public static String EMP_ID = "emp_id";
	public static String EMP_NAME = "emp_name";
	public static String EMP_POSITION = "emp_position";
	public static String EMP_DOJ = "emp_doj";
	public static String EMP_ORG_ID = "org_id";
	public static String EMP_DEPT_ID = "dept_id";
	public static String EMP_ID_GET_QRY = "select test_employee_seq.nextval from dual";
	public static String EMP_INSERT_QRY = "insert into test_employee (emp_id,emp_name,emp_doj,emp_position,org_id,dept_id) values (?,?,?,?,?,?)";
	public static String EMP_SELECT_BY_ID_QRY = "select emp_id,emp_name,emp_doj,emp_position,org_id,dept_id from test_Employee where emp_id = ?";
	public static String EMP_GET_ALL_QRY = "select emp_id, emp_name, emp_position, emp_doj, org_id, dept_id from test_employee";
	public static String EMP_UPDATE_BY_ID_QRY = "update test_employee set emp_name=?, emp_position=?, emp_doj=?, org_id=?, dept_id=? where emp_id=?"; 
	public static String EMP_DELETE_BY_ID_QRY = "delete from test_employee where emp_id=?"; 
	public static String EMP_GET_ALL_BY_ORG_DEPT_ID_QRY = "select emp_id, emp_name, emp_position, emp_doj, org_id, dept_id from test_employee where org_id=? and dept_id=?";
	
	public static String GET_ORG_ID_AND_NAME_FOR_SELECT_QRY = "select org_id,org_name from test_organization";
	public static String GET_DEPT_ID_AND_NAME_FOR_SELECT_BY_ORG_ID_QRY = "select dept_id,dept_name from test_department where org_id=?";
	
}
