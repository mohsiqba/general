package com.exercise.main;

/**
 * 
 */


import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author SOMA SEKHAR
 *
 */
public class UserAttributes {
	private String billingId;
	private String osUserName;
	private String userFirstName;
	private String userLastName;
	private String userFullName;
	private String userEmail;
	private String domain;
	private String dept;
	private String job;
	private String location;
	private String mobileNumber;
	private String phoneNumber;
	private String empId;
	private String address;
	private String userIdentifier;
	private String upn;
	private Boolean _deleted;
	/*private List<UserGroup> userGroupList;
	
	public List<UserGroup> getUserGroupList() {
		return userGroupList;
	}
	public void setUserGroupList(List<UserGroup> userGroupList) {
		this.userGroupList = userGroupList;
	}*/
	public UserAttributes() {

	}
	public String getBillingId() {
		return billingId;
	}
	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}
	public String getOsUserName() {
		return osUserName;
	}
	public void setOsUserName(String osUserName) {
		this.osUserName = osUserName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public String getUpn() {
		return upn;
	}
	public void setUpn(String upn) {
		this.upn = upn;
	}
	public Boolean get_deleted() {
		return _deleted;
	}
	public void set_deleted(Boolean _deleted) {
		this._deleted = _deleted;
	}
	
	public static class UserGroup{
		private String userGroupName;
		private String userGroupDisplayName;
		private String completeADID;
		
		public UserGroup(String userGroupName,String userGroupDisplayName,String completeADID) {
			this.userGroupName=userGroupName;
			this.userGroupDisplayName=userGroupDisplayName;
			this.completeADID=completeADID;
		}
		
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}

		public String getUserGroupName() {
			return userGroupName;
		}

		public String getUserGroupDisplayName() {
			return userGroupDisplayName;
		}

		public String getCompleteADID() {
			return completeADID;
		}
	}
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
