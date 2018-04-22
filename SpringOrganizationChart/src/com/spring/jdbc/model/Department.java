package com.spring.jdbc.model;

public class Department {
	private int deptId;
	private String deptName;
	private String deptMgrName;
	
	private int orgId;
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptMgrName() {
		return deptMgrName;
	}
	public void setDeptMgrName(String deptMgrName) {
		this.deptMgrName = deptMgrName;
	}

	@Override
	public String toString(){
		return "[deptId="+deptId+" deptName="+deptName+" deptMgrName="+deptMgrName+" ]"; 
	}
}
