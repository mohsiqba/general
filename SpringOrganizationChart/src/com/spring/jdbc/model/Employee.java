package com.spring.jdbc.model;

import java.sql.Date;

public class Employee {

	private int empId;
	private String empName;
	private Date empDoj;
	private String empPosition;
	
	private int orgId;
	private int deptId;
	
	@Override
	public String toString(){
		return "{ID="+empId+",Name="+empName+",Role="+empPosition+",doj="+empDoj+"}";
	}

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

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public Date getEmpDoj() {
		return empDoj;
	}


	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}


	public String getEmpPosition() {
		return empPosition;
	}


	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
}
